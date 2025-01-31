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

package org.apache.ignite.internal.metastorage.common.command.cursor;

import org.apache.ignite.lang.IgniteUuid;
import org.apache.ignite.raft.client.ReadCommand;
import org.jetbrains.annotations.NotNull;

/**
 * Cursor {@code hasNext} command for MetaStorageCommandListener that checks whether next element is available.
 */
public class CursorHasNextCommand implements ReadCommand {
    /** Cursor id. */
    @NotNull
    private final IgniteUuid cursorId;

    /**
     * Constructor.
     *
     * @param cursorId Cursor id.
     */
    public CursorHasNextCommand(@NotNull IgniteUuid cursorId) {
        this.cursorId = cursorId;
    }

    /**
     * Returns cursor id.
     */
    public @NotNull IgniteUuid cursorId() {
        return cursorId;
    }
}
