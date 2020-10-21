package com.ProgramSix.P6AnnotationInheritanceMapping;

import com.ProgramSix.P6AnnotationInheritanceMapping.dao.CricketerPerHierarchyClassDao;
import com.ProgramSix.P6AnnotationInheritanceMapping.dao.CricketerPerConcretClassDao;
import com.ProgramSix.P6AnnotationInheritanceMapping.dao.CricketerPerSubClassDao;

public class CricketerMain {
	public static void main(String[] args) {
		int sid,batid,bowid= 0;
		//Table_Per_Heirarchy_class
		sid = CricketerPerHierarchyClassDao.addStaff(1, "Ravi shastri", "India");
		CricketerPerHierarchyClassDao.viewCricketer(sid,"Staff");
		batid = CricketerPerHierarchyClassDao.addBatsman(2, "Nitin", "Pakistan", "Right", "100");
		CricketerPerHierarchyClassDao.viewCricketer(batid,"Batsman");
		bowid = CricketerPerHierarchyClassDao.addBowler(3, "Manish", "Bangladesh", "Left", "5/20");
		CricketerPerHierarchyClassDao.viewCricketer(bowid,"Bowler");/**/
		//Table_Per_Concret_class
		/*sid = CricketerPerConcretClassDao.addStaff(4, "Ravi shastri", "India");
		CricketerPerConcretClassDao.viewCricketer(sid,"Staff");
		batid = CricketerPerConcretClassDao.addBatsman(5, "Nitin", "Pakistan", "Right", "100");
		CricketerPerConcretClassDao.viewCricketer(batid,"Batsman");
		bowid = CricketerPerConcretClassDao.addBowler(6, "Manish", "Bangladesh", "Left", "5/20");
		CricketerPerConcretClassDao.viewCricketer(bowid,"Bowler");*/
		/*sid = CricketerPerConcretClassDao.addStaff("Ravi shastri", "India");
		CricketerPerConcretClassDao.viewCricketer(sid,"Staff");
		batid = CricketerPerConcretClassDao.addBatsman("Nitin", "Pakistan", "Right", "100");
		CricketerPerConcretClassDao.viewCricketer(batid,"Batsman");
		bowid = CricketerPerConcretClassDao.addBowler("Manish", "Bangladesh", "Left", "5/20");
		CricketerPerConcretClassDao.viewCricketer(bowid,"Bowler");*/
		//Table_Per_Sub_class
		/*sid = CricketerPerSubClassDao.addStaff(1, "Ravi shastri", "India");
		CricketerPerSubClassDao.viewCricketer(sid,"Staff");
		batid = CricketerPerSubClassDao.addBatsman(2, "Nitin", "Pakistan", "Right", "100");
		CricketerPerSubClassDao.viewCricketer(batid,"Batsman");
		bowid = CricketerPerSubClassDao.addBowler(3, "Manish", "Bangladesh", "Left", "5/20");
		CricketerPerSubClassDao.viewCricketer(bowid,"Bowler");*/
	}
}
