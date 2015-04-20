package org.lesie.example.domain;

import com.lesie.framework.annotations.mark.Marked;


@Marked
public class Example {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
