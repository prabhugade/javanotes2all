package com.javanotes2all.java.db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangeEngineForMysql {

	public static void main(String[] args) {
		 Connection connection = null;
		    try{
		     Class.forName("com.mysql.jdbc.Driver");    
		     BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		     System.out.println("Enter database name");
		     String database=reader.readLine();
		     System.out.println("Enter username");
		     String user=reader.readLine();
		     System.out.println("Enter Password");
		     String pwd=reader.readLine();
		     connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database,user,pwd);
		     System.out.println("con");
		          try{            
		            // Create statement object  
		            Statement stmt = connection.createStatement();
		            DatabaseMetaData dbm = connection.getMetaData();
					  String[] types = {"TABLE"};
					  ResultSet rs = dbm.getTables(null,null,"%",types);
					  while (rs.next())
					  {
					  String table = rs.getString("TABLE_NAME");
					  System.out.println(table);
					  String sql="ALTER TABLE "+table+" ENGINE = innodb ";
					  int i=stmt.executeUpdate(sql);
					  System.out.println(i);
					  }
		        }
		        catch (SQLException s){
		        	connection.close();
		          System.out.println("SQL Exception " + s);
		        }
		         
		      }
		      catch (Exception e){
		    	  try {
					connection.rollback();
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        e.printStackTrace();
		      } 

	}

}
