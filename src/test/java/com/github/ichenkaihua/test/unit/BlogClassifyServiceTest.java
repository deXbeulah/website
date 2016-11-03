package com.github.ichenkaihua.test.unit;

import com.github.ichenkaihua.model.BlogClassify;
import com.github.ichenkaihua.service.BlogClassifyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016-11-02 15:02
 */
public class BlogClassifyServiceTest extends BaseUnitTest {
    @Autowired
    BlogClassifyService blogClassifyService;
    @Test
    public void addBlogClassify(){
        BlogClassify blogClassify = new BlogClassify();
        blogClassify.setBlogId(1);
        blogClassify.setClassifyId(1);
        blogClassifyService.add(blogClassify);
    }
}
