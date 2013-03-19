package com.vito.chain;

import com.google.common.collect.Table;
import com.vito.framework.Processor;
import com.vito.framework.ChainManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 3/17/13
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultChainManager implements ChainManager {

    private Queue<Processor> processorQueue;
    private Map<String,String> configMap;

    @Override
    public void setConfig(Map<String, String> config) {
        configMap = config;
    }

    @Override
    public void addProcessor(Processor processor) {
        processorQueue.add(processor);
    }

    @Override
    public void addProcessor(List<String> processors) throws Exception {
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
}
