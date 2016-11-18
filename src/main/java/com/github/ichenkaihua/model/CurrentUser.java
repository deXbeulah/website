package com.github.ichenkaihua.model;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: ${DESCRIPTION}
 * @author: WangQiang
 * @create: 2016-11-16 17:20
 */
public class CurrentUser {
    public static ThreadLocal<User> tlCurUser = new ThreadLocal<User>();
    public static void setCurUser(User u){
        tlCurUser.set(u);
    }
    /**
     * 千方百计获取当前用户
     * @return
     */
    public static User getCurUser(){
        User curUser = null;
        //先尝试取当前线程的用户信息
        try{
            curUser=tlCurUser.get();
        }catch(Throwable t){
        }

        return curUser;
    }
}
