package com.github.ichenkaihua.test.web;

import com.github.ichenkaihua.model.Blog;
import com.github.ichenkaihua.service.BlogService;
import com.github.ichenkaihua.utils.RandomUtils;
import com.jayway.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016-11-01 16:50
 */
public class BlogControllerTest extends RestAssuredBaseTest {
    @Autowired
    BlogService blogService;
    private Blog randomBlog(){
        Blog blog = new Blog();
        blog.setBlogName(RandomUtils.randomString());
        blog.setAuthorName(RandomUtils.randomString());
        blog.setBlogFile(RandomUtils.randomString());
        return blog;
    }
    private Blog insertRandomBlog(){
        Blog blog = randomBlog();
        blogService.addBlog(blog);
        return blog;
    }
    public void assertEqualsBlog(Blog expectedBlog,Blog actualBlog){
        assertNotNull(expectedBlog);
        assertNotNull(actualBlog);
        assertEquals(expectedBlog.getId(),actualBlog.getId());
        assertEquals(expectedBlog.getAuthorName(),actualBlog.getAuthorName());
        assertEquals(expectedBlog.getBlogFile(),actualBlog.getBlogFile());
    }
    @Test
    public void addBlogTest(){
        
    }
    @Test 
    public void getBlogByIdTest(){
        Blog blog = insertRandomBlog();
        MockMvcResponse mockMvcResponse = given().log().all()
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .when()
                .get("blogs/{id}", blog.getId());

        mockMvcResponse
                .then().log().all()
                .apply(document("根据id获取博客,不包含密码", preprocessResponse(prettyPrint())))
                .assertThat()
                .statusCode(200);
        Blog queryBlog = mockMvcResponse.as(Blog.class);
        assertEqualsBlog(blog,queryBlog);
    }
}
