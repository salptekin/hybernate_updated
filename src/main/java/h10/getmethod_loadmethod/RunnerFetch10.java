package h10.getmethod_loadmethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch10 {
	/*
				Differences between get() and load() methods
		1)Both are used to fetch data from the database for the given identifier
		2)If object not found for the given identifier then get() will return null object but load() will throw ObjectNotFoundException
		  Because of that, if you are not sure that object exists then use get() method.
		  If you are sure that object exists then use load() method. 
		3)get() returns fully initialized object so this method eager load the object but load() always returns proxy  object(blank object) 
		  so this method is lazy load the object.
		4)get() is slower than load() because it returns fully initialized object which impact the performance of the application
		5)When you use get() method it immediately hits the database but when you use load() method it does not hit the database 
		  before you use the object.
		  
		Note: When do we use load()?
		      For example we need a book object but to have a book object we need a Student object but the features of the student
		      are not important. So we use load() method to get a proxy object to use it to create book object.
		      But most of the times we use get()   
	*/

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students10.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		/*
		 When you run the following code it hits the database immediately and you get the following output.
		 First do not type the  "System.out.println(st1);"
		 The output from line 33 to 41 displays get() method hit the database even I did not use st1 object
		 Hibernate: 
			    select
			        students0_.id as id1_0_0_,
			        students0_.mathGrade as mathgrade2_0_0_,
			        students0_.name as name3_0_0_ 
			    from
			        Students students0_ 
			    where
			        students0_.id=?
		*/
	    Students10 st1 = session.get(Students10.class, 1001);
	    //System.out.println(st1);
	    
	    /*
		 When you run the following code it does not hit the database immediately and you get nothing on the console.
		 First do not type the  "System.out.println(st2);"
		 But after uncomment "System.out.println(st2);" it will hit the database
		*/
	    Students10 st2 = session.load(Students10.class, 1002);
	    //System.out.println(st2);
	    
	    /*
	     In the following code we do not have any data whose id is 1003 so get() will return "null"
	     But if you do the same thing with load() you will get "ObjectNotFoundException"
	     */
	    Students10 st3 = session.get(Students10.class, 1003);
	    System.out.println(st3);
		
		tx.commit();

	}

}
