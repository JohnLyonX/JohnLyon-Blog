package com.johnlyon.blog.controller;

import com.johnlyon.blog.mapper.PostsMapper;
import com.johnlyon.blog.mapper.PostsPageMapper;
import com.johnlyon.blog.pojo.Posts;
import com.johnlyon.blog.pojo.PostsPage;
import com.johnlyon.blog.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/api")
public class WritePostsController {
    @Autowired
    private PostsMapper postsMapper;
    @Autowired
    private PostsPageMapper postsPageMapper;
    @Autowired
    private PostsService postsService;

    @PostMapping("/writePosts")
    @ResponseBody
    public String writePosts(String url,
                             String name,
                             String title,
                             String date,
                             String introduction,
                             String content,
                             String pin) {

        Integer pinInt = Integer.parseInt(pin);
        postsService.addPosts(url, name, title, date, introduction, content, pinInt);

        return "Success";
    }


}
