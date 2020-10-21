package com.Program.P18ManyToOneCollectionMapping.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "manytooneannotationintern")
public class Intern {
	@Id
	@Column(name = "ID",length = 20)
	private int id;
	@Column(name = "AGE",length = 20)
	private int age;
	@Column(name = "NAME",length = 20)
	private String name;
	@Column(name = "GENDER",length = 20)
	private String gender;
	@ManyToOne(targetEntity = Address.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "AID")
	private Address address;
	
	public Intern() {}

	public Intern(int id, int age, String name, String gender, Address address) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Intern [id=" + id + ", age=" + age + ", name=" + name + ", gender=" + gender + ", address=" + address
				+ "]";
	}
	
}
