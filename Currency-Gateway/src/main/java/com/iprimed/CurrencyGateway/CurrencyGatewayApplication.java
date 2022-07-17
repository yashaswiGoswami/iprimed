package com.iprimed.CurrencyGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyGatewayApplication.class, args);
	}
	//creating a bean; we have added Spring Cloud Sleuth to the Zuul API Gateway server.
	@Bean  
	//creating a sampler called   
	public Sampler defaultSampler()  
	{  
	return Sampler.ALWAYS_SAMPLE;  
	}  
}
