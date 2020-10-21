package com.ProgramSix.P6AnnotationInheritanceMapping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.ProgramSix.P6AnnotationInheritanceMapping.model.BatsmanPerSubClass;
import com.ProgramSix.P6AnnotationInheritanceMapping.model.BowlerPerSubClass;
import com.ProgramSix.P6AnnotationInheritanceMapping.model.CricketerPerSubClass;



public class CricketerPerSubClassDao {
	
	private static int addDB(CricketerPerSubClass cricketer) {
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
		CricketerPerSubClass cricketer = new CricketerPerSubClass(id, name, country);
		return addDB(cricketer);
	}
	
	public static int addBatsman(int id,String name,String country,String battingHand,String bestScore) {
		CricketerPerSubClass cricketer = new BatsmanPerSubClass(id, name, country, battingHand, bestScore);
		return addDB(cricketer);
	}
	
	public static int addBowler(int id,String name,String country,String bowlerHand,String bestFigure) {
		CricketerPerSubClass cricketer = new BowlerPerSubClass(id, name, country, bowlerHand, bestFigure);
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
				obj = session.load(BatsmanPerSubClass.class, new Integer(id));
				BatsmanPerSubClass cricketer1 = (BatsmanPerSubClass) obj;
				System.out.println("Cricketer Id \t\t:"+cricketer1.getId()+
	            		"\nCricketer Name \t\t:"+cricketer1.getName()+
	            		"\nCricketer Country \t\t:"+cricketer1.getCountry()+
	            		"\nCricketer BattingHand \t\t:"+cricketer1.getBattingHand()+
	            		"\nCricketer BestScore \t\t:"+cricketer1.getBestScore());
			}
			else if(cType.equalsIgnoreCase("Bowler")) {
				obj = session.load(BowlerPerSubClass.class, new Integer(id));
				BowlerPerSubClass cricketer2 = (BowlerPerSubClass) obj;
				System.out.println("Cricketer Id \t\t:"+cricketer2.getId()+
	            		"\nCricketer Name \t\t:"+cricketer2.getName()+
	            		"\nCricketer Country \t\t:"+cricketer2.getCountry()+
	            		"\nCricketer BowlerHand \t\t:"+cricketer2.getBowlerHand()+
	            		"\nCricketer BestFigure \t\t:"+cricketer2.getBestFigure());
			}
			else if(cType.equalsIgnoreCase("Staff")) {
				obj = session.load(CricketerPerSubClass.class, new Integer(id));
				CricketerPerSubClass cricketer = (CricketerPerSubClass) obj;
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
