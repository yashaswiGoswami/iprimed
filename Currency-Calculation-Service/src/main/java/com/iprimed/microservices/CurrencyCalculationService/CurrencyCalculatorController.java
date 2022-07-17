package com.iprimed.microservices.CurrencyCalculationService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyCalculatorController {

	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-calculator/from/{from}/to/{to}/{quantity}") //where {from} and {to} represents the column   
	//return a bean back  
	public CurrencyCalculatorBean convertCurrency(@PathVariable String from, @PathVariable String to,
	@PathVariable BigDecimal quantity) {
		CurrencyCalculatorBean  rb=proxy.exchange(from, to);
		/*Map<String, String> pathVariable= new HashMap<>();
		pathVariable.put("from", from);
		pathVariable.put("to", to);
		
		ResponseEntity<CurrencyCalculatorBean> response=new RestTemplate().getForEntity(""
				+ "http://localhost:8000/currency-exchange/from/{from}/to/{to} ", CurrencyCalculatorBean.class, pathVariable);
		CurrencyCalculatorBean  rb= response.getBody();*/
		System.out.println("the port is: "+rb.getPort());
		return new CurrencyCalculatorBean(rb.getId(),from,to, 
				rb.getConversionMultiple(),quantity,quantity.multiply
				(rb.getConversionMultiple()),rb.getPort());
		
	}

	
	
}
