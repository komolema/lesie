package com.vito.bootstrap.impl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.vito.framework.bootstrap;
import com.vito.modules.DefaultBootupModule;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 3/17/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultBootStrap implements bootstrap {

    private Map<String,String> processors;

    @Override
    public void init() {

        // initialise the guice modules
        Injector injector = Guice.createInjector(new DefaultBootupModule());
    }


}
