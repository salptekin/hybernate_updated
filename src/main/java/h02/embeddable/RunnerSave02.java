package h02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

	public static void main(String[] args) {
		
		Courses02 courses = new Courses02();
		courses.setElective("Art, Music, Spanish");
		courses.setMandatory("Math, Science");
		
		Students02 student1 = new Students02();
		student1.setId(1005);
		student1.setName("Beyhan Can");
		student1.setGrade(11);
		student1.setCourses(courses);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students02.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(student1);
		tx.commit();

	}

}
