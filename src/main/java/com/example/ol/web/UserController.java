package com.example.ol.web;

import com.example.ol.entity.PageInfo;
import com.example.ol.entity.User;
import com.example.ol.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView root(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("user/home");
        Integer id = (Integer) session.getAttribute("user_id");
        modelAndView.addObject("user", userService.findUserById(id));
        return modelAndView;
    }

    @GetMapping("login")
    public ModelAndView login() {
        return new ModelAndView("user/login");
    }

    @GetMapping("register")
    public ModelAndView register() {
        return new ModelAndView("user/register");
    }

    @GetMapping("recharge")
    public ModelAndView recharge(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("user/buy");
        Integer id = (Integer) session.getAttribute("user_id");
        modelAndView.addObject("user", userService.findUserById(id));
        return modelAndView;
    }

    @PostMapping("sign_in")
    public String signIn(HttpSession session,
                         RedirectAttributes attributes,
                         @RequestParam String username,
                         @RequestParam String password) {
        User user = userService.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user_id", user.getUserId());
            return "redirect:/";
        } else {
            attributes.addFlashAttribute("info", new PageInfo("error", "登录失败,请检查用户名和密码"));
            return "redirect:/login";
        }
    }

    @PostMapping("sign_up")
    public String signUp(RedirectAttributes attributes,
                         @RequestParam String username,
                         @RequestParam String password) {
        if (userService.addUser(new User(username, password))) {
            attributes.addFlashAttribute("info", new PageInfo("success", "注册成功"));
        } else {
            attributes.addFlashAttribute("info", new PageInfo("error", "注册失败,用户名已存在"));
        }
        return "redirect:/register";
    }

    @GetMapping("sign_out")
    public String signOut(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
