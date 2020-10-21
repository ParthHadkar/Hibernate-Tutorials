package com.Program.P27HibernateObjectStatesPersistenceLifeCycle.main;

import java.util.ArrayList;
import java.util.List;

import com.Program.P27HibernateObjectStatesPersistenceLifeCycle.dao.StudentDao;

public class StudentMain {
	
	public static void main(String[] args) {
		List<String> laptop = new ArrayList<String>();
		laptop.add("Dell");
		laptop.add("Hp");
		StudentDao.addStudent(11, 23, "Nitin", "M", laptop);
		//StudentDao.viewStudent(7);
	}

}
