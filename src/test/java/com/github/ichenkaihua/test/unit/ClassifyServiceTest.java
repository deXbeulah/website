package com.github.ichenkaihua.test.unit;

import com.github.ichenkaihua.mapper.ClassifyMapper;
import com.github.ichenkaihua.model.Classify;
import com.github.ichenkaihua.service.ClassifyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016-11-02 14:21
 */
public class ClassifyServiceTest extends BaseUnitTest {
    @Autowired
    ClassifyService classifyService;
    @Test
    public void addClassifyTest(){
        Classify classify = new Classify();
        classify.setClassifyName("java");
        classify.setGroupId(0);
        classifyService.addClassify(classify);
        print("结果",classify.toString());
    }
}
