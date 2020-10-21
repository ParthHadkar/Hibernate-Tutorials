package com.ProgramSix.P6AnnotationInheritanceMapping.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table (name="cricketer_perhierarchyclass_annotation")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "CricketerType",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue (value = "Staff")
public class CricketerPerHierarchyClass {
	@Id
	@GeneratedValue
	@Column (name="ID",length = 20)
	private int id;
	@Column (name="Name",length = 20)
	private String name;
	@Column (name="Country",length = 20)
	private String country;
	
	public CricketerPerHierarchyClass() {}
	
	public CricketerPerHierarchyClass(int id, String name, String country) {
		this.id = id;
		this.name = name;
		this.country = country;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Cricketer [id=" + id + ", name=" + name + ", country=" + country + "]";
	}

}
