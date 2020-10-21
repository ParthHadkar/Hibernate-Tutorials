package com.ProgramSeventeen.P17OneToOneCollectionMapping.main;

import com.ProgramSeventeen.P17OneToOneCollectionMapping.dao.InternDao;
import com.ProgramSeventeen.P17OneToOneCollectionMapping.model.Address;

public class InternMain {

	public static void main(String[] args) {
		Address address = new Address("Mumbai", "Maharashtra", 400028);
		InternDao.addIntern(1, 23, "nitin", "M", address);
		//InternDao.viewIntern(1);
	}
}
