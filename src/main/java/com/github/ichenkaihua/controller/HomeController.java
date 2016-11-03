package com.github.ichenkaihua.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;
import org.slf4j.Logger;
/**
 * Created by chenkaihua on 15-12-15.
 */
@Controller
@RequestMapping("")
@ApiIgnore
public class HomeController {
    private static Logger logger = LoggerFactory.getLogger("hello");
    @RequestMapping("/index")
    public String showHomePage(Model model){

        model.addAttribute("name","spring-mvc");
        return "index";
    }
    @RequestMapping("/test")
    public String showTestPage(Model model){

        model.addAttribute("name","spring-mvc");
        return "testchar";
    }

}
