package com.github.ichenkaihua.test.unit;

import com.github.ichenkaihua.model.Blog;
import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.BlogService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: ${DESCRIPTION}
 * @author: WangQiang
 * @create: 2016-11-18 10:56
 */
public class BlogServiceTest extends BaseUnitTest {
    @Autowired
    BlogService blogService;
    @Test
    @Ignore
    public void addBlog(){
        Blog blog = new Blog();
        blog.setTitle("linux");
        blog.setContent("sh");
        blogService.addBlog(blog);
    }
    @Test
    public void getBlogByUser(){
        User user = new User();
        user.setId(1);

        List<Blog> blogs=blogService.getBlogsByUser(user);
        for (Blog blog:blogs){
            print(blog.toString());
        }
    }
}
