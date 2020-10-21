package com.FourthProgram.P4InheritanceMapping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.FourthProgram.P4InheritanceMapping.model.Batsman;
import com.FourthProgram.P4InheritanceMapping.model.Bowler;
import com.FourthProgram.P4InheritanceMapping.model.Cricketer;

public class CricketerDao {
	
	private static int addDB(Cricketer cricketer) {
		SessionFactory sf = null;
		Session session = null;
		int lid = 0;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			sf = con.buildSessionFactory(reg);
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
			sf.close();
		}
		return lid;
	}
	
	public static int addStaff(int id,String name,String country) {
		Cricketer cricketer = new Cricketer(id, name, country);
		return addDB(cricketer);
	}
	
	public static int addBatsman(int id,String name,String country,String battingHand,String bestScore) {
		Cricketer cricketer = new Batsman(id, name, country, battingHand, bestScore);
		return addDB(cricketer);
	}
	
	public static int addBowler(int id,String name,String country,String bowlerHand,String bestFigure) {
		Cricketer cricketer = new Bowler(id, name, country, bowlerHand, bestFigure);
		return addDB(cricketer);
	}
	
	public static void viewCricketer(int id,String cType) {
		SessionFactory sf = null;
		Session session = null;
		try {
			Configuration con = new Configuration().configure();
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			sf = con.buildSessionFactory(reg);
			session = sf.openSession();
			
			Object obj = null;
			if(cType.equalsIgnoreCase("Batsman")) {
				obj = session.load(Batsman.class, new Integer(id));
				Batsman cricketer1 = (Batsman) obj;
				System.out.println("Cricketer Id \t\t:"+cricketer1.getId()+
	            		"\nCricketer Name \t\t:"+cricketer1.getName()+
	            		"\nCricketer Country \t\t:"+cricketer1.getCountry()+
	            		"\nCricketer BattingHand \t\t:"+cricketer1.getBattingHand()+
	            		"\nCricketer BestScore \t\t:"+cricketer1.getBestScore());
			}
			else if(cType.equalsIgnoreCase("Bowler")) {
				obj = session.load(Bowler.class, new Integer(id));
				Bowler cricketer2 = (Bowler) obj;
				System.out.println("Cricketer Id \t\t:"+cricketer2.getId()+
	            		"\nCricketer Name \t\t:"+cricketer2.getName()+
	            		"\nCricketer Country \t\t:"+cricketer2.getCountry()+
	            		"\nCricketer BowlerHand \t\t:"+cricketer2.getBowlerHand()+
	            		"\nCricketer BestFigure \t\t:"+cricketer2.getBestFigure());
			}
			else if(cType.equalsIgnoreCase("Staff")) {
				obj = session.load(Cricketer.class, new Integer(id));
				Cricketer cricketer = (Cricketer) obj;
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
			sf.close();
		}
		
	}
	
}
