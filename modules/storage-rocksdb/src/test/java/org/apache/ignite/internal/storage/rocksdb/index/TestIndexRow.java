/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.storage.rocksdb.index;

import org.apache.ignite.internal.schema.BinaryRow;
import org.apache.ignite.internal.storage.index.IndexRow;
import org.apache.ignite.table.Tuple;

/**
 * Index row for tests.
 */
public class TestIndexRow implements IndexRow {
    private final Tuple tuple;

    private final BinaryRow pk;

    private final int part;

    /**
     * Constructor.
     */
    public TestIndexRow(Tuple t, BinaryRow pk, int part) {
        this.tuple = t;
        this.pk = pk;
        this.part = part;
    }

    /** {@inheritDoc} */
    @Override
    public BinaryRow primaryKey() {
        return pk;
    }

    @Override
    public int partition() {
        return part;
    }

    /** {@inheritDoc} */
    @Override
    public Object value(int idxColOrder) {
        return tuple.value(idxColOrder);
    }
}