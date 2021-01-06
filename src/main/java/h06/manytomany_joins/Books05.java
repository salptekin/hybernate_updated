package h06.manytomany_joins;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Books05 {

	@Id
	private int book_id;
    private String book;
    
    /*
	  When you want to create "Many To Many" relationship between two tables 
	  you need to use @ManyToMany annotation to create the many-to-many relationship between the entities.
	*/ 
    
    /*
      Note: If you do not use @mappedBy("students"), it will create 2 extra different tables
	        because Books table creates books_students05 table and Students05 table creates students05_books table.
	        2 tables are not needed to create relationship between two tables 
	        to prevent that we should use @mappedBy("students")
    */
    @ManyToMany(mappedBy = "books")//Many books belong to many student
    private List<Students05> students = new ArrayList<Students05>();

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
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

//	@Override
//	public String toString() {
//		return "Books [id=" + book_id + ", book=" + book + ", student=" + students + "]";
//	}
	
	@Override
	public String toString() {
		return "Books [id=" + book_id + ", book=" + book + "]";
	}
    
}
