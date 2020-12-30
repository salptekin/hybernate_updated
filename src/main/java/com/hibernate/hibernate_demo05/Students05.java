package com.hibernate.hibernate_demo05;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.cfg.Configuration;

/*
 	1)One To One: Student ---> Diary (Dayri diye okunur)
 	2)One to Many: Student ---> Course Books
 	3)Many To Many: Students ---> Library Books
*/

@Entity
public class Students05 {
	@Id
	private int id;

	@Column(name="students_name")
	private String name;
	private int grade;
	
	/*
	  When you want to create "Many To Many" relationship between two tables you need to use @ManyToMany
	  annotation and you need to create a list for books.
	  
	  Note: If you do not use @mappedBy("students"), it will create 2 extra different tables
	        because Books table creates books_students05 table and Students05 table creates students05_books table.
	        2 tables are not needed to create relationship between two tables 
	        to prevent that we should use @mappedBy("students")
	 */
	@ManyToMany(mappedBy="students")
	private List<Books05> books = new ArrayList<Books05>();
	
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
	public List<Books05> getBooks() {
		return books;
	}
	public void setBooks(List<Books05> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Students05 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
}
