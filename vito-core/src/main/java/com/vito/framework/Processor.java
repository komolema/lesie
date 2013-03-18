package com.vito.framework;

import java.util.Map;



public interface Processor<T> {
    public Map process(T input);
}
