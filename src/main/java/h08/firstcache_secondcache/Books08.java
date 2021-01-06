package h08.firstcache_secondcache;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "books07")
public class Books08 {

	@Id
	private int id;
    private String book;
    
    @ManyToOne
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
