package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.PlanMapper;
import com.github.ichenkaihua.model.Plan;
import com.github.ichenkaihua.model.User;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016-11-03 17:08
 */
@Service
public class PlanService {
    @Autowired
    PlanMapper planMapper;
    public void deleteWithAdminRoleById(int id){
        planMapper.deleteByPrimaryKey(id);
    }


    public Plan getPlanById(int id){
        return planMapper.selectByPrimaryKey(id);
    }



    public boolean isExist(Plan plan){
        System.out.println(plan.toString());
        return  planMapper.selectCount(plan)>0;
    }


    public void addPlan(Plan plan){
        planMapper.insert(plan);
    }


    public List<Plan> getPlans(Plan plan){
        if (plan == null) {
            return planMapper.selectAll();
        }

        return planMapper.select(plan);
    }
    public List<Plan> getPlansByUser(User user){
        return getPlansByUserId(user.getId());
    }
    public List<Plan> getPlansByUserId(int userId){
        return planMapper.selectByUserId(userId);
    }

    public void deleteById(int id){
        planMapper.deleteByPrimaryKey(id);

    }

    public void update(Plan plan){
        planMapper.updateByPrimaryKey(plan);
    }

}
