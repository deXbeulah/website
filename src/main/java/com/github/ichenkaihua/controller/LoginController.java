package com.github.ichenkaihua.controller;


import com.github.ichenkaihua.model.CurrentUser;
import com.github.ichenkaihua.model.Plan;
import com.github.ichenkaihua.model.Task;
import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.PlanService;
import com.github.ichenkaihua.service.TaskService;
import com.github.ichenkaihua.service.UserService;
import com.github.ichenkaihua.utils.Constant;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description: ${DESCRIPTION}
 * @author: WangQiang
 * @create: 2016-11-16 15:30
 */
@Controller
public class LoginController implements Constant{
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @ModelAttribute(value = "user")
    public User newEntity()
    {
        return new User();
    }
    @Autowired
    UserService userService;
    @Autowired
    PlanService planService;
    @Autowired
    TaskService taskService;
    @RequestMapping(value = "/index", produces = "application/json;charset=utf-8")
    public String initLogin(ModelMap model){
        return "login";
    }
    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String initIndexPage(Model model, HttpSession httpSession){

        List<Plan> plans = new ArrayList<Plan>();
        List<Task> tasks = new ArrayList<Task>();
        User user = CurrentUser.getCurUser();
        if(user==null){
            return "redirect:index";
        }
        plans = planService.getPlansByUser(user);
        for(Plan plan:plans){
            tasks = taskService.getTasksByPlan(plan);
            model.addAttribute("tasks", tasks);
        }
        model.addAttribute("plans", plans);
        return  "index";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录")
    public String login(@ModelAttribute User user, Model model, HttpSession httpSession) {
        User loginUser = userService.login(user);

        if(loginUser!=null){
            CurrentUser.setCurUser(loginUser);
            return "redirect:/homepage";
        }else{
            model.addAttribute("error","用户名或密码错误");
            return  "login";
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public void logout(@PathVariable("id") @ApiParam("用户id") int id , @RequestBody @ApiParam("新的用户信息") User user) {
        user.setId(id);
        userService.update(user);
    }
}
