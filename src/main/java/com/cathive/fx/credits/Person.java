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

import java.io.Serializable;
import java.net.URL;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Represents a single person
 * @author Benjamin P. Jung
 */
@XmlType(name = "person", namespace = "http://www.cathive.com/fx/credits/", propOrder = {
        "id", "name", "email", "url"
})
public final class Person implements Serializable {

    /** @see java.io.Serializable */
    private static final long serialVersionUID = 453270492070378204L;

    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final ObjectProperty<URL> url = new SimpleObjectProperty<>();

    @XmlID
    @XmlAttribute(name="id")
    public String getId() {
        return this.id.get();
    }

    public void setId(final String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return this.id;
    }

    @XmlElement(name = "name", required = true)
    public String getName() {
        return this.name.get();
    }

    public void setName(final String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return this.name;
    }

    @XmlElement(name = "email", required = false)
    public String getEmail() {
        return this.email.get();
    }

    public void setEmail(final String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return this.email;
    }

    @XmlElement(name = "url", required = false)
    public URL getUrl() {
        return this.url.get();
    }

    public void setUrl(final URL url) {
        this.url.set(url);
    }

    public ObjectProperty<URL> urlProperty() {
        return this.url;
    }

    @Override
    public String toString() {
        final String name = getName();
        final String email = getEmail();
        if (email == null) {
            return name;
        } else {
            return String.format("%s <%s>", name, email);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null) {
           return false;
        }  
        if (getClass() != o.getClass()) {
           return false;
        }
        final Person that = (Person) o;
        return Objects.equals(this.getId(), that.getId())
            && Objects.equals(this.getName(), that.getName())
            && Objects.equals(this.getEmail(), that.getEmail())
            && Objects.equals(this.getUrl(), that.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getName(), this.getEmail(), this.getUrl());
    }

}
