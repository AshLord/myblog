package org.jinyang;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by 晋阳 on 2017/8/20.
 */
@EnableRetry
@EnableAsync
@EnableScheduling
@SpringBootApplication(scanBasePackages = "org.jinyang")
public class StartBlog extends SpringBootServletInitializer{

    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(StartBlog.class).profiles("local").run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(getClass());
    }
}
