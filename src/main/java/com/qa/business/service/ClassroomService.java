package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistance.domain.Classroom;
import com.qa.persistance.repository.ClassroomPersistantStorageInterface;
import com.qa.util.JSONToJavaUtility;

public class ClassroomService implements ClassroomServiceInterface{
	
	@Inject
	private ClassroomPersistantStorageInterface classroomDataHandler;
	
	@Inject
	private JSONToJavaUtility JSONUtilityTool;

	public String setClassroomInformation(String JSONClassroomInfoString) {
		
		Classroom newClassroom =
			JSONUtilityTool.getObjectFromJSON(JSONClassroomInfoString, Classroom.class);
		
		return
			classroomDataHandler.setClassroomInformation(newClassroom);
	}

	public String getClassroomInformation(int classroomIDToBeGotten) {

		Classroom classroomToBegotten = 
				classroomDataHandler.getClassroomInformation(classroomIDToBeGotten);
		
		return
			JSONUtilityTool.getJSONFromObject(classroomToBegotten);
				
	}

	public String getAllUsers() {

		return
			JSONUtilityTool.getJSONFromObject(
					classroomDataHandler.getAllUsers());
	}

	public String updateClassroomInofrmation(String JSONClassroomToBeUpdatedInfoString) {
		Classroom updatedClassroom = JSONUtilityTool.getObjectFromJSON(
				JSONClassroomToBeUpdatedInfoString, Classroom.class);
		
		return
			classroomDataHandler.updateClassroomInofrmation(updatedClassroom);
	}

	public boolean deleteClassroomInformation(String JSONClassroomToBeDeletedInfoString) {
		Classroom classroomToBeDeleted = JSONUtilityTool.getObjectFromJSON(
				JSONClassroomToBeDeletedInfoString, Classroom.class);
		
		return
			classroomDataHandler.deleteClassroomInformation(classroomToBeDeleted);
	}

}
