package com.github.ichenkaihua.mapper;

import com.github.ichenkaihua.model.Plan;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016-11-03 17:07
 */
public interface PlanMapper extends Mapper<Plan> {

    @Select("select * from plan where user_id = #{user_id}")
    public List<Plan> selectByUserId(int user_id);
}
