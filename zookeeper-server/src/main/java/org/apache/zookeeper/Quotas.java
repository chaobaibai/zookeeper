/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.zookeeper;

/**
 * this class manages quotas
 * and has many other utils
 * for quota
 * 管理节点的配额
 */
public class Quotas {

    /** the zookeeper nodes that acts as the management and status node **/
    // zookeeper节点的path
    public static final String procZookeeper = "/zookeeper";

    /** the zookeeper quota node that acts as the quota
     * management node for zookeeper */
    // 配额节点的路径
    public static final String quotaZookeeper = "/zookeeper/quota";

    /**
     * the limit node that has the limit of
     * a subtree
     * 对于节点限制配额的路径：/zookeeper/quota/ + 限制节点的绝对path + /zookeeper_limits
     * 对于节点的限制配额分两种，二选其一： 1.子树节点的个数限制（包含自身） 2.节点字节大小限制
     */
    public static final String limitNode = "zookeeper_limits";

    /**
     * the stat node that monitors the limit of
     * a subtree.
     * 监控当前限制节点的子树节点个数（包含自身）和子树数据字节大小（包含自身）
     */
    public static final String statNode = "zookeeper_stats";

    /**
     * return the quota path associated with this
     * prefix
     * @param path the actual path in zookeeper.
     * @return the limit quota path
     */
    public static String quotaPath(String path) {
        return quotaZookeeper + path + "/" + limitNode;
    }

    /**
     * return the stat quota path associated with this
     * prefix.
     * @param path the actual path in zookeeper
     * @return the stat quota path
     */
    public static String statPath(String path) {
        return quotaZookeeper + path + "/" + statNode;
    }

}
