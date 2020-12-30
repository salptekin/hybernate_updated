package h02.embeddable;

import javax.persistence.Embeddable;

/*
  If you do not use @Embeddable annotation it does not add courses data into database
  do not forget to change properties "update" to "create" in hibernate.cfg.xml file 
 */
@Embeddable
public class Courses02 {
	
	private String elective;
	private String mandatory;
	
	public String getElective() {
		return elective;
	}
	public void setElective(String elective) {
		this.elective = elective;
	}
	public String getMandatory() {
		return mandatory;
	}
	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}
	@Override
	public String toString() {
		return "Courses [elective=" + elective + ", mandatory=" + mandatory + "]";
	}

}
