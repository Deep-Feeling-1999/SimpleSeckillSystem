package com.example.controller;

import com.example.domain.mUser;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Deep-Feeling-1999
 * @create 2021/1/5
 */
@Controller
public class RegisterController {
    private final UserMapper userMapper;

    @Autowired
    public RegisterController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping("register")
    public String register() {
        return "register";
    }

    /**
     * @param uName
     * @param uPassword
     * @param model
     * @param session
     * @param request
     *
     * @return
     */
    @RequestMapping("/user/register")
    public String userRegister(@RequestParam("myUserName") String uName, @RequestParam("myPassword") String uPassword,
                               Model model, HttpSession session, HttpServletRequest request) {
        mUser user = new mUser(uName, uPassword);
        userMapper.addUser(user);
        System.out.println(user);
        return "redirect:/login";
    }
}
