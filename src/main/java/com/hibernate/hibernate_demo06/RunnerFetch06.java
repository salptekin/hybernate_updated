package com.hibernate.hibernate_demo06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {

	public static void main(String[] args) {
		
		Students06 student = new Students06();
		Books06 books = new Books06();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students06.class).addAnnotatedClass(Books06.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		/*
		   If you type like the following, it will return information just for the
		   student whose id is 1005 and just for the book whose id is 102
		*/
		student = session.get(Students06.class, 1005);
		books = session.get(Books06.class, 102);
		System.out.println(student);
		System.out.println(books);
		
		/*
		 LAZY FETCH: 
		 If you do not use "fetch = FetchType.EAGER" or if you use "fetch = FetchType.LAZY" 
		 (Because Hibernate is "Lazy Fetch" as default) inside the @OneToMany annotation parenthesis in Students06 class, 
		 the details of books of the student whose id is 1005 will NOT be initialized
		 and loaded into memory until an explicit call is made.
		  
		 Advantages of Lazy Fetch:
		 1)Initial load time much smaller than "Eager Fetch" approach
		 2)Less memory consumption than "Eager Fetch" approach
		 Disadvantages of Lazy Fetch:
		 1)Delayed initialization might impact performance
		 
		 EAGER FETCH:
		 If you use "fetch = FetchType.EAGER" inside the @OneToMany annotation parenthesis in Students06 class
		 When we use "fetch = FetchType.EAGER" and when we load a student into memory, it will also load up 
		 all associated with the student like books etc. and will store it in the memory and initialize them.
		 
		 Advantages of Eager Fetch:
		 1)No delayed initialization related performance impacts
		 Disadvantages of Eager Fetch:
		 1)Long initial loading time
		 2)Loading too much unnecessary data might impact performance and memory badly
	    */
		
		/*
		 If you want to get the information about all books, do the following by lazy fetch.
		 If you use for loop, you can get all books of the student whose id is 1005.
		*/
//	    student = session.get(Students06.class, 1005);
//      Collection<Books06> allBooks = student.getBooksList();
//      for(Books06 w : allBooks) {
//        System.out.println(w);
//      }
		
		tx.commit();
		session.close();
		
	}

}
