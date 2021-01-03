package h04.onetomany_joins;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Books04 {
	/*
	  If you do not use @Id annotation, it gives error. 
	 */
	@Id
	private int id;
    private String book;
    
    @ManyToOne  //Many books belong to One student
    //@JoinColumn(name = "student_id")
    private Students04 student;

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

	public Students04 getStudent() {
		return student;
	}

	public void setStudent(Students04 student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", book=" + book + ", student=" + student + "]";
	}
    
}
