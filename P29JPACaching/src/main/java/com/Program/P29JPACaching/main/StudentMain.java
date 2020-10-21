package com.Program.P29JPACaching.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Program.P29JPACaching.dao.StudentDao;
import com.Program.P29JPACaching.model.Student;

public class StudentMain {
	
	public static void main(String[] args) {
		//First Level Caching
		/*StudentDao.viewStudent(1);
		StudentDao.viewStudent(1);
		StudentDao.closeSession();*/
		//Second Level Caching
		/*StudentDao.viewStudent(1);
		StudentDao.closeSession();
		StudentDao.viewStudent(1);
		StudentDao.closeSession();*/
		//Second Level Caching using Query
		/*StudentDao.viewStudentUsingHqlQuery(1);
		StudentDao.closeSession();
		StudentDao.viewStudentUsingHqlQuery(1);
		StudentDao.closeSession();*/
		/*StudentDao.viewStudentUsingHcqlQueryS();
		StudentDao.closeSession();
		StudentDao.viewStudentUsingHcqlQueryM();
		StudentDao.closeSession();*/
		StudentDao.viewStudentUsingSqlQuery(1);
		StudentDao.closeSession();
		StudentDao.viewStudentUsingSqlQuery(1);
		StudentDao.closeSession();
		/*List<String> laptop = new ArrayList<String>();
		laptop.add("Dell");
		laptop.add("Hp");
		StudentDao.addStudent(13, 23, "Nitin", "M", laptop);*/

	}

}
