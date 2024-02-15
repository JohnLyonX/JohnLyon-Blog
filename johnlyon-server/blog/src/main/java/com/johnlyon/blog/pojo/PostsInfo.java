package com.johnlyon.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class PostsInfo {
    private String url;
    private String name;
    private String title;
    private String date;
    private String introduction;
    private String content;
    private int pin;


}
