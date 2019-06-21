package com.example.ol.common;

public class FreeCourse implements CourseKind {


    @Override
    public boolean isFree() {
        return true;
    }

    @Override
    public String getCourseKindName() {
        return "免费课程";
    }

}
