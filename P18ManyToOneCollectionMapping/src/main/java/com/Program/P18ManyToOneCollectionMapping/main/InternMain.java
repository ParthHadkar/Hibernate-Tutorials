package com.Program.P18ManyToOneCollectionMapping.main;

import com.Program.P18ManyToOneCollectionMapping.dao.InternDao;
import com.Program.P18ManyToOneCollectionMapping.model.Address;

public class InternMain {

	public static void main(String[] args) {
		Address address = new Address("Mumbai", "Maharashtra", 400028);
		InternDao.addIntern(1, 23, "nitin", "M", address);
		InternDao.addIntern(2, 23, "parth", "M", address);
		InternDao.viewIntern(1);
		InternDao.viewIntern(2);
	}
}
