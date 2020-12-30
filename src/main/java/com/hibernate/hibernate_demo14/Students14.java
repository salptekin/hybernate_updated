package com.hibernate.hibernate_demo14;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


/*
 	1)One To One: Student ---> Diary (Dayri diye okunur)
 	2)One to Many: Student ---> Course Books
 	3)Many To Many: Students ---> Library Books
*/

@Entity
public class Students14 {
	@Id
	private int id;

	@Column(name="students_name")
	private String name;
	private int grade;

	@OneToMany(mappedBy = "student")
	private List<Books14> booksList = new ArrayList<Books14>();
	
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
	public List<Books14> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<Books14> booksList) {
		this.booksList = booksList;
	}
	@Override
	public String toString() {
		return "Students04 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
}
