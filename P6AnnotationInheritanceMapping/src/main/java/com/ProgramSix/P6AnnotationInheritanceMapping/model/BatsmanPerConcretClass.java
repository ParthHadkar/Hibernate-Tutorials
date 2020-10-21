package com.ProgramSix.P6AnnotationInheritanceMapping.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="batsman_perconcretclass_annotation")
@AttributeOverrides ({
	@AttributeOverride (name = "id", column= @Column (name="ID",length = 20)),
	@AttributeOverride (name = "name", column= @Column (name="Name",length = 20)),
	@AttributeOverride (name = "country", column= @Column (name="Country",length = 20))
})
public class BatsmanPerConcretClass extends CricketerPerConcretClass{
	@Column (name="BattingHand",length = 20)
	private String battingHand;
	@Column (name="BestScore",length = 20)
	private String bestScore;
	
	public BatsmanPerConcretClass() {
		super();
	}
	
	
	public BatsmanPerConcretClass(int id, String name, String country, String battingHand, String bestScore) {
		super(id, name, country);
		this.battingHand = battingHand;
		this.bestScore = bestScore;
	}
	
	public BatsmanPerConcretClass(String name, String country, String battingHand, String bestScore) {
		super(name, country);
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
