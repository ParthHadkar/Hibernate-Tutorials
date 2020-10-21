package com.ProgramEight.P8BagCollectionMapping.model;

import java.util.List;

public class Student {
	
	private int id,age;
	private String name,gender;
	private List<String> laptop;
	
	public Student() {}

	public Student(int id, int age, String name, String gender, List<String> laptop) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.laptop = laptop;
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

	public List<String> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<String> laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", gender=" + gender + ", laptop=" + laptop
				+ "]";
	}
	
}
