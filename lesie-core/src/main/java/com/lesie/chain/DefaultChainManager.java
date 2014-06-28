/**
 *      Copyright 2014 CPUT
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

package com.lesie.chain;

import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import com.google.inject.Inject;
import com.lesie.framework.Processor;
import com.lesie.framework.ChainManager;

import java.util.*;


public class DefaultChainManager implements ChainManager {
    @Inject
    private Queue<Processor> processorQueue;
    private Map<String,List<String>> configMap;

    @Override
    public void setConfig(Map<String,List<String>> config) {
        configMap = config;
    }

    @Override
    public void addProcessor(Processor processor) {
        processorQueue.add(processor);
    }

    @Override
    public void addProcessor(Collection<String> processors) throws Exception {
        for(String procStr : processors){
            Class procClass = Class.forName(procStr);
            Processor processor = (Processor)procClass.newInstance();

            addProcessor(processor);
        }
    }


    @Override
    public void processChain() throws Exception {
        Processor processor = processorQueue.poll();

        if(processor != null){
            configMap = processor.process(configMap);
        }
        else{
            return;
        }
        processChain();
    }

    public void setProcessorQueue(Queue<Processor> processorQueue) {
        this.processorQueue = processorQueue;
    }
}
