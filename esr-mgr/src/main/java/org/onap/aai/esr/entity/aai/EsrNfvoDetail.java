/**
 * Copyright 2019  Verizon. All Rights Reserved.
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

public class EsrNfvoDetail implements Serializable {

    public static final long serialVersionUID = 1L;

    @SerializedName("nfvo-id")
    private String nfvoId;

    @SerializedName("resource-version")
    private String resourceVersion;

    @SerializedName("api-root")
    private String apiroot;
    
    @SerializedName("esr-system-info-list")
    private EsrSystemInfoList esrSystemInfoList;

    public String getNfvoId() {
        return nfvoId;
    }

    public void setNfvoId(String nfvoId) {
        this.nfvoId = nfvoId;
    }

    public void setApiroot(String apiroot) {
        this.apiroot = apiroot;
    }

    public EsrSystemInfoList getEsrSystemInfoList() {
        return esrSystemInfoList;
    }

    public void setEsrSystemInfoList(EsrSystemInfoList esrSystemInfoList) {
        this.esrSystemInfoList = esrSystemInfoList;
    }

    public String getResourceVersion() {
        return resourceVersion;
    }

    public String getApiroot() {
        return apiroot;
    }

    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

}
