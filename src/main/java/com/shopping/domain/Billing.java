 package com.shopping.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Billing {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String BillingName;
	private String BillingStreet1;
	private String BillingStreet2;
	private String BillingCity;
	private String BillingState;
	private String BillingZipcode;
	
	@OneToOne
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillingName() {
		return BillingName;
	}

	public void setBillingName(String BillingName) {
		this.BillingName = BillingName;
	}

	public String getBillingStreet1() {
		return BillingStreet1;
	}

	public void setBillingStreet1(String BillingStreet1) {
		this.BillingStreet1 = BillingStreet1;
	}

	public String getBillingStreet2() {
		return BillingStreet2;
	}

	public void setBillingStreet2(String BillingStreet2) {
		this.BillingStreet2 = BillingStreet2;
	}

	public String getBillingCity() {
		return BillingCity;
	}

	public void setBillingCity(String BillingCity) {
		this.BillingCity = BillingCity;
	}

	public String getBillingState() {
		return BillingState;
	}

	public void setBillingState(String BillingState) {
		this.BillingState = BillingState;
	}

	public String getBillingZipcode() {
		return BillingZipcode;
	}

	public void setBillingZipcode(String BillingZipcode) {
		this.BillingZipcode = BillingZipcode;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	
	
}
