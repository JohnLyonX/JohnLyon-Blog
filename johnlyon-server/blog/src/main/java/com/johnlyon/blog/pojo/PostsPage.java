package com.johnlyon.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("posts_page")
public class PostsPage {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String url;
    private String name;
    private String title;
    private String date;
    private String content;
}
