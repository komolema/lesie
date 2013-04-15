package com.vito.startup;

import com.vito.domain.Owner;
import com.vito.framework.Framework;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrameworkTest {

    private Framework framework;
    private Map<String,List<String>> config;

    @Before
    public void setUp() throws Exception {

        framework = new Framework();

        config = new HashMap<String,List<String>>() ;

        List<String> processorList = new ArrayList<String>();
        processorList.add("com.vito.configuration.ConfigurationProcessor");
        processorList.add("com.vito.finder.FinderProcessor");
        processorList.add("com.vito.attacher.DefaultAttacher");

        List<String> domainList = new ArrayList<String>();
        domainList.add("com.vito.domain");
        config.put("domain", domainList);


        config.put("processors",processorList);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testStart() throws Exception {
        framework.start(config);
       // Owner owner = new Owner();

       // owner.setId("123");
    }
}
