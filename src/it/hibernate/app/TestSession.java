package it.hibernate.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.hibernate.models.Student;

public class TestSession {	
	
	static SessionFactory factory;
	
	public static void create(){
		Session session = factory.openSession();
		try{
			Student tempStudent = new Student("Sandro", "Conte", "sandroconte.mail@gmail.com");
			session.beginTransaction();
			session.save(tempStudent);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}	
	
	public static void readAll(){
		Session session = factory.openSession();
		try{			
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student").getResultList();
			session.getTransaction().commit();
			for (Student student: students){
				System.out.println(student.toString());
				System.out.println("\n\n");
			}
		} finally {
			factory.close();
		}
	}
	
	public static Student find(int id){
		Session session = factory.openSession();
		Student student;
		try{			
			session.beginTransaction();
			student = session.get(Student.class, id);
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		return student;
	}
	
	
	public static void update(Student student){
		Session session = factory.openSession();
		try{			
			session.beginTransaction();
			session.update(student);
			session.getTransaction().commit();			
		} finally {
			factory.close();
		}
	}
	
	public static void main (String[] args){
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();		
		Student student = factory.openSession().get(Student.class, 1);
		student.setFirstName("Alessandro");
		student.setLastName("Rossi");
		student.setEmail("alessandrorossi@gmail.com");
		update(student);
		
	}
}
