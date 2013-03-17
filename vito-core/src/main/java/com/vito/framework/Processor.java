package com.vito.framework;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 3/17/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Processor<T> {
    public void handleRequest(T request);
}
