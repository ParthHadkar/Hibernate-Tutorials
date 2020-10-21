package com.ProgramSix.P6AnnotationInheritanceMapping.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="bowler_perconcretclass_annotation")
@AttributeOverrides ({
	@AttributeOverride (name = "id", column= @Column (name="ID",length = 20)),
	@AttributeOverride (name = "name", column= @Column (name="Name",length = 20)),
	@AttributeOverride (name = "country", column= @Column (name="Country",length = 20))
})
public class BowlerPerConcretClass extends CricketerPerConcretClass{
	
	@Column (name="BowlerHand",length = 20)
	private String bowlerHand;
	@Column (name="BestFigure",length = 20)
	private String bestFigure;
	
	public BowlerPerConcretClass() {
		super();
	}

	public BowlerPerConcretClass(int id, String name, String country, String bowlerHand, String bestFigure) {
		super(id, name, country);
		this.bowlerHand = bowlerHand;
		this.bestFigure = bestFigure;
	}	
	
	public BowlerPerConcretClass(String name, String country, String bowlerHand, String bestFigure) {
		super(name, country);
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
