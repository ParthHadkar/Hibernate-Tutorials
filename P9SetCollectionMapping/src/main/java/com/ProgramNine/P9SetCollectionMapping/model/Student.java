package com.ProgramNine.P9SetCollectionMapping.model;

import java.util.Set;

public class Student {
	
	private int id,age;
	private String name,gender;
	private Set<String> laptop;
	
	public Student() {}

	public Student(int id, int age, String name, String gender, Set<String> laptop) {
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

	public Set<String> getLaptop() {
		return laptop;
	}

	public void setLaptop(Set<String> laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", gender=" + gender + ", laptop=" + laptop
				+ "]";
	}
	
}
