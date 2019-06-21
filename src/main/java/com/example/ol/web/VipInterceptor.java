package com.example.ol.web;

import com.example.ol.entity.User;
import com.example.ol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class VipInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getRequestURI().contains("learn")) {
            int code = Integer.parseInt(request.getParameter("code"));
            if (code == 0) {
                Integer uid = (Integer) request.getSession().getAttribute("user_id");
                User user = userService.findUserById(uid);
                if (user.getVip()) {
                    return true;
                } else {
                    String contextPath = request.getContextPath();
                    response.sendRedirect(contextPath + "/recharge");
                    return false;
                }
            }
        }
        return true;
    }
}
