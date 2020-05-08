package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClassWithAutowiredMember {
	static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	private void info(String msg) {
		logger.info("skilaru: " + msg);
	}
	
	@Autowired
	private MyComponentClassUsedInAutoWire myAutoWiredBean;
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/hello@AutoWire")
	public String helloAutoWire() {
		info(myAutoWiredBean.getGreet());
		return "testing";
	}
	
	@GetMapping("/hello@Bean")
	public String helloBean() {
		MyPlainJavaClass mb = (MyPlainJavaClass)this.context.getBean("skBean");
		info("Message from retrieved @Bean instance from context " + mb.getBeanMessage());
		return "testing";
	}
	
	@GetMapping("/list@Bean_instances")
	public String[] listBeans() {
        String[] allBeanNames = context.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
        	info(beanName);
        }
        return allBeanNames;
	}
	



}
