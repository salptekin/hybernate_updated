package com.hibernate.hibernate_demo04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {

	public static void main(String[] args) {
		
		Students04 student = new Students04();
		new Books04();
		new Books04();
		new Books04();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students04.class).addAnnotatedClass(Books04.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		/*
		   If you type the like the following, it will return information just for the
		   student whose id is 1005 and the books whose ids are 101, 102, 103
		*/
		student = session.get(Students04.class, 1005);
		session.get(Books04.class, 101);
		session.get(Books04.class, 102);
		session.get(Books04.class, 103);
		
		System.out.println(student);
		for(Books04 w : student.getBooksList()) {
			System.out.println(w);
		}
		
		tx.commit();

	}

}
