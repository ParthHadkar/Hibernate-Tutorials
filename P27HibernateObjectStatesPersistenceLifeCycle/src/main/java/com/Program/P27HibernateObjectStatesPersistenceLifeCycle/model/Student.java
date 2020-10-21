package com.Program.P27HibernateObjectStatesPersistenceLifeCycle.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "studentlist")
public class Student {
	
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "AGE")
	private int age;
	@Column(name = "NAME")
	private String name;
	@Column(name = "GENDER")
	private String gender;
	/*lazy:-fetch = FetchType.LAZY by default and fetch only required columns
	        eager =fetch = FetchType.EAGER it fetch all columns  */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "laptoplist",
	joinColumns = {@JoinColumn(name="ID")})
	@OrderColumn(name ="TYPE")
	@Column(name="LAPTOP")
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
