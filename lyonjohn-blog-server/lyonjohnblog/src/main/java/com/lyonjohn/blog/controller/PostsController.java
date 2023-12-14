package com.lyonjohn.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lyonjohn.blog.mapper.PostsMapper;
import com.lyonjohn.blog.mapper.PostsPageMapper;
import com.lyonjohn.blog.pojo.Posts;
import com.lyonjohn.blog.pojo.PostsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/api")
public class PostsController {
    
    @Autowired
    private PostsMapper postsMapper;
    @Autowired
    private PostsPageMapper postsPageMapper;

    @PostMapping("/getPosts")
    @ResponseBody
    public List<Posts> getPosts() {
        return postsMapper.selectList(null);
    }

    @RequestMapping("/posts")
    @ResponseBody
    public List<PostsPage> getPostsPage(String name) {
        QueryWrapper<PostsPage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return postsPageMapper.selectList(queryWrapper);
    }
}
