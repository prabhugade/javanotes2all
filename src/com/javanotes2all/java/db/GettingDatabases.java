package com.javanotes2all.java.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GettingDatabases {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/test2";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "silica";
	public static void main(String[] args) throws Exception {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			// Gets the metadata of the database
			DatabaseMetaData dbmd = connection.getMetaData();
			String[] types = {"TABLE"};
			
			ResultSet rs = dbmd.getTables(null, null, "%", types);
			while (rs.next()) {
				String tableCatalog = rs.getString(1);
				String tableSchema = rs.getString(2);
				String tableName = rs.getString(3);
				
				System.out.printf("%s - %s - %s%n", tableCatalog, tableSchema, tableName);
			}
		} catch (SQLException e) {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}
}
