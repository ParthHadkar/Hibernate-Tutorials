package com.SecondP.SecondProgram.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.SecondP.SecondProgram.model.BookDetails;

public class BookDao {

	public static void AddBook(int code ,String name) {
		Session session = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
            Transaction tx = session.beginTransaction();
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Calcutta");
            Calendar cal = Calendar.getInstance(timeZone);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = format.format(cal.getTime());
            BookDetails bookDetails = new BookDetails(code,name,currentDate);
            session.save(bookDetails);
            tx.commit();
            System.out.println("Book Added Successfully !!!!!");
            session.flush();
		}
		catch (Exception e) {
	         e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void ShowBook(int code) {
		Session session = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
            Object obj = session.load(BookDetails.class, new Integer(code));
            BookDetails bookDetails = (BookDetails)obj;
            System.out.println("Book Code \t\t:"+bookDetails.getCode()+"\nBook Name \t\t:"+bookDetails.getName()+"\nBook Publication \t:"+bookDetails.getPublication());
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
