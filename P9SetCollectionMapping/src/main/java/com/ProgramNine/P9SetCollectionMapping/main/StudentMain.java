package com.ProgramNine.P9SetCollectionMapping.main;

import java.util.HashSet;
import java.util.Set;

import com.ProgramNine.P9SetCollectionMapping.dao.StudentDao;

public class StudentMain {
	
	public static void main(String[] args) {
		Set<String> laptop = new HashSet<String>();
		laptop.add("Dell");
		laptop.add("Hp");
		StudentDao.addStudent(1, 23, "Nitin", "M", laptop);
		StudentDao.viewStudent(1);
	}

}
