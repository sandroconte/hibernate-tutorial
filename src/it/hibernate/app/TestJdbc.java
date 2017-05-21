package it.hibernate.app;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJdbc {

	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/hibernate?useSSL=false";
		String user = "root";
		String password = "root";
		try{
			System.out.println("Connection to database " + url);
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection succesful");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
