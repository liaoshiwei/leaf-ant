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

package com.kaishustory.leafant.mapping.model;

import lombok.Data;

/**
 * 初始化加载状态
 *
 * @author liguoyang
 * @create 2019-09-11 13:51
 **/
@Data
public class LoadStats {

    private long wait = 0L;

    private long send = 0L;

    private long suceess = 0L;

    private long fail = 0L;
}
