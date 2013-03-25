package com.vito.finder;


import com.vito.exception.FinderException;
import com.vito.framework.Processor;
import com.vito.framework.gate.Gate;
import com.vito.framework.mark.Mark;
import org.reflections.Reflections;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/*
 *Description: this class is responsible for locating all the domain classes that
 * will be traced and placing them inside the config map
 */
public class FinderProcessor  implements Processor<Map<String,List<String>>> {

    private final String MARK_CLASS = "markClass";

    @Override
    public Map<String, List<String>> process(Map<String, List<String>> config) throws Exception {

        //get the domain directory
        if(!config.containsKey("domain")){
            throw new FinderException("No Domain Class Directory specified");
        }

        List<String> domainDirList = config.get("domain");
        List<String> strMarkClasses = new ArrayList<String>();

        //get a list of all the classes annotated with @Mark
        for(String domainDir : domainDirList){
            Reflections reflections = new Reflections(domainDir);
            Set<Class<?>> markClasses = reflections.getTypesAnnotatedWith(Mark.class);


            if(config.containsKey(MARK_CLASS)){
                strMarkClasses = config.get(MARK_CLASS);
            }

            strMarkClasses.addAll(markClassesToString(markClasses));

        }

        config.put(MARK_CLASS,strMarkClasses);

        return config;
    }

    private List<String> markClassesToString(Collection<Class<?>> classes){
        List<String> retStrList = new ArrayList<String>();

        for(Class clazz : classes){

            retStrList.add(clazz.getCanonicalName());

        }
        return retStrList;
    }
}