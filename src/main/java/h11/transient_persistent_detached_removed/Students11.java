package h11.transient_persistent_detached_removed;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students11 {
	@Id
	private int id;
	private String name;
	private int mathGrade;
	
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
	public int getMathGrade() {
		return mathGrade;
	}
	public void setMathGrade(int mathGrade) {
		this.mathGrade = mathGrade;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", mathGrade=" + mathGrade + "]";
	}
	
}
