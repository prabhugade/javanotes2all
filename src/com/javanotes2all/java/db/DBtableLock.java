package com.javanotes2all.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBtableLock {

	public static void main(String[] args) {
		new DBtableLock().Call("test3");
	}
	public void Call(String data)
	{
		Connection connection = null;
		try{

			Class.forName("com.mysql.jdbc.Driver");    
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test3","root","silica");
			// Create statement object  
			Statement stmt = connection.createStatement();
			try{            
				
				// create table query
				int i=0;
				String sql="LOCK TABLE TEST READ";
				stmt.execute(sql);
				System.out.println(sql);
				// Set auto-commit to false
				connection.setAutoCommit(false);
				String sql1="SELECT `productname`, `qty` FROM `table3`";
				System.out.println(sql1);
				ResultSet rs=stmt.executeQuery(sql1);
				while(rs.next())
				{
					System.out.println(rs.getString("productname")+rs.getString("qty"));
				}
				sql1="INSERT INTO `TEST`(`Col1`, `Col2`) VALUES ('"+data+"','"+data+"')";
				i=stmt.executeUpdate(sql1);
				System.out.println("i");
				Thread.sleep(50000);
				System.out.println("after sleep");
				sql="UNLOCK TABLES";
				//stmt.execute(sql);
				connection.commit(); 
				connection.close();
				System.out.println("write end");
			}
			catch (SQLException s){
				String sql="UNLOCK TABLES";
				//stmt.execute(sql);
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
