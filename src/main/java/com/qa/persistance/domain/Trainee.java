package com.qa.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Trainees")
public class Trainee {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 
	private int traineeID;
	
	private String traineeName;
	
	@ManyToOne
    @JoinColumn(name="classroomID", nullable=false)
	private Classroom classroom;
	
	public Trainee() {}

	public int getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(int traineeID) {
		this.traineeID = traineeID;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
}
