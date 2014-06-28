/**
 *      Copyright 2014 CPUT
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

package org.lesie.loader.impl;

import org.lesie.loader.LesieLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class DefaultLesieLoaderStrategy {

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
