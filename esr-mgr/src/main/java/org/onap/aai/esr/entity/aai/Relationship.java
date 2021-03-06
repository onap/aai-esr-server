/**
 * Copyright 2018 ZTE Corporation.
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
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Relationship implements Serializable{

    public static final long serialVersionUID = 1L;
    
    @SerializedName("related-to")
    private String relatedTo;
    
    @SerializedName("related-link")
    private String relatedLink;
    
    @SerializedName("relationship-data")
    private List<RelationshipData> relationshipData;

    public String getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
    }

    public String getRelatedLink() {
        return relatedLink;
    }

    public void setRelatedLink(String relatedLink) {
        this.relatedLink = relatedLink;
    }

    public List<RelationshipData> getRelationshipData() {
        return relationshipData;
    }

    public void setRelationshipData(List<RelationshipData> relationshipData) {
        this.relationshipData = relationshipData;
    }
}
