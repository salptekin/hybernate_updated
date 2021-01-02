package h05.onetomany_joins;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
	
	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Answer ans1 = new Answer();
		ans1.setAnswer("Java is a programming language");
		ans1.setPostedBy("Ali Can");

		Answer ans2 = new Answer();
		ans2.setAnswer("Java is object oriented programming language");
		ans2.setPostedBy("Veli Han");

		Answer ans3 = new Answer();
		ans3.setAnswer("Session is an Interface");
		ans3.setPostedBy("Mark Stone");

		Answer ans4 = new Answer();
		ans4.setAnswer("Session object is used to access methods");
		ans4.setPostedBy("Tom Hanks");

		ArrayList<Answer> list1 = new ArrayList<Answer>();
		list1.add(ans1);
		list1.add(ans2);

		ArrayList<Answer> list2 = new ArrayList<Answer>();
		list2.add(ans3);
		list2.add(ans4);

		Question question1 = new Question();
		question1.setQuestion("What is Java?");
		question1.setAnswers(list1);

		Question question2 = new Question();
		question2.setQuestion("What is Session?");
		question2.setAnswers(list2);

		session.save(question1);
		session.save(question2);
		
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		session.save(ans4);

		tx.commit();
		session.close();
		System.out.println("success");
	}
}
