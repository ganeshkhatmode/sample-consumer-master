package com.gk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${operations.resturl}")
	private String serviceUrl;
	
	@GetMapping("/consumeEmployess" )
	String getEmployee() {
		return restTemplate.getForObject(serviceUrl, String.class);
	}
	
	
	@Bean
	RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
