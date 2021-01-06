package h12.sessionfactory_entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunnerFetch12 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		
		Students12 st1 = em.find(Students12.class, 1002);
		System.out.println(st1);
		
		
	}

}
