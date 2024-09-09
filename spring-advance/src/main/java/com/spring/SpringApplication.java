package com.spring;

import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Field;

// @SpringBootApplication
public class SpringApplication {

	public static void main(String[] args) {

		// 创建 Spring 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		// 容器中获取 bean 对象
		UserService userService = (UserService) applicationContext.getBean("userService");// 这里是小写 为何? TODO
		// UserService userService = (UserService) applicationContext.getBean("userService");// 默认是单例模式,多次获取为同一个对象
		// UserService userService = (UserService) applicationContext.getBean("userService");

		// 调用 bean 中方法
		userService.test();

		UserService bean = new UserService();

		// Spring 给属性赋值代码示例
		// logic:如果属性有Autowired注解,则进行赋值
		for (Field field : bean.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(Autowired.class)) {
				// field.set(bean, ??);
			}
		}

		// 如何将普通的对象放入容器变为 bean 对象？
		Object o = new Object();
		applicationContext.getBeanFactory().registerSingleton("xxx", o);

	}

}
