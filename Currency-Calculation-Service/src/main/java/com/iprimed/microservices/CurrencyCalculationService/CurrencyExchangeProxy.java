package com.iprimed.microservices.CurrencyCalculationService;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@LoadBalancerClient(name = "currency-exchange-service",
configuration=LoadBalancerConfiguration.class)
@FeignClient(name ="currency-exchange-service", url="localhost:8000")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyCalculatorBean exchange(@PathVariable(value="from") String from, 
			@PathVariable(value="to") String to);
}
