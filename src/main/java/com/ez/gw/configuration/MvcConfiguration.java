package com.ez.gw.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ez.gw.controller.AdminLoginInterceptor;
import com.ez.gw.controller.LoginInterceptor;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new LoginInterceptor())
		.excludePathPatterns("/")
		.addPathPatterns("/anonymousBoard/**","/approval/**",
				"/board/**","/calendar/**", "/club/**","/commute/**",
				"/market/**","/mypage/**","/message/**","/reman/**",
				"/pds/**","/qna/**","/reservation/**");

		registry.addInterceptor(new AdminLoginInterceptor())
		.excludePathPatterns("/admin/login")
		.addPathPatterns("/admin/**");



	}

	/*
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver 
		= new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8"); // 파일 인코딩 설정
		multipartResolver.setMaxUploadSizePerFile(2 * 1024 * 1024); // 파일당 업로드 크기 제한 (2MB)
		return multipartResolver;
	}

	

	/*
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/pd_images/**").addResourceLocations("file:///C:/lecture/pd_images/");
		
	}
*/
	
}