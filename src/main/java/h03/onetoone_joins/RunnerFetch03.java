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
		
		student1 = session.get(Students03.class, 1005);
		System.out.println("1) " + student1);
		
		diary1 = session.get(Diary.class, 101);
		System.out.println("2) " + diary1);
		
		//How to use SQL Query in Hibernate (INNER JOIN)
		String sqlQuery1 = "SELECT s.students_name, d.diary\n"
							+ "FROM Students03 s INNER JOIN Diary d\n"
							+ "ON s.id = d.student_id";
		List<Object[]> std01 = session.createSQLQuery(sqlQuery1).list();
		for(Object[] w : std01) {
			System.out.println("3) " + w[0] + " - " + w[1]);
		}
		
		//How to use SQL Query in Hibernate (LEFT JOIN)
		String sqlQuery2 = "SELECT s.students_name, d.diary\n"
							+ "FROM Students03 s LEFT JOIN Diary d\n"
							+ "ON s.id = d.student_id";
		List<Object[]> std02 = session.createSQLQuery(sqlQuery2).list();
		for(Object[] w : std02) {
			System.out.println("4) " + w[0] + " - " + w[1]);
		}
		
		//How to use SQL Query in Hibernate (LEFT JOIN)
		String sqlQuery3 = "SELECT s.students_name, d.diary\n"
							+ "FROM Students03 s RIGHT JOIN Diary d\n"
							+ "ON s.id = d.student_id";
		List<Object[]> std03 = session.createSQLQuery(sqlQuery3).list();
		for(Object[] w : std03) {
			System.out.println("5) " + w[0] + " - " + w[1]);
		}
		
		//How to get unique result (INNER JOIN)
		String hqlQuery1 = "FROM Students03 s INNER JOIN FETCH s.diary";
		Students03 std1 = session.createQuery(hqlQuery1, Students03.class).uniqueResult();
		System.out.println("6) " + std1);
		
		//How to get multiple results (LEFT JOIN)
		String hqlQuery2 = "FROM Students03 s LEFT JOIN FETCH s.diary";
		List<Students03> std2 = session.createQuery(hqlQuery2, Students03.class).getResultList();
		System.out.println("7) " + std2);
		
		//How to get multiple result (LEFT JOIN)
		String hqlQuery3 = "FROM Diary d LEFT JOIN FETCH d.student";
		List<Diary> dry1 = session.createQuery(hqlQuery3, Diary.class).getResultList();
		System.out.println("8) " + dry1);
		
		//How to get multiple result (LEFT JOIN)
		String hqlQuery4 = "FROM Diary d RIGHT JOIN FETCH d.student";
		List<Diary> dry2 = session.createQuery(hqlQuery4, Diary.class).getResultList();
		System.out.println("9) " + dry2);

		tx.commit();
		
		session.close();

	}

}
