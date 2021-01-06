package h06.manytomany_joins;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch05 {

	public static void main(String[] args) {
		
		Students05 student = new Students05();
		Books05 books = new Books05();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students05.class).addAnnotatedClass(Books05.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//1)Fetch the student whose id is 1001 by using get()
//		student = session.get(Students06.class, 1001);
//		System.out.println(student);
		
		//2)Fetch the book whose id is 101 by using get()
//		book = session.get(Books06.class, 101);
//		System.out.println(book);
		
		//3)Fetch the book whose name is "Art Book". I want to see the owners as well
//		String hqlQuery1 = "FROM Books06 b WHERE b.book_name = 'Math Book'";
//		Object rs1 = session.createQuery(hqlQuery1).getSingleResult();
//		System.out.println(rs1);
		
		//4)Fetch the student whose name is "Ali Can". I want to see the books as well
//		String hqlQuery2 ="FROM Students06 s WHERE s.name = 'Ali Can'";
//		Object rs2 = session.createQuery(hqlQuery2).getSingleResult();
//		System.out.println(rs2);
		
		//5)Fetch the student names
//		String hqlQuery3 = "SELECT s.name FROM Students06 s";
//		List<Object[]> resultList1 = session.createQuery(hqlQuery3).getResultList();
//		System.out.println(resultList1);
		
		//6)Fetch the book names
//		String hqlQuery4 = "SELECT b.book_name FROM Books06 b";
//		List<Object[]> resultList2 = session.createQuery(hqlQuery4).getResultList();
//		System.out.println(resultList2);
		
		//6)Fetch the book name whose id is 101
//		String hqlQuery5 = "SELECT b.book_name FROM Books06 b WHERE book_id = 101";
//		List<Object[]> resultList3 = session.createQuery(hqlQuery5).getResultList();
//		System.out.println(resultList3);
		
		//7)Fetch the student name, book name whose student id is 1001
		String hqlQuery6 = "SELECT s.name, b.book_name FROM Students06 s "
				+ "INNER JOIN FETCH Books06 b ON s.std_id =1001";
		List<Object[]> resultList4 = session.createQuery(hqlQuery6).getResultList();
		for(Object[] w : resultList4) {
			System.out.println(Arrays.toString(w));
		}
		
		tx.commit();
		
		System.out.println(student);
		System.out.println(books);

	}

}
