package com.FourthProgram.P4InheritanceMapping.model;

public class Batsman extends Cricketer{
	
private String battingHand,bestScore;
	
	public Batsman() {
		super();
	}
	
	
	public Batsman(int id, String name, String country, String battingHand, String bestScore) {
		super(id, name, country);
		this.battingHand = battingHand;
		this.bestScore = bestScore;
	}


	public String getBattingHand() {
		return battingHand;
	}

	public void setBattingHand(String battingHand) {
		this.battingHand = battingHand;
	}

	public String getBestScore() {
		return bestScore;
	}

	public void setBestScore(String bestScore) {
		this.bestScore = bestScore;
	}

	@Override
	public String toString() {
		return "Batsman [battingHand=" + battingHand + ", bestScore=" + bestScore + "]";
	}

}
