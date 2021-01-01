package h04.onetomany_joins;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import h03.onetoone_joins.Students03;

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
		
		//How to fetch all books for a specific student
//		student = session.get(Students04.class, 1005);
//		
//		for(Books04 w : student.getBooksList()) {
//			System.out.println(w);
//		}
		
		//How to use SQL Query in Hibernate (OneToMany - INNER JOIN)
//		String sqlQuery1 = "SELECT s.students_name, b.book \n"
//							+ "FROM Students04 s INNER JOIN Books04 b \n"
//							+ "ON s.id = b.student_id";
//		List<Object[]> std01 = session.createSQLQuery(sqlQuery1).list();
//		for(Object[] w : std01) {
//			System.out.println("1) " + w[0] + " - " + w[1]);
//		}
		
		//How to use HQL Query in Hibernate (OneToMany - INNER JOIN)
//		String hqlQuery1 = "SELECT s.name, b.book FROM Students04 s INNER JOIN FETCH Books04 b ON s.id = b.student";
//		List<Object[]> std02 = session.createQuery(hqlQuery1).getResultList();
//		for(Object[] w : std02) {
//			System.out.println("1) " + Arrays.toString(w));
//	    }
		
		//How to use HQL Query in Hibernate (OneToMany - LEFT JOIN)
//		String hqlQuery2 = "SELECT s.name, b.book FROM Students04 s LEFT JOIN FETCH Books04 b ON s.id = b.student";
//		List<Object[]> std02 = session.createQuery(hqlQuery2).getResultList();
//		for(Object[] w : std02) {
//			System.out.println("3) " + Arrays.toString(w));
//	    }
		
		//How to use HQL Query in Hibernate (OneToMany - RIGHT JOIN)
//		String hqlQuery3 = "SELECT s.name, b.book FROM Students04 s RIGHT JOIN FETCH Books04 b ON s.id = b.student";
//		List<Object[]> std03 = session.createQuery(hqlQuery3).getResultList();
//		for(Object[] w : std03) {
//			System.out.println("4) " + Arrays.toString(w));
//	    }
		
		//How to use HQL Query in Hibernate (OneToMany - FULL JOIN)
//		String hqlQuery4 = "SELECT s.name, b.book FROM Students04 s FULL JOIN FETCH Books04 b ON s.id = b.student";
//		List<Object[]> std04 = session.createQuery(hqlQuery4).getResultList();
//		for(Object[] w : std04) {
//			System.out.println("5) " + Arrays.toString(w));
//	    }
		
		tx.commit();

	}

}
