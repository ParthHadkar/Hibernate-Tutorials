package com.ProgramThirteen.P13OneToOneCollectionMapping.main;

import com.ProgramThirteen.P13OneToOneCollectionMapping.dao.InternDao;
import com.ProgramThirteen.P13OneToOneCollectionMapping.model.Address;

public class InternMain {

	public static void main(String[] args) {
		Address address = new Address("Mumbai", "Maharashtra", 400028);
		InternDao.addIntern(1, 23, "nitin", "M", address);
		InternDao.viewIntern(1);
	}
}
