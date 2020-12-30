package com.hibernate.hibernate_demo10;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerCreateTable {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Random r = new Random();
		for(int i=1; i<=50; i++) {	
			Students student = new Students();
			student.setId(i);
			student.setName("Name" + i);
			student.setMathGrade(r.nextInt(100));
			session.save(student);	
		}
	
		tx.commit();

	}

}
