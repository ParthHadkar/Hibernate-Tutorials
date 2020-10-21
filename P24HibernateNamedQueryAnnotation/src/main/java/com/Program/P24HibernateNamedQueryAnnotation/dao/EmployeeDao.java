package com.Program.P24HibernateNamedQueryAnnotation.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Program.P24HibernateNamedQueryAnnotation.model.Employee;




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
			Query typedQuery = session.getNamedQuery("FindEmpBySal");
			//TypedQuery typedQuery2 = session.getNamedQuery("FindEmpBySal");
			typedQuery.setParameter("sal", sal);
			List<Employee> emp = typedQuery.list();
			//List<Employee> emp = typedQuery.getResultList();
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

}
