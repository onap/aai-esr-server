/**
 * Copyright 2016 ZTE Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onap.aai.esr.dao;

import org.hibernate.SessionFactory;
import org.onap.aai.esr.entity.db.BaseData;


/**
 * a common class for Hibernate DAO classes.<br>
 * 
 * @author 10159474
 * 
 */
public class CommonDao extends BaseDao<BaseData> {

  /**
   * init session.
   * 
   * @param sessionFactory session Factory
   */
  public CommonDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }


}
