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
	
	public Collection<Classroom> getAllUsers()
	{
		Query managerQuery = manager.createQuery("Select a FROM Account a");
		Collection<Classroom> listOfClassrooms = (Collection<Classroom>) managerQuery.getResultList();
		return listOfClassrooms;
	}
	
	@Transactional(REQUIRED)
	public String updateClassroomInofrmation(Classroom ClassroomToBeUpdated)
	{
		manager.merge(ClassroomToBeUpdated);
		return 
			"{\"message\": \"account sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public boolean deleteClassroomInformation(Classroom ClassroomToBeDeleted)
	{
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
}
