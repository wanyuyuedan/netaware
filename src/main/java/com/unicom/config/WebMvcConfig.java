package com.unicom.config;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public LoginInterceptor loginInterceptor() {
		System.out.println("LocaleChangeInterceptor");
		LoginInterceptor lci = new LoginInterceptor();
		return lci;
	}

	/*
	 * 配置拦截器(non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("---------1-----------");
		registry.addInterceptor(loginInterceptor()).addPathPatterns("/**/*")
				.excludePathPatterns("/user/login", "/user/logout", "/druid/*");
	}

	/*
	 * 配置静态路径(non-Javadoc)，在src/main/resources文件夹下面
	 * 参考https://blog.csdn.net/zhoujiyu123/article/details/80255445
	 * 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#
	 * addResourceHandlers(org.springframework.web.servlet.config.annotation.
	 * ResourceHandlerRegistry)
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/")
				.addResourceLocations("classpath:/resources/").addResourceLocations("classpath:/static/")
				.addResourceLocations("classpath:/public/");
	}
}
