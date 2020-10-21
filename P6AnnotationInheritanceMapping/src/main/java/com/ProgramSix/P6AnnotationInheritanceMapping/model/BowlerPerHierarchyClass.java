package com.ProgramSix.P6AnnotationInheritanceMapping.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "Bowler")
public class BowlerPerHierarchyClass extends CricketerPerHierarchyClass{
	@Column (name="BowlerHand",length = 20)
	private String bowlerHand;
	@Column (name="BestFigure",length = 20)
	private String bestFigure;
	
	public BowlerPerHierarchyClass() {
		super();
	}

	public BowlerPerHierarchyClass(int id, String name, String country, String bowlerHand, String bestFigure) {
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
