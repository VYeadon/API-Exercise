package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistance.domain.Classroom;
import com.qa.persistance.domain.Trainee;
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
	
	public String getAllClassroomInformation()
	{
		return
				JSONUtilityTool.getJSONFromObject(
						classroomDataHandler.getAllClassroomInformation());
	}

	public String updateClassroomInformation(String JSONClassroomToBeUpdatedInfoString, int classroomID) {
		Classroom updatedClassroom = JSONUtilityTool.getObjectFromJSON(
				JSONClassroomToBeUpdatedInfoString, Classroom.class);
		
		return
			classroomDataHandler.updateClassroomInformation(updatedClassroom, classroomID);
	}

	public String deleteClassroomInformation(int classroomID) {
		
			if(classroomDataHandler.deleteClassroomInformation(classroomID))
			{
				return 
					"{\"message\": \"account has been sucessfully deleted\"}";
			}
			else
			{
				return
					"{\"message\": \"account has not been sucessfully deleted\"}";
			}
	}

}
