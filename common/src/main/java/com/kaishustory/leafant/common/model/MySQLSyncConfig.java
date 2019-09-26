/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.kaishustory.leafant.common.model;

import lombok.Data;
import java.util.Date;
import java.util.Map;
import static com.kaishustory.leafant.common.constants.EventConstants.LOAD_STATUS_NO;

/**
 * MySQL同步配置
 *
 * @author liguoyang
 * @create 2019-09-09 11:20
 **/
@Data
public class MySQLSyncConfig {

    /**
     * 主键
     */
    private String id;

    /**
     * 环境
     */
    private String env;

    /**
     * 是否分表
     */
    private boolean isSharding = false;

    /**
     * 数据源实例
     */
    private String sourceRds;

    /**
     * 数据源库
     */
    private String sourceDatabase;

    /**
     * 数据源表
     */
    private String sourceTable;

    /**
     * 数据源配置
     */
    private SyncDataSourceConfig sourceDataSource;

    /**
     * 目标数据源 <ID余数，目标数据源>
     */
    private Map<Long, SyncDataSourceConfig> targetDataSource;

    /**
     * 分表列
     */
    private String shardingCol;

    /**
     * 是否同步
     */
    private boolean sync = false;

    /**
     * 初始化状态：no：未初始化，initing：初始化中，complete：完成，fail：失败
     */
    private String init = LOAD_STATUS_NO;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;



}