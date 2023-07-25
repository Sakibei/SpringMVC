package com.benny.config;

import jakarta.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //用來註冊相當於beans.config.xml的java程式設定
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    //用來註冊相當於mvc-servlet.xml的java程式設定
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebAppConfig.class};
    }

    //用來設定DispatcherServlet接收http請求的映射路徑
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    //相當於web.xml中的CharacterEncodingFilter設定 (tomcat 9 才需要)
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter cft = new CharacterEncodingFilter("UTF-8", true);
        return new Filter[] {cft};
    }
}
