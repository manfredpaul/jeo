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
package io.jeo.util;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KeyTest {

    @Test
    public void testConvertMulti() {
        Key<Integer> key = new Key("foo", Integer.class).multi(true);
        Map<String,Object> map = (Map) Collections.singletonMap(key.name(), "1,2,3");

        List<Integer> list = key.all(map);
        assertEquals(3, list.size());

        assertEquals(1, list.get(0).intValue());
        assertEquals(2, list.get(1).intValue());
        assertEquals(3, list.get(2).intValue());
    }

    @Test
    public void testAliases() {
        Key<Integer> key = new Key("foo", Integer.class).alias("bar");

        assertTrue(key.in((Map) Collections.singletonMap(key, 1)));
        assertTrue(key.in((Map) Collections.singletonMap("foo", 1)));
        assertTrue(key.in((Map) Collections.singletonMap("bar", 1)));
        assertFalse(key.in((Map) Collections.singletonMap("baz", 1)));

        assertEquals(Integer.valueOf(1), key.get((Map) Collections.singletonMap(key, 1)));
        assertEquals(Integer.valueOf(1), key.get((Map) Collections.singletonMap("foo", 1)));
        assertEquals(Integer.valueOf(1), key.get((Map) Collections.singletonMap("bar", 1)));
    }
}
