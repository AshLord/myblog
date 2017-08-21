package org.jinyang.blog.web.controller;

import org.jinyang.blog.common.objects.CommonResult;
import org.jinyang.blog.common.objects.JPage;
import org.jinyang.blog.common.objects.PageParams;
import org.jinyang.blog.dao.entity.BlogEntity;
import org.jinyang.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by yang.jin on 21/08/2017.
 */
@Controller
@RequestMapping(value = "/back",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class BackController {

    @Autowired
    private BlogService blogService;

    private static final String MAIN = "blog-main";

    @RequestMapping("/main/page")
    public ModelAndView mainPage() {
        return new ModelAndView(MAIN);
    }

    @RequestMapping("/main/params")
    @ResponseBody
    public CommonResult mainParams(PageParams pageParams) {
        JPage<BlogEntity> jPage = blogService.queryAll(pageParams);
        return new CommonResult<JPage<BlogEntity>>().retSucc(jPage);
    }

    @RequestMapping("/insert/page")
    public ModelAndView insertPage() {
        return new ModelAndView("blog-insert");
    }

    @RequestMapping("/insert/params")
    public String insertParams(BlogEntity entity) {
        blogService.insert(entity);
        return MAIN;
    }

    @RequestMapping("/update/page")
    public ModelAndView updatePage(HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        BlogEntity entity = blogService.queryOne(id);
        ModelAndView mv = new ModelAndView("blog-update");
        mv.addObject("blog",entity);
        return mv;
    }

    @RequestMapping("/update/params")
    public String updateParams(@Valid BlogEntity entity, BindingResult bindingResult) {
        blogService.update(entity);
        return MAIN;
    }

    @RequestMapping("/delete/params")
    public String remove(@RequestParam("ids[]") List ids){
        for (int i=0;i<ids.size();i++){
            long id = Long.parseLong(ids.get(i).toString());
            blogService.delete(id);
        }
        return MAIN;
    }
}
