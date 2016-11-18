package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.TaskMapper;
import com.github.ichenkaihua.model.Plan;
import com.github.ichenkaihua.model.Task;
import com.github.ichenkaihua.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: ${DESCRIPTION}
 * @author: WangQiang
 * @create: 2016-11-17 21:14
 */
@Service
public class TaskService {
    @Autowired
    TaskMapper taskMapper;
    public void deleteWithAdminRoleById(int id){
        taskMapper.deleteByPrimaryKey(id);
    }


    public Task getTaskById(int id){
        return taskMapper.selectByPrimaryKey(id);
    }



    public boolean isExist(Task task){
        System.out.println(task.toString());
        return  taskMapper.selectCount(task)>0;
    }


    public void addTask(Task task){
        taskMapper.insert(task);
    }


    public List<Task> getTasks(Task task){
        if (task == null) {
            return taskMapper.selectAll();
        }

        return taskMapper.select(task);
    }
    public List<Task> getTasksByPlan(Plan plan){
        return getTasksByPlanId(plan.getId());
    }
    public List<Task> getTasksByPlanId(int planId){
        return taskMapper.selectByPlanId(planId);
    }

    public void deleteById(int id){
        taskMapper.deleteByPrimaryKey(id);

    }

    public void update(Task task){
        taskMapper.updateByPrimaryKey(task);
    }

}
