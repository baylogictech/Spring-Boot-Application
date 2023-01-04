package com.baylogic;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baylogic.service.ProvidersService;
import com.baylogic.service.ProvidersServiceImpl;


@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.baylogic.repositories" })
@ComponentScan("com.baylogic")
@PropertySource("classpath:application.properties")
public class JPAConfiguration {

	@Bean
	public ProvidersService providersService() {
		return new ProvidersServiceImpl();
	}

}