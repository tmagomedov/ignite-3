/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

namespace Apache.Ignite.Tests
{
    using System.Threading.Tasks;
    using Ignite.Table;
    using NUnit.Framework;

    /// <summary>
    /// Base class for client tests.
    /// </summary>
    public class IgniteTestsBase
    {
        protected const string TableName = "PUB.tbl1";

        protected const string KeyCol = "key";

        protected const string ValCol = "val";

        private JavaServer? _serverNode;

        protected int ServerPort => _serverNode?.Port ?? 0;

        protected IIgniteClient Client { get; private set; } = null!;

        protected ITable Table { get; private set; } = null!;

        [OneTimeSetUp]
        public async Task OneTimeSetUp()
        {
            _serverNode = await JavaServer.StartAsync();
            Client = await IgniteClient.StartAsync(GetConfig());
            Table = (await Client.Tables.GetTableAsync(TableName))!;
        }

        [OneTimeTearDown]
        public void OneTimeTearDown()
        {
            // ReSharper disable once ConstantConditionalAccessQualifier
            Client?.Dispose();
            _serverNode?.Dispose();
        }

        protected IgniteClientConfiguration GetConfig() => new()
        {
            Endpoints = { "127.0.0.1:" + _serverNode?.Port }
        };
    }
}