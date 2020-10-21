package com.ThirdProgram.ComponentMapping.model;

public class Customer {
	private int id;
	private String name;
	private float height;
	private Address address;
	
	public Customer() {}

	public Customer(String name, float height, Address address) {
		this.name = name;
		this.height = height;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", height=" + height + ", address=" + address + "]";
	}
	

}
