package com.github.ichenkaihua.mapper;

import com.github.ichenkaihua.model.Blog;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Description: ${DESCRIPTION}
 * @author: WangQiang
 * @create: 2016-11-18 10:40
 */
public interface BlogMapper extends Mapper<Blog>{
    @ResultMap(value = "BaseResultMap")
    @Select(value = "select * from blog where user_id = #{userId}")
    public List<Blog> selectByUserId(int userId);
    @ResultMap(value = "BaseResultMap")
    @Select(value = "select * from blog where user_id = #{userId}")
    public List<Blog> selectByPlanId(int planId);
}
