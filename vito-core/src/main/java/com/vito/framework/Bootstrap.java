package com.vito.framework;


import com.google.common.collect.Multimap;

import java.util.List;
import java.util.Map;


public interface Bootstrap {

    public void init(Map<String,List<String>> config) throws Exception;

}
