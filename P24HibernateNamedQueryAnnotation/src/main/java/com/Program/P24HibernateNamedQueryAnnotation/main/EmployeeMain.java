package com.Program.P24HibernateNamedQueryAnnotation.main;



import com.Program.P24HibernateNamedQueryAnnotation.dao.EmployeeDao;


public class EmployeeMain {

	public static void main(String[] args) {
		EmployeeDao.viewEmployees(20000);
	}

}
