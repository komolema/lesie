package com.vito.framework;

import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.List;
import java.util.Map;



public interface ChainManager {

    public void setConfig(Map<String,List<String>> config)  ;

    public void addProcessor(Processor processor);

    public void addProcessor(Collection<String> processors) throws Exception;

    public void processChain();

}
