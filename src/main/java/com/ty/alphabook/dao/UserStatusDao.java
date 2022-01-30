package com.ty.alphabook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.aplhabook.dto.Status;
import com.ty.aplhabook.dto.User;


public class UserStatusDao {

	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	private EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveUser(User user) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}

	public User checkLogin(String mailid) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		User user = entityManager.find(User.class, mailid);
		entityTransaction.commit();
		return user;
		//entityManager.merge(status);
	}
	 
	public void postStatus(Status status,User user) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		//entityManager.persist(status);
		entityManager.merge(user);
		entityTransaction.commit();
	}

	public void deleteStatus(String mailid) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		User user = entityManager.find(User.class, mailid);
		entityManager.remove(user.getStatus());
		entityTransaction.commit();
	}

	public void deleteUser(String mailid) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.remove(entityManager.find(User.class, mailid));
		entityTransaction.commit();
	}

	public List<Status> getStatusById(String mailid) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		User user = entityManager.find(User.class, mailid);
		return user.getStatus();
	}

}
