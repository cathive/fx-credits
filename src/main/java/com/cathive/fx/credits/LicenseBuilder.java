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
 * 
 * @author Benjamin P. Jung
 */
public final class LicenseBuilder {

    private String id;
    private String name;
    private URL url;

    private LicenseBuilder() {
        super();
    }

    public LicenseBuilder create() {
        return new LicenseBuilder();
    }

    public License build() {
        final License license = new License();
        license.setId(id);
        license.setName(name);
        license.setUrl(url);
        return license;
    }

    public LicenseBuilder id(final String id) {
        this.id = id;
        return this;
    }

    public LicenseBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public LicenseBuilder url(final URL url) {
        this.url = url;
        return this;
    }

}
