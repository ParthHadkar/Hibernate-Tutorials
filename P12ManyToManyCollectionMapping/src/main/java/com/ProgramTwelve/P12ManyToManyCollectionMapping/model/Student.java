package com.ProgramTwelve.P12ManyToManyCollectionMapping.model;

import java.util.List;

public class Student {
	
	private int id,age;
	private String name,gender;
	private List<Laptop> laptopList;
	
	public Student() {}

	public Student(int id, int age, String name, String gender, List<Laptop> laptopList) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.laptopList = laptopList;
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

	public List<Laptop> getLaptopList() {
		return laptopList;
	}

	public void setLaptopList(List<Laptop> laptopList) {
		this.laptopList = laptopList;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", gender=" + gender + ", laptopList="
				+ laptopList + "]";
	}
	
}
