package com.example.ol.web;

import com.example.ol.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    private AdminService adminService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String[] s = new String[]{
                "/admin/login",
                "/admin/sign_in",
                "/admin/sign_out",
        };

        if (request.getRequestURI().contains("admin")) {
            for (String value : s) {
                if (request.getRequestURI().contains(value)) {
                    return true;
                }
            }
            String aid = (String) request.getSession().getAttribute("admin_id");

            if (aid != null && adminService.findAdminByUsername(aid) != null) {
                return true;
            } else {
                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath + "/admin/login");
                return false;
            }
        }
        return true;
    }
}
