package com.vito.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.ScopedBindingBuilder;
import com.vito.bootstrap.impl.DefaultBootStrap;
import com.vito.chain.DefaultChainManager;
import com.vito.framework.Bootstrap;
import com.vito.framework.ChainManager;
import com.vito.framework.Processor;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;


public class DefaultBootupModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Bootstrap.class).to(DefaultBootStrap.class).in(Scopes.SINGLETON);
        bind(ChainManager.class).to(DefaultChainManager.class);
        bind(new TypeLiteral<Queue<Processor>>(){}).to(new TypeLiteral<LinkedList<Processor>>(){}) ;
    }
}
