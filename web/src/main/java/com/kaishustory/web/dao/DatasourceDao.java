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

package com.kaishustory.web.dao;

import com.kaishustory.web.model.Datasource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据源管理Dao
 *
 * @author liguoyang
 * @create 2019-08-13 16:41
 **/
@Component
public class DatasourceDao {

    /**
     * Mongo
     */
    @Resource(name = "mongoTemplate")
    private MongoTemplate mongoTemplate;

    /**
     * 环境
     */
    @Value("${spring.profiles.active}")
    private String env;

    /**
     * 数据源集合
     */
    private final String collection = "datasource";

    /**
     * 查询数据源列表
     */
    public List<Datasource> findDatabaseList(){
        return mongoTemplate.find(Query.query(Criteria.where("env").is(env)), Datasource.class, collection);
    }

    /**
     * 查询数据源
     * @param id 数据源ID
     */
    public Datasource get(String id){
        return mongoTemplate.findById(id, Datasource.class, collection);
    }

    /**
     * 保存数据源
     * @param datasource 数据源信息
     */
    public void save(Datasource datasource){
        datasource.setEnv(env);
        mongoTemplate.save(datasource, collection);
    }

    /**
     * 删除数据源
     * @param id 数据源ID
     */
    public void delete(String id){
        mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), Datasource.class, collection);
    }
}
