package com.poly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.poly.interception.LoggerInterceptor;
import com.poly.interception.SecurityInterceptor;

@Configuration
public class InterConfig implements WebMvcConfigurer {
	
	@Autowired
	LoggerInterceptor interceptor;
	
	@Autowired
	SecurityInterceptor auth;

	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {		
//		registry.addInterceptor(interceptor)
//		.addPathPatterns("/**")
//		.excludePathPatterns("/assets/**");
		
		registry.addInterceptor(auth)
			.addPathPatterns("/xeoxo/**", "/cart/**","/order/**", "/admin/**")
			.excludePathPatterns("/xeoxo/login", "/xeoxo/index","/xeoxo/signup");
		

		
	}

}
