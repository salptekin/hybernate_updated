package h03.onetoone_joins;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {
	/*
	  If you do not use @Id annotation, it gives error. 
	*/
	@Id
	private int id;
    private String diary;
    
    @OneToOne
    @JoinColumn(name = "student_id")
    private Students03 student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiary() {
		return diary;
	}

	public void setDiary(String diary) {
		this.diary = diary;
	}

	public Students03 getStudent() {
		return student;
	}

	public void setStudent(Students03 student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Diary [id=" + id + ", diary=" + diary + ", student=" + student + "]";
	}
    
}
