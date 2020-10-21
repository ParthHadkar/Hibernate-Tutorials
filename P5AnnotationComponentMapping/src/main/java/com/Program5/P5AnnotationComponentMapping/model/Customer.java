package com.Program5.P5AnnotationComponentMapping.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="customer_annotation")
public class Customer {
	@Id
	@GeneratedValue
	@Column (name="Id",length = 20)
	private int id;
	@Column (name="Name",length = 20)
	private String name;
	//@Transient  //To skip the column in database
	@Column (name="Height",length = 20)
	private float height;
	@Embedded
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
