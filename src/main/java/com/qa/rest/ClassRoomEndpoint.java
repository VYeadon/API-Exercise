package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomServiceInterface;

@Path("/classroom")
public class ClassRoomEndpoint {
	
	@Inject
	private ClassroomServiceInterface service;

	@Path("/operations")
	@GET
	@Produces({ "application/json" })
	public String returnAllUserAccounts() {
		return 
			service.getAllClassroomInformation();
	}

	@Path("/operations")
	@POST
	@Produces({ "application/json" })
	public String addNewAccount(String JSONClassroomInfoString) {
		return 
			service.setClassroomInformation(JSONClassroomInfoString);
	}
	
	@Path("/operations/{classroomID}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("classroomID") int classroomID, String JSONClassroomToBeUpdatedInfoString) {
		
		return 
			service.updateClassroomInformation(JSONClassroomToBeUpdatedInfoString, classroomID);
	}
	
	@Path("/operations/{classroomID}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("classroomID") int classroomID) {
		
		return
			service.deleteClassroomInformation(classroomID);
	}
}
