package com.deppit.feature.toggle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackages = "com.deppit.feature.toggle")
@Slf4j
public class FeatureToggleApp {

	@PostConstruct
	public void run(){
		log.info("Deppit Feature Toggle it's running!");
	}
}
