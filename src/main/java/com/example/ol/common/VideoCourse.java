package com.example.ol.common;

//视频课程
public class VideoCourse extends Course {

    protected String courseVideo;

    private VideoCourse(CourseBuilder courseBuilder) {
        super.teacher = courseBuilder.teacher;
        super.courseKind = courseBuilder.courseKind;
        super.courseName = courseBuilder.courseName;
        this.courseVideo = courseBuilder.courseVideo;
        super.coursePic = courseBuilder.coursePic;
        super.courseIntro = courseBuilder.courseIntro;
        super.courseCatalog = courseBuilder.courseCatalog;
        courseBuilder.teacher.getCourseList().add(this);
    }

    public String getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(String courseVideo) {
        this.courseVideo = courseVideo;
    }

    public static class CourseBuilder {
        private CourseKind courseKind;
        private String courseName;
        private Teacher teacher;
        private String coursePic;
        private String courseIntro;
        private String courseVideo;
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

        public CourseBuilder buildCourseVideo(String courseVideo) {
            this.courseVideo = courseVideo;
            return this;
        }

        public CourseBuilder buildCourseIntro(String courseIntro) {
            this.courseIntro = courseIntro;
            return this;
        }

        public CourseBuilder buildCourseCatalog(String courseCatalog) {
            this.courseCatalog = courseCatalog;
            return this;
        }

        public VideoCourse build() {
            return new VideoCourse(this);
        }
    }

}
