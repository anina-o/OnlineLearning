package com.example.ol.web;

import com.example.ol.adapter.CourseDTO;
import com.example.ol.common.Course;
import com.example.ol.factory.CoursesFactory;
import com.example.ol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "/coding")
public class CodingCourseController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView list(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("user/coding/list");
        Integer id = (Integer) session.getAttribute("user_id");
        modelAndView.addObject("user", userService.findUserById(id));
        CoursesFactory coursesFactory = new CoursesFactory();
        List<Course> courses = coursesFactory.getCourses("CodingCourse");
        modelAndView.addObject("courses", courses);
        return modelAndView;
    }

    @GetMapping("detail")
    public ModelAndView detail(HttpSession session, CourseDTO course) {
        ModelAndView modelAndView = new ModelAndView("user/coding/detail");
        Integer id = (Integer) session.getAttribute("user_id");
        modelAndView.addObject("user", userService.findUserById(id));
        modelAndView.addObject("course", course);
        return modelAndView;
    }

    @GetMapping("learn")
    public ModelAndView learn(HttpSession session, CourseDTO course) {
        ModelAndView modelAndView = new ModelAndView("user/coding/learn");
        Integer id = (Integer) session.getAttribute("user_id");
        modelAndView.addObject("user", userService.findUserById(id));
        modelAndView.addObject("course", course);
        return modelAndView;
    }
}
