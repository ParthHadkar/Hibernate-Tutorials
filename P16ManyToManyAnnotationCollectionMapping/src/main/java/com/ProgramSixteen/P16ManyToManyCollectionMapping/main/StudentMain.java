package com.ProgramSixteen.P16ManyToManyCollectionMapping.main;

import java.util.ArrayList;
import java.util.List;

import com.ProgramSixteen.P16ManyToManyCollectionMapping.dao.StudentDao;
import com.ProgramSixteen.P16ManyToManyCollectionMapping.model.Laptop;
import com.ProgramSixteen.P16ManyToManyCollectionMapping.model.Student;

public class StudentMain {

	public static void main(String[] args) {
		
		Laptop laptop1 = new Laptop("Dell", "Gamming", 20000.0);
		Laptop laptop2 = new Laptop("Hp", "Gamming", 25000.0);
		List<Laptop> laptopList = new ArrayList<Laptop>();
		laptopList.add(laptop1);
		laptopList.add(laptop2);
		StudentDao.addStudent(1, 22, "Nitin", "M", laptopList);
		//StudentDao.viewStudent(1);
		
	}

}
