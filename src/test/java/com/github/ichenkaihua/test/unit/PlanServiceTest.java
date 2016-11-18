package com.github.ichenkaihua.test.unit;

import com.github.ichenkaihua.model.Plan;
import com.github.ichenkaihua.service.PlanService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016-11-03 17:09
 */
public class PlanServiceTest extends BaseUnitTest {
    @Autowired
    PlanService planService;

    @Test
    @Ignore
    public void AddPlan(){
        Plan plan = new Plan();
        plan.setGroupId(0);
        plan.setName("减肥");
        planService.addPlan(plan);
        print("result",plan.toString());
    }
    @Test
    public void getPlanByUser(){
//        List<Plan> plans = planService.getPlansByUserId(1);
        List<Plan> plans = planService.getPlans(null);
        print(Integer.toString(plans.size()));
        for(Plan plan: plans){
            print(plan.toString());
        }
    }
}
