package com.hibernate.hibernate_demo08;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity

public class Books08 {

	@Id
	private int id;
    private String book;
    
    @ManyToOne
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Students08 student;

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
	public Students08 getStudent() {
		return student;
	}
	public void setStudent(Students08 student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", book=" + book + ", student=" + student + "]";
	}
    
}
