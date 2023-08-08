package com.benny.config;

import jakarta.servlet.Filter;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //用來註冊相當於beans.config.xml的java程式設定
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootAppConfig.class};
//        return null;
    }

    //用來註冊相當於mvc-servlet.xml的java程式設定
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebAppConfig.class};
//        return null;
    }

    //用來設定DispatcherServlet接收http請求的映射路徑
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
//        return null;
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("C:/temp/upload/"));
    }

    //相當於web.xml中的CharacterEncodingFilter設定 (tomcat 9 才需要)
//    @Override
//    protected Filter[] getServletFilters() {
//        CharacterEncodingFilter cft = new CharacterEncodingFilter("UTF-8", true);
//        return new Filter[] {cft};
//    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter cef = new CharacterEncodingFilter("UTF-8", true);
        HiddenHttpMethodFilter hmf = new HiddenHttpMethodFilter();
        return new Filter[] {cef, hmf};
    }

}
