package com.vito.util;

import org.vito.loader.VitoLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 5/9/13
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoaderUtil {

    /*
     * Name:convertToVitoLoader
     * Description: Thi method returns true if the specified Classloader is of type VitoLoader
     */
    public static boolean isVitoClassLoader(ClassLoader cl) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class vitoLoaderClazz = cl.getParent().loadClass(VitoLoader.class.getCanonicalName());
        Class<?>[] clInterfaces = cl.getClass().getInterfaces();


        for(int i=0; i != clInterfaces.length;i++){
            Class clInterface =clInterfaces[i];
            if(clInterface.isAssignableFrom(vitoLoaderClazz)){
                return true;
            }

        }

        return false;
    }

    public static void invokeMethodOnLoader(ClassLoader cl,String methodName,Object... params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = cl.getClass().getMethod(methodName);
        method.invoke(cl,params);
    }
}
