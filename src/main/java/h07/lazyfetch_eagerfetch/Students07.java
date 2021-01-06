package h07.lazyfetch_eagerfetch;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Students07 {
	@Id
	private int id;

	@Column(name="students_name")
	private String name;
	private int grade;
	
	/*
	 	Note: To see the differences between LAZY and EAGER you need to DROP and create tables again
	 	      by running RunnerSave Class...
	 */

	/*
		  If you want to get information about all books for a specific student, and the information of the student 
		  you need to use "fetch=FetchType.EAGER"
		  
		  When you use "fetch=FetchType.EAGER", the query in Hibernate console will be like;
				  "Hibernate: 
					    select
					        students0x0_.id as id1_2_0_,
					        students0x0_.grade as grade2_2_0_,
					        students0x0_.students_name as students_name3_2_0_,
					        bookslist1_.student_id as student_id3_1_1_,
					        bookslist1_.id as id1_1_1_,
					        bookslist1_.id as id1_1_2_,
					        bookslist1_.book as book2_1_2_,
					        bookslist1_.student_id as student_id3_1_2_ 
					    from
					        Students0 students0x0_ 
					    left outer join
					        Books06 bookslist1_ 
					            on students0x0_.id=bookslist1_.student_id 
					    where
					        students0x0_.id=?
				   Students06 [id=1005, name=Beyhan Can, grade=11]"	  
	*/  
	  
	/*  
		  If you want to get information about a specific student but not to get information about his/her books 
		  you need to use "fetch=FetchType.LAZY"
		  Note: You may type nothing for LAZY as well because Hibernate is in LAZY Fetch type as default
		  
		  When you use "fetch=FetchType.LAZY" or nothing the query in Hibernate console will be like;
					  "Hibernate: 
						    select
						        students0x0_.id as id1_2_0_,
						        students0x0_.grade as grade2_2_0_,
						        students0x0_.students_name as students_name3_2_0_ 
						    from
						        Students0 students0x0_ 
						    where
						        students0x0_.id=?
					   Students06 [id=1005, name=Beyhan Can, grade=11]"
		  As you see above, there is no any select about the books of Beyhan Can		     
	*/
	@OneToMany(mappedBy="student", fetch=FetchType.EAGER) 
	private List<Books07> booksList = new ArrayList<Books07>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public List<Books07> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<Books07> booksList) {
		this.booksList = booksList;
	}
	@Override
	public String toString() {
		return "Students06 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
}
