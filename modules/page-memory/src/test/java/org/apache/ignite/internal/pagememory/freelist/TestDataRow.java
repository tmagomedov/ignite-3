/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
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

package org.apache.ignite.internal.pagememory.freelist;

import static org.apache.ignite.internal.pagememory.freelist.TestDataPageIo.VERSIONS;

import org.apache.ignite.internal.pagememory.Storable;
import org.apache.ignite.internal.pagememory.io.AbstractDataPageIo;
import org.apache.ignite.internal.pagememory.io.IoVersions;

/**
 * Test storable row with raw data.
 */
class TestDataRow implements Storable {
    private long link;

    final byte[] bytes;

    /**
     * Constructor.
     *
     * @param size Size of the object in bytes.
     */
    TestDataRow(int size) {
        bytes = new byte[size];
    }

    /** {@inheritDoc} */
    @Override
    public void link(long link) {
        this.link = link;
    }

    /** {@inheritDoc} */
    @Override
    public long link() {
        return link;
    }

    /** {@inheritDoc} */
    @Override
    public int partition() {
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public int size() {
        return bytes.length;
    }

    /** {@inheritDoc} */
    @Override
    public int headerSize() {
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public IoVersions<? extends AbstractDataPageIo> ioVersions() {
        return VERSIONS;
    }
}
