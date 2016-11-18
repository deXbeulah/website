package com.github.ichenkaihua.mapper;

import com.github.ichenkaihua.model.Task;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Description: ${DESCRIPTION}
 * @author: WangQiang
 * @create: 2016-11-17 21:01
 */
public interface TaskMapper extends Mapper<Task> {

    
    @ResultMap(value = "BaseResultMap")
    @Select("select * from task where plan_id = #{id}")
    List<Task> selectByPlanId(int id);
}
