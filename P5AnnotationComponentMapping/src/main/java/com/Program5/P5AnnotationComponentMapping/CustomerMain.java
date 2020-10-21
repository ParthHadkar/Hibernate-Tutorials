package com.Program5.P5AnnotationComponentMapping;

import com.Program5.P5AnnotationComponentMapping.dao.CustomerDao;

public class CustomerMain {
	
	public static void main(String[] args) {
		int id = CustomerDao.addCustomer("parth", 1.46f, "Mumbai", "Maharashtra", 400028);
		CustomerDao.viewCustomer(id);
	}

}
