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

package org.apache.ignite.internal.sql.engine.rel;

import java.util.List;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.PhysicalNode;
import org.apache.calcite.rel.RelCollation;
import org.apache.calcite.util.Pair;
import org.apache.ignite.internal.sql.engine.trait.CorrelationTrait;
import org.apache.ignite.internal.sql.engine.trait.IgniteDistribution;
import org.apache.ignite.internal.sql.engine.trait.RewindabilityTrait;
import org.apache.ignite.internal.sql.engine.trait.TraitUtils;

/**
 * A superinterface of all Ignite relational nodes.
 */
public interface IgniteRel extends PhysicalNode {
    /**
     * Accepts a visit from a visitor.
     *
     * @param visitor Ignite visitor.
     * @return Visit result.
     */
    <T> T accept(IgniteRelVisitor<T> visitor);

    /**
     * Clones this rel associating it with given cluster.
     *
     * @param cluster Cluster.
     * @return New rel.
     */
    IgniteRel clone(RelOptCluster cluster, List<IgniteRel> inputs);

    /**
     * Get node distribution.
     */
    default IgniteDistribution distribution() {
        return TraitUtils.distribution(getTraitSet());
    }

    /**
     * Get node collations.
     */
    default RelCollation collation() {
        return TraitUtils.collation(getTraitSet());
    }

    /**
     * Get node rewindability.
     */
    default RewindabilityTrait rewindability() {
        return TraitUtils.rewindability(getTraitSet());
    }

    /**
     * Get node correlation.
     */
    default CorrelationTrait correlation() {
        return TraitUtils.correlation(getTraitSet());
    }

    /** {@inheritDoc} */
    @Override
    default Pair<RelTraitSet, List<RelTraitSet>> passThroughTraits(
            RelTraitSet required) {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    default Pair<RelTraitSet, List<RelTraitSet>> deriveTraits(
            RelTraitSet childTraits, int childId) {
        return null;
    }
}
