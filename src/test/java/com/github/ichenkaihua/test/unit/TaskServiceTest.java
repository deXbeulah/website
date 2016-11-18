package com.github.ichenkaihua.test.unit;

import com.github.ichenkaihua.model.Task;
import com.github.ichenkaihua.service.TaskService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: ${DESCRIPTION}
 * @author: WangQiang
 * @create: 2016-11-17 21:16
 */
public class TaskServiceTest extends BaseUnitTest{
    @Autowired
    TaskService taskService;
    @Test
    public void getTaskByPlanId(){
        List<Task> tasks = taskService.getTasksByPlanId(1);
        for(Task task: tasks){
            print(task.toString());
        }
    }
}
