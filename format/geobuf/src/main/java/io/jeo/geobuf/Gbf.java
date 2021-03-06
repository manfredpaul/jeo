/* Copyright 2015 The jeo project. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jeo.geobuf;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.jeo.data.FileDriver;
import io.jeo.util.Messages;
import io.jeo.vector.VectorDriver;
import io.jeo.vector.Schema;

/**
 * Geobuf driver.
 * <p>
 * Based on {@link https://github.com/mapbox/geobuf}
 * </p>
 * <p>
 * Usage:
 * <pre><code>
 * Geobuf.open(new File("states.pbf"));
 * </code></pre>
 * </p>
 * 
 * @author Justin Deoliveira, OpenGeo
 */
public class Gbf extends FileDriver<GeobufDataset> implements VectorDriver<GeobufDataset> {

    public static GeobufDataset open(Path path) throws IOException {
        return new Gbf().open(path.toFile(), null);
    }

    @Override
    public String name() {
        return "Geobuf";
    }

    @Override
    public List<String> aliases() {
        return Arrays.asList("gbf", "pbf");
    }

    @Override
    public Class<GeobufDataset> type() {
        return GeobufDataset.class;
    }
    
    @Override
    public GeobufDataset open(File file, Map opts) throws IOException {
        return new GeobufDataset(file);
    }

    @Override
    public Set<Capability> capabilities() {
        return Collections.emptySet();
    }

    @Override
    public boolean canCreate(Map<?, Object> opts, Messages msgs) {
        return FILE.in(opts);
    }

    @Override
    public GeobufDataset create(Map<?, Object> opts, Schema schema) throws IOException {
        return new GeobufDataset(FILE.get(opts));
    }
}
