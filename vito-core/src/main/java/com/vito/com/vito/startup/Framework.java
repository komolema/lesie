package com.vito.com.vito.startup;

import com.google.common.collect.Multimap;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.vito.bootstrap.impl.DefaultBootStrap;
import com.vito.framework.Bootstrap;
import com.vito.modules.DefaultBootupModule;

import java.util.List;
import java.util.Map;

/**
 * File:Framework.java
 * Description: This class is the bootstrapping class that lo
 */
public class Framework {



    private Bootstrap  bootstrap;



    public void start(Map<String,List<String>> config) throws Exception{
        Injector injector = Guice.createInjector(new DefaultBootupModule());

        bootstrap = injector.getInstance(DefaultBootStrap.class);
        bootstrap.init(config);

    }

    @Inject
    public void setBootstrap(Bootstrap bootstrap){
        this.bootstrap = bootstrap;
    }
}
