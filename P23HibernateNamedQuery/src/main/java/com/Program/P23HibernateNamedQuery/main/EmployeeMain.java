package com.Program.P23HibernateNamedQuery.main;



import com.Program.P23HibernateNamedQuery.dao.EmployeeDao;


public class EmployeeMain {

	public static void main(String[] args) {
		EmployeeDao.viewEmployees(20000);
	}

}
