package com.yujiedu.arch.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ArchConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchConfigServiceApplication.class, args);
	}
}
