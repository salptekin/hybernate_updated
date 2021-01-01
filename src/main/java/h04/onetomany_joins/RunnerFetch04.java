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
		Books04 book = new Books04();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students04.class).addAnnotatedClass(Books04.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//Example 1: Fetch all books of a student by using get() method		
//		student = session.get(Students04.class, 1005);
//		for(Books04 w : student.getBooksList()) {
//			System.out.println(w);
//		}
		
		//Example 2: Fetch student who owns a book by using get() method		
//		book = session.get(Books04.class, 103);
//		System.out.println(session.get(Students04.class, book.getStudent().getId()));
		
		//Example 3: Fetch student name, book name of common records from Students04 and Books04 tables (INNER JOIN)
		//1.Way: By using SQL Queries
//		String sqlQuery1 = "SELECT s.students_name, b.book \n"
//							+ "FROM Students04 s INNER JOIN Books04 b \n"
//							+ "ON s.id = b.student_id";
//		List<Object[]> std1 = session.createSQLQuery(sqlQuery1).list();
//		for(Object[] w : std1) {
//			System.out.println(Arrays.toString(w));
//		}
//		//Or
//		for(Object[] w : std1) {
//			System.out.println(w[0] + " - " + w[1]);
//		}
		
		//2.Way: By using HQL Queries
//		String hqlQuery1 = "SELECT s.name, b.book FROM Students04 s INNER JOIN FETCH Books04 b ON s.id = b.student";
//		List<Object[]> std2 = session.createQuery(hqlQuery1).getResultList();
//		for(Object[] w : std2) {
//			System.out.println(Arrays.toString(w));
//	    }
//		//Or
//		for(Object[] w : std2) {
//			System.out.println(w[0] + " - " + w[1]);
//		}
		
		//Example 4: Fetch student name, book name of records from Students04 table (LEFT JOIN)
        //Use just HQL
//		String hqlQuery2 = "SELECT s.name, b.book FROM Students04 s LEFT JOIN FETCH Books04 b ON s.id = b.student";
//		List<Object[]> std02 = session.createQuery(hqlQuery2).getResultList();
//		for(Object[] w : std02) {
//			System.out.println("3) " + Arrays.toString(w));
//	    }
		
		//Example 5: Fetch student name, book name of records from Books04 table (RIGHT JOIN)
        //Use just HQL
//		String hqlQuery3 = "SELECT s.name, b.book FROM Students04 s RIGHT JOIN FETCH Books04 b ON s.id = b.student";
//		List<Object[]> std3 = session.createQuery(hqlQuery3).getResultList();
//		for(Object[] w : std3) {
//			System.out.println(Arrays.toString(w));
//	    }
		
		//Example 6: Fetch student name, book name of all records from Students04 and Books04 table (FULL JOIN)
//		String hqlQuery4 = "SELECT s.name, b.book FROM Students04 s FULL JOIN FETCH Books04 b ON s.id = b.student";
//		List<Object[]> std4 = session.createQuery(hqlQuery4).getResultList();
//		for(Object[] w : std4) {
//			System.out.println("5) " + Arrays.toString(w));
//	    }
		
		tx.commit();

	}

}
