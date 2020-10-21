package com.ProgramSix.P6AnnotationInheritanceMapping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="batsman_persubclass_annotation")
@PrimaryKeyJoinColumn (name = "ID")
public class BatsmanPerSubClass extends CricketerPerSubClass{
	
	@Column (name="BattingHand",length = 20)
	private String battingHand;
	@Column (name="BestScore",length = 20)
	private String bestScore;
	
	public BatsmanPerSubClass() {
		super();
	}
	
	
	public BatsmanPerSubClass(int id, String name, String country, String battingHand, String bestScore) {
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
