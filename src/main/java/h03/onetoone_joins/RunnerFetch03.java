package h03.onetoone_joins;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {

	public static void main(String[] args) {
		
		Students03 student1 = new Students03();
		Diary diary1 = new Diary();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students03.class)
				.addAnnotatedClass(Diary.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		//Example 1: Fetch the student whose id is 101 by using get()
//		std1 = session.get(Students03.class, 101);
//		System.out.println(std1);
		
		//Example 2: Fetch the diary details of a student whose id is 101 by using get()
//		d1 = session.get(Diary.class, 11);
//		System.out.println(d1);
		
		//Example 3: Fetch student name, diary name and student grade of common records from Students03 and Diary tables
		
		//1.Way: By using SQL Queries
//		String sqlQuery1 = "SELECT s.std_name, d.diary_name, s.grade   \n"
//							+ "FROM Students03 s \n"
//							+ "INNER JOIN Diary d ON s.id = d.student_id";
//		List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
//		for(Object[] w : resultList1) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//2.Way: By using HQL Queries
//		String hqlQuery1 = "SELECT s.name, d.diary_name, s.grade FROM Students03 s INNER JOIN FETCH Diary d ON s.id = d.student";
//		List<Object[]> resultList2 = session.createQuery(hqlQuery1).getResultList();
//		for(Object[] w : resultList2) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//Example 4: Fetch student name, diary name and student grade of records from Students03 table
		
		//1.Way: By using SQL Queries
//		String sqlQuery2 = "SELECT s.std_name, d.diary_name, s.grade   \n"
//							+ "FROM Students03 s \n"
//							+ "LEFT JOIN Diary d ON s.id = d.student_id";
//		List<Object[]> resultList3 = session.createSQLQuery(sqlQuery2).getResultList();
//		for(Object[] w : resultList3) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//2.Way: By using HQL Queries
//		String hqlQuery2 = "SELECT s.name, d.diary_name, s.grade FROM Students03 s LEFT JOIN FETCH Diary d ON s.id = d.student";
//		List<Object[]> resultList4 = session.createQuery(hqlQuery2).getResultList();
//		for(Object[] w : resultList4) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//Example 5: Fetch student name, diary name and student grade of records from Diary table
		
		//1.Way: By using SQL Queries
//		String sqlQuery3 = "SELECT s.std_name, d.diary_name, s.grade   \n"
//							+ "FROM Students03 s \n"
//							+ "RIGHT JOIN Diary d ON s.id = d.student_id";
//		List<Object[]> resultList5 = session.createSQLQuery(sqlQuery3).getResultList();
//		for(Object[] w : resultList5) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//2.Way: By using HQL Queries
//		String hqlQuery3 = "SELECT s.name, d.diary_name, s.grade FROM Students03 s RIGHT JOIN FETCH Diary d ON s.id = d.student";
//		List<Object[]> resultList6 = session.createQuery(hqlQuery3).getResultList();
//		for(Object[] w : resultList6) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//Example 6: Fetch student name, diary name and student grade of all records from Students03 and Diary table
		
		//1.Way: By using SQL Queries
//		String sqlQuery4 = "SELECT s.std_name, d.diary_name, s.grade   \n"
//							+ "FROM Students03 s \n"
//							+ "FULL JOIN Diary d ON s.id = d.student_id";
//		List<Object[]> resultList7 = session.createSQLQuery(sqlQuery4).getResultList();
//		for(Object[] w : resultList7) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//2.Way: By using HQL Queries
//		String hqlQuery4 = "SELECT s.name, d.diary_name, s.grade FROM Students03 s FULL JOIN FETCH Diary d ON s.id = d.student";
//		List<Object[]> resultList8 = session.createQuery(hqlQuery4).getResultList();
//		for(Object[] w : resultList8) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//Example 7: Fetch all students information of common records from Students03 and Diary table
//		String hqlQuery5 = "FROM Students03 s INNER JOIN FETCH s.diary";
//		List<Students03> resultList9 = session.createQuery(hqlQuery5).getResultList();
//		System.out.println(resultList9);
		
		//Example 8: Fetch all diary information of common records from Students03 and Diary table
//		String hqlQuery6 = "FROM Diary d INNER JOIN FETCH d.student";
//		List<Diary> resultList9 = session.createQuery(hqlQuery6).getResultList();
//		System.out.println(resultList9);

		tx.commit();
		
		session.close();
		sf.close();

	}

}
