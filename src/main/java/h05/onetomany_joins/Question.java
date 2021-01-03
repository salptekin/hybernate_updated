package h05.onetomany_joins;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String question;

	/*
	 								What Is Cascading?
	 Any operations on the table of “Question” will have an impact over the table of “Answers”. 
	 When you create id for a question, it will be added into Answers table for every question
    */
	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name = "question_id")
	private List<Answer> answers = new ArrayList<Answer>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
