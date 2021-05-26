package h04.onetomany_joins;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/*
 	One to Many: Student ---> Course Books
*/

@Entity
public class Students04 {
	@Id
	private int id;

	@Column(name="students_name")
	private String name;
	private int grade;
	
	/*
	  1)When you want to create "One To Many" relationship between two tables you need to use @OneToMany
	    annotation and you need to create a list for books.
	    If you use @OneToOne annotation, it will add a new column into the Students03 table and name the column as 
	    BOOK_ID
	  2)orphanRemoval = true ==> Over here books are childs of students, if a student is removed, the books related with
	                             student is removed as well.
	  3) CascadeType.All will ensure that all persistence events such as persist, refresh, merge and remove 
	     that occur on the parent, will be passed to the child.
	      Note: Do not use CascadeType.All in ManyToOne because entity state transitions should propagate 
	      from parent entities to child ones
	*/
	
	//@OneToMany ==> One student has many books
	@OneToMany(mappedBy="student", cascade = CascadeType.ALL, orphanRemoval = true) 
	private List<Books04> booksList = new ArrayList<Books04>();
	
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
	public List<Books04> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<Books04> booksList) {
		this.booksList = booksList;
	}
	@Override
	public String toString() {
		return "Students04 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
}
