package com.example.ol.web;

import com.example.ol.adapter.CourseDTO;
import com.example.ol.common.Course;
import com.example.ol.common.VideoCourse;
import com.example.ol.decorator.FreeDecorator;
import com.example.ol.factory.CoursesFactory;
import com.example.ol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/video")
public class VideoCourseController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView list(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("user/video/list");
        Integer id = (Integer) session.getAttribute("user_id");
        modelAndView.addObject("user", userService.findUserById(id));
        CoursesFactory factory = new CoursesFactory();
        List<Course> courses = factory.getCourses("VideoCourse");
        List<FreeDecorator> discountVideoCourse = new ArrayList<>();
        List<VideoCourse> videoCourse = new ArrayList<>();
        for (Course c : courses) {
            //对Vue课程进行限免活动
            if (c.getCourseName().contains("Vue")) {
                discountVideoCourse.add(new FreeDecorator(c));
            } else {
                videoCourse.add((VideoCourse) c);
            }
        }
        modelAndView.addObject("courses_", discountVideoCourse);
        modelAndView.addObject("courses", videoCourse);

        return modelAndView;
    }

    @GetMapping("detail")
    public ModelAndView detail(HttpSession session, CourseDTO course) {
        ModelAndView modelAndView = new ModelAndView("user/video/detail");
        Integer id = (Integer) session.getAttribute("user_id");
        modelAndView.addObject("user", userService.findUserById(id));
        modelAndView.addObject("course", course);
        return modelAndView;
    }

    @GetMapping("learn")
    public ModelAndView learn(HttpSession session, CourseDTO course) {
        ModelAndView modelAndView = new ModelAndView("user/video/learn");
        Integer id = (Integer) session.getAttribute("user_id");
        modelAndView.addObject("user", userService.findUserById(id));
        modelAndView.addObject("course", course);
        return modelAndView;
    }
}
