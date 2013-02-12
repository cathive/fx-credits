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
import java.net.URL;
import java.util.Objects;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

/**
 * Any kind of component, e.g. a texture pack, a 3rd party library or whatever.
 * 
 * @author Benjamin P. Jung
 */
@XmlType(name = "component", namespace = "http://www.cathive.com/fx/credits/", propOrder = {
    "id", "name", "description", "url", "license"
})
public final class Component implements Serializable {

    /** @see java.io.Serializable */
    private static final long serialVersionUID = 8632971694384502658L;

    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final ObjectProperty<URL> url = new SimpleObjectProperty<>();
    private final ObjectProperty<License> license = new SimpleObjectProperty<>();


    public Component() {
        super();
    }


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

    @XmlElement(name = "name", nillable = false, required = true)
    public String getName() {
        return this.name.get();
    }

    public void setName(final String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return this.name;
    }

    @XmlElement(name = "description", nillable = true, required = false)
    public String getDescription() {
        return this.description.get();
    }

    public void setDescription(final String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return this.description;
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

    @XmlElement(name = "license", required = false)
    public License getLicense() {
        return this.license.get();
    }

    public void setLicense(final License license) {
        this.license.set(license);
    }

    public ObjectProperty<License> licenseProperty() {
        return this.license;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null) {
           return false;
        }  
        if (getClass() != o.getClass()) {
           return false;
        }
        final Component that = (Component) o;
        return Objects.equals(this.getId(), that.getId())
            && Objects.equals(this.getName(), that.getName())
            && Objects.equals(this.getDescription(), that.getDescription())
            && Objects.equals(this.getUrl(), that.getUrl())
            && Objects.equals(this.getLicense(), that.getLicense());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getName(), this.getDescription(), this.getUrl(), this.getLicense());
    }

}
