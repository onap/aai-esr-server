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
package org.onap.aai.esr.externalservice.aai;

import org.junit.Before;
import org.junit.Test;
import org.onap.aai.esr.common.MsbConfig;
import org.onap.aai.esr.entity.aai.CloudRegionDetail;
import org.onap.aai.esr.exception.ExtsysException;

public class CloudRegionProxyTest {

    CloudRegionProxy proxy;

    @Before
    public void init() {
        MsbConfig.setMsbServerAddr("http://msb-server");
        proxy = new CloudRegionProxy();
    }

    @Test(expected = ExtsysException.class)
    public void testRegisterVim() throws ExtsysException {
        CloudRegionDetail cloudRegion = new CloudRegionDetail();
        proxy.registerVim("owner-1", "region-1", cloudRegion);
    }

    @Test(expected = ExtsysException.class)
    public void testQueryVimDetail() throws ExtsysException {
        proxy.queryVimDetail("owner-1", "region-1");
    }

    @Test(expected = ExtsysException.class)
    public void testQueryVimList() throws ExtsysException {
        proxy.qureyVimList();
    }

    @Test(expected = ExtsysException.class)
    public void testDeleteVim() throws ExtsysException {
        proxy.deleteVim("owner-1", "region-1", "version-1");
    }
}
