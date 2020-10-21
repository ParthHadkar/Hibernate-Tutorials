package com.Program5.P5AnnotationComponentMapping.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column (name="Pincode",length = 20)
	private int pincode;
	@Column (name="City",length = 20)
	private String city;
	@Column (name="State",length = 20)
	private String state;
	
	public Address() {}

	public Address(String city, String state, int pincode) {
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
}
