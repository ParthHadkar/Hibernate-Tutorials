package com.ProgramSix.P6AnnotationInheritanceMapping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.ProgramSix.P6AnnotationInheritanceMapping.model.BatsmanPerHierarchyClass;
import com.ProgramSix.P6AnnotationInheritanceMapping.model.BowlerPerHierarchyClass;
import com.ProgramSix.P6AnnotationInheritanceMapping.model.CricketerPerHierarchyClass;



public class CricketerPerHierarchyClassDao {
	
	private static int addDB(CricketerPerHierarchyClass cricketer) {
		Session session = null;
		int lid = 0;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			Transaction tx = session.beginTransaction();
			lid = (Integer)session.save(cricketer);
			tx.commit();
			session.flush();
			System.out.println("Cricker Added Sucessfully !!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return lid;
	}
	
	public static int addStaff(int id,String name,String country) {
		CricketerPerHierarchyClass cricketer = new CricketerPerHierarchyClass(id, name, country);
		return addDB(cricketer);
	}
	
	public static int addBatsman(int id,String name,String country,String battingHand,String bestScore) {
		CricketerPerHierarchyClass cricketer = new BatsmanPerHierarchyClass(id, name, country, battingHand, bestScore);
		return addDB(cricketer);
	}
	
	public static int addBowler(int id,String name,String country,String bowlerHand,String bestFigure) {
		CricketerPerHierarchyClass cricketer = new BowlerPerHierarchyClass(id, name, country, bowlerHand, bestFigure);
		return addDB(cricketer);
	}
	
	public static void viewCricketer(int id,String cType) {
		Session session = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			
			Object obj = null;
			if(cType.equalsIgnoreCase("Batsman")) {
				obj = session.load(BatsmanPerHierarchyClass.class, new Integer(id));
				BatsmanPerHierarchyClass cricketer1 = (BatsmanPerHierarchyClass) obj;
				System.out.println("Cricketer Id \t\t:"+cricketer1.getId()+
	            		"\nCricketer Name \t\t:"+cricketer1.getName()+
	            		"\nCricketer Country \t\t:"+cricketer1.getCountry()+
	            		"\nCricketer BattingHand \t\t:"+cricketer1.getBattingHand()+
	            		"\nCricketer BestScore \t\t:"+cricketer1.getBestScore());
			}
			else if(cType.equalsIgnoreCase("Bowler")) {
				obj = session.load(BowlerPerHierarchyClass.class, new Integer(id));
				BowlerPerHierarchyClass cricketer2 = (BowlerPerHierarchyClass) obj;
				System.out.println("Cricketer Id \t\t:"+cricketer2.getId()+
	            		"\nCricketer Name \t\t:"+cricketer2.getName()+
	            		"\nCricketer Country \t\t:"+cricketer2.getCountry()+
	            		"\nCricketer BowlerHand \t\t:"+cricketer2.getBowlerHand()+
	            		"\nCricketer BestFigure \t\t:"+cricketer2.getBestFigure());
			}
			else if(cType.equalsIgnoreCase("Staff")) {
				obj = session.load(CricketerPerHierarchyClass.class, new Integer(id));
				CricketerPerHierarchyClass cricketer = (CricketerPerHierarchyClass) obj;
				System.out.println("Staff Id \t\t:"+cricketer.getId()+
	            		"\nStaff Name \t\t:"+cricketer.getName()+
	            		"\nStaff Country \t\t:"+cricketer.getCountry());
			}
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
