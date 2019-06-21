package com.example.ol.web;

import com.example.ol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    String[] s = new String[]{
            "/static",
            "/sign_up",
            "/sign_in",
            "/sign_out",
            "/login",
            "/register",
            "/admin"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        for (String value : s) {
            if (request.getRequestURI().contains(value)) {
                return true;
            }
        }
        Integer uid = (Integer) request.getSession().getAttribute("user_id");
        if (uid != null && userService.findUserById(uid) != null) {
            return true;
        }
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/login");
        return false;

    }
}
