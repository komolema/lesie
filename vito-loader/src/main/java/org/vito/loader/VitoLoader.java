package org.vito.loader;


public interface VitoLoader{
    public void addGateClass(String classFullName,Class gateClass);
    public void addMarkClass(String classFullName,Class markClass);
    public void setFrameworkStarted(boolean frameworkStarted);
    public boolean isFrameworkStarted();
}
