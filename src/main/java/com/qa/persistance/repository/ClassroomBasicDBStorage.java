package com.qa.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistance.domain.Classroom;
import com.qa.persistance.domain.Trainee;

@Transactional(SUPPORTS)
@Default
public class ClassroomBasicDBStorage implements ClassroomPersistantStorageInterface {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Transactional(REQUIRED)
	public String setClassroomInformation(Classroom classToBeSet)
	{
		manager.persist(classToBeSet);
		return 
			"{\"message\": \"account has been sucessfully added\"}";
	}
	
	public Classroom getClassroomInformation(int classroomIDToBeGotten)
	{
		return
			manager.find(Classroom.class, classroomIDToBeGotten);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Classroom> getAllClassroomInformation()
	{
		Query managerQuery = manager.createQuery("Select a FROM Classroom a");

		Collection<Classroom> listOfClassrooms = (Collection<Classroom>) managerQuery.getResultList();
		return listOfClassrooms;
	}
	
	@Transactional(REQUIRED)
	public String updateClassroomInformation(Classroom updatedClassroomInfo, int classroomID)
	{
		Classroom oldClassroomFromDB = getClassroomObject(classroomID);
		
		oldClassroomFromDB.setTrainer(updatedClassroomInfo.getTrainer());
		oldClassroomFromDB.setTrainees(updatedClassroomInfo.getTrainees());
		
		manager.merge(oldClassroomFromDB);
		return 
			"{\"message\": \"account sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public boolean deleteClassroomInformation(int classroomID)
	{
		Classroom ClassroomToBeDeleted = manager.find(Classroom.class, classroomID);
		if(manager.contains(ClassroomToBeDeleted))
		{
			manager.remove(ClassroomToBeDeleted);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	private Classroom getClassroomObject(int classroomID) {
		return manager.find(Classroom.class, classroomID);
	}
}
