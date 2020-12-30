package com.hibernate.hibernate_demo13;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunnerSaveData {

	public static void main(String[] args) {

		//Create the object
		Students13 st2 = new Students13();
		st2.setId(1003);
		st2.setMathGrade(88);
		st2.setName("Mary Star");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		
		//To add the st2 object into database, do the following 3 steps
		em.getTransaction().begin();
		em.persist(st2);
		em.getTransaction().commit();
		
		//Fetch the data from the database
		Students13 st = em.find(Students13.class, 1003);
		System.out.println(st);

	}

}
