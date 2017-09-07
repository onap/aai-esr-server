/**
 * Copyright 2016-2017 ZTE Corporation.
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


public class EmsRestData extends BaseRestData{

  private String emsId;
  
  private String name;
  
  private String vendor;
  
  private String version;
  
  private FtpAddr resourceAddr;
  
  private FtpAddr performanceAddr;
  
  private AlarmAddr alarmAddr;

  public String getEmsId() {
    return emsId;
  }

  public void setEmsId(String emsId) {
    this.emsId = emsId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public FtpAddr getResourceAddr() {
    return resourceAddr;
  }

  public void setResourceAddr(FtpAddr resourceAddr) {
    this.resourceAddr = resourceAddr;
  }

  public FtpAddr getPerformanceAddr() {
    return performanceAddr;
  }

  public void setPerformanceAddr(FtpAddr performanceAddr) {
    this.performanceAddr = performanceAddr;
  }

  public AlarmAddr getAlarmAddr() {
    return alarmAddr;
  }

  public void setAlarmAddr(AlarmAddr alarmAddr) {
    this.alarmAddr = alarmAddr;
  }

}
