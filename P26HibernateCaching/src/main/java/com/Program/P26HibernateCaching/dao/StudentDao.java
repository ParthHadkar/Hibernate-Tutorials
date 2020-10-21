package com.Program.P26HibernateCaching.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Program.P26HibernateCaching.model.Student;

import net.sf.ehcache.CacheManager;

public class StudentDao {
	
	private static SessionFactory sf = null;
	private static Session session = null;
	
	private static Session DBConfiguration() {
		try {
			if(sf == null) {
		    System.out.println("sf "+sf);	
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			sf = con.buildSessionFactory(reg);
			}
			session = sf.openSession();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}	
	
	public static void viewStudent(int id) {
		
		try {
			if((session == null) || !(session.isOpen())) {
				System.out.println("session "+session);
			session =DBConfiguration();
			}
			Object obj = session.load(Student.class,new Integer(id));
			Student student = (Student)obj;
			System.out.println("Student Id \t\t:"+student.getId()+
            		"\nStudent Name \t\t:"+student.getName()+
            		"\nStudent Gender \t:"+student.getGender()+
            		"\nStudent Age \t:"+student.getAge());
            		/*+
            		"\nStudent Laptop \t\t:"+(student.getLaptop().toString().replace("[","")).replace("]",""));*/
			session.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("No data found !!!!"+e.getMessage());
		}
		
	}
public static void viewStudentUsingHqlQuery(int id) {
		
		try {
			if((session == null) || !(session.isOpen())) {
				System.out.println("session "+session);
			session =DBConfiguration();
			}
			Query query = session.createQuery("FROM Student s WHERE s.id=:id");
			query.setParameter("id", id);
			query.setCacheable(true);
			Student student = (Student)query.uniqueResult();
			System.out.println("Student Id \t\t:"+student.getId()+
            		"\nStudent Name \t\t:"+student.getName()+
            		"\nStudent Gender \t:"+student.getGender()+
            		"\nStudent Age \t:"+student.getAge());
            		/*+
            		"\nStudent Laptop \t\t:"+(student.getLaptop().toString().replace("[","")).replace("]",""));*/
			session.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("No data found !!!!"+e.getMessage());
		}
		
	}
   
public static void viewStudentUsingHcqlQuery(String val) {
	
	try {
		if((session == null) || !(session.isOpen())) {
			System.out.println("session "+session);
		session =DBConfiguration();
		}
		Criteria query = session.createCriteria(Student.class);
		query.setProjection(Projections.property(val));
		query.addOrder(Order.asc(val));
		query.setCacheable(true);
		List<String> list = query.list();
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String student = (String)iterator.next();
		System.out.println("Student \t\t:"+student);
		}
        		/*+
        		"\nStudent Laptop \t\t:"+(student.getLaptop().toString().replace("[","")).replace("]",""));*/
		session.flush();
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println("No data found !!!!"+e.getMessage());
	}
	
}

public static void viewStudentUsingSqlQuery(int id) {
	
	try {
		if((session == null) || !(session.isOpen())) {
			System.out.println("session "+session);
		session =DBConfiguration();
		}
		SQLQuery query = session.createSQLQuery("SELECT * FROM studentlist s WHERE s.ID=:id");
		query.addEntity(Student.class);
		query.setParameter("id", id);
		query.setCacheable(true);
		Student student = (Student)query.uniqueResult();
		System.out.println("Student Id \t\t:"+student.getId()+
        		"\nStudent Name \t\t:"+student.getName()+
        		"\nStudent Gender \t:"+student.getGender()+
        		"\nStudent Age \t:"+student.getAge());
        		/*+
        		"\nStudent Laptop \t\t:"+(student.getLaptop().toString().replace("[","")).replace("]",""));*/
		session.flush();
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println("No data found !!!!"+e.getMessage());
	}
	
}
	public static void closeSession() {
		if(session != null) {
			session.close();
			//sf.close();
			}
	}

}
