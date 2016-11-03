package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.ClassifyMapper;
import com.github.ichenkaihua.model.Classify;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016-11-02 13:54
 */
@Service
public class ClassifyService {
    @Autowired
    ClassifyMapper classifyMapper;
    @RequiresRoles("admin")
    public void deleteWithAdminRoleById(int id) {
        classifyMapper.deleteByPrimaryKey(id);
    }


    public Classify getClassifyById(int id) {
        return classifyMapper.selectByPrimaryKey(id);
    }


    public boolean isExist(Classify classify) {
        System.out.println(classify.toString());
        return classifyMapper.selectCount(classify) > 0;
    }


    public void addClassify(Classify classify) {
        classifyMapper.insert(classify);
    }


    public List<Classify> getClassifys(Classify classify) {
        if (classify == null) {
            return classifyMapper.selectAll();
        }

        return classifyMapper.select(classify);
    }


    public void deleteById(int id) {
        classifyMapper.deleteByPrimaryKey(id);

    }

    public void update(Classify classify) {
        classifyMapper.updateByPrimaryKey(classify);
    }


}
