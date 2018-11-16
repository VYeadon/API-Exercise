package com.qa.persistance.repository;

import java.util.Collection;
import java.util.List;

import com.qa.persistance.domain.Classroom;

public interface ClassroomPersistantStorageInterface {

	public String setClassroomInformation(Classroom classToBeSet);
	
	public Classroom getClassroomInformation(int classroomIDToBeGotten);
	
	public Collection<Classroom> getAllUsers();
	
	public String updateClassroomInofrmation(Classroom ClassroomToBeUpdated);
	
	public boolean deleteClassroomInformation(Classroom ClassroomToBeDeleted);
}
