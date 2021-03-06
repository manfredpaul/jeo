/* Copyright 2013 The jeo project. All rights reserved.
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
package io.jeo.geopkg;

import java.io.IOException;

import java.util.Map;

import io.jeo.vector.FeatureAppendCursor;
import io.jeo.vector.FeatureCursor;
import io.jeo.vector.FeatureWriteCursor;
import io.jeo.vector.VectorQuery;
import io.jeo.data.Transaction;
import io.jeo.data.Transactional;
import io.jeo.vector.VectorDataset;
import io.jeo.vector.Schema;

public class GeoPkgVector extends GeoPkgDataset<FeatureEntry> implements VectorDataset, Transactional {

    public GeoPkgVector(FeatureEntry entry, GeoPkgWorkspace geopkg) {
        super(entry, geopkg);
    }

    @Override
    public Schema schema() throws IOException {
        return geopkg.schema(entry);
    }

    @Override
    public long count(VectorQuery q) throws IOException {
        return geopkg.count(entry, q);
    }

    @Override
    public FeatureCursor read(VectorQuery q) throws IOException {
        return geopkg.read(entry, q);
    }

    @Override
    public FeatureWriteCursor update(VectorQuery q) throws IOException {
        return geopkg.update(entry, q);
    }

    @Override
    public FeatureAppendCursor append(VectorQuery q) throws IOException {
        return geopkg.append(entry, q);
    }

    @Override
    public Transaction transaction(Map<String, Object> options) throws IOException {
        return new GeoPkgTransaction(geopkg.backend.session());
    }

}

