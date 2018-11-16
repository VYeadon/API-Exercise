package com.qa.business.service;

public interface ClassroomServiceInterface {

	public String setClassroomInformation(String JSONClassroomInfoString);
	
	public String getClassroomInformation(int classroomIDToBeGotten);
	
	public String getAllUsers();
	
	public String updateClassroomInofrmation(String JSONClassroomToBeUpdatedInfoString);
	
	public boolean deleteClassroomInformation(String JSONClassroomToBeDeletedInfoString);
	
}
