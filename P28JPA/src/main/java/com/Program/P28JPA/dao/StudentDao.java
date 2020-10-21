package com.Program.P28JPA.dao;

//https://www.baeldung.com/jpa-hibernate-projections
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transaction;

import com.Program.P28JPA.model.Student;


public class StudentDao {
	
	private static EntityManagerFactory mf = null;
	private static EntityManager manager = null;
	
	private static EntityManager DBConfiguration() {
		try {
			if(mf == null) {
		    System.out.println("mf "+mf);	
			mf = Persistence.createEntityManagerFactory("unit1");
			}
			manager = mf.createEntityManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return manager;
	}
	
public static void addStudent(int id, int age, String name, String gender, List<String> laptop) {
		
		try {
			if((manager == null) || !(manager.isOpen())) {
				System.out.println("manager "+manager);
				manager =DBConfiguration();
			}
			
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			Student student = new Student(id, age, name, gender, laptop);
			manager.persist(student);
			tx.commit();
			//manager.flush();
			System.out.println("Student Added Sucessfully !!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("No data found !!!!"+e.getMessage());
		}
		
	}
	
	public static void viewStudent(int id) {
		
		try {
			if((manager == null) || !(manager.isOpen())) {
				System.out.println("manager "+manager);
				manager =DBConfiguration();
			}
			Object obj = manager.find(Student.class,new Integer(id));
			Student student = (Student)obj;
			System.out.println("Student Id \t\t:"+student.getId()+
            		"\nStudent Name \t\t:"+student.getName()+
            		"\nStudent Gender \t:"+student.getGender()+
            		"\nStudent Age \t:"+student.getAge());
            		/*+
            		"\nStudent Laptop \t\t:"+(student.getLaptop().toString().replace("[","")).replace("]",""));*/
			//manager.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("No data found !!!!"+e.getMessage());
		}
		
	}
public static void viewStudentUsingHqlQuery(int id) {
		
		try {
			if((manager == null) || !(manager.isOpen())) {
				System.out.println("manager "+manager);
				manager =DBConfiguration();
			}
			Query query = manager.createQuery("FROM Student s WHERE s.id=:id");
			query.setParameter("id", id);
			Student student = (Student)query.getSingleResult();
			System.out.println("Student Id \t\t:"+student.getId()+
            		"\nStudent Name \t\t:"+student.getName()+
            		"\nStudent Gender \t:"+student.getGender()+
            		"\nStudent Age \t:"+student.getAge());
            		/*+
            		"\nStudent Laptop \t\t:"+(student.getLaptop().toString().replace("[","")).replace("]",""));*/
			//manager.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("No data found !!!!"+e.getMessage());
		}
		
	}
   
public static void viewStudentUsingHcqlQueryS() {
	try {
		if((manager == null) || !(manager.isOpen())) {
			System.out.println("manager "+manager);
			manager =DBConfiguration();
		}
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = builder.createQuery(Object.class);
		Root<Student> student = criteriaQuery.from(Student.class);
		criteriaQuery.select(student.get("age"));
		Query query = manager.createQuery(criteriaQuery);
		List<Integer> emp = query.getResultList();
		Iterator<Integer> iterator = emp.iterator();
		while(iterator.hasNext()) {
			Integer s =  iterator.next();
			System.out.println(" Student Age:-"+s);
		}
		//manager.flush();
		System.out.println("Record Fetch Sucessfully !!!!");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}

public static void viewStudentUsingHcqlQueryM() {
	try {
		if((manager == null) || !(manager.isOpen())) {
			System.out.println("manager "+manager);
			manager =DBConfiguration();
		}
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		Root<Student> student = criteriaQuery.from(Student.class);
		criteriaQuery.multiselect(student.get("id"),student.get("name"));
		//criteriaQuery.multiselect(student.get("Name"), builder.count(Id));
		//criteriaQuery.groupBy(student.get("Name"));
		Query query = manager.createQuery(criteriaQuery);
		List<Object[]> emp = query.getResultList();
		Iterator<Object[]> iterator = emp.iterator();
		while(iterator.hasNext()) {
			Object[] employee =  (Object[])iterator.next();
			System.out.println("Student Id:-"+employee[0]+" Student Name:-"+employee[1]);
		}
		//manager.flush();
		System.out.println("Record Fetch Sucessfully !!!!");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}

public static void viewStudentUsingSqlQuery(int id) {
	
	try {
		if((manager == null) || !(manager.isOpen())) {
			System.out.println("manager "+manager);
			manager =DBConfiguration();
		}
		Query query = manager.createNativeQuery("SELECT * FROM studentlist s WHERE s.ID=:id",Student.class);
		query.setParameter("id", id);
		List<Student> emp = query.getResultList();
		Iterator<Student> iterator = emp.iterator();
		while(iterator.hasNext()) {
			Student student =  (Student)iterator.next();
		System.out.println("Student Id \t\t:"+student.getId()+
        		"\nStudent Name \t\t:"+student.getName()+
        		"\nStudent Gender \t:"+student.getGender()+
        		"\nStudent Age \t:"+student.getAge());
        		/*+
        		"\nStudent Laptop \t\t:"+(student.getLaptop().toString().replace("[","")).replace("]",""));*/
		}
		//manager.flush();
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println("No data found !!!!"+e.getMessage());
	}
	
}
	public static void closeSession() {
		if(manager != null) {
			manager.close();
			//mf.close();
			}
	}

}
