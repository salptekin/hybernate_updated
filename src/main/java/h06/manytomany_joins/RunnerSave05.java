package h06.manytomany_joins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {

	public static void main(String[] args) {
				
		Books05 bookArt = new Books05();
		Books05 bookMath = new Books05();
		Students05 student1 = new Students05();
		Students05 student2 = new Students05();
		Students05 student3 = new Students05();
		
		student1.setStd_id(1005);
		student1.setName("Beyhan Can");
		student1.setGrade(11);
		student1.getBooks().add(bookArt);
		student1.getBooks().add(bookMath);
		
		student2.setStd_id(1006);
		student2.setName("Ali Can");
		student2.setGrade(10);
		student2.getBooks().add(bookArt);
		student2.getBooks().add(bookMath);
		
		student3.setStd_id(1007);
		student3.setName("Ayse Tan");
		student3.setGrade(12);
		student3.getBooks().add(bookArt);
		student3.getBooks().add(bookMath);
		
		bookArt.getStudents().add(student1);
		bookArt.getStudents().add(student2);
		bookArt.getStudents().add(student3);
		
		bookArt.setBook_id(101);
		bookArt.setBook("Art Book");
		bookArt.setStudents(bookArt.getStudents());
		
		bookMath.getStudents().add(student1);
		bookMath.getStudents().add(student2);
		bookMath.getStudents().add(student3);
		
		bookMath.setBook_id(102);
		bookMath.setBook("Math Book");
		bookMath.setStudents(bookMath.getStudents());

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students05.class).addAnnotatedClass(Books05.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(bookArt);
		session.save(bookMath);
		
		tx.commit();

	}

}
