package com.hibernate.hibernate_demo13;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerCreateTable {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students13.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();

			Students13 student1 = new Students13();
			student1.setId(1001);
			student1.setName("Ali Can");
			student1.setMathGrade(87);
			
			Students13 student2 = new Students13();
			student2.setId(1002);
			student2.setName("Kemal Kuzu");
			student2.setMathGrade(93);
				
		    session.save(student1);	 
		    session.save(student2);
		
			tx.commit();
			
	}

}
