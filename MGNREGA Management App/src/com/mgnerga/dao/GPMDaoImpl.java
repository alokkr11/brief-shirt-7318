package com.mgnerga.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
			
			ResultSet rs= statement.executeQuery("select * from GMP where email='"+email+"' AND password ='"+password+"' ");
			if ( rs.next()) {
				System.out.println("welcome.....");
				System.out.println("Gram Panchayet member");
				
				gmpfun();
				
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
			gmpfun();
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
				System.out.println("Age :- "+rs.getInt("totalEmployee"));
				
				
				
				System.out.println("------------------------------------");
				
			}
			
			bdofun();
			
			}catch (Exception e) {	
				System.out.println(e);
			}
		
	}
		
	

	@Override
	public void assignProject() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wagesAndWorkdays() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
