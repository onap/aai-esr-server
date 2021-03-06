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
package org.onap.aai.esr.entity.aai;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class CloudRegionDetail implements Serializable {

    public static final long serialVersionUID = 1L;

    @SerializedName("cloud-owner")
    private String cloudOwner;

    @SerializedName("cloud-region-id")
    private String cloudRegionId;

    @SerializedName("cloud-type")
    private String cloudType;

    @SerializedName("cloud-region-version")
    private String cloudRegionVersion;

    @SerializedName("owner-defined-type")
    private String ownerDefinedType;

    @SerializedName("cloud-zone")
    private String cloudZone;

    @SerializedName("complex-name")
    private String complexName;

    @SerializedName("cloud-extra-info")
    private String cloudExtraInfo;

    @SerializedName("resource-version")
    private String resourceVersion;

    @SerializedName("esr-system-info-list")
    private EsrSystemInfoList esrSystemInfoList;

    public String getCloudOwner() {
        return cloudOwner;
    }

    public void setCloudOwner(String cloudOwner) {
        this.cloudOwner = cloudOwner;
    }

    public String getCloudRegionId() {
        return cloudRegionId;
    }

    public void setCloudRegionId(String cloudRegionId) {
        this.cloudRegionId = cloudRegionId;
    }

    public String getCloudType() {
        return cloudType;
    }

    public void setCloudType(String cloudType) {
        this.cloudType = cloudType;
    }

    public String getCloudRegionVersion() {
        return cloudRegionVersion;
    }

    public void setCloudRegionVersion(String cloudRegionVersion) {
        this.cloudRegionVersion = cloudRegionVersion;
    }

    public String getOwnerDefinedType() {
        return ownerDefinedType;
    }

    public void setOwnerDefinedType(String ownerDefinedType) {
        this.ownerDefinedType = ownerDefinedType;
    }

    public String getCloudZone() {
        return cloudZone;
    }

    public void setCloudZone(String cloudZone) {
        this.cloudZone = cloudZone;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public String getCloudExtraInfo() {
        return cloudExtraInfo;
    }

    public void setCloudExtraInfo(String cloudExtraInfo) {
        this.cloudExtraInfo = cloudExtraInfo;
    }

    public String getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public EsrSystemInfoList getEsrSystemInfoList() {
        return esrSystemInfoList;
    }

    public void setEsrSystemInfoList(EsrSystemInfoList esrSystemInfoList) {
        this.esrSystemInfoList = esrSystemInfoList;
    }

}
