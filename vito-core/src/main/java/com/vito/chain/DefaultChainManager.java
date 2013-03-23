package com.vito.chain;

import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import com.google.inject.Inject;
import com.vito.framework.Processor;
import com.vito.framework.ChainManager;

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
    public void processChain() {
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
