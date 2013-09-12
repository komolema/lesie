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

package com.vito.example;

import com.vito.example.domain.Example;
import com.vito.framework.Framework;
import org.vito.loader.web.TomcatVitoLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ExampleServlet extends javax.servlet.http.HttpServlet {

    Framework vitoFramework;
    public void init(){
        HashMap<String, List<String>> config = new HashMap<String, List<String>>();;

        List<String> processorList = new ArrayList<String>();
        processorList.add("com.vito.configuration.ConfigurationProcessor");
        processorList.add("com.vito.finder.FinderProcessor");
        processorList.add("com.vito.attacher.DefaultAttacher");

        List<String> domainList = new ArrayList<String>();
        domainList.add("com.vito.example.domain");
        config.put("domain", domainList);

        List<String> envList = new ArrayList<String>();
        envList.add("tomcat");
        config.put("env",envList);

        config.put("processors",processorList);
        try {
            vitoFramework.getInstance().start(config);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Example example = new Example();

        example.setId("123");

        TomcatVitoLoader loader = new TomcatVitoLoader(Thread.currentThread().getContextClassLoader());
        try {
            Example example2 = (Example) loader.loadClass(Example.class.getCanonicalName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
