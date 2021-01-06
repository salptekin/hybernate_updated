package h06.manytomany_joins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch05 {

	public static void main(String[] args) {
		
		Students05 student = new Students05();
		Books05 books = new Books05();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students05.class).addAnnotatedClass(Books05.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		student = session.get(Students05.class, 1005);
		books = session.get(Books05.class, 101);
		
		tx.commit();
		
		System.out.println(student);
		System.out.println(books);

	}

}
