/**
 * Copyright 2017-2018 ZTE Corporation.
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
package org.onap.aai.esr.externalservice.cloud;

import org.glassfish.jersey.client.ClientConfig;
import org.onap.aai.esr.common.MsbConfig;
import org.onap.aai.esr.exception.ExtsysException;
import com.eclipsesource.jaxrs.consumer.ConsumerFactory;

public class VimManagerProxy {
    
//    private VimManagerProxy() {
//	
//    }

    public void updateVim(String cloudOwner, String cloudRegionId, Tenant tenant) throws ExtsysException {
        ClientConfig config = new ClientConfig(new VimUpdateProvider());
        IVimManage updateVimServiceproxy =
                ConsumerFactory.createConsumer(MsbConfig.getMultiCloudAddr(), config, IVimManage.class);
        try {
            updateVimServiceproxy.updateVIM(cloudOwner, cloudRegionId, tenant);
        } catch (Exception e) {
            throw new ExtsysException("Update cloud region to A&AI by Multi-Cloud failed.", e);
        }
    }
}
