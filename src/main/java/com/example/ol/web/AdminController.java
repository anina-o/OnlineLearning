package com.example.ol.web;

import com.example.ol.entity.Admin;
import com.example.ol.entity.PageInfo;
import com.example.ol.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("login")
    public ModelAndView login() {
        return new ModelAndView("admin/login");
    }

    @PostMapping("sign_in")
    public String signIn(RedirectAttributes attributes, HttpSession session, @RequestParam String username, @RequestParam String password) {
        Admin admin = adminService.findAdminByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            session.setAttribute("admin_id", admin.getUsername());
            return "redirect:/admin";
        } else {
            attributes.addFlashAttribute("info", new PageInfo("error", "登录失败,请检查用户名和密码"));
            return "redirect:/admin/login";
        }
    }

    @GetMapping
    public ModelAndView home(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("admin/home");
        String id = (String) session.getAttribute("admin_id");
        Admin admin = adminService.findAdminByUsername(id);
        modelAndView.addObject("admin", admin);
        modelAndView.addObject("users", adminService.findAllUsers());
        return modelAndView;
    }

    @GetMapping("do_buy")
    public String doBuy(RedirectAttributes attributes, HttpSession session, Integer user_id, Integer t) {
        boolean flag = false;
        if (t == 1) {
            if (adminService.buyVipOneMonth(user_id)) {
                flag = true;
            }
        } else if (t == 3) {
            if (adminService.buyVipThreeMonth(user_id)) {
                flag = true;
            }
        }
        if (flag) {
            attributes.addFlashAttribute("info", new PageInfo("success", "充值成功"));
        } else {
            attributes.addFlashAttribute("info", new PageInfo("error", "充值失败"));
        }
        return "redirect:/admin/";
    }

    @GetMapping("signOut")
    public String signOut(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
}
