package com.Program.P28JPA.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Program.P28JPA.dao.StudentDao;
import com.Program.P28JPA.model.Student;

public class StudentMain {
	
	public static void main(String[] args) {
		//First 
		/*StudentDao.viewStudent(1);
		StudentDao.viewStudent(1);
		StudentDao.closeSession();*/
		//Second 
		StudentDao.viewStudent(1);
		StudentDao.closeSession();
		StudentDao.viewStudent(1);
		StudentDao.closeSession();
		//Second using Query
		/*StudentDao.viewStudentUsingHqlQuery(1);
		StudentDao.closeSession();
		StudentDao.viewStudentUsingHqlQuery(1);
		StudentDao.closeSession();*/
		/*StudentDao.viewStudentUsingHcqlQueryS();
		StudentDao.closeSession();
		StudentDao.viewStudentUsingHcqlQueryM();
		StudentDao.closeSession();*/
		/*StudentDao.viewStudentUsingSqlQuery(1);
		StudentDao.closeSession();
		StudentDao.viewStudentUsingSqlQuery(1);
		StudentDao.closeSession();*/
		/*List<String> laptop = new ArrayList<String>();
		laptop.add("Dell");
		laptop.add("Hp");
		StudentDao.addStudent(12, 23, "Nitin", "M", laptop);*/

	}

}
