package com.hibernate.hibernate_demo04;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/*
 	1)One To One: Student ---> Diary (Dayri diye okunur)
 	2)One to Many: Student ---> Course Books
 	3)Many To Many: Students ---> Library Books
*/

@Entity
public class Students04 {
	@Id
	private int id;

	@Column(name="students_name")
	private String name;
	private int grade;
	
	/*
	  When you want to create "One To Many" relationship between two tables you need to use @OneToMany
	  annotation and you need to create a list for diary.
	  If you use @OneToOne annotation, it will add a new column into the Students03 table and name the column as 
	  DIARY_ID
	*/
	
	//@OneToMany ==> One student has many books
	@OneToMany(mappedBy="student") 
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
