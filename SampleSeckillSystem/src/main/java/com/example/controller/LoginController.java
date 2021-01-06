package com.example.controller;

import com.example.domain.mUser;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author DeepFeeling-1999
 */
@Controller
public class LoginController {
    private final UserMapper userMapper;

    @Autowired
    public LoginController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 登入账号，登入成功则重定向至管理首页，否则跳转到主页面重新登入
     *
     * @param uName 用户名
     * @param uPassword 密码
     * @param model 模型渲染数据
     * @param session 账户session
     *
     * @return 主页面文件名和首页面文件名
     */
    @RequestMapping("/user/login")
    public String login(@RequestParam("myUserName") String uName, @RequestParam("myPassword") String uPassword,
                        Model model, HttpSession session, HttpServletRequest request) {
        mUser mUser = userMapper.getUserWithAccount(uName);
        if (mUser == null) {
            model.addAttribute("msg", "用户不存在，请先注册");
            return "redirect:/register";
        }

        //判断是否勾选rememberMe
        if (request.getParameter("rememberMe") != null) {
            HttpSession session1 = request.getSession();
        }

        if (!StringUtils.isEmpty(uName) && userMapper.getUserWithAccount(uName).getUPassWord().equals(uPassword)) {
            //增加一个属性记录，可以用来作为拦截判断，以及后续信息展示
            session.setAttribute(uName, uPassword);
            //重定向至main页面，然后通过自定义ViewController使main路径实际上跳转到index页面
            return "redirect:/index";
        } else {
            model.addAttribute("msg", "用户名或者密码错误");
            return "redirect:/login";
        }
    }

    /**
     * 登出账号
     *
     * @param session 获取账号session
     *
     * @return 首页
     */
    @RequestMapping("/user/logout")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "index";
    }
}
