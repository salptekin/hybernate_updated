package com.hibernate.hibernate_demo10;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSaveStudentsToInsert {

	public static void main(String[] args) {
		
		StudentsToInsert student1 = new StudentsToInsert();
		student1.setId(1006);
		student1.setName("Beyhan Can");
		student1.setMathGrade(10);
		
		StudentsToInsert student2 = new StudentsToInsert();
		student2.setId(1007);
		student2.setName("Ayhan Tok");
		student2.setMathGrade(85);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentsToInsert.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		//save() method is used to save data into database
		session.save(student1);
		session.save(student2);
		tx.commit();

	}

}
