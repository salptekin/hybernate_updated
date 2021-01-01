package h04.onetomany_joins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {

	public static void main(String[] args) {
				
		Books04 books1 = new Books04();
		Books04 books2 = new Books04();
		Books04 books3 = new Books04();
		Students04 student1 = new Students04();
		Students04 student2 = new Students04();
		
		student1.setId(1005);
		student1.setName("Beyhan Can");
		student1.setGrade(11);
		
		student2.setId(1006);
		student2.setName("Ayhan Can");
		student2.setGrade(12);

		books1.setBook(student1.getName() + "'s art book");
		books1.setId(101);
		books1.setStudent(student1);
		
		books2.setBook(student1.getName() + "'s math book");
		books2.setId(102);
		books2.setStudent(student1);
		
		books3.setBook("Veli Han's science book");
		books3.setId(103);
		
		student1.getBooksList().add(books1);
		student1.getBooksList().add(books2);
		student1.getBooksList().add(books3);	

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students04.class).addAnnotatedClass(Books04.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(student1);
		session.save(student2);
		
		for(Books04 w : student1.getBooksList()) {
			session.save(w);
		}
		
		tx.commit();
		session.close();

	}

}
