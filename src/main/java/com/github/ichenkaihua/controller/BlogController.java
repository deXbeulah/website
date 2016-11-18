package com.github.ichenkaihua.controller;

import com.github.ichenkaihua.model.Blog;
import com.github.ichenkaihua.model.CurrentUser;
import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.BlogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Description: ${DESCRIPTION}
 * @author: WangQiang
 * @create: 2016-11-18 13:17
 */
@Controller
@RequestMapping(value = "/blogs")
public class BlogController  {
    @Autowired
    BlogService blogService;
    @ModelAttribute(value = "blogs")
    public List<Blog> getBlogsByUser(User user){
        return blogService.getBlogsByUser(user);
    }

    @ApiOperation(value = "获取指定用户所有博客", response = User.class, responseContainer = "List")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getBlogsByUserId(Model model) {
        System.out.println(CurrentUser.getCurUser().toString());
        getBlogsByUser(CurrentUser.getCurUser());
        return "blog";
    }

}
