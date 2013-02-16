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
 * @see Credits
 * @author Benjamin P. Jung
 */
public final class CreditsBuilder implements Builder<Credits> {

    private ObservableList<Person> persons;
    private ObservableList<Section> sections;
    private ObservableList<Component> components;

    private CreditsBuilder() {
        super();
    }

    public static CreditsBuilder create() {
        return new CreditsBuilder();
    }

    public CreditsBuilder persons(ObservableList<Person> persons) {
        this.persons = persons;
        return this;
    }

    public CreditsBuilder persons(Person... persons) {
        this.persons = FXCollections.observableArrayList(persons);
        return this;
    }

    public CreditsBuilder sections(ObservableList<Section> sections) {
        this.sections = sections;
        return this;
    }

    public CreditsBuilder sections(Section... sections) {
        this.sections = FXCollections.observableArrayList(sections);
        return this;
    }

    public CreditsBuilder components(ObservableList<Component> components) {
        this.components = components;
        return this;
    }

    public CreditsBuilder components(Component... components) {
        this.components = FXCollections.observableArrayList(components);
        return this;
    }

    @Override
    public Credits build() {
        final Credits credits = new Credits();
        credits.setPersons(persons);
        credits.setSections(sections);
        credits.setComponents(components);
        return credits;
    }

}
