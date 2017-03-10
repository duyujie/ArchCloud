package com.yujiedu.arch.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({ "com.yujiedu.portal" })
public class ArchPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchPortalApplication.class, args);
	}
}
