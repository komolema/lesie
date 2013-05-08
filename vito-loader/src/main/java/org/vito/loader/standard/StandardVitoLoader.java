package org.vito.loader.standard;

import org.vito.loader.VitoLoader;
import org.vito.loader.impl.DefaultVitoLoaderStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 5/7/13
 * Time: 3:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class StandardVitoLoader extends ClassLoader implements VitoLoader {
    private boolean frameworkStarted;
    private DefaultVitoLoaderStrategy loaderStrategy;

    private java.util.logging.Logger log = java.util.logging.Logger.getLogger(StandardVitoLoader.class.getName());


    public StandardVitoLoader(){
        super();
        loaderStrategy = new DefaultVitoLoaderStrategy();
    }

    public StandardVitoLoader(ClassLoader parent){
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
//            log.info("ViTO framework has not been started as of yet");
        }

        return super.loadClass(name);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public boolean isFrameworkStarted() {
        return frameworkStarted;
    }

    @Override
    public void addGateClass(String classFullName, Class gateClass) {
        loaderStrategy.addGateClass(classFullName,gateClass);
    }

    @Override
    public void addMarkClass(String classFullName, Class markClass) {
        loaderStrategy.addGateClass(classFullName,markClass);
    }

    public void setFrameworkStarted(boolean frameWorkStarted) {
        this.frameworkStarted = frameWorkStarted;
    }
}
