package com.FirstP.FirstProgram.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.FirstP.FirstProgram.model.Employee;

public class EmployeeDao {
	
	/*
	 * To create  Session and as it is interface we have to create SessionFactory and as it is also interface we have to create 
	 * ServiceRegistry and as it is also interface we have to create and object of ServiceRegistryBuilder() and in it applySettings we have to pass 
	 * Configuration object getProperties method before that we have to create Configuration object.
	 * */
	
	public static void AddEmployee(int id,String name,long sal) {
		Session session = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);//reg
			//Session is used to perform operation.
			session = sf.openSession();
			//Transaction is used to save the operation
			Transaction tx = session.beginTransaction();
			/*
			  Employee employeee = new Employee(); 
			  employeee.setEid(id);
			  employeee.setEname(name); 
			  employeee.setEsal(sal); 
			  session.save(employeee);
			 */
			Employee employee = new Employee(id, name, sal);
			session.save(employee);//session.persist(employee);
			tx.commit();
			session.flush();
			System.out.println("Record Inserted Sucessfully !!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void UpdateEmployee(int id,String name,long sal) {
		Session session = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			Transaction tx = session.beginTransaction();
				Object obj = session.load(Employee.class, new Integer(id));//session.get(Employee.class, new Integer(id))
					//Employee employee = new Employee(id,name,sal);
					Employee employee = (Employee) obj;
					employee.setEname(name);
					employee.setEsal(sal);
					session.update(employee);
					tx.commit();
					System.out.println("Record Updated Sucessfully !!!!");
					session.flush();	
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println("No data found !!!!"+e.getMessage());
		}
		finally {
			session.close();
		}
		
	}
	
	public static void DeleteEmployee(int id) {
		Session session = null;
		try {			
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			Transaction tx = session.beginTransaction();
			/*Employee employee = new Employee();
			employee.setEid(id);
			session.delete(employee);*/
			Object obj = session.load(Employee.class, new Integer(id));//session.get(Employee.class, new Integer(id))
			session.delete(obj);
			tx.commit();
			System.out.println("Record Deleted Successfully !!!!");
			 session.flush();
		}
		catch (Exception e) {
			//e.printStackTrace();
			System.out.println("No data found !!!!"+e.getMessage());
		}
		finally {
			session.close();
		}
	}
	
	

}
