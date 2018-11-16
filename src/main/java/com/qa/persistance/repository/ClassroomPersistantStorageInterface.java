package com.qa.persistance.repository;

import java.util.Collection;
import java.util.List;

import com.qa.persistance.domain.Classroom;
import com.qa.persistance.domain.Trainee;

public interface ClassroomPersistantStorageInterface {

	public String setClassroomInformation(Classroom classToBeSet);
	
	public Classroom getClassroomInformation(int classroomIDToBeGotten);
	
	public Collection<Classroom> getAllClassroomInformation();
	
	public String updateClassroomInformation(Classroom ClassroomToBeUpdated, int classroomID);
	
	public boolean deleteClassroomInformation(int classroomID);
}
