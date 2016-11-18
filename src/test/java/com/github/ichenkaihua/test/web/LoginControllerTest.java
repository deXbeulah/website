package com.github.ichenkaihua.test.web;

import com.github.ichenkaihua.model.User;
import com.jayway.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.Test;
import org.springframework.http.MediaType;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.Assert.assertNotNull;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

/**
 * @Description: ${DESCRIPTION}
 * @author: WangQiang
 * @create: 2016-11-18 15:28
 */
public class LoginControllerTest extends RestAssuredBaseTest{
    @Test
    public void testAddUser(){
        User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");
        MockMvcResponse mockMvcResponse = given()
                .body(user)
                .log().all()
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .when()
                .post("/login");
        mockMvcResponse
                .then()
                .log().all()
                .apply(document("添加用户,会忽略id，用于自动创建", preprocessResponse(prettyPrint())))
                .assertThat().statusCode(201);
        User responUser = mockMvcResponse.as(User.class);
    }
}
