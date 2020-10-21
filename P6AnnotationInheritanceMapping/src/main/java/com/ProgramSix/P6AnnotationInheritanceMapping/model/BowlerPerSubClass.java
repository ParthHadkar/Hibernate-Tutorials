package com.ProgramSix.P6AnnotationInheritanceMapping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="bowler_persubclass_annotation")
@PrimaryKeyJoinColumn (name = "ID")
public class BowlerPerSubClass extends CricketerPerSubClass{
	
	@Column (name="BowlerHand",length = 20)
	private String bowlerHand;
	@Column (name="BestFigure",length = 20)
	private String bestFigure;
	
	public BowlerPerSubClass() {
		super();
	}

	public BowlerPerSubClass(int id, String name, String country, String bowlerHand, String bestFigure) {
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
