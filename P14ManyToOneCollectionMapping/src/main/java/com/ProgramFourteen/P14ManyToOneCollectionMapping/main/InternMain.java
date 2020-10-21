package com.ProgramFourteen.P14ManyToOneCollectionMapping.main;

import com.ProgramFourteen.P14ManyToOneCollectionMapping.dao.InternDao;
import com.ProgramFourteen.P14ManyToOneCollectionMapping.model.Address;

public class InternMain {

	public static void main(String[] args) {
		Address address = new Address("Mumbai", "Maharashtra", 400028);
		InternDao.addIntern(1, 23, "nitin", "M", address);
		InternDao.addIntern(2, 23, "parth", "M", address);
		InternDao.viewIntern(1);
		InternDao.viewIntern(2);
	}
}
