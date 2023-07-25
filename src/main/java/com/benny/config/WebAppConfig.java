package com.benny.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
}
