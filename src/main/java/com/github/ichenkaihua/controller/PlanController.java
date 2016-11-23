package com.github.ichenkaihua.controller;

import com.github.ichenkaihua.model.CurentUser;
import com.github.ichenkaihua.model.Plan;
import com.github.ichenkaihua.model.Task;
import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.PlanService;
import com.github.ichenkaihua.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

import static com.github.ichenkaihua.utils.Constant.currentUser;
import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016-11-03 17:08
 */
@RestController
@RequestMapping("plans")
@ApiIgnore
public class PlanController {
    private Logger logger = LoggerFactory.getLogger(PlanController.class);
    @Autowired
    PlanService planService;
    @Autowired
    TaskService taskService;
    @RequestMapping(value = "")
    public String initIndexPage(Model model) {

        List<Plan> plans = new ArrayList<Plan>();
        List<Task> tasks = new ArrayList<Task>();
        User user = CurentUser.val();
        logger.info("-------------------------------------------" + currentUser.toString());
        if (user == null) {
            return "redirect:index";
        }
        plans = planService.getPlansByUser(user);
        for (Plan plan : plans) {
            tasks = taskService.getTasksByPlan(plan);
            model.addAttribute("tasks", tasks);
        }
        model.addAttribute("plans", plans);
        model.addAttribute("user", user);
        return "index";
    }
}
