package com.bookstore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.bookstore.entity.Users;

public class ReviewTest {

	public static void main(String[] args) {
		
		ReviewTable newRev = new ReviewTable();
		
		newRev.setRating(2);
		newRev.setHeadline("superowa ");
		newRev.setComment("dupka");
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(newRev);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("Review object was persisted");
		
		}		
	}


