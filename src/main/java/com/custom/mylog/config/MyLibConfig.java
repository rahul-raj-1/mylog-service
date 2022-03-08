package com.custom.mylog.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.custom.mylog.config")
@EnableJpaRepositories("com.custom.mylog.config")
@EntityScan("com.custom.mylog.config")
@EnableScheduling
public class MyLibConfig {
	
}