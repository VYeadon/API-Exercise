package com.qa.persistance.repository;

import java.util.Collection;
import java.util.List;

import com.qa.persistance.domain.Classroom;

public interface ClassroomPersistantStorageInterface {

	public void setClassroomInformation(Classroom classToBeSet);
	
	public Classroom getClassroomInformation(Classroom classToBeGet);
	
	public Collection<Classroom> getAllUsers();
	
	public String updateClassroomInofrmation(Classroom ClassroomToBeUpdated);
	
	public void deleteClassroomInformation(Classroom ClassroomToBeDeleted);
}
