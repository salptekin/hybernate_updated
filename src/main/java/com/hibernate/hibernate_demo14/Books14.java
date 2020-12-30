package com.hibernate.hibernate_demo14;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Books14 {

	@Id
	private int id;
    private String book;
    
    @ManyToOne
    private Students14 student;

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

	public Students14 getStudent() {
		return student;
	}

	public void setStudent(Students14 student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", book=" + book + ", student=" + student + "]";
	}
    
}
