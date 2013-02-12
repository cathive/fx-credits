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

    private Credits creditsOut;
    private Credits creditsIn;
    private File file;

    @BeforeClass
    protected void initialize() throws Exception {

        creditsOut = CreditsBuilder.create()
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
        file.deleteOnExit();
        JAXB.marshal(creditsOut, file);
    }

    @Test(groups = "xmlDeserialization", dependsOnMethods = "testXmlSerialization")
    public void testXmlDeserialization() throws Exception {
        creditsIn = JAXB.unmarshal(file, Credits.class);
        assertNotNull(creditsIn);
        assertTrue(creditsIn.getComponents().size() > 0);
    }

    @Test(dependsOnMethods = "testXmlDeserialization")
    public void testHashCode() throws Exception {
        assertEquals(creditsIn.hashCode(), creditsOut.hashCode());
    }

    @Test(dependsOnMethods = "testXmlDeserialization")
    public void testEquals() throws Exception {
        assertEquals(creditsIn, creditsOut);
    }

}
