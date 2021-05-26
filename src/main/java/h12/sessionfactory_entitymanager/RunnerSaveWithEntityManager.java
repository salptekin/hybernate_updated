package h12.sessionfactory_entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunnerSaveWithEntityManager {
	
	/*
	 		There are two ways to handle persistence in Hibernate: Session(Hibernate) and Entity Manager(JPA).
	 		
	 1) EntityManagerFactory is  the standard implementation, it is the same across all the implementations. 
	    If we migrate our ORM for any other provider, there will not be any change in the approach for handling the transaction. 
	    In contrast, if you use hibernate’s session factory, it is tied  to hibernate APIs and cannot migrate to new vendor easily.
	    
     2) One dis-advantage of using the standard implementation is that, it is not providing the advanced features. 
        There is not much control provided in the EntityManager APIs. 
        Whereas, hibernate’s SessionFactory has lot of advanced features which can not be done in JPA. 
        
        Looking into the above points, one has to decide which one is better. 
        There is no hard rule, after all it depends on the developers requirement. 
	*/

	public static void main(String[] args) {

		//Create the object
		Students12 st2 = new Students12();
		st2.setId(1003);
		st2.setMathGrade(88);
		st2.setName("Mary Star");
		
		/*
			 		Entity Manager Factory
		     An Entity Manager Factory provides entity manager instances, 
		     all instances are configured to connect to the same database, 
		     to use the same default settings as defined by the particular implementation, etc. 
		     You can prepare several entity manager factories to access several data stores. 
		     This interface is similar to the SessionFactory in Hibernate.
		     
		     Note: When the EntityManagerFactory is created, the persistence implementation searches for 
		     the "META-INF/persistence.xml" file in the classpath.
		*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		
		/*
		 			Entity Manager
         The Entity Manager API is used to access a database in a particular unit of work. 
         It is used to create and remove persistent entity instances, to find entities by their primary key identity, and to query over all entities. 
         This interface is similar to the Session in Hibernate.
		 */
		EntityManager em = emf.createEntityManager();
		
		//To save data into database, do the following 3 steps
		em.getTransaction().begin();
		em.persist(st2);//Similar with save()
		
		
		//To fetch data from the database
		Students12 st = em.find(Students12.class, 1003);//To retrieve an object from the database
		System.out.println("==>" + st);
		
		//To query
		Object st1 = em.createQuery("FROM Students12 s WHERE s.name = 'Ali Can'").getSingleResult();
		System.out.println(st1);
		
		//To remove data from a table
		//em.remove(st);
		
		//To detach data (Close its session)
		//em.detach(st);
		
		em.getTransaction().commit();

	}

}
