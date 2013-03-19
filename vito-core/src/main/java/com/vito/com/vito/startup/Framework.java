package com.vito.com.vito.startup;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.vito.bootstrap.impl.DefaultBootStrap;
import com.vito.framework.Bootstrap;
import com.vito.modules.DefaultBootupModule;

import java.util.Map;

/**
 * File:Framework.java
 * Description: This class is the bootstrapping class that lo
 */
public class Framework {

    private Bootstrap bootStrap;

    public void start(Map<String,String> config) throws Exception{
        Injector injector = Guice.createInjector(new DefaultBootupModule());

        bootStrap =new DefaultBootStrap();

        bootStrap.init(config);


    }
}
