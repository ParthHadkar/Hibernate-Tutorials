package com.Program.P18ManyToOneCollectionMapping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manytooneannotationaddress")
public class Address {
	@Id
	@GeneratedValue
	@Column(name = "ID",length = 20)
	private int id;
	@Column(name = "PINCODE",length = 20)
	private int pincode;
	@Column(name = "CITY",length = 20)
	private String city;
	@Column(name = "STATE",length = 20)
	private String state;
	
	public Address() {}

	public Address(int id,String city, String state, int pincode) {
		this.id = id;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", pincode=" + pincode + ", city=" + city + ", state=" + state + "]";
	}
	
}
