package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.BlogMapper;
import com.github.ichenkaihua.model.Blog;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016 11 01 15:27
 */
@Service
public class BlogService {
    @Autowired
    BlogMapper blogMapper;


    @RequiresRoles("admin")
    public void deleteWithAdminRoleById(int id) {
        blogMapper.deleteByPrimaryKey(id);
    }


    public Blog getBlogById(int id) {
        return blogMapper.selectByPrimaryKey(id);
    }


    public boolean isExist(Blog blog) {
        System.out.println(blog.toString());
        return blogMapper.selectCount(blog) > 0;
    }


    public void addBlog(Blog blog) {
        blogMapper.insert(blog);
    }


    public List<Blog> getBlogs(Blog blog) {
        if (blog == null) {
            return blogMapper.selectAll();
        }

        return blogMapper.select(blog);
    }


    public void deleteById(int id) {
        blogMapper.deleteByPrimaryKey(id);

    }

    public void update(Blog blog) {
        blogMapper.updateByPrimaryKey(blog);
    }


}
