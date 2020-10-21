package com.ProgramTen.P10MapCollectionMapping.main;

import java.util.HashMap;
import java.util.Map;
import com.ProgramTen.P10MapCollectionMapping.dao.StudentDao;

public class StudentMain {
	
	public static void main(String[] args) {
		Map<String,String> laptop = new HashMap<String,String>();
		laptop.put("Gaming","Dell");
		laptop.put("Home","Hp");
		StudentDao.addStudent(1, 23, "Nitin", "M", laptop);
		StudentDao.viewStudent(1);
	}

}
