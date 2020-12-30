package com.hibernate.hibernate_demo10;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;

public class RunnerFetchDataSQL {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//Change "create" to "update" in cfg.xml file
		//The syntax which you typed inside the createQuery() is case sensitive
		
		//1)To get all data from Students table by SQL
		//instead of * you can type all column names as well but it does not work with some column names
//		List<Students> students = session.createSQLQuery("select * from Students").addEntity(Students.class).list();
//		for(Students w:students) {
//			System.out.println(w);
//		}
		
		//2)To get students whose grades are more than 50 from the Students table by SQL
		//instead of * you can type all column names as well but it does not work with some column names
//		List<Students> students = session.
//										createSQLQuery("select * from Students where mathGrade>50").
//										addEntity(Students.class).
//										list();
//		for(Students w:students) {
//			System.out.println(w);
//		}
		
		//3)To get a student whose id is 11 from the Students table by SQL
		//instead of * you can type all column names as well but it does not work with some column names
//		Students students = (Students) session.createSQLQuery("select * from Students where id=11").addEntity(Students.class).uniqueResult();
//		System.out.println(students);
		
		//4)To get just name and math grade of a student whose id is 11 from the Students table by SQL
		//Note1: Name and Grade are in different data type because of that I selected Object as data type
		//Note2: There are more than 1 outputs because of that I made it Array.
//		Object[] students = (Object[]) session.createSQLQuery("select name, mathGrade from Students where id=11").uniqueResult();
//		System.out.println("Name:" + students[0] + " - " + "Math Grade:" + students[1]);
		
		//5)To get just names and math grades of all students from the Students table by SQL
//		List<Object[]> students = session.createSQLQuery("select name, mathGrade from Students").list();
//		for(Object[] w:students) {
//			System.out.println("Name:" + w[0] + " - " + "Math Grade:" + w[1]);
//		}
		
		//6)To get just names and math grades of students whose math Grades are more than 80 from the Students table by SQL
//		List<Object[]> students = session.createSQLQuery("select name, mathGrade from Students where mathGrade>80").list();
//		for(Object[] w:students) {
//			System.out.println("Name:" + w[0] + " - " + "Math Grade:" + w[1]);
//		}
		
		//7)To get sum of math grades of students whose math Grades are more than 90 from the Students table by SQL
		//Note: For sum in uniqueResult() use BigDecimal not Integer
//		BigDecimal sumMathGrade = (BigDecimal) session.createSQLQuery("select sum(mathGrade) from Students where mathGrade>90").uniqueResult();
//		System.out.println(sumMathGrade);
		
		//8)To get average of math grades of students whose math Grades are more than 90 from the Students table by SQL
		//Note: For average in uniqueResult() use BigDecimal not Double
//		BigDecimal avgMathGrade = (BigDecimal) session.createSQLQuery("select avg(mathGrade) from Students where mathGrade>90").uniqueResult();
//		System.out.println(avgMathGrade);
		
		//9)To get minimum math grade of students whose math Grades are more than 90 from the Students table by SQL
//		BigDecimal avgMathGrade = (BigDecimal) session.createSQLQuery("select min(mathGrade) from Students where mathGrade>90").uniqueResult();
//		System.out.println(avgMathGrade);
		
		                                  // Update in HQL
		
		//1)Update the name of the student whose id is 11
//		int result = session.createSQLQuery("UPDATE Students set name = 'Ali Canan' WHERE id = 11").executeUpdate();
//		System.out.println("Rows effected: " + result);
//		
//		Students students = (Students) session.createSQLQuery("select * from Students where id=11").addEntity(Students.class).uniqueResult();
//		System.out.println(students);
		
		//2)Update the math grades of the students to 100 whose mathGrades are more than 90
//		int result = session.createSQLQuery("UPDATE Students set mathGrade = 100 WHERE mathGrade > 90").executeUpdate();
//		System.out.println("Rows effected: " + result);
//		
//		List<Students> students = session.createSQLQuery("select * from Students where mathGrade>90").addEntity(Students.class).list();
//		for(Students w:students) {
//			System.out.println(w);
//		}
		
										// Delete in SQL
		//1)Delete the record whose id is 12
//		int result = session.createSQLQuery("DELETE from Students WHERE id = 13").executeUpdate();
//		System.out.println("Rows effected: " + result);
//		
//		Students students = (Students) session.createSQLQuery("select * from Students where id=13").addEntity(Students.class).uniqueResult();
//		System.out.println(students);
		
		//2)Delete the records whose mathGrades are less than 20
//		int result = session.createSQLQuery("DELETE from Students WHERE mathGrade < 20").executeUpdate();
//		System.out.println("Rows effected: " + result);
//		
//		List<Students> students = session.createSQLQuery("select * from Students where mathGrade<20").addEntity(Students.class).list();
//		for(Students w:students) {
//			System.out.println(w);
//		}
		
										// Insert in SQL
		//1)Insert a record whose id is 51, name is "Kemal Kuzu", and mathGrade is 97
//		int result = session.createSQLQuery("INSERT INTO Students (id, mathGrade, name) VALUES (51, 99, 'Kemal Kuzu')").executeUpdate();
//		System.out.println("Rows effected: " + result);
//		
//		Students students = (Students) session.createSQLQuery("select * from Students where id = 51").addEntity(Students.class).uniqueResult();
//		System.out.println(students);
		
		
		//2)Insert a record form another table
		//I created StudentsToInsert class and table, and I inserted data from StudentsToInsert to Students table
		//But you have to add <mapping class ="com.hibernate.hibernate_demo10.Students"/> (Bu data eklenecek table)
		//between <session-factory> tags otherwise it does not work...
		
//		Students studentsBeforeInsert = (Students) session.createSQLQuery("select * from Students where id = 1006").addEntity(Students.class).uniqueResult();
//		System.out.println(studentsBeforeInsert);
//		
//		int result = session.createSQLQuery("INSERT INTO Students (id, mathGrade, name) select id, mathGrade, name from StudentsToInsert where id = 1006").executeUpdate();
//		System.out.println("Rows effected: " + result);
//		
//		Students studentsAfterInsert = (Students) session.createSQLQuery("select * from Students where id = 1006").addEntity(Students.class).uniqueResult();
//		System.out.println(studentsAfterInsert);
		
		tx.commit();

	}

}
