package com.qa.business.service;

public interface ClassroomServiceInterface {

	public String setClassroomInformation(String JSONClassroomInfoString);
	
	public String getClassroomInformation(int classroomIDToBeGotten);
	
	public String getAllClassroomInformation();
	
	public String updateClassroomInformation(String JSONClassroomToBeUpdatedInfoString, int classroomID);
	
	public String deleteClassroomInformation(int classroomID);
	
}
