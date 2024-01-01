package com.johnlyon.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.johnlyon.blog.mapper.MyMapper;
import com.johnlyon.blog.pojo.My;
import com.johnlyon.blog.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class MyController {
    @Autowired
    private MyMapper myMapper;
    @Autowired
    CookieService cookieService;

    @PostMapping("/login")
    @ResponseBody
    public String Certification(My my, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        QueryWrapper<My> myQueryWrapper = new QueryWrapper<>();
        myQueryWrapper.eq("username", my.getUsername());
        My certificationMe = myMapper.selectOne(myQueryWrapper);
        if (certificationMe == null) {
            return "Not User";
        } else {
            if (certificationMe.getPassword().equals(my.getPassword())) {
                Cookie cookie = cookieService.addCookie(my.getUsername());
                response.addCookie(cookie);
                return "Success";
            } else {
                return "Incorrect Password";
            }
        }
    }

    @GetMapping("/state")
    @ResponseBody
    public String userState(HttpServletRequest request) {
        String cookie = cookieService.getCookie(request.getCookies());
        if (cookie != null) {
            return "on";
        }
        return "off";
    }
}
