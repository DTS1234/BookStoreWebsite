package com.bookstore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.bookstore.entity.Users;

public class UserTest {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	public static void main(String[] args) {
		
		Users user1 = new Users();
		user1.setEmail("duoa@mail.com");
		user1.setFullName("Adamus");
		user1.setPassword("rura");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(user1);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("user object was persisted");
		
		}		
	}


