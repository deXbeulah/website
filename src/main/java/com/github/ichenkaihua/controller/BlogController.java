package com.github.ichenkaihua.controller;

import com.github.ichenkaihua.jopo.ErrorResponseEntity;
import com.github.ichenkaihua.model.Blog;
import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.BlogService;
import com.github.ichenkaihua.utils.URIUtils;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016 11 01 15:08
 */
@RequestMapping(value = "blogs", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
@Api(value = "/blogs", tags = "BlogApi", description = "博客接口")
public class BlogController {
    private Logger logger = LoggerFactory.getLogger(BlogController.class);
    @Autowired
    BlogService blogService;


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ApiOperation(
            value = "根据id获取用户信息,不包含密码",
            response = User.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "指定id的博客不存在",
                    response = ErrorResponseEntity.class)
    })
    public ResponseEntity getBlogById(@ApiParam(value = "博客id",required = true) @PathVariable int id) {
        System.out.println("blogServ:"+blogService);
        Blog blog = blogService.getBlogById(id);
        if (blog == null) {
            return ErrorResponseEntity.buildToResponseEntity(1000, "博客不存在");
        }
        return ResponseEntity.ok(blog);
    }
    @RequestMapping(value = "",method = RequestMethod.POST, consumes = {APPLICATION_JSON_VALUE})
    @ApiOperation(value = "添加用户,会忽略id，用于自动创建", code = 201, response = Blog.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "用户已经存在",response = ErrorResponseEntity.class)
    })
    public ResponseEntity addBlog(@ApiParam(value = "博客信息") @RequestBody Blog blog){
        blogService.addBlog(blog);
        return ResponseEntity.created(URIUtils.createURI("/blogs/{id}",blog.getId())).body(blog);
    }
}
