package com.example.demo;

public class MyPlainJavaClass {
	
	private String beanMessage;

	public String getBeanMessage() {
		return beanMessage;
	}

	public void setBeanMessage(String beanMessage) {
		this.beanMessage = beanMessage;
	}

	public MyPlainJavaClass(String beanMessage) {
		this.beanMessage = beanMessage;
	}

}
