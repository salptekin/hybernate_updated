package h03.onetoone_joins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {

	public static void main(String[] args) {
				
		Diary diary1 = new Diary();
		Diary diary2 = new Diary();
		Students03 student1 = new Students03();
		Students03 student2 = new Students03();
		
		student1.setId(1005);
		student1.setName("Ali Can");
		student1.setGrade(11);
		student1.setDiary(diary1);
		
		student2.setId(1006);
		student2.setName("Veli Han");
		student2.setGrade(10);
		
		diary1.setId(101);
		diary1.setDiary(student1.getName() + "'s diary");
		diary1.setStudent(student1);
		
		diary2.setId(102);
		diary2.setDiary("Nobody's diary");


		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students03.class).addAnnotatedClass(Diary.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(diary1);
		session.save(diary2);
		session.save(student1);
		session.save(student2);
		
		tx.commit();
		
		session.close();
		sf.close();

	}

}
