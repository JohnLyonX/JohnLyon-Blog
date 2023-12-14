package com.lyonjohn.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("posts_page")
public class PostsPage {
    private int id;
    private String url;
    private String name;
    private String title;
    private String date;
    private String content;
}
