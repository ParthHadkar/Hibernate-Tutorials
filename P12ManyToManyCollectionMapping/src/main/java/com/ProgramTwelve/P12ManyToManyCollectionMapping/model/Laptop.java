package com.ProgramTwelve.P12ManyToManyCollectionMapping.model;

import java.util.List;

public class Laptop {
	
	private int id;
	private String name,type;
	private double price;
	private List<Student> studentList;
	
	public Laptop() {}

	public Laptop(int id, String name, String type, double price) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	public Laptop(int id, String name, String type, double price, List<Student> studentList) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.studentList = studentList;
	}

	public Laptop(String name, String type, double price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	public Laptop(String name, String type, double price, List<Student> studentList) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.studentList = studentList;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", studentList="
				+ studentList + "]";
	}
	
}
