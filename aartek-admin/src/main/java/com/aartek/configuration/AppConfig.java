package com.aartek.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * 
 * @author Vivek, 06/04/2015, AppConfig file package scan
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.aartek" })
@EnableTransactionManagement
@Import({ SecurityConfiguration.class })
@PropertySource("classpath:log4j.properties")
public class AppConfig {
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520); // 20MB
		multipartResolver.setMaxInMemorySize(1048576); // 1MB
		return multipartResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resourceMessage = new ResourceBundleMessageSource();
		resourceMessage.setBasename("message");
		return resourceMessage;
	}

	@Bean
	public ViewResolver viewResolver() {

		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(0);

		return resolver;

	}

}