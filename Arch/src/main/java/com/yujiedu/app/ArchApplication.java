package com.yujiedu.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.yujiedu" })
@EnableJpaRepositories("com.yujiedu.repository")
@EntityScan(basePackages = "com.yujiedu.orm")
public class ArchApplication {

	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(ArchApplication.class, args);
	}
}
