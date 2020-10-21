package com.ProgramFifteen.P15AnnotationOneToManyCollectionMapping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "onetomanyannotationlaptop")
public class Laptop {
	
	@Id
	@Column(name="ID",length = 20)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="NAMW",length = 20)
	private String name;
	@Column(name="TYPE",length = 20)
	private String type;
	@Column(name="PRICE",length = 20)
	private double price;
	
	public Laptop() {}

	public Laptop(int id, String name, String type, double price) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	public Laptop(String name, String type, double price) {
		this.name = name;
		this.type = type;
		this.price = price;
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

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}
	
}
