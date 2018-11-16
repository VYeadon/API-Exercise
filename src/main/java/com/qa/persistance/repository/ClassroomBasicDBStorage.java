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
	public void setClassroomInformation(Classroom classToBeSet)
	{
		manager.persist(classToBeSet);
	}
	
	public Classroom getClassroomInformation(Classroom classToBeGet)
	{
		return
			manager.find(Classroom.class, classToBeGet.getClassroomID());
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
	public void deleteClassroomInformation(Classroom ClassroomToBeDeleted)
	{
		manager.remove(ClassroomToBeDeleted);
	}
}
