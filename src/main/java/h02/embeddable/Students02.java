package h02.embeddable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Students02 {
	@Id
	private int id;

	@Column(name="students_name")
	private String name;
	private int grade;
	
	/*
		 This will be added to the Students class to teach @embeddable annotation
		 If you want to use a class object as variable in a class and you want to add it into your table
		 1)Create a new class(Courses02), 
		 2)Create variables, getters, setters, and toString() method 
		 3)Come to the Students class and add "private Courses courses;" as variable. 
		 4)Create getters and setters of courses variable in Students class
		 5)Update toString() method for courses object
	*/
	private Courses02 courses;
	
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
	public Courses02 getCourses() {
		return courses;
	}
	public void setCourses(Courses02 courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Students02 [id=" + id + ", name=" + name + ", grade=" + grade + ", courses=" + courses + "]";
	}
	
}
