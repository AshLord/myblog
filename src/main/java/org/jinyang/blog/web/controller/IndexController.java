package org.jinyang.blog.web.controller;

import org.jinyang.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yang.jin on 21/08/2017.
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("blog");
        mv.addObject("list", blogService.queryByLabel("JavaScript"));
        return mv;
    }

}
