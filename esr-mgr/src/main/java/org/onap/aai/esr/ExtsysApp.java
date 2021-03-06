/**
 * Copyright 2016-2018 ZTE Corporation.
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
package org.onap.aai.esr;


import org.onap.aai.esr.common.MsbConfig;
import org.onap.aai.esr.externalservice.msb.MsbHelper;
import org.onap.aai.esr.resource.EmsManager;
import org.onap.aai.esr.resource.PnfManager;
import org.onap.aai.esr.resource.ServiceTest;
import org.onap.aai.esr.resource.ThirdpartySdncManager;
import org.onap.aai.esr.resource.VimManager;
import org.onap.aai.esr.resource.VnfmManager;
import org.onap.aai.esr.resource.NfvoManager;
import org.onap.msb.sdk.httpclient.msb.MSBServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.server.SimpleServerFactory;
import io.dropwizard.setup.Environment;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ExtsysApp extends Application<ExtsysAppConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExtsysApp.class);

    public static void main(String[] args) throws Exception {
        new ExtsysApp().run(args);
    }

    @Override
    public String getName() {
        return "ONAP-ESR";
    }

    @Override
    public void run(ExtsysAppConfiguration configuration, Environment environment) {
        LOGGER.info("Start to initialize esr.");
        MsbConfig.setMsbServerAddr(configuration.getMsbServerAddr());
        MsbConfig.setMsbDiscoveryIp(configuration.getMsbDiscoveryIp());
        MsbConfig.setMsbDiscoveryPort(configuration.getMsbDiscoveryPort());
        environment.jersey().register(new EmsManager());
        environment.jersey().register(new ThirdpartySdncManager());
        environment.jersey().register(new VimManager());
        environment.jersey().register(new VnfmManager());
        environment.jersey().register(new NfvoManager());
        environment.jersey().register(new PnfManager());
        environment.jersey().register(new ServiceTest());
        initSwaggerConfig(environment, configuration);
        if ("false".equals(configuration.getRegistByHand())) {
            String MSB_IP = configuration.getMsbDiscoveryIp();
            Integer MSB_Port = Integer.valueOf(configuration.getMsbDiscoveryPort());
            MSBServiceClient msbClient = new MSBServiceClient(MSB_IP, MSB_Port);
            MsbHelper helper = new MsbHelper(msbClient);
            try {
                helper.registerMsb();
                LOGGER.info("Register esr-server to msb by java-sdk finished");
            } catch (Exception e) {
                LOGGER.error("Register esr-server to msb by java-sdk failed", e);
            }
        }
        LOGGER.info("Initialize extsys finished.");
    }
    
    /**
     * initialize swagger configuration.
     * 
     * @param environment environment information
     * @param configuration catalogue configuration
     */
    private void initSwaggerConfig(Environment environment, ExtsysAppConfiguration configuration) {
        environment.jersey().register(new ApiListingResource());
        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        BeanConfig config = new BeanConfig();
        config.setTitle("ONAP ESR Service rest API");
        config.setVersion("1.0.0");
        config.setResourcePackage("org.onap.aai.esr.resource");
        // set rest api basepath in swagger
        SimpleServerFactory simpleServerFactory =
                (SimpleServerFactory) configuration.getServerFactory();
        String basePath = simpleServerFactory.getApplicationContextPath();
        String rootPath = simpleServerFactory.getJerseyRootPath().get();
        rootPath = rootPath.substring(0, rootPath.indexOf("/*"));
        basePath =
                basePath.equals("/") ? rootPath : (new StringBuilder()).append(basePath)
                        .append(rootPath).toString();
        LOGGER.info("getApplicationContextPath: " + basePath);
        config.setBasePath(basePath);
        config.setScan(true);
    }
    
}
