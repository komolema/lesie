package com.vito.chain;

import com.google.common.collect.Table;
import com.vito.framework.Processor;
import com.vito.framework.ChainManager;

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
    private Map configMap;

    @Override
    public void addProcessor(Processor processor) {
        processorQueue.add(processor);
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
