package com.benny.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

//相當於mvc-servlet.xml
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.benny"})
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //相當於<mvc:default-servlet-handler/>
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        //InternalResourceViewResolver irv = new InternalResourceViewResolver("/WEB-INF/pages/",".jsp");
        InternalResourceViewResolver irv = new InternalResourceViewResolver();
        irv.setPrefix("/WEB-INF/pages/");
        irv.setSuffix(".jsp");
        irv.setOrder(6);
        return irv;
    }

    // 設定國際化資源檔
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
//        ms.setBasename("static.encode.message");
        ms.setBasename("static.message");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("locale");
        registry.addInterceptor(lci).addPathPatterns("/**");
    }

    //名稱必須為localeResolver，否則無法取得
    @Bean
    public SessionLocaleResolver localeResolver(){
        SessionLocaleResolver slr = new SessionLocaleResolver();
        return slr;
    }

    //設定預設頁面和轉向
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "membersmain.controller");
        registry.addViewController("happyday.action").setViewName("form");
    }

    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public MappingJackson2JsonView jsonView() {
        MappingJackson2JsonView jView = new MappingJackson2JsonView();
        jView.setPrettyPrint(true);
        return jView;
    }
    @Bean
    public ContentNegotiatingViewResolver contentViewResolver() {
        ContentNegotiatingViewResolver vr1 = new ContentNegotiatingViewResolver();

        List<View> lists = new ArrayList<View>();
        lists.add(jsonView());

        vr1.setDefaultViews(lists);
        return vr1;
    }

}
