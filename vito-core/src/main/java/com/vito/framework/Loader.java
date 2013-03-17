package com.vito.framework;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 3/17/13
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Loader<T> {
    public void load(T ... options);
}
