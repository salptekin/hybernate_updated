package com.hibernate.hibernate_demo06;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/*
 	1)One To One: Student ---> Diary (Dayri diye okunur)
 	2)One to Many: Student ---> Course Books
 	3)Many To Many: Students ---> Library Books
*/

@Entity
public class Students06 {
	@Id
	private int id;

	@Column(name="students_name")
	private String name;
	private int grade;
	
	//@OneToMany ==> One student has many books
	/*
	  To be able to get all books for a specific student you need to use 
	  fetch=FetchType.EAGER over here.
	  
	  But before teaching fetch=FetchType.EAGER, go to RunnerFetch class and teach how to do by using for-each loop
	*/
	@OneToMany(mappedBy="student", fetch=FetchType.EAGER) 
	private List<Books06> booksList = new ArrayList<Books06>();
	
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
	public List<Books06> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<Books06> booksList) {
		this.booksList = booksList;
	}
	@Override
	public String toString() {
		return "Students06 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
}
