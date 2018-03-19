package com.jstu.tea.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher {
    private String teacherId;
    private String name;
    private Character sax;
    private String comments;

    public void setSax(Character sax) {
        this.sax = sax;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
