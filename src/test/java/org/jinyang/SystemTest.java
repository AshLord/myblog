package org.jinyang;

import org.jinyang.blog.dao.entity.BlogEntity;
import org.jinyang.blog.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by yang.jin on 23/08/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {StartBlog.class})
@ActiveProfiles(profiles = {"local"})
public class SystemTest {

    @Autowired
    private BlogService blogService;

    @Test
    public void testDbAvailable(){
        List<BlogEntity> list = blogService.queryByLabel("JavaScript");
        BlogEntity entity = list.get(1);
        System.out.println(entity.getContent());
    }
}
