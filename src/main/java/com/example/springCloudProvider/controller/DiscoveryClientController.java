package com.example.springCloudProvider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LW  
 * @date 2017年11月1日
 */
@RestController
public class DiscoveryClientController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	/**
	 * 通过DiscoveryClient接口的getServices获取了当前客户端缓存的所有服务清单
	 * @return
	 */
	@RequestMapping("/dc")
	public String dc(){
		String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
	}
}
