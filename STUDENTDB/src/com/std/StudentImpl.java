package com.std;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentImpl implements Student{

	Scanner scan = new Scanner(System.in);

	@Override
	public void addStudent() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement ps = connection.prepareStatement("insert into student values(?,?,?,?)");
			System.out.println("Enter student id:");
			ps.setInt(1, scan.nextInt());

			System.out.println("Enter student name");
			ps.setString(2,  scan.next());

			System.out.println("Enter student age");
			ps.setInt(3, scan.nextInt());

			System.out.println("Enter Student marks");
			ps.setInt(4, scan.nextInt());

			ps.execute();
			System.out.println("Data Saved");
			System.out.println("----------------------------");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent() {

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement ps = connection.prepareStatement("delete from  student where id=?");

			System.out.println("Enter Student ID to delete");
			ps.setInt(1,scan.nextInt());

			ps.execute();

			System.out.println("Student Deleted");
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent() {

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement ps = connection.prepareStatement("update student set marks=? where id=?");
			
			System.out.println("Enter Student Id");
			ps.setInt(2, scan.nextInt());
			
			System.out.println("Enter Student marks");
			ps.setInt(1, scan.nextInt());
			
						
			
			
			ps.execute();
			
			System.out.println("Student Updated");
		
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getAllStudent() {

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			
			PreparedStatement ps = connection.prepareStatement("select * from student where id=?");
			System.out.println("Enter Student Id:");
			ps.setInt(1, scan.nextInt());
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next())
			{
				System.out.println("Student id is: "+rs.getInt(1));
				System.out.println("Student name is: "+rs.getString(2));
				System.out.println("Student age is: "+rs.getInt(3));
				System.out.println("Student marks is: "+rs.getInt(4));
			}
			System.out.println("--------------------------------------------");
			//ps.execute();
			
			
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getStudentByMarks() {

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
            
			PreparedStatement ps = connection.prepareStatement("Select * from student where marks>=?");
			System.out.println("Enter Student Marks:");
			ps.setInt(1, scan.nextInt());
			ResultSet rs = ps.executeQuery();

			
            
            
            while(rs.next())
            {
            	System.out.println("Student id is: "+rs.getInt(1));
            	System.out.println("Student name is: "+rs.getString(2));
            	System.out.println("Student Age is: "+rs.getInt(3));
            	System.out.println("Student marks is: "+rs.getInt(4));
            }
            ps.execute();
            
            
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
