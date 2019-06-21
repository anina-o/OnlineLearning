package com.example.ol.factory;

import com.example.ol.common.*;

import java.util.ArrayList;
import java.util.List;

public class CoursesFactory {

    private CourseKind freeCourse = new FreeCourse();
    private CourseKind nonfreeCourse = new NonfreeCourse();

    private Teacher geely = new Teacher("Geely", "丰富的互联网项目经验，公司内部技术讲师，热爱技术，乐于分享；教学格言：把复杂的技术简单化，简单的技术极致化");
    private Teacher z17 = new Teacher("正十七_卢云", "目前供职于google，技术方向是深度学习，具有五年工作经验，曾先后在百度、腾讯工作。对机器学习算法抱有强烈的兴趣，先后从事过图像检索与分类、文本分类、人脸识别、广告点击率预估、图像翻译等方面的项目，有丰富的炼丹经...");
    private Teacher david_beck = new Teacher("david_beck", "资深推荐算法，机器学习工程师，在BAT中多家有过工作经验。主导过多个推荐产品个性化推荐算法的0-1搭建和算法项目的0-1搭建。曾获荣誉：第一作者身份算法专利4篇，参与算法专利10余篇。");
    private Teacher dellLee = new Teacher("DellLee", "BAT资深前端工程师，负责数据平台技术研发。曾任去哪儿网高级前端工程师，主导去哪儿网内部前端监控系统设计，负责去哪儿网门票用户端的前端设计开发。曾任国内知名培训机构高级前端讲师，负责React，Angular，Vue，...");
    private Teacher liao = new Teacher("廖师兄", "载着干货的老司机。微服务，分布式架构方面经验丰富。");
    private Teacher y = new Teacher("廖师兄", "");

    public List<Course> getCourses(String type) {
        List<Course> courses = new ArrayList<>();
        if (type.equals("VideoCourse")) {
            Course springbootcourse = new VideoCourse.CourseBuilder()
                    .buildCourseKind(freeCourse)
                    .buildCourseName("2小时快速上手Spring Boot")
                    .buildCourseIntro("信息时代最重视的是什么？是效率！企业最重视的人才是什么？是高效能人士！所谓“天下武功唯快不破 ” ，为此专门设计本课程，慕课网重磅推出的首门微课，让你快速Get到SpringBoot实际应用技能。课程由慕课网口碑讲师-廖师兄亲自上阵，遵循”学习其实可以很快乐“的原则，以极客浪漫情怀的”红包表白程序“为场景，贯穿微服务必学框架-SpringBoot相关内容，将初学SpringBoot的踩坑点进行指点，为同学打造麻雀虽小五脏俱全的课程。讲师风趣幽默的讲解，必然让你本次的学习之旅尽兴而归。载着干货的老司机，在召唤你~")
                    .buildTeacher(liao)
                    .buildCourseCatalog("Java后端")
                    .buildCoursePic("https://img4.mukewang.com/szimg/5c9dcf8d09b18ff912000676-240-180.jpg")
                    .buildCourseVideo("http://yujing.mp.haue.edu.cn/demo.mp4")
                    .build();
            Course springcloudCourse = new VideoCourse.CourseBuilder()
                    .buildCourseKind(nonfreeCourse)
                    .buildCourseName("Spring Cloud微服务实战")
                    .buildCourseIntro("微服务架构已是当下最热门的话题，许多公司都在从传统架构系统向微服务转化。本门课程以点餐业务为例，使用Spring Boot2.x 配合SpringCloud核心组件，剖析微服务原理。并利用Rancher+Docker实现容器编排，SpringCloud Sleuth集成Zipkin实现分布式链路追踪，带你领略最潮的微服务实现方案")
                    .buildTeacher(liao)
                    .buildCourseVideo("http://yujing.mp.haue.edu.cn/demo.mp4")
                    .buildCoursePic("https://img2.mukewang.com/szimg/5cb68a1408ed350506000338-240-180.jpg")
                    .buildCourseCatalog("Java微服务")
                    .build();
            Course vueCourse = new VideoCourse.CourseBuilder()
                    .buildCourseKind(nonfreeCourse)
                    .buildCourseName("Vue2.5开发去哪儿网App 从零基础入门到实战项目")
                    .buildCourseIntro("Vue2.5开发去哪儿网App 从零基础入门到实战项目\n" +
                            "从Vue基础语法入手，逐层递进，实战项目贴近企业流程，完全按照企业级别代码质量和工程开发流程进行授课，让你理解这套技术在企业中被使用的真实流程。更好的掌握Vue各个基础知识点。")
                    .buildTeacher(dellLee)
                    .buildCourseVideo("http://yujing.mp.haue.edu.cn/demo.mp4")
                    .buildCoursePic("https://img2.mukewang.com/szimg/5ac2dfe100014a9005400300-240-180.jpg")
                    .buildCourseCatalog("Web前端")
                    .build();
            courses.add(springbootcourse);
            courses.add(springcloudCourse);
            courses.add(vueCourse);

        } else if (type.equals("CodingCourse")) {
            Course tensorflowCourse = new CodingCourse.CourseBuilder()
                    .buildCourseKind(nonfreeCourse)
                    .buildCourseName("TensorFlow2.0 入门到进阶")
                    .buildCourseIntro("课程以Tensorflow2.0框架为主体，以图像分类、房价预测、文本分类、文本生成、机器翻译、泰坦尼克生存预测等项目为依托，讲解Tensorflow框架的使用方法，让学员获得灵活使用Tensorflow的能力，同时学习到相关的深度学习/机器学习知识，达到初级深度学习工程师的水平")
                    .buildTeacher(z17)
                    .buildCourseCatalog("机器学习")
                    .buildCoursePic("https://img.mukewang.com/szimg/5ce7e7970894f48706000338-360-202.jpg")
                    .build();
            courses.add(tensorflowCourse);

            Course deeplearningCourse = new CodingCourse.CourseBuilder()
                    .buildCourseKind(freeCourse)
                    .buildCourseName("深度学习之神经网络入门最佳路径")
                    .buildCourseIntro("本课程首先介绍机器学习与深度学习，包括机器学习的应用、岗位职责，深度学习的等。然后通过讲解神经元及其衍生模型逻辑斯底回归、目标函数、梯度下降等深度学习基础知识。最后通过Tensorflow来实现课程讲解的模型。")
                    .buildTeacher(z17)
                    .buildCourseCatalog("人工智能")
                    .buildCoursePic("https://img3.mukewang.com/5bd8157a0001a7a506000336-240-135.jpg")
                    .build();
            courses.add(deeplearningCourse);
        }
        return courses;
    }
}
