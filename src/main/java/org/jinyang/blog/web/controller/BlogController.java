package org.jinyang.blog.web.controller;

import org.jinyang.blog.dao.entity.BlogEntity;
import org.jinyang.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yang.jin on 23/08/2017.
 */
@Controller
@RequestMapping(value = "/blog",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class BlogController {

    @Autowired
    private BlogService blogService;

    @ResponseBody
    @RequestMapping(value = "/show",method = RequestMethod.POST)
    public Object show(String label) {
        return blogService.queryByLabel(label);
    }
}
