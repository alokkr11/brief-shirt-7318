package com.mgnerga.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

import com.mgnerga.login.Login;
import com.mgnrega.util.DBUtil;

public class GPMDaoImpl implements GPMDao {
	
	DBUtil db=new DBUtil();
	Connection con= db.provideConnection();
	
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void GPMLogin() throws SQLException {
		try {
			
			Statement statement =con.createStatement();
			
			System.out.println("Enter Email id : ");
			String email=sc.next();
			
			System.out.println("Enter password : ");
			String password=sc.next();
			
			ResultSet rs= statement.executeQuery("select * from gpm where email='"+email+"' AND password ='"+password+"' ");
			if ( rs.next()) {
				System.out.println("welcome.....");
				System.out.println("Gram Panchayet member");
				
				gpmfun();
				
			}else {
				System.out.println("Email/Password is incorrect");
				Login l=new Login();
				l.login_choice();
			}
			}catch (Exception e) {	
				System.out.println(e);
			}
		
	}

	@Override
	public void createEmployee() throws SQLException {
		try {
			Statement statement = con.createStatement();
			sc.nextLine();

			System.out.println("Enter name:");
			String name = sc.nextLine();
			System.out.println("Enter email:");
			String email = sc.nextLine();
			System.out.println("Enter password:");
			String password = sc.nextLine();
			System.out.println("Enter area:");
			String area = sc.nextLine();
			System.out.println("Enter pincode:");
			int pincode = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter age:");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter GPM id");
			int id = sc.nextInt();

			statement.execute("insert into Employee (ename,email,password,area,pincode,age,gid)" +
					"values('" + name + "','" + email + "','" + password + "','" + area + "','" + pincode + "','" + age + "','" + id + "')");
			System.out.println("Done");
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error is:" + e.getMessage());
		} finally {
			try {
				gpmfun();
			} catch (ParseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	 public void gpmfun() throws ParseException, IOException {
			
			System.out.print("1.Create Employee \n"
					+ "2.View the Details of Employee \n"
					+ "3.Assign Employee to a Project \n"
					+ "4.total number of days Employee \n"
					+ "5. Exit");
			System.out.println();
			System.out.println("Choose an appropriate option");
			int x=sc.nextInt();
			
			switch (x) {
			case 1: {
				
				try {
					createEmployee();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			case 2:{
				try {
					viewEmployee();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
//			case 3:{
//				try {
//					
//				} catch (SQLException e) {
//					System.out.println(e.getMessage()); 
//				}
//			}
//			case 4:{
//				    try {
//						
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//			}
			case 5:{
				System.out.println("Thank You");
				Login l=new Login();
				try {
					l.login_choice();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + x);
			}
			
		}
	  

	@Override
	public void viewEmployee() throws SQLException {
		try {
			
			Statement statement =con.createStatement();
			
			ResultSet rs= statement.executeQuery("select * from employee");
			
			
			
			while ( rs.next()) {
				System.out.println("-----------------------------------");
				System.out.println("Employee id :- "+rs.getInt("empid"));
				System.out.println("Employee name :- "+rs.getString("ename"));
				System.out.println("Email id :- "+rs.getString("email"));
				System.out.println("Password :- "+rs.getString("email"));
				System.out.println("Area/Village :- "+rs.getString("area"));
				System.out.println("PinCode :- "+rs.getString("pincode"));
				System.out.println("Age :- "+rs.getInt("age"));
				
				
				
				System.out.println("------------------------------------");
				
			}
			
			gpmfun();
			
			}catch (Exception e) {	
				System.out.println(e);
			}
		
	}
		
	

//	@Override
//	public void assignProject() throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void wagesAndWorkdays() throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}

}
