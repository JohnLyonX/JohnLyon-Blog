package com.johnlyon.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.johnlyon.blog.pojo.My;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyMapper extends BaseMapper<My> {
}
