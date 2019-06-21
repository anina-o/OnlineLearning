package com.example.ol.common;

public abstract class Course {
    //收费类型
    protected CourseKind courseKind;
    //课程类别
    protected String courseCatalog;
    //课程名
    protected String courseName;
    //课程老师
    protected Teacher teacher;
    //课程图片url
    protected String coursePic;
    //课程简介
    protected String courseIntro;

    public Course() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCoursePic() {
        return coursePic;
    }

    public void setCoursePic(String coursePic) {
        this.coursePic = coursePic;
    }

    public String getCourseIntro() {
        return courseIntro;
    }

    public void setCourseIntro(String courseIntro) {
        this.courseIntro = courseIntro;
    }

    public CourseKind getCourseKind() {
        return courseKind;
    }

    public void setCourseKind(CourseKind courseKind) {
        this.courseKind = courseKind;
    }

    public String getCourseCatalog() {
        return courseCatalog;
    }

    public void setCourseCatalog(String courseCatalog) {
        this.courseCatalog = courseCatalog;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseKind=" + courseKind.getCourseKindName() +
                ", courseName='" + courseName + '\'' +
                ", teacher=" + teacher +
                ", coursePic='" + coursePic + '\'' +
                ", courseIntro='" + courseIntro + '\'' +
                '}';
    }
}
