package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyComponentClassUsedInAutoWire {
	static Logger logger = LoggerFactory.getLogger(MyComponentClassUsedInAutoWire.class);
	@Value("${com.example.greet}")
	String greet;

	@Bean(name= "skBean")
	public MyPlainJavaClass getMyBeanInstance() {
		info("My Bean instance is created");
		return new MyPlainJavaClass("Created when autowire is called");
	}

	public String getGreet() {
		return greet;
	}

	public void setGreet(String greet) {
		info("setGree called");
		this.greet = greet;
	}

	public MyComponentClassUsedInAutoWire(String greet) {
		info("Parameter constructor called");
		this.greet = greet;
	}

	public MyComponentClassUsedInAutoWire() {
		info("Default constructor called");
		this.greet = "Hello Autowire";
	}

	private void info(String msg) {
		logger.info("skilaru: " + msg);
	}

}
