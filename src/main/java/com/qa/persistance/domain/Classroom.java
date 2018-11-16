package com.qa.persistance.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Classrooms")
public class Classroom {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 
	private int classroomID;
	
	private String trainer;
	
	@OneToMany(targetEntity=com.qa.persistance.domain.Trainee.class,
            mappedBy="classroom")
	private Set<Trainee> trainees;
	
	public Classroom() {}

	public int getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(int classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}
	
	

}
