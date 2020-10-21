package com.Program.P20LazyCollectionMappingAnnotation.main;

import java.util.ArrayList;
import java.util.List;

import com.Program.P20LazyCollectionMappingAnnotation.dao.StudentDao;

public class StudentMain {
	
	public static void main(String[] args) {
		List<String> laptop = new ArrayList<String>();
		laptop.add("Dell");
		laptop.add("Hp");
		//StudentDao.addStudent(1, 23, "Nitin", "M", laptop);
		StudentDao.viewStudent(1);
	}

}
