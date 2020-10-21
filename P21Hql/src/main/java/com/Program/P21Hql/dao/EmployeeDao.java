package com.Program.P21Hql.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Program.P21Hql.model.Employee;


public class EmployeeDao {
	
	private static Session DBConfiguration() {
		Session session = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}
	
	public static void updateEmployee(int id,String name,long sal) {
		Session session = null;
		try {
			session = DBConfiguration();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("Update Employee SET ename=:name,esal=:sal WHERE eid=:id");
			query.setParameter("name", name);
			query.setParameter("sal", sal);
			query.setParameter("id", id);
			int status=query.executeUpdate();
			tx.commit();
			session.flush();
			System.out.println("Record Updated Sucessfully !!!! "+status);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void deleteEmployee(int id) {
		Session session = null;
		try {
			
			session = DBConfiguration();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("DELETE FROM Employee WHERE eid=:id");
			query.setParameter("id", id);
			int status=query.executeUpdate();
			tx.commit();
			session.flush();
			System.out.println("Record Deleted Sucessfully !!!! "+status);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void viewEmployees() {
		Session session = null;
		try {
			session = DBConfiguration();
			Query query = session.createQuery("FROM Employee");
			List<Employee> emp = query.list();
			Iterator<Employee> iterator = emp.iterator();
			while(iterator.hasNext()) {
				Employee employee = (Employee)iterator.next();
				System.out.println("Employee Id:-"+employee.getEid()+" Employee Name:-"+employee.getEname()
				+" Employee Sal:-"+employee.getEsal());
			}
			session.flush();
			System.out.println("Record Fetch Sucessfully !!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void viewEmployeesPagination1(int startPoint,int endPoint) {
		Session session = null;
		try {
			session = DBConfiguration();
			Query query = session.createQuery("FROM Employee");
			query.setFirstResult(startPoint);
			query.setMaxResults(endPoint);
			List<Employee> emp = query.list();
			Iterator<Employee> iterator = emp.iterator();
			while(iterator.hasNext()) {
				Employee employee = (Employee)iterator.next();
				System.out.println("Employee Id:-"+employee.getEid()+" Employee Name:-"+employee.getEname()
				+" Employee Sal:-"+employee.getEsal());
			}
			session.flush();
			System.out.println("Record Fetch Sucessfully !!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void viewEmployeesPagination2(int startPoint,int endPoint) {
		Session session = null;
		try {
			session = DBConfiguration();
			Query query = session.createQuery("SELECT eid,ename,esal FROM Employee");
			query.setFirstResult(startPoint);
			query.setMaxResults(endPoint);
			Iterator iterator = query.iterate();
			while(iterator.hasNext()) {
				Object[] employee = (Object[])iterator.next();
				System.out.println("Employee Id:-"+employee[0]+" Employee Name:-"+employee[1]
				+" Employee Sal:-"+employee[2]);
			}
			session.flush();
			System.out.println("Record Fetch Sucessfully !!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void viewEmployeesPagination3(int startPoint,int endPoint) {
		Session session = null;
		try {
			session = DBConfiguration();
			Query query = session.createQuery("SELECT eid,ename,esal FROM Employee");
			query.setFirstResult(startPoint);
			query.setMaxResults(endPoint);
			List<Object[]> emp = query.list();
			Iterator<Object[]> iterator = emp.iterator();
			while(iterator.hasNext()) {
				Object[] employee = (Object[])iterator.next();
				System.out.println("Employee Id:-"+employee[0]+" Employee Name:-"+employee[1]
				+" Employee Sal:-"+employee[2]);
			}
			session.flush();
			System.out.println("Record Fetch Sucessfully !!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void groupFunction(String selectQuery,String type) {//Aggregate Function
		Session session = null;
		try {
			session = DBConfiguration();
			Query query = session.createQuery(selectQuery);
			Object value = query.uniqueResult();
			System.out.println(type+":- "+value);
			session.flush();
			System.out.println("Record Fetch Sucessfully !!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

}
