package com.example.ol.common;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    //老师名
    private String teacherName;
    //老师简介
    private String teacherIntro;
    //老师开设课程，体现组合模式整体局部
    private List<Course> courseList = new ArrayList<>();

    public Teacher(String teacherName, String teacherIntro) {
        this.teacherName = teacherName;
        this.teacherIntro = teacherIntro;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherIntro() {
        return teacherIntro;
    }

    public void setTeacherIntro(String teacherIntro) {
        this.teacherIntro = teacherIntro;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                ", teacherIntro='" + teacherIntro + '\'' +
                '}';
    }
}
