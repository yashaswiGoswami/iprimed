package com.iprimed.CurrencyExchangeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.core.env.Environment;  

 
@RestController   
public class CurrencyExchangeController {

	@Autowired  
	private Environment environment;  
	@Autowired
	private CurrencyExchangeRepository repo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}") //where {from} and {to} are path variable  
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, 
			@PathVariable String to)  //from map to USD and to map to INR  
	{     
		//taking the exchange value  
		ExchangeValue exchangeValue= repo.findByFromAndTo(from, to); 
		//picking port from the environment  
		exchangeValue.setPort(Integer.parseInt(environment
				.getProperty("local.server.port")));  
		
		return exchangeValue;  
	}  
}
