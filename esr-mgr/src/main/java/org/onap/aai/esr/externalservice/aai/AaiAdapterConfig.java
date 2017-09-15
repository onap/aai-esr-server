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
package org.onap.aai.esr.externalservice.aai;

public class AaiAdapterConfig {
  
  protected static String cloudInfrastructureAddr;
  
  protected static String externalSystemAddr;
  
  public static void setCloudInfrastructureAddr(String address){
    cloudInfrastructureAddr = address;
  }
  
  public static String getCloudInfrastructureAddr(){
      return cloudInfrastructureAddr;
  }

  public static String getExternalSystemAddr() {
    return externalSystemAddr;
  }

  public static void setExternalSystemAddr(String externalSystemAddr) {
    AaiAdapterConfig.externalSystemAddr = externalSystemAddr;
  }
}
