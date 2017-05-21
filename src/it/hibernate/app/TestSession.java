package it.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.hibernate.models.Student;

public class TestSession {

	public static void main (String[] args){
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			Student tempStudent = new Student("Sandro", "Conte", "sandroconte.mail@gmail.com");
			session.beginTransaction();
			session.save(tempStudent);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
