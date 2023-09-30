package com.wang.po;

import java.io.Serializable;

public class TSubject implements Serializable {
    private static final long serialVersionUID = -5826411213054576028L;
    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
