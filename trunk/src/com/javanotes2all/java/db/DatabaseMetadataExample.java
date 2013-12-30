package com.javanotes2all.java.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetadataExample {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public static void main(String[] args) throws Exception {
        Connection connection = null;
	try {
	    Class.forName(DRIVER);
	    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	    
	    DatabaseMetaData metadata = connection.getMetaData();
	    // data is database table
	    ResultSet resultSet = metadata.getColumns(null, null, "data", null);
	    while (resultSet.next()) {
		String name = resultSet.getString("COLUMN_NAME");
		String type = resultSet.getString("TYPE_NAME");
		int size = resultSet.getInt("COLUMN_SIZE");
		String dvalue=resultSet.getString("COLUMN_DEF");
		
		System.out.println("Column name: [" + name + "]; type: [" + type 
		    + "]; size: [" + size + "]"+"; defaultvalue:["+dvalue+"];");
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    connection.close();
	}
    }

}
