package com.Program.P27HibernateObjectStatesPersistenceLifeCycle.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Program.P27HibernateObjectStatesPersistenceLifeCycle.model.Student;

public class StudentDao {
	
	public static void addStudent(int id, int age, String name, String gender, List<String> laptop) {
		Session session = null;
		SessionFactory sf = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Student student = new Student(id, age, name, gender, laptop);
			session.save(student);
			//student.setAge(66);
			tx.commit();
			session.flush();
			System.out.println("Student Added Sucessfully !!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sf.close();	//all session and cache store in session factory will be lose	
		}
	}
	
	public static void viewStudent(int id) {
		Session session = null;
		SessionFactory sf = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			Object obj = session.load(Student.class,new Integer(id));
			Student student = (Student)obj;
			System.out.println("Student Id \t\t:"+student.getId()+
            		"\nStudent Name \t\t:"+student.getName()+
            		"\nStudent Gender \t:"+student.getGender()+
            		"\nStudent Age \t:"+student.getAge());
            		/*+
            		"\nStudent Laptop \t\t:"+(student.getLaptop().toString().replace("[","")).replace("]",""));*/
			session.flush();
			/*student.setAge(76);
			session.beginTransaction();
			session.getTransaction().commit();*/
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("No data found !!!!"+e.getMessage());
		}
		finally {
			session.close();
			//sf.close();//all session and cache store in session factory will be lose	
		}
	}

}
