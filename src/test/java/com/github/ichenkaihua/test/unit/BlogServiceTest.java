package com.github.ichenkaihua.test.unit;

import com.github.ichenkaihua.model.Blog;
import com.github.ichenkaihua.service.BlogService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016 11 01 15:40
 */
public class BlogServiceTest extends BaseUnitTest{
    @Autowired
    BlogService blogService;
    @Test
    public void addBlogTest(){
        Blog blog = new Blog();
        blog.setAuthorName("wq");
        blog.setBlogFile("test");
        blog.setBlogName("1.blog");
        blogService.addBlog(blog);
    }

    @Test
    @Ignore
    public void searchBlogsTest(){
        Blog blog = new Blog();
        blog.setAuthorName("wq");
        blog.setBlogFile("test");
        blog.setBlogName("1.blog");
        List<Blog> blogs = blogService.getBlogs(blog);
        print("lenght",String.valueOf(blogs.size()));
    }
}
