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

package com.kaishustory.leafant.subscribe.model;

import lombok.Data;

/**
 * 主键字段信息
 *
 * @author liguoyang
 * @create 2019-09-11 17:07
 **/
@Data
public class PriColInfo {

    private String table;

    private String col;

    private boolean isNum;

    private String type;

    private String comment;

    public PriColInfo(String table, String col, String dataType, String type, String comment) {
        this.table = table;
        this.col = col;
        this.isNum = dataType.toLowerCase().matches(".*int|decimal.*");
        this.type = type;
        this.comment = comment;
    }
}
