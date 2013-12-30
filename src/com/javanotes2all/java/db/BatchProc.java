package com.javanotes2all.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProc {

	public static void main(String[] args) {
		Connection connection = null;
		try{

			Class.forName("com.mysql.jdbc.Driver");    
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ftpusers","root","Silica123");
			try{            
				// Create statement object  
				Statement stmt = connection.createStatement();

				// Set auto-commit to false
				connection.setAutoCommit(false);
				// create table query
				int i=0;

				String query1 = "CREATE TABLE user(user_id integer, user_name varchar(10)) ENGINE=InnoDB";
				stmt.addBatch(query1);
				System.out.println("SQL Exception "+i++);
				// insert query 
				String query2 = "INSERT INTO user (user_id, user_name) VALUES(1,'Brijesh')";
				stmt.addBatch(query2);
				System.out.println("SQL Exception "+i++);
				// insert query
				String query3 = "INSERT INTO user (user_id, user_name) VALUES(2,'Raj Singh')";
				stmt.addBatch(query3);
				System.out.println("SQL Exception "+i++);
				// insert query
				String query4 = "INSERT INTO user (user_id, user_name) VALUES(3,'Ankit')";
				stmt.addBatch(query4);
				System.out.println("SQL Exception "+i++);
				// insert query
				String query5 = "INSERT INTO user (user_id, user_name) VALUES(4,'Raj11111111111')";
				stmt.addBatch(query5);
				System.out.println("SQL Exception "+i++);
				// Update row value query
				String query6 = "UPDATE user SET user_name = 'Ravi' WHERE user_id = 1";
				stmt.addBatch(query6);
				System.out.println("SQL Exception "+i++);
				// delete record from the table query
				String query7 = "Delete from user where user_id=3";
				stmt.addBatch(query7);                
				System.out.println("SQL Exception "+i++);
				stmt.executeBatch();
				System.out.println("Batch processing is done" );
				// connection commited
				connection.commit(); 
				connection.close();
			}
			catch (SQLException s){
				connection.rollback();
				connection.close();
				System.out.println("SQL Exception " + s);
			}

		}
		catch (Exception e){
			e.printStackTrace();
		}  
	}

}
