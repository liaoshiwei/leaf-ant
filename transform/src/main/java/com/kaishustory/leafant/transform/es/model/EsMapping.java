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

package com.kaishustory.leafant.transform.es.model;

import com.kaishustory.leafant.common.utils.JsonUtils;
import lombok.Data;

import java.util.LinkedHashMap;

/**
 * ElasticSearch索引映射
 *
 * @author liguoyang
 * @create 2019-08-07 10:59
 **/
@Data
public class EsMapping {

    /**
     * 是否动态动态索引（true：动态结构, false: 固定结构[新增字段忽略]，strict：固定结构[新增字段报错]）
     */
    private String dynamic = "false";

    /**
     * 属性列表
     */
    private LinkedHashMap<String, MappingProperty> properties = new LinkedHashMap<>();


    /**
     * 索引字段
     */
    @Data
    public static class MappingProperty{

        public MappingProperty() {
        }

        public MappingProperty(String type, String index) {
            this.type = type;
            this.index = index;
            if("date".equals(type)){
                format = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis";
            }
        }

        /**
         * 属性类型（keyword：文本不分词，text：文本分词）
         */
        private String type;

        /**
         * 索引类型（true：索引，false：不索引）
         */
        private String index;

        /**
         * 日期格式
         */
        private String format;

    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
