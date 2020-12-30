package com.hibernate.hibernate_demo13;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunnerFetchData {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		
		Students13 st1 = em.find(Students13.class, 1002);
		System.out.println(st1);
		
		
	}

}
