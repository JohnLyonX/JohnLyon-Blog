package com.lyonjohn.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("music")
public class Music {
    private int id;
    private String url;
}
