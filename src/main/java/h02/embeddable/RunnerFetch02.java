package h02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {

	public static void main(String[] args) {
		
		Students02 student1 = new Students02();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students02.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		student1 = session.get(Students02.class, 1005);
		tx.commit();
		
		System.out.println(student1);

	}

}
