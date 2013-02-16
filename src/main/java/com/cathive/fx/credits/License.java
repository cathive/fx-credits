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

import java.net.MalformedURLException;
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
 * 
 * @author Benjamin P. Jung
 */
@XmlType(name = "license", namespace = "http://www.cathive.com/fx/credits/", propOrder = {
    "id", "name", "url"
})
public final class License {

    /**
     * Apache License, Version 2.0 (January 2004)
     * <p>The Apache License is a free software license authored by the Apache Software Foundation (ASF).
     * The Apache License requires preservation of the copyright notice and disclaimer.
     * Like any free software license, the Apache License allows the user of the software the freedom to
     * use the software for any purpose, to distribute it, to modify it, and to distribute modified versions
     * of the software, under the terms of the license, without concern for royalties.</p>
     */
    public static final License APACHE_LICENSE_VERSION_2_0 = new License("APLv2", "Apache License, Version 2.0", "http://www.apache.org/licenses/LICENSE-2.0.html");

    /**
     * GNU General Public License, Version 2.0 (June 1991)
     * <p>The GNU General Public License (GNU GPL or GPL) is the most widely used open source software license,
     * which guarantees end users (individuals, organizations, companies) the freedoms to use, study, share (copy),
     * and modify the software. Software that ensures that these rights are retained is called free software.</p>
     */
    public static final License GNU_GENERAL_PUBLIC_LICENSE_VERSION_2_0 = new License("GPLv2", "GNU General Public License, Version 2.0)", "http://www.gnu.org/licenses/gpl-2.0.txt");

    /**
     * GNU General Public License, Version 3.0 (29 June 2007)
     * <p>The GNU General Public License (GNU GPL or GPL) is the most widely used open source software license,
     * which guarantees end users (individuals, organizations, companies) the freedoms to use, study, share (copy),
     * and modify the software. Software that ensures that these rights are retained is called free software.</p>
     */
    public static final License GNU_GENERAL_PUBLIC_LICENSE_VERSION_3_0 = new License("GPLv3", "GNU General Public License, Version 3.0)", "http://www.gnu.org/licenses/gpl-3.0.txt");

    /**
     * GNU Lesser General Public License, Version 2.1 (February 1999)
     * <p>The GNU Lesser General Public License or LGPL (formerly the GNU Library General Public License) is a free
     * software license published by the Free Software Foundation (FSF). The LGPL allows developers and companies to
     * use and integrate LGPL software into their own (even proprietary) software without being required
     * (by the terms of a strong copyleft) to release the source code of their own software-parts.</p>
     */
    public static final License GNU_LESSER_GENERAL_PUBLIC_LICENSE_VERSION_2_1 = new License("LGPLv2.1", "GNU Lesser General Public License, Version 2.1", "http://www.gnu.org/licenses/lgpl-2.1.txt"); 

    /**
     * GNU Lesser General Public License, Version 3.0 (29 June 2007)
     * <p>The GNU Lesser General Public License or LGPL (formerly the GNU Library General Public License) is a free
     * software license published by the Free Software Foundation (FSF). The LGPL allows developers and companies to
     * use and integrate LGPL software into their own (even proprietary) software without being required
     * (by the terms of a strong copyleft) to release the source code of their own software-parts.</p>
     */
    public static final License GNU_LESSER_GENERAL_PUBLIC_LICENSE_VERSION_3_0 = new License("LGPLv3.0", "GNU Lesser General Public License, Version 3.0", "http://www.gnu.org/licenses/lgpl-3.0.txt");


    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final ObjectProperty<URL> url = new SimpleObjectProperty<>();


    public License() {
        super();
    }

    private License(final String id, final String name, final String urlString) {
        super();
        this.id.set(id);
        this.name.set(name);
        if (urlString != null) {
            try {
                this.url.set(new URL(urlString));
            } catch (MalformedURLException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @XmlID
    @XmlAttribute(name = "id")
    public String getId() {
        return this.id.get();
    }

    public void setId(final String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return this.id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return this.name.get();
    }

    public void setName(final String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return this.name;
    }

    @XmlElement(name = "url")
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
    public boolean equals(Object o) {
        if (o == null) {
            return false;
         }  
         if (getClass() != o.getClass()) {
            return false;
         }
         final License that = (License) o;
         return Objects.equals(this.getId(), that.getId())
             && Objects.equals(this.getName(), that.getName())
             && Objects.equals(this.getUrl(), that.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getName(), this.getUrl());
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
