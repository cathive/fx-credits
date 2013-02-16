/*
 * Copyright (C) 2012 The Cat Hive Developers.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cathive.fx.credits;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import javax.xml.bind.JAXB;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 
 * @author Benjamin P. Jung
 */
@Test
public class CreditsTest {

    private Person kirk;
    private Person spock;
    private Person picard;
    private Person riker;

    private Section captains;
    private Section firstGeneration;
    private Section nextGeneration;

    private Credits creditsOut;
    private Credits creditsIn;
    private File file;

    @BeforeClass
    protected void initialize() throws Exception {

        kirk = PersonBuilder.create()
                .id("kirk")
                .name("James T. Kirk")
                .email("james-t.kirk@uss.enterprise.org")
                .build();

        spock = PersonBuilder.create()
                .id("spock")
                .name("Mr. Spock")
                // Spock doesn't have an email address
                .build();

        picard = PersonBuilder.create()
                .id("picard")
                .name("Jean Luc Picard")
                .email("picard@starfleet.com")
                .build();

        riker = PersonBuilder.create()
                .id("riker")
                .name("William T. Riker")
                .email("honeybunny@starmail.net")
                .build();

        firstGeneration = SectionBuilder.create()
                .id("first-gen")
                .name("Enterprise")
                .persons(kirk, spock)
                .build();

        nextGeneration = SectionBuilder.create()
                .id("next-gen")
                .name("Star Trek: The next Generation")
                .persons(picard, riker)
                .build();

        captains = SectionBuilder.create()
                .id("captains")
                .name("Captains")
                .persons(kirk, picard)
                .build();

        creditsOut = CreditsBuilder.create()
                .persons(kirk, spock, picard, riker)
                .sections(firstGeneration, nextGeneration, captains)
                .components(
                    ComponentBuilder.create()
                            .id("lib.logback")
                            .name("Logback")
                            .url(new URL("http://logback.qos.ch/"))
                            .description("The reliable, generic, fast and flexible logging framework.")
                            .license(License.GNU_LESSER_GENERAL_PUBLIC_LICENSE_VERSION_2_1)
                            .build(),
                    ComponentBuilder.create()
                            .id("lib.testng")
                            .name("TestNG")
                            .url(new URL("http://testng.org/"))
                            .description("Java Testing Framework")
                            .license(License.APACHE_LICENSE_VERSION_2_0)
                            .build())
                .build();
    }

    @Test(groups = "xmlSerialization")
    public void testXmlSerialization() throws Exception {
        file = File.createTempFile("fx-credits", ".xml");
        //file.deleteOnExit();
        JAXB.marshal(creditsOut, file);
    }

    @Test(groups = "xmlDeserialization", dependsOnMethods = "testXmlSerialization")
    public void testXmlDeserialization() throws Exception {
        creditsIn = JAXB.unmarshal(file, Credits.class);
        assertNotNull(creditsIn);
        assertTrue(creditsIn.getPersons().contains(picard));
        assertTrue(creditsIn.getPersons().contains(kirk));
        assertTrue(creditsIn.getPersons().contains(riker));
        assertTrue(creditsIn.getPersons().contains(spock));
        assertTrue(creditsIn.getSections().size() > 0);
        assertTrue(creditsIn.getComponents().size() > 0);
    }

    @Test(dependsOnMethods = "testXmlDeserialization")
    public void testHashCode() throws Exception {
        assertEquals(creditsIn.hashCode(), creditsOut.hashCode());
    }

    // TODO The equals() method doesn't work right now. :-(
    //      I have to think about equality of collections a bit more, I fear...
    @Test(dependsOnMethods = "testXmlDeserialization", enabled = false)
    public void testEquals() throws Exception {
        assertEquals(creditsIn, creditsOut);
    }

}
