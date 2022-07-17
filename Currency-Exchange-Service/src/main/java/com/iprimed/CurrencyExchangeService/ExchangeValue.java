package com.iprimed.CurrencyExchangeService;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;  

@Entity
@Table
public class ExchangeValue {	
	@Id
	@Column(name="currency_id")
	private Long id;  
	@Column(name="currency_from")
	private String from;  
	@Column(name="currency_to")
	private String to; 
	@Column(name="conversionmultiple")
	private BigDecimal conversionMultiple;  
	@Column(name="currency_port")
	private int port;
	public Long getId() {		return id; }
	public void setId(Long id) {	this.id = id;	}
	public String getFrom() {	return from;	}
	public void setFrom(String from) {	this.from = from;	}
	public String getTo() {	return to;	}
	public void setTo(String to) {		this.to = to;	}
	public BigDecimal getConversionMultiple() {	return conversionMultiple;	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;	}
	public int getPort() {		return port;	}
	public void setPort(int port) {		this.port = port;	}  
	
}
