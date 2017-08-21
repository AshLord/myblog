package org.jinyang.blog.web.exception;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Writer;

/**
 * Created by yaxiong.hu on 2016/11/2.
 */
public class FreemarkerExceptionHandler implements TemplateExceptionHandler  {

    private static final Logger log = LoggerFactory.getLogger(FreemarkerExceptionHandler.class);

    public void handleTemplateException(TemplateException te, Environment env,Writer out) throws TemplateException {
        log.warn("[Freemarker Error: " + te.getMessage() + "]");
        throw te;
    }
}
