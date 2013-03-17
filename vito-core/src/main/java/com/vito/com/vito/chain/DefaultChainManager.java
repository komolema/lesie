package com.vito.com.vito.chain;

import com.vito.com.vito.processor.Processor;
import com.vito.framework.com.vito.framework.ChainManager;
import com.vito.framework.com.vito.framework.Loader;

import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 3/17/13
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultChainManager implements ChainManager {

    private Queue<Processor<Loader>> processorQueue;

    @Override
    public void addProcessor(Processor processor) {

    }

    @Override
    public Processor removeProcessor() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void processChain() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
