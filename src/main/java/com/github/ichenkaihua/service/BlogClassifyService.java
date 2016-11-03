package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.BlogClassifyMapper;
import com.github.ichenkaihua.model.BlogClassify;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016-11-02 14:52
 */
@Service
public class BlogClassifyService  {
    @Autowired
    BlogClassifyMapper blogClassifyMapper;
  
    @RequiresRoles("admin")
    public void deleteWithAdminRoleById(int id) {
        blogClassifyMapper.deleteByPrimaryKey(id);
    }


    public BlogClassify get(int id) {
        return blogClassifyMapper.selectByPrimaryKey(id);
    }


    public boolean isExist(BlogClassify blogClassify) {
        System.out.println(blogClassify.toString());
        return blogClassifyMapper.selectCount(blogClassify) > 0;
    }


    public void add(BlogClassify blogClassify) {
        blogClassifyMapper.insert(blogClassify);
    }


    public List<BlogClassify> getList(BlogClassify blogClassify) {
        if (blogClassify == null) {
            return blogClassifyMapper.selectAll();
        }

        return blogClassifyMapper.select(blogClassify);
    }


    public void deleteById(int id) {
        blogClassifyMapper.deleteByPrimaryKey(id);

    }

    public void update(BlogClassify blogClassify) {
        blogClassifyMapper.updateByPrimaryKey(blogClassify);
    }


}
