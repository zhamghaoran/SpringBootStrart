package com.zhr.boot;

import com.zhr.boot.Config.myConfig;
import com.zhr.boot.Dao.Pet;
import com.zhr.boot.Dao.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.zip.CheckedOutputStream;

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
        // 在容器中注册的组件默认就是单实例的
        // 组件依赖问题
        User bean = run.getBean("User",User.class);
        System.out.println(bean.getPet() == run.getBean("pet",Pet.class));

        // 从容器中获取组件
        System.out.println("======");
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for( String i : beanNamesForType)
            System.out.println(i);

        boolean tom = run.containsBean("User");
        System.out.println(tom);
    }

}
