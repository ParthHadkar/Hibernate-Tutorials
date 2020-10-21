package com.Program5.P5AnnotationComponentMapping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Program5.P5AnnotationComponentMapping.model.Address;
import com.Program5.P5AnnotationComponentMapping.model.Customer;


public class CustomerDao {
	
	public static int addCustomer(String name,float height,String city,String state,int pincode) {
		Session session = null;
		int id = 0;
		try {
			Configuration con = new Configuration().configure(); //new AnnotationConfiguration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Address address = new Address(city,state,pincode);
			Customer customer = new Customer(name,height,address);
			id =(Integer) session.save(customer);// persist
			tx.commit();
			session.flush();
			System.out.println("Customer Added Sucessfully !!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return id;
	}
	
	public static void viewCustomer(int id) {
		Session session = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			Object obj = session.load(Customer.class, new Integer(id));
			Customer customer = (Customer) obj;
            System.out.println("Customer Id \t\t:"+customer.getId()+
            		"\nCustomer Name \t\t:"+customer.getName()+
            		"\nCustomer Height \t:"+customer.getHeight()+
            		"\nCustomer City \t\t:"+customer.getAddress().getCity()+
            		"\nCustomer State \t\t:"+customer.getAddress().getState()+
            		"\nCustomer Pincode \t:"+customer.getAddress().getPincode());
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
