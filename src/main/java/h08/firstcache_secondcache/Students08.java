package h08.firstcache_secondcache;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "students07")
public class Students08 {
	
	@Id
	private int id;

	@Column(name="students_name")
	private String name;
	private int grade;

	@OneToMany(mappedBy="student") 
	private List<Books08> booksList = new ArrayList<Books08>();
	
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
	public List<Books08> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<Books08> booksList) {
		this.booksList = booksList;
	}
	@Override
	public String toString() {
		return "Students07 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
}
