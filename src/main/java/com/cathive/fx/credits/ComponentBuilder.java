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

import java.net.URL;

/**
 * @see Component
 * @author Benjamin P. Jung
 */
public final class ComponentBuilder {

    private String id;
    private String name;
    private String description;
    private URL url;
    private License license;

    private ComponentBuilder() {
        super();
    }

    public static ComponentBuilder create() {
        return new ComponentBuilder();
    }

    public Component build() {
        final Component component = new Component();
        component.setId(id);
        component.setName(name);
        component.setDescription(description);
        component.setUrl(url);
        component.setLicense(license);
        return component;
    }

    public ComponentBuilder id(final String id) {
        this.id = id;
        return this;
    }

    public ComponentBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public ComponentBuilder description(final String description) {
        this.description = description;
        return this;
    }

    public ComponentBuilder url(final URL url) {
        this.url = url;
        return this;
    }

    public ComponentBuilder license(final License license) {
        this.license = license;
        return this;
    }
}
