package com.ProgramSeventeen.P17OneToOneCollectionMapping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.ProgramSeventeen.P17OneToOneCollectionMapping.model.Address;
import com.ProgramSeventeen.P17OneToOneCollectionMapping.model.Intern;

public class InternDao {
	
	public static void addIntern(int id, int age, String name, String gender, Address address) {
		Session session = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Intern intern = new Intern(id, age, name, gender, address);
			address.setIntern(intern);
			session.save(intern);
			//session.save(address);
			tx.commit();
			session.flush();
			System.out.println("Intern Added Sucessfully!!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void viewIntern(int id) {
		Session session = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			Object obj = session.load(Intern.class, new Integer(id));
			Intern intern = (Intern)obj;
			System.out.println("Intern Id \t\t:"+intern.getId()+
            		"\nIntern Name \t\t:"+intern.getName()+
            		"\nIntern Gender \t:"+intern.getGender()+
            		"\nIntern Age \t:"+intern.getAge()+
            		"\nIntern Address \t\t:"+(intern.getAddress()));
			session.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("No data found !!!!"+e.getMessage());
		}
		finally {
			session.close();
		}
	}
}
