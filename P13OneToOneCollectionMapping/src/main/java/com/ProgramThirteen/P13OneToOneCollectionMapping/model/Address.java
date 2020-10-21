package com.ProgramThirteen.P13OneToOneCollectionMapping.model;

public class Address {
	private int id,pincode;
	private String city,state;
	private Intern intern;
	
	public Address() {}

	public Address(int id,String city, String state, int pincode) {
		this.id = id;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public Address(String city, String state, int pincode) {
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Intern getIntern() {
		return intern;
	}

	public void setIntern(Intern intern) {
		this.intern = intern;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", pincode=" + pincode + ", city=" + city + ", state=" + state + "]";
	}
	
}
