package h05.onetomany_joins;

import javax.persistence.*;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String answer;
	private String postedBy;
	
	@ManyToOne //Many Answers to one Question
	private Question question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
