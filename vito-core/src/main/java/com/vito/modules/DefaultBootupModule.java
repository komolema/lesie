package com.vito.modules;

import com.google.inject.AbstractModule;
import com.vito.chain.DefaultChainManager;
import com.vito.framework.ChainManager;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 3/17/13
 * Time: 11:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultBootupModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ChainManager.class).to(DefaultChainManager.class);
    }
}
