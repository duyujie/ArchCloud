package com.yujiedu.main.exporter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.yujiedu.service.poc.IPocService;

@Configuration
public class HessianExporterConfig {
	@Autowired
	private IPocService pocService;

	@Bean(name = "/remote/pocService")
	public HessianServiceExporter hessianServiceExporter() {
		HessianServiceExporter export = new HessianServiceExporter();
		export.setService(pocService);
		export.setServiceInterface(IPocService.class);
		return export;
	}
}
