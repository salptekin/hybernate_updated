package h07.lazyfetch_eagerfetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {

	public static void main(String[] args) {
				
		Books07 books1 = new Books07();
		Books07 books2 = new Books07();
		Books07 books3 = new Books07();
		Students07 student = new Students07();
		
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

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students07.class).addAnnotatedClass(Books07.class);
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
