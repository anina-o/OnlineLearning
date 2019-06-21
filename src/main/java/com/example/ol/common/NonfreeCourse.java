package com.example.ol.common;

public class NonfreeCourse implements CourseKind {

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String getCourseKindName() {
        return "收费课程";
    }

}
