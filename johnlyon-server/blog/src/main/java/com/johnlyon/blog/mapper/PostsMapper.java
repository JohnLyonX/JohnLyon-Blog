package com.johnlyon.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.johnlyon.blog.pojo.Posts;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostsMapper extends BaseMapper<Posts>{
}
