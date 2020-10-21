package com.Program.P23HibernateNamedQuery.model;

public class Employee {
	private int eid;
	private String ename;
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
