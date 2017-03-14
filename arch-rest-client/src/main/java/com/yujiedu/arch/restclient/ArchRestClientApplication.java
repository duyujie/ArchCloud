package com.yujiedu.arch.restclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({ "com.yujiedu.arch.restclient" })
public class ArchRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchRestClientApplication.class, args);
	}
}
