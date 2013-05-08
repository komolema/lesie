package org.vito.loader.impl;

import org.vito.loader.VitoLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 5/7/13
 * Time: 3:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultVitoLoaderStrategy{

    public static final String GATE_CLASS = "gate";

    public static final String MARK_CLASS = "mark";

    private Map<String,Map<String,Class>> modifiedClasses = new HashMap<String, Map<String, Class>>();


    public void addGateClass(String classFullName,Class gateClass) {
        addModifiedClasses(GATE_CLASS,classFullName,gateClass);

    }

    public void addMarkClass(String classFullName,Class markClass) {
        addModifiedClasses(MARK_CLASS,classFullName,markClass);
    }

    public Class getModifiedClass(String className){
        Set<String> keys = modifiedClasses.keySet();

        for(String key :keys){
            Map<String, Class> modifiedMap = modifiedClasses.get(key);
            Class modifiedClass =modifiedMap.get(className);

            if(modifiedClass != null){
                return modifiedClass;
            }
        }
        return null;
    }

    private void addModifiedClasses(String type,String className,Class clazz){
        Map<String,Class> modifiedClassMap = modifiedClasses.get(type);
        Class modifiedClass;
        if(modifiedClassMap == null){
            modifiedClassMap = new HashMap<String,Class>();

        }else{
            modifiedClass = modifiedClassMap.get(className);
        }
        modifiedClassMap.put(className, clazz);
        modifiedClasses.put(type,modifiedClassMap);
    }



}
