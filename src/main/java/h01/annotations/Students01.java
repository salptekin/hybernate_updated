package h01.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
  Entity: Entity is an Object 
  		  Entity has an associated table in relational database.
  		  Each instance of the Entity represents a row of the table.
  		  
  Some points to be noted during writing Entity Class:
  		  Class must have constructor
  		  Create getter setter for each field 
  		  Do not define any field static or final.  				  
*/

/*
	If you use just @Entity annotation, it makes the name of the table in database same with the class name
	If you use @Entity annotation like @Entity(name="students_table"), it makes the name of the table
	in database as students_table but at the same time it changes the @Entity name to students_table
	
	The class which you use @Entity annotation means a table will be created for the class
*/
@Entity
/*
  If you use @Table annotation after the @Entity annotation like @Table(name="students _table")
  it makes the table name in database as students_table but it does not change the @Entity name
*/
public class Students01 {
	/*
	  @Id annotation makes the variable primary key.
	*/
	@Id
	private int id;
	
	/*
	 If you use @Column(name="students_name") it makes the column name in database students_name
	 If you do not use @Column(name="students_name") it uses variable name as column name in data base
	*/
	@Column(name="students_name")
	private String name;
	
	/*
	 If you use @Transient annotation before any variable, the variable is not stored in database
	*/
	//@Transient
	private int grade;
	
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
	@Override
	public String toString() {
		return "Students01 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
}
