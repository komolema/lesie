package com.vito.com.vito.startup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 3/19/13
 * Time: 11:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class FrameworkTest {

    private Framework framework;
    private Map<String,String> config;

    @Before
    public void setUp() throws Exception {

        framework = new Framework();

        config = new HashMap<String,String>();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testStart() throws Exception {
        framework.start(config);
    }
}
