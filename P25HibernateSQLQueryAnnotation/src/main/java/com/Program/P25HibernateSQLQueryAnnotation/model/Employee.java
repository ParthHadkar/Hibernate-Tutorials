package com.Program.P25HibernateSQLQueryAnnotation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name = "ID",length = 20)
	private int eid;
	@Column(name = "NAME",length = 20)
	private String ename;
	@Column(name = "SAL",length = 20)
	private long esal;
		
	public Employee() {}

	public Employee(int eid, String ename, long esal) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public long getEsal() {
		return esal;
	}
	public void setEsal(long esal) {
		this.esal = esal;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
	}

}
