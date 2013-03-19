package com.vito.framework;

import java.util.List;
import java.util.Map;



public interface ChainManager {

    public void setConfig(Map<String,String> config)  ;

    public void addProcessor(Processor processor);

    public void addProcessor(List<String> processors) throws Exception;

    public void processChain();

}
