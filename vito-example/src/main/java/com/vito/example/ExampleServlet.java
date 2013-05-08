package com.vito.example;

import com.vito.framework.Framework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 5/7/13
 * Time: 4:03 AM
 * To change this template use File | Settings | File Templates.
 */
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
    }
}
