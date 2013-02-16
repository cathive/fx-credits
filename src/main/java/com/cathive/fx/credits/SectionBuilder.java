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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Builder;

/**
 * 
 * @author Benjamin P. Jung
 */
public final class SectionBuilder implements Builder<Section> {

    private String id;
    private String name;
    private ObservableList<Person> persons;

    private SectionBuilder() {
        super();
    }

    public static SectionBuilder create() {
        return new SectionBuilder();
    }

    @Override
    public Section build() {
        final Section section = new Section();
        section.setId(id);
        section.setName(name);
        section.setPersons(persons);
        return section;
    }

    public SectionBuilder id(final String id) {
        this.id = id;
        return this;
    }

    public SectionBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public SectionBuilder persons(final ObservableList<Person> persons) {
        this.persons = persons;
        return this;
    }

    public SectionBuilder persons(final Person... persons) {
        this.persons = FXCollections.observableArrayList(persons);
        return this;
    }

}
