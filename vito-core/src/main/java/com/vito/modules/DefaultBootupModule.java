/**
 *      Copyright 2013 CPUT
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package com.vito.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.matcher.Matchers;
import com.vito.bootstrap.impl.DefaultBootStrap;
import com.vito.chain.DefaultChainManager;
import com.vito.framework.Bootstrap;
import com.vito.framework.ChainManager;
import com.vito.framework.Processor;
import com.vito.util.Slf4jTypeListener;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;


public class DefaultBootupModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Bootstrap.class).to(DefaultBootStrap.class).in(Scopes.SINGLETON);
        bind(ChainManager.class).to(DefaultChainManager.class);
        bind(new TypeLiteral<Queue<Processor>>(){}).to(new TypeLiteral<LinkedList<Processor>>(){});
        bindListener(Matchers.any(), new Slf4jTypeListener());
    }
}
