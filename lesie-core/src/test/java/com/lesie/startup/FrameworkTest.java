/**
 *      Copyright 2013 CPUT
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

package com.lesie.startup;

import com.lesie.domain.Owner;
import com.lesie.framework.Framework;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.lesie.loader.standard.StandardLesieLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrameworkTest {

    private Framework framework;
    private Map<String,List<String>> config;

    @BeforeClass
    public static void setUpClass() throws Exception{
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(new StandardLesieLoader(cl));
    }
    @Before
    public void setUp() throws Exception {


        framework =Framework.getInstance();

        config = new HashMap<String,List<String>>() ;

        List<String> processorList = new ArrayList<String>();
        processorList.add("com.lesie.configuration.ConfigurationProcessor");
        processorList.add("com.lesie.finder.FinderProcessor");
        processorList.add("com.lesie.attacher.DefaultAttacher");

        List<String> domainList = new ArrayList<String>();
        domainList.add("com.lesie.domain");
        config.put("domain", domainList);


        config.put("processors",processorList);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testStart() throws Exception {
        //framework.start(config);
        Owner owner = new Owner();

       // owner.setId("123");
    }
}
