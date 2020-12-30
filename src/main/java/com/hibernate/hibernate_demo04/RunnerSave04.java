package com.hibernate.hibernate_demo04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {

	public static void main(String[] args) {
				
		Books04 books1 = new Books04();
		Books04 books2 = new Books04();
		Books04 books3 = new Books04();
		Students04 student = new Students04();
		
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

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students04.class).addAnnotatedClass(Books04.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(student);
		for(Books04 w : student.getBooksList()) {
			session.save(w);
		}
		
		tx.commit();
		session.close();

	}

}
