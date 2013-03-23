package com.vito.framework;

import com.google.common.collect.Multimap;

import java.util.List;
import java.util.Map;


public interface Processor<T> {
    public Map<String,List<String>> process(T input);
}
