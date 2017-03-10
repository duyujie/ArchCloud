package com.yujiedu.portal.controller.poc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PocController {

	public PocController() {
	}

	@GetMapping("/")
	public String greeting() {
		return "Hello World! 欢迎来到架构师的梦想之家！";
	}

}
