package com.vito.policy;


public enum PolicyType {
    ENFORCER,VISIBILITY;

    public String toString(){
        String s = super.toString();
        return s.substring(0,1) + s.substring(1).toLowerCase();
    }
}
