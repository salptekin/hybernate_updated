package com.hibernate.hibernate_demo06;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Books06 {

	@Id
	private int id;
    private String book;
    
    @ManyToOne  //Many books belong to One student
    @JoinColumn(name = "student_id")
    private Students06 student;

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

	public Students06 getStudent() {
		return student;
	}

	public void setStudent(Students06 student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", book=" + book + ", student=" + student + "]";
	}
    
}
