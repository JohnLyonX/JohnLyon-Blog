package com.johnlyon.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("posts")
@Data
public class Posts {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String url;
    private String name;
    private String date;
    private String introduction;
    private int pin;
}
