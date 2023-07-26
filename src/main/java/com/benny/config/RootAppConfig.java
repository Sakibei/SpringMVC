package com.benny.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import java.util.Properties;

// 等同於beans.config.xml
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.benny")
@EnableTransactionManagement
public class RootAppConfig {

    //	等同於beans.config.xml中的<bean id="dataSource" ... />
    @Bean
    public DataSource dataSource() throws IllegalArgumentException, NamingException {
        JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
        jndiBean.setJndiName("java:comp/env/connectMySQLJdbc/springMvc");
        jndiBean.afterPropertiesSet();
        DataSource ds = (DataSource) jndiBean.getObject();
        return ds;
    }

    // 等同於beans.config.xml中的<bean id="sessionFactory" ... />
    @Bean
    public LocalSessionFactoryBean sessionFactory() throws IllegalArgumentException, NamingException {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.benny");
        factory.setHibernateProperties(addtionalProperties());
        return factory;
    }

    // 等同於beans.config.xml中的<bean id="hibernateProperties" ... />
    private Properties addtionalProperties() {
        Properties props = new Properties();
        props.put("hibernate.dialect", org.hibernate.dialect.SQLServerDialect.class);
        props.put("hibernate.show_sql", Boolean.TRUE);
        props.put("hibernate.format_sql", Boolean.TRUE);
        return props;
    }

    // 等同於beans.config.xml中的<bean id="transactionManager" ... />
    @Bean
    public HibernateTransactionManager transactionManager() throws IllegalArgumentException, NamingException {
        HibernateTransactionManager txMgr = new HibernateTransactionManager();
        txMgr.setSessionFactory(sessionFactory().getObject());
        return txMgr;
    }

}
