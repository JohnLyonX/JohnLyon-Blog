package com.johnlyon.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.johnlyon.blog.pojo.PostsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PostsInfoMapper extends BaseMapper<PostsInfo> {
    List<PostsInfo> getEditorPostsInfo(String name);
}
