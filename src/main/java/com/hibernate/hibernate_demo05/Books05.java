package com.hibernate.hibernate_demo05;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Books05 {
	/*
	  If you do not use @Id annotation, it gives error. 
	 */
	@Id
	private int id;
    private String book;
    
    /*
	  When you want to create "Many To Many" relationship between two tables you need to use @ManyToMany
	  annotation and you need to create a list for students.
	 */    
    @ManyToMany//Many books belong to many student
//    @JoinTable(
//            name = "Students05",
//            joinColumns ={@JoinColumn (name = "id")}
//    )
    private List<Students05> students = new ArrayList<Students05>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}
	public List<Students05> getStudents() {
		return students;
	}

	public void setStudents(List<Students05> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", book=" + book + ", student=" + students + "]";
	}
    
}
