package com.example.ol.decorator;

import com.example.ol.common.Course;

public interface AbstractDecorator {

    public abstract String getName();

    public abstract Course getCourse();
}
