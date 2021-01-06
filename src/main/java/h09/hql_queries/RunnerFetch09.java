package h09.hql_queries;

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

public class RunnerFetch09 {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students09.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();

		//Note: The syntax which you typed inside the "createQuery()" is CASE SENSITIVE
		
		//1)To get all data from Students09 table by HQL
//		String hqlQuery1 = "from Students09";
//		List<Students09> students = session.createQuery(hqlQuery1).list();
//		for(Students09 w:students) {
//			System.out.println(w);
//		}
		
		//2)To get students whose grades are more than 50 from the Students09 table by HQL
//		String hqlQuery2 = "from Students09 where mathGrade>50";
//		List<Students09> students = session.createQuery(hqlQuery2).list();
//		for(Students09 w:students) {
//			System.out.println(w);
//		}
		
		//3)To get a student whose id is 11 from the Students09 table by HQL
//		String hqlQuery3 = "from Students09 where id=11";
//		Students09 students = (Students09) session.createQuery(hqlQuery3).uniqueResult();
//		System.out.println(students);
		
		//4)To get just name and math grade of a student whose id is 11 from the Students09 table by HQL
		//Note 1: Name and Grade are in different data type because of that I selected Object as data type
		//Note 2: There are more than 1 outputs because of that I made it Array.
//		String hqlQuery4 = "select name, mathGrade from Students09 where id=11";
//		Object[] students = (Object[]) session.createQuery(hqlQuery4).uniqueResult();
//		System.out.println("Name:" + students[0] + " - " + "Math Grade:" + students[1]);
		
		//5)To get just names and math grades of all students from the Students09 table by HQL
//		List<Object[]> students = session.createQuery("select name, mathGrade from Students09").list();
//		for(Object[] w:students) {
//			System.out.println("Name:" + w[0] + " - " + "Math Grade:" + w[1]);
//		}
		
		//6)To get just names and math grades of students whose math Grades are more than 80 from the Students09 table by HQL
//		List<Object[]> students = session.createQuery("select name, mathGrade from Students09 where mathGrade>80").list();
//		for(Object[] w:students) {
//			System.out.println("Name:" + w[0] + " - " + "Math Grade:" + w[1]);
//		}
		
		//7)To get sum of math grades of students whose math Grades are more than 90 from the Students09 table by HQL
		//Note: For sum in uniqueResult() use Long not Integer
//		Long sumMathGrade = (Long) session.createQuery("select sum(mathGrade) from Students09 where mathGrade>90").uniqueResult();
//		System.out.println(sumMathGrade);
		
		//8)To get average of math grades of students whose math Grades are more than 90 from the Students09 table by HQL
		//Note: For average in uniqueResult() use Double not Integer not Long
//		Double avgMathGrade = (Double) session.createQuery("select avg(mathGrade) from Students09 where mathGrade>90").uniqueResult();
//		System.out.println(avgMathGrade);
		
		//9)To get minimum math grade of students whose math Grades are more than 90 from the Students09 table by HQL
//		Integer avgMathGrade = (Integer) session.createQuery("select min(mathGrade) from Students09 where mathGrade>90").uniqueResult();
//		System.out.println(avgMathGrade);
		
		                                  // Update in HQL
		
		//1)Update the name of the student whose id is 11
//		int result = session.createQuery("UPDATE Students09 set name = 'Ali Can' WHERE id = 11").executeUpdate();
//		System.out.println("Rows effected: " + result);
//		
//		Students09 students = (Students09) session.createQuery("from Students where id=11").uniqueResult();
//		System.out.println(students);
		
		//2)Update the math grades of the students to 100 whose mathGrades are more than 90
//		int result = session.createQuery("UPDATE Students09 set mathGrade = 100 WHERE mathGrade > 90").executeUpdate();
//		System.out.println("Rows effected: " + result);
//		
//		List<Students09> students = session.createQuery("from Students09 where mathGrade>90").list();
//		for(Students09 w:students) {
//			System.out.println(w);
//		}
		
										// Delete in HQL
		//1)Delete the record whose id is 12
//		int result = session.createQuery("DELETE from Students09 WHERE id = 12").executeUpdate();
//		System.out.println("Rows effected: " + result);
//		
//		Students09 students = (Students09) session.createQuery("from Students09 where id=12").uniqueResult();
//		System.out.println(students);
		
		//2)Delete the records whose mathGrades are less than 20
//		int result = session.createQuery("DELETE from Students09 WHERE mathGrade < 20").executeUpdate();
//		System.out.println("Rows effected: " + result);
//		
//		List<Students09> students = session.createQuery("from Students09 where mathGrade<20").list();
//		for(Students09 w:students) {
//			System.out.println(w);
//		}
		
										// Insert in HQL
		//In HQL, only the INSERT INTO … SELECT … is supported; there is no INSERT INTO … VALUES. 
		//HQL only support insert from another table.
		//If you want to add a new record you can use the following code
		
		//1)Insert a record whose id is 51, name is "Kemal Kuzu", and mathGrade is 97
//		Students09 student = new Students09();
//		student.setId(51);
//		student.setName("Kemal Kuzu");
//		student.setMathGrade(97);
//		session.save(student);	
		
		
		//2)Insert a record form another table
		//I created StudentsToInsert09 class and table and I inserted data from StudentsToInsert09 to Students09 table
		//But you have to add <mapping class ="com.hibernate.hibernate_demo10.Students09"/> (Bu data eklenecek table)
		//between <session-factory> tags otherwise it does not work...
		
//		int result = session.createQuery("INSERT INTO Students09 (id, mathGrade, name) select id, mathGrade, name from StudentsToInsert09 where id = 1006").executeUpdate();
//		System.out.println("Rows effected: " + result);
//		
//		Students09 students = (Students09) session.createQuery("from Students09 where id = 1006").uniqueResult();
//		System.out.println(students);

		tx.commit();

	}

}
