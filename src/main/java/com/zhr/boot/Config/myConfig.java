package com.zhr.boot.Config;

import com.zhr.boot.Dao.Pet;
import com.zhr.boot.Dao.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.task.TaskRejectedException;

/**
 * 配置类中可以使用@Bean给容器注册组件
 * 默认是单实例的
 * proxyBeanMethods代理bean的方法
 *          full(proxyBeanMethods = true)
 *          lite(proxyBeanMethods = false)
 *          组件依赖
 * {@code @Import} ({User.class,Pet.class})
 *  给容器中自动创建出这些类型的组件,默认组件的名字就是全类名
 *  {@code @ImportResource} 可以导入spring的配置文件
 *
 */

@Import({User.class, Pet.class})
@Configuration(proxyBeanMethods = true) // 这是一个配置类
public class myConfig {
    /**
     * 外部对这个配置类中注册方法调用多少遍，得到的都是容器中的单实例对象
     * @return
     */
    //@ConditionalOnMissingBean(name = "tom") // 条件装配
    @Bean("User") // 以方法名作为组件的id，返回类型就是组件类型，返回的值就是组件在容器中保存的对象
    public User user01() {
        User hangman = new User("hangman", 1);
        hangman.setPet(pet());
        return hangman;
    }

    @Bean("tom")
    public Pet pet() {
        return new Pet("123456");
    }

}
