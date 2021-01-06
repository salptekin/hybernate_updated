package h06.manytomany_joins;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/*
 	3)Many To Many: Students ---> Library Books
*/

@Entity
public class Students05 {
	@Id
	private int std_id;

	@Column(name="students_name")
	private String name;
	private int grade;
	
	/*
	  When you want to create "Many To Many" relationship between two tables you need to use @ManyToMany
	  annotation and you need to create a list for books.
	*/
	
	/*
	 In our example, the owning side is Students05 so the join table is specified on the owning side 
	 by using the @JoinTable annotation in Employee class. 
	 
	 The @JoinTable is used to define the "link table". In this case, it is "Students05_Books05".
	*/
	
	/*
	 The @JoinColumn annotation is used to specify the linking column with the main table. 
	 Here, the link column is "std_id".
	 "book_id" is the inverse join column since Books05 is on the inverse side of the relationship.
	*/
	@ManyToMany(cascade = CascadeType.ALL)

    @JoinTable(
            name = "Students05_Books05", 
            joinColumns = { @JoinColumn(name = "std_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
        )
	private List<Books05> books = new ArrayList<Books05>();
	
	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
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
		return "Students05 [std_id=" + std_id + ", name=" + name + ", grade=" + grade + ", books=" + books + "]";
	}
	
//	@Override
//	public String toString() {
//		return "Students05 [std_id=" + std_id + ", name=" + name + ", grade=" + grade + "]";
//	}
	
}
