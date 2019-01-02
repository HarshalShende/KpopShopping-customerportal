package com.shopping.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Shipping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String shippingName;
	private String shippingStreet1;
	private String shippingStreet2;
	private String shippingCity;
	private String shippingState;
	private String shippingCountry;
	private String shippingZipcode;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getshippingName() {
		return shippingName;
	}

	public void setshippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getshippingStreet1() {
		return shippingStreet1;
	}

	public void setshippingStreet1(String shippingStreet1) {
		this.shippingStreet1 = shippingStreet1;
	}

	public String getshippingStreet2() {
		return shippingStreet2;
	}

	public void setshippingStreet2(String shippingStreet2) {
		this.shippingStreet2 = shippingStreet2;
	}

	public String getshippingCity() {
		return shippingCity;
	}

	public void setshippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getshippingState() {
		return shippingState;
	}

	public void setshippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getshippingCountry() {
		return shippingCountry;
	}

	public void setshippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getshippingZipcode() {
		return shippingZipcode;
	}

	public void setshippingZipcode(String shippingZipcode) {
		this.shippingZipcode = shippingZipcode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
