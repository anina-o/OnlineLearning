package com.example.ol.common;

//实战课程
public class CodingCourse extends Course {

    public CodingCourse(CourseBuilder courseBuilder) {
        super.teacher = courseBuilder.teacher;
        super.courseKind = courseBuilder.courseKind;
        super.courseName = courseBuilder.courseName;
        super.coursePic = courseBuilder.coursePic;
        super.courseIntro = courseBuilder.courseIntro;
        super.courseCatalog = courseBuilder.courseCatalog;
        courseBuilder.teacher.getCourseList().add(this);
    }

    public static class CourseBuilder {
        private CourseKind courseKind;
        private String courseName;
        private Teacher teacher;
        private String coursePic;
        private String courseIntro;
        private String courseCatalog;

        public CourseBuilder buildCourseKind(CourseKind courseKind) {
            this.courseKind = courseKind;
            return this;
        }

        public CourseBuilder buildCourseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public CourseBuilder buildTeacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public CourseBuilder buildCoursePic(String coursePic) {
            this.coursePic = coursePic;
            return this;
        }

        public CourseBuilder buildCourseCatalog(String courseCatalog) {
            this.courseCatalog = courseCatalog;
            return this;
        }

        public CourseBuilder buildCourseIntro(String courseIntro) {
            this.courseIntro = courseIntro;
            return this;
        }

        public CodingCourse build() {
            return new CodingCourse(this);
        }
    }

}
