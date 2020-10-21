package com.ProgramFifteen.P15AnnotationOneToManyCollectionMapping.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.ProgramFifteen.P15AnnotationOneToManyCollectionMapping.model.Laptop;
import com.ProgramFifteen.P15AnnotationOneToManyCollectionMapping.model.Student;

public class StudentDao {
	
	public static void addStudent(int id, int age, String name, String gender, List<Laptop> laptopList) {
		Session session = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Student student = new Student(id, age, name, gender, laptopList);
			session.save(student);
			/*for(Laptop laptop : laptopList) {//if cascade all is not used
				session.save(laptop);
			}*/
			tx.commit();
			session.flush();
			System.out.println("Student Added Sucessfully !!!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void viewStudent(int id) {
		Session session = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			Object obj = session.load(Student.class, new Integer(id));
			Student student = (Student)obj;
			System.out.println("Student Id \t\t:"+student.getId()+
            		"\nStudent Name \t\t:"+student.getName()+
            		"\nStudent Gender \t:"+student.getGender()+
            		"\nStudent Age \t:"+student.getAge()+
            		"\nStudent Laptop \t\t:"+(student.getLaptopList().toString().replace("[","")).replace("]",""));
			session.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("No data found !!!!"+e.getMessage());
		}
		finally {
			session.close();
		}
	}
}
