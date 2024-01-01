package com.johnlyon.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("my")
public class My {
    private int id;
    private String username;
    private String password;
}
