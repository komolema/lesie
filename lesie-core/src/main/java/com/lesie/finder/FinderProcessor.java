/**
 *      Copyright 2013 CPUT
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package com.lesie.finder;


import com.lesie.exception.FinderException;
import com.lesie.framework.Processor;
import com.lesie.framework.annotations.mark.Mark;
import org.reflections.Reflections;

import java.util.*;

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