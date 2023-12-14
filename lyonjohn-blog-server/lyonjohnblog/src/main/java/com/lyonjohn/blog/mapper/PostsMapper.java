package com.lyonjohn.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyonjohn.blog.pojo.Posts;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostsMapper extends BaseMapper<Posts>{
}
