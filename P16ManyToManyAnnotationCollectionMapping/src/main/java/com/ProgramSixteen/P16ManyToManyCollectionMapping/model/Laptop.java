package com.ProgramSixteen.P16ManyToManyCollectionMapping.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="manytomanyannotationlaptop")
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID",length = 20)
	private int id;
	@Column(name ="NAME",length = 20)
	private String name;
	@Column(name ="TYPE",length = 20)
	private String type;
	@Column(name ="PRICE",length = 20)
	private double price;
	@ManyToMany(mappedBy = "laptopList")
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
