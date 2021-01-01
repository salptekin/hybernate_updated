package h03.onetoone_joins;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*
 	One To One: Student ---> Diary (Dayri diye okunur)
*/

@Entity
public class Students03 {
	@Id
	private int id;

	@Column(name="students_name")
	private String name;
	private int grade;
	
	/*
	  When you create "One To One" relationship between two tables you need to use @OneToOne annotation.
	  If you use @OneToOne annotation, it will add a new column into the Students03 table and name the column as 
	  DIARY_ID
	*/
	@OneToOne(mappedBy = "student")
	private Diary diary;
	
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
	public Diary getDiary() {
		return diary;
	}
	public void setDiary(Diary diary) {
		this.diary = diary;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
}
