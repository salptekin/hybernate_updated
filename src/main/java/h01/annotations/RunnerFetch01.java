package h01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {

	public static void main(String[] args) {
		
		Students01 student1 = new Students01();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students01.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		/*
		 get() method is used to fetch data from database
		 I created a Students object to store the data which get() method returned
		 The object can be created like Students student1 = null; as well
		 I created a toString() method to be able to see the output on the console
		*/
		student1 = session.get(Students01.class, 1006);
		tx.commit();
		
		System.out.println("==>" + student1);

	}

}
