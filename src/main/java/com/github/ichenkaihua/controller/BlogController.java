package com.github.ichenkaihua.controller;

import com.github.ichenkaihua.model.Blog;
import com.github.ichenkaihua.model.CurentUser;
import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.BlogService;
import com.github.ichenkaihua.utils.Constant;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: ${DESCRIPTION}
 * @author: WangQiang
 * @create: 2016-11-18 13:17
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController  implements Constant{

    @Autowired
    BlogService blogService;
    @ModelAttribute(value = "blog")
    public Blog newBlog(){
        return new Blog();
    }
    @ModelAttribute(value = "blog")
    public List<Blog> getBlogsByUser(User user){
        return blogService.getBlogsByUser(user);
    }

    @ApiOperation(value = "获取指定用户所有博客", response = User.class, responseContainer = "List")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getBlogsByUserId(Model model) {

//        getBlogsByUser(user);
        return "blog";
    }
    @ApiOperation(value = "获取指定用户所有博客", response = User.class, responseContainer = "List")
    @RequestMapping(value = "/listByUserId/{id}", method = RequestMethod.GET)
    public String getBlogsByUserId(@PathVariable("id")int id, Model model) {
        User user = new User();
        user.setId(id);
        getBlogsByUser(user);
        return "blog";
    }

}
