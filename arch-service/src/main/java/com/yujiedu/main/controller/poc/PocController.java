package com.yujiedu.main.controller.poc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yujiedu.orm.poc.PocUser;
import com.yujiedu.service.poc.IPocService;
import com.yujiedu.service.poc.vo.WelcomeInfo;

@RestController
public class PocController {
	@Autowired
	private IPocService pocService;
	private static Logger logger = LoggerFactory.getLogger(PocController.class);

	public PocController() {
	}

	@GetMapping("/")
	public String greeting() {
		return "Hello World! 欢迎来到架构师的梦想之家！";
	}

	@Value("${server.port}")
	String serverPort;
	
	@GetMapping(value = "/greeting")
	public String greet() {
		return "Hi, I'm from "+serverPort;
	}

	@GetMapping(value = "/welcome")
	@ResponseBody
	public WelcomeInfo welcomePage(HttpServletRequest request) {
		pocService.log("welcome");
		HttpSession session = request.getSession(true);
		WelcomeInfo welcomeInfo = new WelcomeInfo();
		welcomeInfo.setToken(session.getId());
		welcomeInfo.setCreatedDate(new Date());

		return welcomeInfo;
	}

	@GetMapping(value = "/pocUsers")
	@ResponseBody
	public List<PocUser> findAllPocUsers() {
		return pocService.findAllPocUsers();
	}

	@GetMapping(value = "/pocUsers/{userId}")
	@ResponseBody
	public PocUser findPocUserById(@PathVariable("userId") String userId) {
		return pocService.findUserById(userId);
	}

	@GetMapping(value = "/pocUsersList")
	@ResponseBody
	public List<PocUser> findPocUsersById(@RequestParam("userId") String userId) {
		return pocService.findUsersById(userId);
	}

	@Value("${foo}")
	String foo;

	@GetMapping("/foo")
	public String foo() {
		return "The foo is: " + foo;
	}
}
