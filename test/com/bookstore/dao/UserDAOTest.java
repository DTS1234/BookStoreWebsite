package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.plaf.ListUI;

import org.apache.catalina.User;
import org.hibernate.jdbc.Expectation;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setupClass(){
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		
		userDAO = new UserDAO(entityManager);
	}
	
	@Test
	public void testCreateUsers() {
		Users user2 = new Users();
		user2.setEmail("denis@gmail.com");
		user2.setFullName("Denis Kramer");
		user2.setPassword("12378");
		
		user2 = userDAO.create(user2);
		
		assertTrue(user2.getUserId()>0);
		
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		
		Users user2 = new Users();

		user2 = userDAO.create(user2);
		
	}
	
	@Test
	public void testUpdateUser() {
		Users user1= new Users();
		user1.setUserId(1);
		user1.setEmail("adamus@zmianaa.pl");
		user1.setFullName("adamus");
		user1.setPassword("has³o123");
		
		user1 = userDAO.update(user1);
		
		String expected = "has³o123";
		String actual = user1.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetUsersFound() {
		
		Integer userId = 1;
		Users user = userDAO.get(userId);
		
		if(user!=null) {
		System.out.println(user.getEmail());
			}
		
		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 99;
		Users user = userDAO.get(userId);
		
		assertNull(user);	
	}
	
	@Test
	public void testDeleteUser() {
		Integer userId = 9;
		userDAO.delete(userId);
		
		Users user = userDAO.get(userId);
		assertNull(user);	
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistUser() {
		Integer userId = 99;
		userDAO.delete(userId);
		
		Users user = userDAO.get(userId);
		assertNull(user);	
	}
	
	@Test
	public void testListAll(){
		List<Users> listUsers = userDAO.listAll();
		
		for(Users user:listUsers)
		System.out.println(user.getFullName());
		
		assertTrue(listUsers.size()>0);
 	}
	
	@Test
	public void testCount(){
		long totalUsers = userDAO.count();
		assertTrue(userDAO.listAll().size()==totalUsers);	
	}
	
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}
	

}
