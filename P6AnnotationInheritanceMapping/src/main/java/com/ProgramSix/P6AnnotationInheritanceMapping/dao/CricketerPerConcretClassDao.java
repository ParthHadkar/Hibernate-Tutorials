package com.ProgramSix.P6AnnotationInheritanceMapping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.ProgramSix.P6AnnotationInheritanceMapping.model.BatsmanPerConcretClass;
import com.ProgramSix.P6AnnotationInheritanceMapping.model.BowlerPerConcretClass;
import com.ProgramSix.P6AnnotationInheritanceMapping.model.CricketerPerConcretClass;




public class CricketerPerConcretClassDao {
	
	private static int addDB(CricketerPerConcretClass cricketer) {
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
		CricketerPerConcretClass cricketer = new CricketerPerConcretClass(id, name, country);
		return addDB(cricketer);
	}
	
	public static int addStaff(String name,String country) {
		CricketerPerConcretClass cricketer = new CricketerPerConcretClass(name, country);
		return addDB(cricketer);
	}
	
	public static int addBatsman(int id,String name,String country,String battingHand,String bestScore) {
		CricketerPerConcretClass cricketer = new BatsmanPerConcretClass(id, name, country, battingHand, bestScore);
		return addDB(cricketer);
	}
	
	public static int addBatsman(String name,String country,String battingHand,String bestScore) {
		CricketerPerConcretClass cricketer = new BatsmanPerConcretClass(name, country, battingHand, bestScore);
		return addDB(cricketer);
	}
	
	public static int addBowler(int id,String name,String country,String bowlerHand,String bestFigure) {
		CricketerPerConcretClass cricketer = new BowlerPerConcretClass(id, name, country, bowlerHand, bestFigure);
		return addDB(cricketer);
	}
	
	public static int addBowler(String name,String country,String bowlerHand,String bestFigure) {
		CricketerPerConcretClass cricketer = new BowlerPerConcretClass(name, country, bowlerHand, bestFigure);
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
				obj = session.load(BatsmanPerConcretClass.class, new Integer(id));
				BatsmanPerConcretClass cricketer1 = (BatsmanPerConcretClass) obj;
				System.out.println("Cricketer Id \t\t:"+cricketer1.getId()+
	            		"\nCricketer Name \t\t:"+cricketer1.getName()+
	            		"\nCricketer Country \t\t:"+cricketer1.getCountry()+
	            		"\nCricketer BattingHand \t\t:"+cricketer1.getBattingHand()+
	            		"\nCricketer BestScore \t\t:"+cricketer1.getBestScore());
			}
			else if(cType.equalsIgnoreCase("Bowler")) {
				obj = session.load(BowlerPerConcretClass.class, new Integer(id));
				BowlerPerConcretClass cricketer2 = (BowlerPerConcretClass) obj;
				System.out.println("Cricketer Id \t\t:"+cricketer2.getId()+
	            		"\nCricketer Name \t\t:"+cricketer2.getName()+
	            		"\nCricketer Country \t\t:"+cricketer2.getCountry()+
	            		"\nCricketer BowlerHand \t\t:"+cricketer2.getBowlerHand()+
	            		"\nCricketer BestFigure \t\t:"+cricketer2.getBestFigure());
			}
			else if(cType.equalsIgnoreCase("Staff")) {
				obj = session.load(CricketerPerConcretClass.class, new Integer(id));
				CricketerPerConcretClass cricketer = (CricketerPerConcretClass) obj;
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
