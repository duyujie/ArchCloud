package com.yujiedu.main.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackages = "com.yujiedu.orm")
@ComponentScan({ "com.yujiedu.main" })
@EnableJpaRepositories("com.yujiedu.main.repository")
public class ArchMainApplication {

	@Autowired
	DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(ArchMainApplication.class, args);

	}
}
