package com.iprimed.microservices.CurrencyCalculationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
@EnableFeignClients("com.iprimed.microservices.CurrencyCalculationService")
@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyCalculationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyCalculationServiceApplication.class, args);
	}
	@Bean  
	public Sampler defaultSampler()  	{  
	            return Sampler.ALWAYS_SAMPLE;  
	      } 

}
