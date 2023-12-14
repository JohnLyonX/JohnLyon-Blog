package com.lyonjohn.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("posts")
@Data
public class Posts {
    private int id;
    private String name;
    private String date;
    private String introduction;
    private int pin;
    private String url;
}
