package com.hibernate.hibernate_demo14;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch14 {

	public static void main(String[] args) {
		
		new Books14();
		new Books14();
		new Books14();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students14.class).addAnnotatedClass(Books14.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
											//INNER JOIN
		//By SQL
//		String innerSql = "SELECT students_name, book\n"
//						+ "FROM students14 INNER JOIN books14\n"
//						+ "ON students14.id = books14.student_id";
//		List<Object[]> innerJoinSql = session.createSQLQuery(innerSql).list();
//		for(Object[] w : innerJoinSql) {
//			System.out.println("Name:" + w[0] + " - " + "Book:" + w[1]);
//		}
		
		//By HQL
		List<Object[]> innerJoinHql = null;
		try {
			String innerHql = "SELECT Students14.name, Books14.book FROM Students14 INNER JOIN FETCH Students14.id";
			innerJoinHql = session.createQuery(innerHql).getResultList();
		}catch(NullPointerException e) {
		     e.printStackTrace();
		}
		for(Object[] w : innerJoinHql) {
			System.out.println("Name: " + w[0] + " - " + "Book: " + w[1]);
		}
		
		
//		
//										//LEFT JOIN
//		//By SQL
//		String leftSql = "SELECT students_name, book\n"
//						+ "FROM students14 LEFT JOIN books14\n"
//						+ "ON students14.id = books14.student_id";
//		List<Object[]> leftJoinSql = session.createSQLQuery(leftSql).list();
//		for(Object[] w : leftJoinSql) {
//			System.out.println("Name:" + w[0] + " - " + "Book:" + w[1]);
//		}
//		
//		//By HQL
//		String leftHql = "SELECT\n"
//							+ "        students_name,\n"
//							+ "        book \n"
//							+ "    FROM\n"
//							+ "        students14 \n"
//							+ "    LEFT JOIN\n"
//							+ "        books14 \n"
//							+ "            ON students14.id = books14.student_id";
//		List<Object[]> leftJoinHql = session.createQuery(leftHql).list();
//		for(Object[] w : leftJoinHql) {
//			System.out.println("Name:" + w[0] + " - " + "Book:" + w[1]);
//		}
//		
//										//RIGHT JOIN
//		//By SQL
//		String rightSql = "SELECT students_name, book\n"
//						+ "FROM students14 RIGHT JOIN books14\n"
//						+ "ON students14.id = books14.student_id";
//		List<Object[]> rightJoinSql = session.createSQLQuery(rightSql).list();
//		for(Object[] w : rightJoinSql) {
//			System.out.println("Name:" + w[0] + " - " + "Book:" + w[1]);
//		}
//		
//		//By HQL
//		String rightHql = "SELECT\n"
//							+ "        students_name,\n"
//							+ "        book \n"
//							+ "    FROM\n"
//							+ "        students14 \n"
//							+ "    RIGHT JOIN\n"
//							+ "        books14 \n"
//							+ "            ON students14.id = books14.student_id";
//		List<Object[]> rightJoinHql = session.createQuery(leftHql).list();
//		for(Object[] w : rightJoinHql) {
//			System.out.println("Name:" + w[0] + " - " + "Book:" + w[1]);
//		}
//		
		tx.commit();
		session.close();

	}

}
