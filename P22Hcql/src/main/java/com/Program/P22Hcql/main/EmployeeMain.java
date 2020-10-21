package com.Program.P22Hcql.main;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.Program.P22Hcql.dao.EmployeeDao;

public class EmployeeMain {

	public static void main(String[] args) {
		//EmployeeDao.viewEmployees();
		//EmployeeDao.viewEmployeesPagination(0, 5);
		/*EmployeeDao.viewRestrictionCriteria(Restrictions.lt("esal",20000l));//less than
		EmployeeDao.viewRestrictionCriteria(Restrictions.le("esal",10000l));//less than or equal
		EmployeeDao.viewRestrictionCriteria(Restrictions.gt("esal",20000l));//greater than
		EmployeeDao.viewRestrictionCriteria(Restrictions.ge("esal",45000l));//greater than or equal
		EmployeeDao.viewRestrictionCriteria(Restrictions.ne("esal",25000l));//not equal
		EmployeeDao.viewRestrictionCriteria(Restrictions.eq("esal",25000l));//equal
		EmployeeDao.viewRestrictionCriteria(Restrictions.between("esal",20000l,30000l));//between
		EmployeeDao.viewRestrictionCriteria(Restrictions.like("ename","%a%"));//like*/
		/*EmployeeDao.viewOrderCriteria(Order.asc("esal"));//ascending order
		EmployeeDao.viewOrderCriteria(Order.desc("esal"));//descending order*/
		EmployeeDao.viewProjectionCriteriaS();
		EmployeeDao.viewProjectionCriteriaM();
	}

}
