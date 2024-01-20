package com.qwerty.learn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired
	private CustomHandlerInterceptor customHandlerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// register blocking rules
		InterceptorRegistration interceptorRegistration = registry.addInterceptor(customHandlerInterceptor);
		
		//Intercept all paths for api requests
		interceptorRegistration.addPathPatterns("/**");
		
		//exclude paths 
		interceptorRegistration.excludePathPatterns("/scratchy/getZero");
	}
}
