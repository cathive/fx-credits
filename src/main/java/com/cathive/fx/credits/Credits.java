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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Benjamin P. Jung
 */
@XmlType(name = "credits", namespace = "http://www.cathive.com/fx/credits/", propOrder = {
    "components_JAXB"
})
@XmlRootElement(name = "credits", namespace = "http://www.cathive.com/fx/credits/")
public final class Credits implements Serializable {

    /** @see java.io.Serializable */
    private static final long serialVersionUID = 4420652488345252112L;

    private final ListProperty<Component> components = new SimpleListProperty<>(FXCollections.observableList(new ArrayList<Component>()));


    public Credits() {
        super();
    }


    @XmlTransient
    public ObservableList<Component> getComponents() {
        return this.components.get();
    }

    public void setComponents(final ObservableList<Component> components) {
        this.components.set(components);
    }

    public ListProperty<Component> componentsProperty() {
        return this.components;
    }

    /** Helper method for JAXB XML deserialization */
    @XmlElement(name = "component")
    @XmlElementWrapper(name = "components")
    protected List<Component> getComponents_JAXB() {
        return this.components.get();
    }

    /** Helper method for JAXB XML serialization */
    protected void setComponents_JAXB(final List<Component> components) {
        this.components.set(FXCollections.observableList(components));
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null) {
           return false;
        }  
        if (getClass() != o.getClass()) {
           return false;
        }
        final Credits that = (Credits) o;
        return Objects.deepEquals(this.getComponents(), that.getComponents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getComponents());
    }

}
