package com.vito.framework;

import com.google.common.collect.Multimap;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.vito.bootstrap.impl.DefaultBootStrap;
import com.vito.framework.Bootstrap;
import com.vito.framework.annotations.logging.InjectLogger;
import com.vito.modules.DefaultBootupModule;
import com.vito.util.LoaderUtil;
import org.slf4j.Logger;
import org.vito.loader.VitoLoader;
import org.vito.loader.web.TomcatVitoLoader;

import java.util.List;
import java.util.Map;

/**
 * File:Framework.java
 * Description: This class is the bootstrapping class that lo
 */
public class Framework {



    private Bootstrap  bootstrap;

    private static Framework frameworkInstance;

    private static boolean started = false;

    @InjectLogger
    private Logger log;

    private Framework(){

    }

    public static Framework getInstance(){

        synchronized (Framework.class){
            if(frameworkInstance == null){
                frameworkInstance = new Framework();
            }
            return frameworkInstance;
        }
    }

    public static boolean isStarted(){
        return started;
    }


    public void start(Map<String,List<String>> config) throws Exception{
        Injector injector = Guice.createInjector(new DefaultBootupModule());
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        bootstrap = injector.getInstance(DefaultBootStrap.class);
        String runtime_env = config.get("env").get(0);

        if(LoaderUtil.isVitoClassLoader(cl)){

            //boolean vitoLoaderClazz;
            started = true;
            bootstrap.init(config);
            LoaderUtil.invokeMethodOnLoader(cl,"setFrameworkStarted",true);

        }else{
            log.info("V-001:ClassLoader is not of type VitoLoader");
        }


    }

    @Inject
    public void setBootstrap(Bootstrap bootstrap){
        this.bootstrap = bootstrap;
    }
}
