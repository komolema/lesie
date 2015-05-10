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

package org.lesie.attacher;


import com.lesie.framework.annotations.mark.MarkId;
import javassist.*;
import org.lesie.exception.AttacherException;
import org.lesie.framework.Processor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class DefaultAttacher  implements Processor<Map<String,List<String>>> {

    private final String MARK_CLASS = "markClass";
    private final String ID_MARKER = "id";
    private ClassPool classPool = null;


    @Override
    public Map<String, List<String>> process(Map<String, List<String>> config) throws Exception {

        if(!config.containsKey(MARK_CLASS)){
            throw new AttacherException("No Mark Classes found");
        }

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        ClassPool classPool = ClassPool.getDefault();
        classPool.insertClassPath(new LoaderClassPath(cl));
        for (String strMarkClass : config.get(MARK_CLASS)) {
            CtClass markCtClass = classPool.get(strMarkClass);
            attachMarkClass(markCtClass);

        }


        return config;
    }

    public void weaveCodeToClass(String name,ClassLoader cl) throws Exception {
        initClassPool(cl);
        CtClass lesieAnnotatedClass = classPool.get(name);
        attachMarkClass(lesieAnnotatedClass);
    }

    private void initClassPool(ClassLoader cl) {
        if(classPool == null) {
            classPool = ClassPool.getDefault();
            classPool.insertClassPath(new LoaderClassPath(cl));
        }
    }

    private void attachMarkClass(CtClass markCtClass) throws ClassNotFoundException, AttacherException, CannotCompileException, NotFoundException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        boolean idExistOnAnnotation = false;
        boolean idExistOnField = false;
        boolean setterExist = false;
        String idFieldName = "";
        //1.first check to see if there is a identification annotation
        for (CtField ctField : markCtClass.getDeclaredFields()) {

            for (Object annotation : ctField.getAnnotations()) {
                if(annotation instanceof MarkId) {
                    idExistOnAnnotation = true;
                    idFieldName = ctField.getName();
                }
            }

            if(!idExistOnAnnotation){
                if(ctField.getName().toLowerCase().equals(ID_MARKER)){
                    idExistOnField = true;
                    idFieldName = ctField.getName();
                }
            }
        }

        if(!idExistOnAnnotation && !idExistOnField){
            throw new AttacherException("No Identification field found");
        }

        //check to see if this method has a Setter
        for (CtMethod ctMethod : markCtClass.getDeclaredMethods()) {

            String methodName = ctMethod.getName();
            if(methodName.startsWith("set")){
                String setterFieldName = methodName.substring(3).toLowerCase();
                if(setterFieldName.equals(idFieldName)){
                    setterExist = true;
                    generate(markCtClass, ctMethod, methodName);
                }
            }
        }

        if(!setterExist){
            throw new AttacherException("No Setter found for Annotatted field");
        }


        markCtClass.writeFile();

    }

    private void generate(CtClass markCtClass, CtMethod ctMethod, String methodName) throws CannotCompileException {
        CtMethod mNew = CtNewMethod.copy(ctMethod, methodName, markCtClass, null);
        String nMethodName = methodName + "$Impl";
        ctMethod.setName(nMethodName);

        //build method body
        StringBuffer body = new StringBuffer();
        body.append("{System.out.println(\"Hello World\");}");

        mNew.setBody(body.toString());

        markCtClass.addMethod(mNew);
    }
}
