package com.ProgramSixteen.P16ManyToManyCollectionMapping.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="manytomanyannotationstudent")
public class Student {
	
	@Id
	@Column(name ="ID",length = 20)
	private int id;
	@Column(name ="AGE",length = 20)
	private int age;
	@Column(name ="NAME",length = 20)
	private String name;
	@Column(name ="GENDER",length = 20)
	private String gender;
	@ManyToMany(targetEntity = Laptop.class,cascade = CascadeType.ALL)
	@JoinTable(name = "manytomanyannotationstudent_laptop",
	joinColumns = {@JoinColumn(name = "SID")},
	inverseJoinColumns = {@JoinColumn(name = "LID")})
	@OrderColumn(name = "TYPE")
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
