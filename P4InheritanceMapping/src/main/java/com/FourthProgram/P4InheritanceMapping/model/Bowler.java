package com.FourthProgram.P4InheritanceMapping.model;

public class Bowler extends Cricketer{
	
	private String bowlerHand,bestFigure;
	
	public Bowler() {
		super();
	}

	public Bowler(int id, String name, String country, String bowlerHand, String bestFigure) {
		super(id, name, country);
		this.bowlerHand = bowlerHand;
		this.bestFigure = bestFigure;
	}	

	public String getBowlerHand() {
		return bowlerHand;
	}

	public void setBowlerHand(String bowlerHand) {
		this.bowlerHand = bowlerHand;
	}

	public String getBestFigure() {
		return bestFigure;
	}

	public void setBestFigure(String bestFigure) {
		this.bestFigure = bestFigure;
	}

	@Override
	public String toString() {
		return "Bowler [bowlerHand=" + bowlerHand + ", bestFigure=" + bestFigure + "]";
	}	
	
}
