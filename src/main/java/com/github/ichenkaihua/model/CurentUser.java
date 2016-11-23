package com.github.ichenkaihua.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Description: ${DESCRIPTION}
 * @author: WangQiang
 * @create: 2016-11-18 19:49
 */
@Component
public class CurentUser extends User{
    private static User curUser;
    public static void setCurUser(User user){
        curUser = user;
    }
    public static User val(){
        if(curUser==null){
            return null;
        }
        return curUser;
    }
}
