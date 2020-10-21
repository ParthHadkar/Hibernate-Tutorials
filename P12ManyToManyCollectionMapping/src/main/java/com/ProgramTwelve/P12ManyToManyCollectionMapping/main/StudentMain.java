package com.ProgramTwelve.P12ManyToManyCollectionMapping.main;

import java.util.ArrayList;
import java.util.List;

import com.ProgramTwelve.P12ManyToManyCollectionMapping.dao.StudentDao;
import com.ProgramTwelve.P12ManyToManyCollectionMapping.model.Laptop;
import com.ProgramTwelve.P12ManyToManyCollectionMapping.model.Student;

public class StudentMain {

	public static void main(String[] args) {
		
		Laptop laptop1 = new Laptop("Dell", "Gamming", 20000.0);
		Laptop laptop2 = new Laptop("Hp", "Gamming", 25000.0);
		List<Laptop> laptopList = new ArrayList<Laptop>();
		laptopList.add(laptop1);
		laptopList.add(laptop2);
		StudentDao.addStudent(1, 22, "Nitin", "M", laptopList);
		StudentDao.viewStudent(1);
		
	}

}
