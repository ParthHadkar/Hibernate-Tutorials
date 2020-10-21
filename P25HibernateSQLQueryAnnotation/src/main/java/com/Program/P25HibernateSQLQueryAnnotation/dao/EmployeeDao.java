package com.Program.P25HibernateSQLQueryAnnotation.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Program.P25HibernateSQLQueryAnnotation.model.Employee;




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
	
	public static void viewEmployees(long sal) {
		Session session = null;
		try {
			session = DBConfiguration();
			SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM employee e WHERE e.sal<=:sal");
			sqlQuery.setParameter("sal", sal);
			sqlQuery.addEntity(Employee.class);
			List<Employee> emp = sqlQuery.list();
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
	
	public static void viewEmployeeById1(int id) {
		Session session = null;
		try {
			session = DBConfiguration();
			SQLQuery sqlQuery = session.createSQLQuery("SELECT name,sal FROM employee e WHERE e.id=:id");
			sqlQuery.setParameter("id", id);
			sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List<Object> emp = sqlQuery.list();
			Iterator<Object> iterator = emp.iterator();
			while(iterator.hasNext()) {
				Object object = (Object)iterator.next();
				Map<Object,Object> employee = (Map<Object, Object>) object;
				System.out.println("Employee Name:-"+employee.get("name")+" Employee Sal:-"+employee.get("sal"));
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

	public static void viewEmployeeById2(int id) {
		Session session = null;
		try {
			session = DBConfiguration();
			SQLQuery sqlQuery = session.createSQLQuery("SELECT name,sal FROM employee e WHERE e.id=:id");
			sqlQuery.setParameter("id", id);
			List<Object[]> emp = sqlQuery.list();
			Iterator<Object[]> iterator = emp.iterator();
			while(iterator.hasNext()) {
				Object[] employee = (Object[])iterator.next();
				System.out.println("Employee Name:-"+employee[0]+" Employee Sal:-"+employee[1]);
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
