package com.zhr.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@code @SpringBootApplication} 这是一个springboot应用
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for(String i : beanDefinitionNames) {
            System.out.println(i);
        }
    }

}
