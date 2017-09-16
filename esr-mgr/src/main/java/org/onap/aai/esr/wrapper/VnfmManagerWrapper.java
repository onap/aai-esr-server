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
package org.onap.aai.esr.wrapper;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.onap.aai.esr.entity.aai.CloudRegionDetail;
import org.onap.aai.esr.entity.aai.EsrVnfmDetail;
import org.onap.aai.esr.entity.rest.CommonRegisterResponse;
import org.onap.aai.esr.entity.rest.VnfmRegisterInfo;
import org.onap.aai.esr.externalservice.aai.CloudRegionProxy;
import org.onap.aai.esr.externalservice.aai.ExternalSystemProxy;
import org.onap.aai.esr.util.VimManagerUtil;
import org.onap.aai.esr.util.VnfmManagerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class VnfmManagerWrapper {
  private static VnfmManagerWrapper vnfmManagerWrapper;
  private static final Logger LOG = LoggerFactory.getLogger(VnfmManagerWrapper.class);

  /**
   * get VnfmManagerWrapper instance.
   * @return vnfm manager wrapper instance
   */
  public static VnfmManagerWrapper getInstance() {
    if (vnfmManagerWrapper == null) {
      vnfmManagerWrapper = new VnfmManagerWrapper();
    }
    return vnfmManagerWrapper;
  }

  public Response registerVnfm(VnfmRegisterInfo vnfm) {
    CommonRegisterResponse result = new CommonRegisterResponse();
    EsrVnfmDetail esrVnfmDetail = new EsrVnfmDetail();
    esrVnfmDetail = VnfmManagerUtil.vnfmRegisterInfo2EsrVnfm(vnfm);
    String vnfmId = esrVnfmDetail.getVnfmId();
    try {
      ExternalSystemProxy.registerVnfm(vnfmId, esrVnfmDetail);
      result.setId(vnfmId);
      return Response.ok(result).build();
    } catch (Exception e) {
      LOG.error("Register VNFM failed !" + e.getMessage());
      return Response.serverError().build();
    }
  }
  
  public Response updateVnfm(VnfmRegisterInfo vnfm, String vnfmId) {
    //TODO
    return Response.ok().build();
  }
  
  public Response queryVnfmList() {
    ArrayList<VnfmRegisterInfo> vnfmList = new ArrayList<VnfmRegisterInfo>();
    //TODO
    return Response.ok(vnfmList).build();
  }
  
  public Response queryVnfmById(String vnfmId) {
    VnfmRegisterInfo vnfm = new VnfmRegisterInfo();
    EsrVnfmDetail esrVnfmDetail = new EsrVnfmDetail();
    try {
      String esrVnfmstr = ExternalSystemProxy.queryVnfmDetail(vnfmId);
      LOG.info("Response from AAI by query VNFM: " + esrVnfmstr);
      esrVnfmDetail = new Gson().fromJson(esrVnfmstr, EsrVnfmDetail.class);
      vnfm = VnfmManagerUtil.esrVnfm2VnfmRegisterInfo(esrVnfmDetail);
      return Response.ok(vnfm).build();
    } catch (Exception e) {
      e.printStackTrace();
      return Response.serverError().build();
    }
  }
  
  public Response delVnfm(String vnfmId) {
    //TODO
    return Response.noContent().build();
  }
}
