package org.vito.loader.web;

import org.vito.loader.VitoLoader;
import org.apache.catalina.loader.WebappClassLoader;
import org.vito.loader.impl.DefaultVitoLoaderStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 4/26/13
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TomcatVitoLoader extends WebappClassLoader implements VitoLoader {

    private boolean frameworkStarted = false;
    private DefaultVitoLoaderStrategy loaderStrategy;

    private java.util.logging.Logger log = java.util.logging.Logger.getLogger(TomcatVitoLoader.class.getName());

    public TomcatVitoLoader(){
        super();
        loaderStrategy = new DefaultVitoLoaderStrategy();

    }

    public TomcatVitoLoader(ClassLoader parent){
        super(parent);
        loaderStrategy = new DefaultVitoLoaderStrategy();
    }

    @Override
    public Class loadClass(String name) throws ClassNotFoundException {

        if(frameworkStarted){
            log.info("ViTO framework has been started");

            Class modifiedClass = loaderStrategy.getModifiedClass(name);
            if(modifiedClass != null){
                return modifiedClass;
            }

        }else{
            log.info("ViTO framework has not been started as of yet");
        }

        return super.loadClass(name);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected Class findLoadedClass0(String name) {
        return super.findLoadedClass0(name);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public boolean isFrameworkStarted() {
        return frameworkStarted;
    }

    public void setFrameworkStarted(boolean frameWorkStarted) {
        this.frameworkStarted = frameWorkStarted;
    }

    @Override
    public void addGateClass(String classFullName,Class gateClass) {
        loaderStrategy.addGateClass(classFullName,gateClass);

    }

    @Override
    public void addMarkClass(String classFullName,Class markClass) {
        loaderStrategy.addGateClass(classFullName,markClass);
    }
}
