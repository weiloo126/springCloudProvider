package com.example.springCloudProvider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LW  
 * @date 2017年10月9日
 */
@RestController
public class HelloController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private DiscoveryClient client;
	
    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + name);
        return "hello "+name+"，this is first messge";
    }
}
