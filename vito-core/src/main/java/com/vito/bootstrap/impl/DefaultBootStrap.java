package com.vito.bootstrap.impl;

import com.google.inject.Inject;
import com.vito.framework.Bootstrap;
import com.vito.framework.ChainManager;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 3/17/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultBootStrap implements Bootstrap {

    @Inject
    private List<String> processors;
    @Inject
    private ChainManager chainManager;
    @Inject
    private Map<String,String> config;

    @Override
    public void init(Map<String,String> config) throws Exception {

        chainManager.setConfig(config);
        chainManager.addProcessor(processors);
    }


    public List<String> getProcessors() {
        return processors;
    }

    public void setProcessors(List<String> processors) {
        this.processors = processors;
    }

    public ChainManager getChainManager() {
        return chainManager;
    }

    public void setChainManager(ChainManager chainManager) {
        this.chainManager = chainManager;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }
}
