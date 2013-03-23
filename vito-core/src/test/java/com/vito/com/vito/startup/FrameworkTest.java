package com.vito.com.vito.startup;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
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
        processorList.add("com.vito.configuration.impl.ConfigurationProcessor");

        config.put("processors",processorList);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testStart() throws Exception {
        framework.start(config);
    }
}
