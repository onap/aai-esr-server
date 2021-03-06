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
package org.onap.aai.esr.util;

import org.onap.aai.esr.common.SystemType;
import org.onap.aai.esr.entity.aai.EsrSystemInfo;
import org.onap.aai.esr.entity.aai.EsrSystemInfoList;
import org.onap.aai.esr.entity.aai.EsrVnfmDetail;
import org.onap.aai.esr.entity.rest.VnfmRegisterInfo;

public class VnfmManagerUtil {
    private static ExtsysUtil extsysUtil = new ExtsysUtil();

    public EsrVnfmDetail vnfmRegisterInfo2EsrVnfm(VnfmRegisterInfo vnfmRegisterInfo) {
        EsrVnfmDetail esrVnfm = new EsrVnfmDetail();
        esrVnfm.setCertificateUrl(vnfmRegisterInfo.getCertificateUrl());
        esrVnfm.setVimId(vnfmRegisterInfo.getVimId());
        esrVnfm.setVnfmId(extsysUtil.generateId());
        EsrSystemInfo authInfo = getAuthInfoFromVnfmRegisterInfo(vnfmRegisterInfo);
        EsrSystemInfoList esrSystemInfo = extsysUtil.getEsrSystemInfoListFromAuthInfo(authInfo);
        esrVnfm.setEsrSystemInfoList(esrSystemInfo);
        return esrVnfm;
    }

    /**
     * @param vnfmRegisterInfo vnfm register informantion from portal
     * @return
     */
    private EsrSystemInfo getAuthInfoFromVnfmRegisterInfo(VnfmRegisterInfo vnfmRegisterInfo) {
        EsrSystemInfo authInfo = new EsrSystemInfo();
        authInfo.setEsrSystemInfoId(extsysUtil.generateId());
        authInfo.setSystemName(vnfmRegisterInfo.getName());
        authInfo.setType(vnfmRegisterInfo.getType());
        authInfo.setVendor(vnfmRegisterInfo.getVendor());
        authInfo.setVersion(vnfmRegisterInfo.getVersion());
        authInfo.setServiceUrl(vnfmRegisterInfo.getUrl());
        authInfo.setUserName(vnfmRegisterInfo.getUserName());
        authInfo.setPassword(vnfmRegisterInfo.getPassword());
        authInfo.setSystemType(SystemType.VNFM.toString());
        return authInfo;
    }

    public VnfmRegisterInfo esrVnfm2VnfmRegisterInfo(EsrVnfmDetail esrVnfm) {
        VnfmRegisterInfo vnfmRegisterInfo = new VnfmRegisterInfo();
        vnfmRegisterInfo.setVnfmId(esrVnfm.getVnfmId());
        vnfmRegisterInfo.setCertificateUrl(esrVnfm.getCertificateUrl());
        vnfmRegisterInfo.setVimId(esrVnfm.getVimId());
        EsrSystemInfo authInfo = esrVnfm.getEsrSystemInfoList().getEsrSystemInfo().get(0);
        vnfmRegisterInfo.setName(authInfo.getSystemName());
        vnfmRegisterInfo.setPassword(authInfo.getPassword());
        vnfmRegisterInfo.setType(authInfo.getType());
        vnfmRegisterInfo.setUrl(authInfo.getServiceUrl());
        vnfmRegisterInfo.setUserName(authInfo.getUserName());
        vnfmRegisterInfo.setVendor(authInfo.getVendor());
        vnfmRegisterInfo.setVersion(authInfo.getVersion());
        return vnfmRegisterInfo;
    }

}
