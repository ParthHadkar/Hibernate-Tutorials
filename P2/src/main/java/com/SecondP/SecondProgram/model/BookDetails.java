package com.SecondP.SecondProgram.model;

public class BookDetails {

	private int code;
	private String name,publication;
	
	public BookDetails() {}
	
	public BookDetails(int code, String name, String publication) {
		this.code = code;
		this.name = name;
		this.publication = publication;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	@Override
	public String toString() {
		return "BookDetails [code=" + code + ", name=" + name + ", publication=" + publication + "]";
	}
	
}
