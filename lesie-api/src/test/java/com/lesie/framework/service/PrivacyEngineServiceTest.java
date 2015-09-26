/**
 *      Copyright 2015 CPUT
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package com.lesie.framework.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrivacyEngineServiceTest {

    private PrivacyEngineService privacyEngineService;

    @Before
    public void init(){
        privacyEngineService = new PrivacyEngineService();
    }

    @Test
    public void testCanShare(){
        String result = privacyEngineService.canShare("1", "2", "3");
        Assert.assertEquals("Not a success", "Y", result);
    }
}
