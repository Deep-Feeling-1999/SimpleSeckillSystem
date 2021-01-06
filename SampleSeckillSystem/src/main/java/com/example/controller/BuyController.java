package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Deep-Feeling-1999
 * @create 2021/1/6
 */
@Controller
public class BuyController {

    @RequestMapping("/user/buy")
    @ResponseBody
    public String buy(@RequestParam("amount") Integer amount,
                      Model model, HttpSession session, HttpServletRequest request){

        return new String("Success");
    }
}
