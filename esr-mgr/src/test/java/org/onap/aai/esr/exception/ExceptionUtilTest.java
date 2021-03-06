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
package org.onap.aai.esr.exception;

import org.junit.Assert;
import org.junit.Test;
import javax.ws.rs.WebApplicationException;

public class ExceptionUtilTest {

    @Test
    public void testBuildExceptionResponse() {
        WebApplicationException exp = ExceptionUtil.buildExceptionResponse("Exception from JUnit");
        Assert.assertNotNull(exp);
        Assert.assertNotNull(exp.getResponse());
        Assert.assertTrue(exp.getMessage().contains("498"));
    }
}
