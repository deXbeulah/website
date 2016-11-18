package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.BlogMapper;
import com.github.ichenkaihua.model.Blog;
import com.github.ichenkaihua.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: ${DESCRIPTION}
 * @author: WangQiang
 * @create: 2016-11-18 10:51
 */
@Service
public class BlogService {
    @Autowired
    BlogMapper blogMapper;
    public void deleteWithAdminRoleById(int id){
        blogMapper.deleteByPrimaryKey(id);
    }


    public Blog getBlogById(int id){
        return blogMapper.selectByPrimaryKey(id);
    }



    public boolean isExist(Blog blog){
        System.out.println(blog.toString());
        return  blogMapper.selectCount(blog)>0;
    }


    public void addBlog(Blog blog){
        blogMapper.insert(blog);
    }


    public List<Blog> getBlogs(Blog blog){
        if (blog == null) {
            return blogMapper.selectAll();
        }

        return blogMapper.select(blog);
    }
    public List<Blog> getBlogsByUser(User user){
        return getBlogsByUserId(user.getId());
    }
    public List<Blog> getBlogsByUserId(int userId){
        return blogMapper.selectByUserId(userId);
    }

    public void deleteById(int id){
        blogMapper.deleteByPrimaryKey(id);

    }

    public void update(Blog blog){
        blogMapper.updateByPrimaryKey(blog);
    }
}
