package com.javanotes2all.java.db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class CopyDbToAnotherDb 
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Source Database name");
			String sourcedb=reader.readLine();
			System.out.println("Enter Username");
			String uname=reader.readLine();
			System.out.println("Enter Password");
			String pwd=reader.readLine();
			System.out.println("Enter Destination Database name");
			String destinationdb=reader.readLine();
			//creating database
			CopyDbToAnotherDb db=new CopyDbToAnotherDb();
			db.createDatabase(destinationdb, uname, pwd);
			//getting tableslist
			ArrayList<String> tablist=db.getTablesFromDatabase(sourcedb, uname, pwd);
			//System.out.println(tablist);
			
			String s=db.copyTablesStructuresAndData(sourcedb, destinationdb, uname, pwd, tablist);
			System.out.println(s);
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private void createDatabase(String dbname,String uname,String pwd) 
	{
		//for creating database
		Connection Conn=null;
		try
		{
				Conn = DriverManager.getConnection("jdbc:mysql://localhost/?user="+uname+"&password="+pwd); 
				Statement st=Conn.createStatement();
				int Result=st.executeUpdate("CREATE DATABASE "+dbname);
				if(Result>0)
				{
				System.out.println("database created successfully");
				}
			System.out.println("successfully created");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	private ArrayList<String> getTablesFromDatabase(String dbname,String uname,String pwd)
	{
		Connection con=null;
		Statement st=null;
		//for getting the tables from database
		ArrayList<String> tableslist=new ArrayList<String>();
		try
		{
			con=connect(dbname, uname, pwd);
			DatabaseMetaData dbm =con.getMetaData();
			ResultSet rs = null;
			String types[] = { "TABLE" };
			rs = dbm.getTables(null, null, "", types);
			while (rs.next())
			{
				String str = rs.getString("TABLE_NAME");
				tableslist.add(str);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return tableslist;
	}
	public Connection connect(String dbname,String uname,String pwd)
	{
		//for connect database
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url="jdbc:mysql://localhost:3306/"+dbname;
			con=DriverManager.getConnection(url,uname,pwd);
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		return con;
	}
	private String copyTablesStructuresAndData(String sourcedbname,String destdbname,String uname,String pwd,ArrayList<String> tablist)
	{
		//for creating the database struture
		String result1="start";
		Connection soucon=null;
		Connection destcon=null;
		Statement soust=null;
		Statement destst=null;
		try
		{
			soucon=connect(sourcedbname,uname,pwd);
			destcon=connect(destdbname,uname,pwd);
			soust=soucon.createStatement();
			destst=destcon.createStatement();
			Iterator<String> it=tablist.iterator();

			destcon.setAutoCommit(false);
			int k=0;
			while(it.hasNext())
			{
				k++;
				StringBuffer result = new StringBuffer();
				String tabname=it.next();
				try
				{
					//for creating the table structure
					StringBuffer sql = new StringBuffer();
					sql.append("SELECT * FROM ");
					sql.append(tabname);
					ResultSet rs = soust.executeQuery(sql.toString());
					ResultSetMetaData md = rs.getMetaData();
					result.append("CREATE TABLE ");
					result.append(tabname);
					result.append(" ( ");
					for (int i = 1; i <= md.getColumnCount(); i++)
					{
						if (i != 1)
							result.append(',');
						result.append("`"+md.getColumnName(i)+"`");
						result.append(' ');

						String type = md.getColumnTypeName(i);
						result.append(type);

						if (md.getPrecision(i) < 65535)
						{
							result.append('(');
							result.append(md.getPrecision(i));
							if (md.getScale(i) > 0)
							{
								result.append(',');
								result.append(md.getScale(i));
							}
							result.append(") ");
						} else
							result.append(' ');

						/*if (this.isNumeric(md.getColumnType(i)))
					     {
					       if (!md.isSigned(i))
					         result.append("UNSIGNED ");
					     }*/

						if (md.isNullable(i) == ResultSetMetaData.columnNoNulls)
							result.append("NOT NULL ");
						else
							result.append("NULL ");
						if (md.isAutoIncrement(i))
							result.append(" auto_increment");
					}
					DatabaseMetaData dbm = soucon.getMetaData();
					ResultSet primary = dbm.getPrimaryKeys(null, null, tabname);
					boolean first = true;
					while (primary.next())
					{
						if (first)
						{
							first = false;
							result.append(',');
							result.append("PRIMARY KEY(");
						} else
							result.append(",");
						result.append(primary.getString
								("COLUMN_NAME"));
					} 

					if (!first)
						result.append(')');

					result.append(" )TYPE=innodb ");
					//System.out.println(k+"---"+result.toString());
					destst.addBatch(result.toString());
					
					//for copy the data
					String datasql="INSERT INTO "+tabname+" SELECT * FROM "+sourcedbname+"."+tabname;
					//System.out.println(k+"---"+datasql);
					destst.addBatch(datasql);
					
				} 
				catch (Exception e)
				{
					System.out.println(e);
				}  

			}
			int a[]=destst.executeBatch();
			destcon.commit();
			result1="successfully copied";
		}
		catch(Exception e)
		{
			try
			{
				destcon.rollback();
			}catch(Exception e1)
			{
				System.out.println("rollback"+e1.getMessage());
			}
			System.out.println(e);
		}
		return result1;
	}
}
