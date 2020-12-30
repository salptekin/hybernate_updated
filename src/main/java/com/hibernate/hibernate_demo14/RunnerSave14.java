package com.hibernate.hibernate_demo14;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {

	public static void main(String[] args) {
				
		Books14 book1 = new Books14();
		Books14 book2 = new Books14();
		Books14 book3 = new Books14();
		Books14 book4 = new Books14();
		Students14 student1 = new Students14();
		Students14 student2 = new Students14();
		
		student1.setId(1005);
		student1.setName("Beyhan Can");
		student1.setGrade(11);
		
		student2.setId(1006);
		student2.setName("Akif Han");
		student2.setGrade(12);

		book1.setBook(student1.getName() + "'s art book");
		book1.setId(101);
		book1.setStudent(student1);
		
		book2.setBook(student1.getName() + "'s math book");
		book2.setId(102);
		book2.setStudent(student1);
		
		book3.setBook(student1.getName() + "'s science book");
		book3.setId(103);
		book3.setStudent(student1);
		
		book4.setBook("Nobody's book");
		book4.setId(104);

		student1.getBooksList().add(book1);
		student1.getBooksList().add(book2);
		student1.getBooksList().add(book3);	

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students14.class).addAnnotatedClass(Books14.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(student1);
		session.save(student2);
		session.save(book4);
		
		for(Books14 w : student1.getBooksList()) {
			session.save(w);
		}
		
		tx.commit();
		session.close();

	}

}
