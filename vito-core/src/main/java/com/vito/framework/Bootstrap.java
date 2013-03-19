package com.vito.framework;


import java.util.Map;

public interface Bootstrap {

    public void init(Map<String,String> config) throws Exception;

}
