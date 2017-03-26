package com.yujiedu.arch.portal.controller;

import java.net.MalformedURLException;
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
class RpcServiceController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Value("${arch.main.appName}")
	private String archMainServiceName;

	private IPocService getPocService() {

		String serviceUri = this.discoveryClient.getInstances(archMainServiceName).get(0).getUri()
				+ "/remote/pocService";
		
		HessianProxyFactory proxyFactory=new HessianProxyFactory();
		IPocService pocService=null;
		try {
			pocService = (IPocService)proxyFactory.create(IPocService.class, serviceUri);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return pocService;
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

}