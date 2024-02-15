package com.johnlyon.blog.controller;

import com.johnlyon.blog.mapper.PostsInfoMapper;
import com.johnlyon.blog.pojo.PostsInfo;
import com.johnlyon.blog.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class EditorPostsController {
    @Autowired
    private PostsService postsService;
    @Autowired
    private PostsInfoMapper postsInfoMapper;

    @PostMapping("/writePosts")
    @ResponseBody
    public String writePosts(String url, String name, String title, String date, String introduction, String content, String pin) {
        Integer pinInt = Integer.parseInt(pin);
        postsService.addPosts(url, name, title, date, introduction, content, pinInt);
        return "Success";
    }

    @RequestMapping("/getEditorPosts")
    @ResponseBody
    public List<PostsInfo> showPostsInfo(String name) {
        return postsInfoMapper.getEditorPostsInfo(name);

    }

    @PostMapping("/editPosts")
    @ResponseBody
    public String editPosts(String url, String name, String title, String date, String introduction, String content, String pin) {
        Integer pinInt = Integer.parseInt(pin);
        postsService.editPosts(url, name, title, date, introduction, content, pinInt);
        return "Success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deletePosts(String name) {
        postsService.deletePosts(name);
        return "Success";
    }


}
