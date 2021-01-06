package h11.transient_persistent_detached_removed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerCreateTable {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students11.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();

		/*
		 		Transient Object State:
		 An object is transient if it has just been instantiated using the new operator, and 
		 it is not associated with a Hibernate Session. 
		 It has no persistent representation in the database and no identifier value(Primary Key Value) has been assigned. 
		 Transient instances will be destroyed by the garbage collector if the application is closed, or 
		 if you make any modification on the data, or if you delete the data. After destroying you cannot get it back.		
		*/
			Students11 student = new Students11();
			student.setId(1001);
			student.setName("Ali Can");
			student.setMathGrade(87);
			
		/*
		 		Persistent Object State:
		 An object that is associated with the Hibernate session is called as Persistent object. 
		 When the object is in persistent state, then it represent one row of the database and consists of an identifier value.
		 Hibernate will detect(algilamak) any changes made to an object in persistent state and synchronize the state with the database 
		 when the unit of work completes.
		 Developers do not execute manual UPDATE statements, or DELETE statements when an object should be made transient.
		 To make an object persistent we use save() or persist() methods
		 		
		*/
			
		     session.save(student);	         //(Yukaridakinin database'de olmadigini gosterdikten sonra  bunu ac)
		     student.setName("Kemal Kuzu");  //(session.save(student); kullanip database'de oldugunu gosterdikten sonra update'i de goster)
			
		/*
		  		Detached Object State:  
		A detached instance is an object that has been persistent, but its Session has been closed.
		The detached instance might even be modified in this state.
		Any changes made to the detached objects are not saved to the database.
		The detached object can be re-attached to the new session and save to the database using save or update or merge methods.
		When we close the session persistent object will be in detached state or you can use detach() method.	
		*/
			tx.commit();
			session.detach(student);         //session.close(); da ayni isi yapar)
		    student.setName("Ayhan Can");    //(line 43 den sonra line 54 ve 55'i ac ve update'in database'i etkilemedigini goster)
		    
	    /*
  				Removed Object State:  
  		If you remove a persistent object from data base by using remove() method or delete query, it means it is removed from database
  		but it is still in Java. So the object is in Removed Object State	
  		
  			session.remove(student); use that one before line 53 and display database is empty
        */
		   
		      
	    /*
	     Note: If you fetch a data from database by using get() or find() methods, it means you have a new object. 
	     This object is coming from data base and it was persistent so the object is not transient, it is persistent. 
	     
	     Note: Objects are in transient, detached, and removed states can be destroyed by Garbage Collector.
	    */
	
		

	}

}
