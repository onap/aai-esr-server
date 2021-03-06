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

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CloudRegionListTest {

    @Test
    public void getterAndSetter4cloudRegion() {
        CloudRegionList cloudRegionList = new CloudRegionList();
        List<CloudRegion> cloudRegions = new ArrayList<>();
        CloudRegion cloudRegion = new CloudRegion();
        cloudRegion.setCloudOwner("owner");
        cloudRegion.setCloudRegionId("regionId");
        cloudRegions.add(cloudRegion);
        cloudRegionList.setCloudRegion(cloudRegions);
        assertEquals(cloudRegionList.getCloudRegion(), cloudRegions);
    }
}
