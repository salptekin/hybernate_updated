package h08.firstcache_secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {

	public static void main(String[] args) {
				
		Books08 books1 = new Books08();
		Books08 books2 = new Books08();
		Books08 books3 = new Books08();
		Students08 student = new Students08();
		
		student.setId(1005);
		student.setName("Beyhan Can");
		student.setGrade(11);

		books1.setBook(student.getName() + "'s art book");
		books1.setId(101);
		books1.setStudent(student);
		
		books2.setBook(student.getName() + "'s math book");
		books2.setId(102);
		books2.setStudent(student);
		
		books3.setBook(student.getName() + "'s science book");
		books3.setId(103);
		books3.setStudent(student);
		
		student.getBooksList().add(books1);
		student.getBooksList().add(books2);
		student.getBooksList().add(books3);	

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students08.class).addAnnotatedClass(Books08.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(student);
		session.save(books1);
		session.save(books2);
		session.save(books3);
		
		tx.commit();

	}

}
