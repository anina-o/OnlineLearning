package com.example.ol;

import com.example.ol.common.*;
import com.example.ol.decorator.FreeDecorator;
import org.junit.Test;

public class CourseTest {

    @Test
    public void test() {

        CourseKind freeCourse = new FreeCourse();
        Teacher geely = new Teacher("Geely", "知名在线旅游互联网公司,高级技术经理");
        //建造者模式链式调用
        Course javaCourse = new VideoCourse.CourseBuilder()
                .buildCourseKind(freeCourse)
                .buildCourseName("Spring Boot")
                .buildCourseIntro("Spring Boot2.0从入门到精通")
                .buildTeacher(geely)
                .build();
        System.out.println(javaCourse);

        CourseKind nonfreeCourse = new NonfreeCourse();
        Teacher z17 = new Teacher("正十七_卢云", "Google资深算法工程师");
        Course pythonCourse = new CodingCourse.CourseBuilder()
                .buildCourseKind(nonfreeCourse)
                .buildCourseName("Tensorflow")
                .buildCourseIntro("Tensorflow2.0从入门到进阶")
                .buildTeacher(z17)
                .build();
        System.out.println(pythonCourse);

        FreeDecorator freeDecorator = new FreeDecorator(pythonCourse);
    }
}
