/*
 * Copyright (C) 2013 The Cat Hive Developers.
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

import java.net.URL;

import javafx.util.Builder;

/**
 * @see Person
 * @author Benjamin P. Jung
 */
public final class PersonBuilder implements Builder<Person> {

    private String id;
    private String name;
    private String email;
    private URL url;

    private PersonBuilder() {
        super();
    }

    public static PersonBuilder create() {
        return new PersonBuilder();
    }

    @Override
    public Person build() {
        final Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setEmail(email);
        person.setUrl(url);
        return person;
    }

    public PersonBuilder id(final String id) {
        this.id = id;
        return this;
    }

    public PersonBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder email(final String email) {
        this.email = email;
        return this;
    }

    public PersonBuilder url(final URL url) {
        this.url = url;
        return this;
    }

}
