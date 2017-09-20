/**
 * Copyright 2017 ZTE Corporation.
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
package org.onap.aai.esr.entity.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommonRegisterResponseTest {
  @Test
  public void getterAndSetter4id(){
      final String id = "312erqdfa";
      CommonRegisterResponse commonRegisterResponse = new CommonRegisterResponse();
      commonRegisterResponse.setId(id);
      assertEquals(commonRegisterResponse.getId(), id);
  }
}
