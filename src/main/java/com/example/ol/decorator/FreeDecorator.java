package com.example.ol.decorator;

import com.example.ol.common.Course;

//课程限时免费优惠装饰器
public class FreeDecorator implements AbstractDecorator {

    private Course course;

    public FreeDecorator(Course course) {
        this.course = course;
    }

    @Override
    public String getName() {
        return "(限免)" + this.course.getCourseName();
    }

    @Override
    public Course getCourse() {
        return this.course;
    }
}
