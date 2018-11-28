package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;



public class DBConnection  {
	
	public static Connection conn;
	public static String url="jdbc:sqlserver://ABC-PC\\SQLEXPRESS:1433;databaseName=Test;integratedSecurity=true";
	
	public static void main(String args[]) {
		
		
		DBConnection db=new DBConnection();
			List<Student> s=	(ArrayList)db.getAllStudents();
			if(s==null)
				System.out.println("empty list returned");	
			else {
				
				for(Student a:s)
				 System.out.println(a);
								
					
				}
			
				
		//if(con==null)
		//	System.out.println("connect nt established");
		
		
	}
	
	
	public static Connection getConnection() {
		//String url="jdbc:sqlserver://ABC-PC\\SQLEXPRESS:1433;databaseName=Test;integratedSecurity=true";
		//Connection conn=null;
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 conn=DriverManager.getConnection(url,"abc-PC\\Home","");
		} 
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
		
		public List<Student> getAllStudents(){
			
			String query="select * from students";
			List <Student> students= new ArrayList<Student>();
			try
			(
					Connection con=getConnection();
					Statement stmnt=con.createStatement();
					ResultSet rs=stmnt.executeQuery(query);

					)
			{
				
				while(rs.next()) {
									
					int id=rs.getInt("id");
				String first=rs.getString("fname");
				String last =rs.getString("lname");
				Student s=new Student(id,first,last);
				
				students.add(s);

				}
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
				System.out.println("Bad query");
			}
			
			return students;
			
		}
	

}
