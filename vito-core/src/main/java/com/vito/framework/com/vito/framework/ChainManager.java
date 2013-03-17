package com.vito.framework.com.vito.framework;

import com.vito.com.vito.processor.Processor;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 3/17/13
 * Time: 8:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ChainManager {

    public void addProcessor(Processor processor);

    public Processor removeProcessor();

    public void processChain();

}
