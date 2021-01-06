package h07.lazyfetch_eagerfetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {

	public static void main(String[] args) {
		
		Students07 student = new Students07();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students07.class).addAnnotatedClass(Books07.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();

		student = session.get(Students07.class, 1005);
		System.out.println(student);
		
		/*
		 Advantages of LAZY FETCH:
		 1)Initial load time much smaller than "Eager Fetch" approach
		 2)Less memory consumption than "Eager Fetch" approach
		 
		 Disadvantage of LAZY FETCH:
		 1)Delayed initialization might impact performance
		 
		 ====================================================
		 
		 Advantages of EAGER FETCH:
		 1)No delayed initialization related performance impacts
		 
		 Disadvantages of EAGER FETCH:
		 1)Long initial loading time
		 2)Loading too much unnecessary data might impact performance and memory badly
	    */

		
		tx.commit();
		session.close();
		sf.close();
		
	}

}
