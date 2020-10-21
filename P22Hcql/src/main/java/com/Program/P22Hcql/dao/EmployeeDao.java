package com.Program.P22Hcql.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Program.P22Hcql.model.Employee;


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
	
	public static void viewEmployees() {
		Session session = null;
		try {
			session = DBConfiguration();
			Criteria criteria = session.createCriteria(Employee.class);
			List<Employee> emp = criteria.list();
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
	
	public static void viewEmployeesPagination(int startPoint,int endPoint) {
		Session session = null;
		try {
			session = DBConfiguration();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.setFirstResult(startPoint);
			criteria.setMaxResults(endPoint);
			List<Employee> emp = criteria.list();
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
	public static void viewRestrictionCriteria(Criterion criterion) {
		Session session = null;
		try {
			session = DBConfiguration();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(criterion);
			List<Employee> emp = criteria.list();
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
	
	public static void viewOrderCriteria(Order order) {
		Session session = null;
		try {
			session = DBConfiguration();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.addOrder(order);
			List<Employee> emp = criteria.list();
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
	
	public static void viewProjectionCriteriaS() {
		Session session = null;
		try {
			session = DBConfiguration();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.setProjection(Projections.property("esal"));//single projection
			/*criteria.setProjection(Projections.projectionList()
		             .add(Projections.groupProperty("esal"))
		             .add(Projections.alias(Projections.rowCount(), "count")));
		criteria.addOrder(Order.asc("esal"));*/
			List<Long> emp = criteria.list();
			Iterator<Long> iterator = emp.iterator();
			while(iterator.hasNext()) {
				Long employee =  iterator.next();
				System.out.println(" Employee Sal:-"+employee);
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
	
	public static void viewProjectionCriteriaM() {
		Session session = null;
		try {
			session = DBConfiguration();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.setProjection(Projections.projectionList()//multiple projection
					    .add(Projections.id())
					    .add(Projections.property("ename")));
			List<Object[]> emp = criteria.list();
			Iterator<Object[]> iterator = emp.iterator();
			while(iterator.hasNext()) {
				Object[] employee =  (Object[])iterator.next();
				System.out.println("Employee Id:-"+employee[0]+" Employee Name:-"+employee[1]);
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

}
