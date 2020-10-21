package com.FourthProgram.P4InheritanceMapping;

import com.FourthProgram.P4InheritanceMapping.dao.CricketerDao;

public class CricketerMain {
	public static void main(String[] args) {
		int sid = CricketerDao.addStaff(11, "Ravi shastri", "India");
		CricketerDao.viewCricketer(sid,"Staff");
		int batid = CricketerDao.addBatsman(12, "Nitin", "Pakistan", "Right", "100");
		CricketerDao.viewCricketer(batid,"Batsman");
		int bowid = CricketerDao.addBowler(13, "Manish", "Bangladesh", "Left", "5/20");
		CricketerDao.viewCricketer(bowid,"Bowler");
	}
}
