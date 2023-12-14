package com.lyonjohn.blog.controller;

import com.lyonjohn.blog.mapper.MusicMapper;
import com.lyonjohn.blog.pojo.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class MusicController {
    @Autowired
    private MusicMapper musicMapper;

    @PostMapping("/getMusic")
    @ResponseBody
    public Music getMusic() {
        return musicMapper.selectById(1);
    }

}
