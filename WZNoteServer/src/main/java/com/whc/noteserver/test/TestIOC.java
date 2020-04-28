package com.whc.noteserver.test;



import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {

	public static void main(String[] args) {
		//spring应用上下文
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conf/spring-service.xml");
		//实例化对象
		//Date date=context.getBean("date",Date.class);
		//System.out.println(date);
		//http://www.baidu.com/login.html  跳转到  http://www.baidu.com/index.html
		//直接输入 http://www.baidu.com/index.html  跳转到  http://www.baidu.com/login.html
		//bean的作用域 singletonv request  session
		//FanDian fanDian =context.getBean("fanDian",FanDian.class);
		//System.out.println(fanDian.hashCode());
		//fanDian.say();
		//fanDian =context.getBean("fanDian",FanDian.class);
		//System.out.println(fanDian.hashCode());
		//fanDian =context.getBean("fanDian",FanDian.class);
		//System.out.println(fanDian.hashCode());
		
		//Person person = context.getBean("person",Person.class);
		//person.say();

		
		

	}

}
