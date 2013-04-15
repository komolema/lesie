package com.vito.domain;

import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import com.vito.framework.annotations.mark.Mark;
import com.vito.framework.annotations.mark.MarkId;

@Mark
public class Owner {

    @MarkId
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
