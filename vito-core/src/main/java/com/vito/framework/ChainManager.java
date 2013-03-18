package com.vito.framework;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 3/17/13
 * Time: 8:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ChainManager {

    public void addProcessor(Processor processor);

    public void processChain();

}
