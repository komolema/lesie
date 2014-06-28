/**
 *      Copyright 2014 CPUT
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

package com.lesie.example;

import com.lesie.example.domain.Example;
import com.lesie.framework.Framework;
import org.lesie.loader.web.TomcatLesieLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ExampleServlet extends javax.servlet.http.HttpServlet {

    Framework lesieFramework;
    public void init(){
        HashMap<String, List<String>> config = new HashMap<String, List<String>>();;

        List<String> processorList = new ArrayList<String>();
        processorList.add("com.lesie.configuration.ConfigurationProcessor");
        processorList.add("com.lesie.finder.FinderProcessor");
        processorList.add("com.lesie.attacher.DefaultAttacher");

        List<String> domainList = new ArrayList<String>();
        domainList.add("com.lesie.example.domain");
        config.put("domain", domainList);

        List<String> envList = new ArrayList<String>();
        envList.add("tomcat");
        config.put("env",envList);

        config.put("processors",processorList);
        try {
            lesieFramework.getInstance().start(config);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Example example = new Example();

        example.setId("123");


    }
}
