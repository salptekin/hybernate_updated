package com.hibernate.hibernate_demo08;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {

	public static void main(String[] args) {

		Books08 books = new Books08();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students08.class).addAnnotatedClass(Books08.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session1 = sf.openSession();
		Transaction tx1 = session1.beginTransaction();
		
		books = session1.get(Books08.class, 101);
		System.out.println(books);		
//		books = session1.get(Books.class, 102);
//		System.out.println(books);
		
		/*
		 If you do request with same book id's twice, it means you requested same data twice
		 because of that First-Level Cache enables and database is hit once. Because Hibernate gets the data from Cache
		 You will get the followings on the hibernate console:
		 
		 Single Hit ==> Hibernate: select books0_.id as id1_0_0_, books0_.book as book2_0_0_, books0_.student_id as student_id3_0_0_, students07x1_.id as id1_1_1_, students07x1_.grade as grade2_1_1_, students07x1_.students_name as students_name3_1_1_ from Books books0_ left outer join Students07 students07x1_ on books0_.student_id=students07x1_.id where books0_.id=?
					    Books [id=101, book=Beyhan Can's art book, student=Students07 [id=1005, name=Beyhan Can, grade=11]]
					    Books [id=101, book=Beyhan Can's art book, student=Students07 [id=1005, name=Beyhan Can, grade=11]]
		*/
//		books = session1.get(Books08.class, 101);
//		System.out.println(books);		
//		books = session1.get(Books08.class, 101);
//		System.out.println(books);
		
		tx1.commit();
		session1.close();
		
		/*
		 In the session1, I got the data about the books whose id is 101 and the data is stored in first level cache but when I ask the same data
		 by using another session which is session2 Hibernate hit the database to get the data about the books whose id is 101.
		 Actually, the data exists in the first level cache because I did not close the session but I did not configure the second level cache
		 because of that, Hibernate could not get the data and hit the database 
		 
		 Hibernate console:
		 
		 ==>Hibernate: select books0_.id as id1_0_0_, books0_.book as book2_0_0_, books0_.student_id as student_id3_0_0_, students07x1_.id as id1_1_1_, students07x1_.grade as grade2_1_1_, students07x1_.students_name as students_name3_1_1_ from Books books0_ left outer join Students07 students07x1_ on books0_.student_id=students07x1_.id where books0_.id=?
		 Books [id=101, book=Beyhan Can's art book, student=Students07 [id=1005, name=Beyhan Can, grade=11]]
		 ==>Hibernate: select books0_.id as id1_0_0_, books0_.book as book2_0_0_, books0_.student_id as student_id3_0_0_, students07x1_.id as id1_1_1_, students07x1_.grade as grade2_1_1_, students07x1_.students_name as students_name3_1_1_ from Books books0_ left outer join Students07 students07x1_ on books0_.student_id=students07x1_.id where books0_.id=?
		 Books [id=102, book=Beyhan Can's math book, student=Students07 [id=1005, name=Beyhan Can, grade=11]]
		 Books [id=101, book=Beyhan Can's art book, student=Students07 [id=1005, name=Beyhan Can, grade=11]]
		 Books [id=101, book=Beyhan Can's art book, student=Students07 [id=1005, name=Beyhan Can, grade=11]]
		 ==>Hibernate: select books0_.id as id1_0_0_, books0_.book as book2_0_0_, books0_.student_id as student_id3_0_0_, students07x1_.id as id1_1_1_, students07x1_.grade as grade2_1_1_, students07x1_.students_name as students_name3_1_1_ from Books books0_ left outer join Students07 students07x1_ on books0_.student_id=students07x1_.id where books0_.id=?
		 Books [id=101, book=Beyhan Can's art book, student=Students07 [id=1005, name=Beyhan Can, grade=11]]
		 Books [id=101, book=Beyhan Can's art book, student=Students07 [id=1005, name=Beyhan Can, grade=11]]
		 
		 To configure Second Level cache:
		 1) Add to pom.xml
		 	<dependency>
				<groupId>net.sf.ehcache</groupId>
				<artifactId>ehcache</artifactId>
				<version>2.10.6</version>
		    </dependency>
		    
		    <dependency>
			    <groupId>org.hibernate</groupId>
			    <artifactId>hibernate-ehcache</artifactId>
			    <version>5.4.23.Final</version>
			</dependency>
		  2)Go to hibernate.cfg.xml file and do the followings
		     <property name="hibernate.cache.use_second_level_cache">true</property> 
		     //Bu asagidaki adresi Maven dependency jar file icinden bulduk
		     <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.internal.EhcacheRegionFactory</property>
  		  3)To the Students07 class you need to add @Cacheable and @Cache(usage = CacheConcurrencyStrategy.READ_ONLY) annotations below the @Entity annotation
  
		*/
		
		Session session2 = sf.openSession();
		
		Transaction tx2 = session2.beginTransaction();
		
		books = session2.get(Books08.class, 101);
		System.out.println(books);		
//		books = session2.get(Books08.class, 101);
//		System.out.println(books);
		
		tx2.commit();
		session2.close();
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
