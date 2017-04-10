package com.yujiedu.arch.portal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DefaultController {

	public DefaultController() {
	}

	@GetMapping("/")
	public String greeting() {
		return "Hello World! 欢迎来到架构师的梦想之家！";
	}

}
