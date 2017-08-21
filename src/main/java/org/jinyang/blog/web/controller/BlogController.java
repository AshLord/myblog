package org.jinyang.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yang.jin on 21/08/2017.
 */
@Controller
public class BlogController {

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("blog-java");
        mv.addObject("author", "jy");
        return mv;
    }
}
