package com.yujiedu.arch.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.caucho.hessian.client.HessianProxyFactory;
import com.yujiedu.orm.poc.PocUser;
import com.yujiedu.service.poc.IPocService;

@RestController
class PocController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Value("${service.main}")
	String mainService;
	public PocController() {
	}

	@GetMapping("/")
	public String greeting() {
		return "Hello World! 欢迎来到架构师的梦想之家！";
	}

	@GetMapping(value = "/pocUsers")
	@ResponseBody
	public List<PocUser> findAllPocUsers() {
		return getPocService().findAllPocUsers();
	}

	@GetMapping(value = "/pocUsers/{userId}")
	@ResponseBody
	public PocUser findPocUserById(@PathVariable("userId") String userId) {
		return getPocService().findUserById(userId);
	}

	@GetMapping(value = "/pocUsersList")
	@ResponseBody
	public List<PocUser> findPocUsersById(@RequestParam("userId") String userId) {
		return getPocService().findUsersById(userId);
	}

	private IPocService getPocService() {
		IPocService pocService = null;
		try {

			String url = this.discoveryClient.getInstances(mainService).get(0).getUri() + "/remote/pocService";
			HessianProxyFactory factory = new HessianProxyFactory();
			pocService = (IPocService) factory.create(IPocService.class, url);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pocService;
	}
}
