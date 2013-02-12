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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;

/**
 * @see Credits
 * @author Benjamin P. Jung
 */
public final class CreditsBuilder {

    private List<Component> components;

    private CreditsBuilder() {
        super();
    }

    public static CreditsBuilder create() {
        return new CreditsBuilder();
    }

    public CreditsBuilder components(List<Component> components) {
        this.components = components;
        return this;
    }

    public CreditsBuilder components(Component ... components) {
        this.components = new ArrayList<Component>();
        Collections.addAll(this.components, components);
        return this;
    }

    public Credits build() {
        final Credits credits = new Credits();
        if (components != null) {
            credits.setComponents(FXCollections.observableList(components));
        }
        return credits;
    }

}
