package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

	@Bean
	MyBean myBean() {
		MyBean myBean = new MyBean();
		myBean.setMyLong(123);
		myBean.setMyString("Godoro");
		myBean.setMyDouble(12.34);
		return myBean;
	}
}
