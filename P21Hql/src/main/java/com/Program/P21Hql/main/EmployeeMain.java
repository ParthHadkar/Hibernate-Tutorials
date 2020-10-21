package com.Program.P21Hql.main;

import com.Program.P21Hql.dao.EmployeeDao;

public class EmployeeMain {

	public static void main(String[] args) {
		//EmployeeDao.viewEmployees();
		//EmployeeDao.updateEmployee(7, "Sachin", 60000);
		//EmployeeDao.deleteEmployee(8); 
		/*EmployeeDao.groupFunction("select sum(esal) from Employee", "sum(salary)");
		EmployeeDao.groupFunction("select max(esal) from Employee", "max(salary)");
		EmployeeDao.groupFunction("select min(esal) from Employee", "min(salary)");
		EmployeeDao.groupFunction("select count(esal) from Employee", "count(salary)");
		EmployeeDao.groupFunction("select avg(esal) from Employee", "avg(salary)");*/
		//EmployeeDao.viewEmployeesPagination1(0, 5);
		//EmployeeDao.viewEmployeesPagination2(0, 5);
		EmployeeDao.viewEmployeesPagination3(0, 5);
	}

}
