package com.std;

import java.util.Scanner;

public interface MainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student student = new StudentImpl();
		while(true)
		{
			System.out.println("Enter your choice"
					+ "\n1.Add student"
					+ "\n2.Delete Student"
					+ "\n3.Update Student"
					+ "\n4.Get student details based on marks"
					+ "\n5.Get all Student details");
			
			int ch = scan.nextInt();
			
			switch(ch)
			{
			case 1:
				student.addStudent();
				break;
			
			case 2:
				student.deleteStudent();
				break;
			
			case 3:
				student.updateStudent();
				break;
				
			case 4:
				student.getStudentByMarks();
				break;
				
			case 5:
				student.getAllStudent();
				break;
				
			default: 
				System.out.println("Invalid chouce!!");
				
				
			}
		}
	}
}
