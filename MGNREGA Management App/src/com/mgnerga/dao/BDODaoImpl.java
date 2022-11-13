package com.mgnerga.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mgnrega.util.DBUtil;


public class BDODaoImpl implements BDODao {

	DBUtil db=new DBUtil();
	Connection con= db.provideConnection();
	
	
	Scanner sc= new Scanner(System.in);
	
	@Override
	public void BDOLogin() throws SQLException {
		
		try {
			
			Statement statement =con.createStatement();
			
			System.out.println("Enter Email id : ");
			String email=sc.next();
			
			System.out.println("Enter password : ");
			String password=sc.next();
			
			ResultSet rs= statement.executeQuery("select * from BDO where email='"+email+"' AND password ='"+password+"' ");
			if ( rs.next()) {
				System.out.println("welcome.....");
				System.out.println("Block Development Officer");
				
				bdofun();
				
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
	public void createGMP() throws SQLException {
		
			
			try {
				
				Statement statement =con.createStatement();
				sc.nextLine();
				
				System.out.println("Enter name:");
				String gname=sc.nextLine();
				System.out.println("Enter email id:");
				String email=sc.nextLine();
				System.out.println("Enter Password:");
				String password=sc.nextLine();
				System.out.println("Enter Area:");
				String area=sc.nextLine();
				System.out.println("Enter PinCode:");
				int pincode=sc.nextInt();
				System.out.println("Enter BDO id:");
				int bid=sc.nextInt();
				
				statement.execute("insert into gmp (gname, email, password, area, pincode, bId) " +
						"values('" + gname + "','" + email+ "','" + password + "','" + area + "','" + pincode + "','" + bid + "')");
				System.out.println("Done");
				statement.close();
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				bdofun();
			}
	}

	@Override
	public void showGMP() throws SQLException {
		
		try {
			
			Statement statement =con.createStatement();
			
			ResultSet rs= statement.executeQuery("select * from gmp");
			
			while ( rs.next()) {
				System.out.println("-----------------------------------");
				System.out.println("GMP name :- "+rs.getString("gname"));
				System.out.println("GMP Emaail id :- "+rs.getString("email"));
				System.out.println("GMP Password :- "+rs.getString("password"));
				System.out.println("Area :- "+rs.getString("area"));
				System.out.println("Pincode :- "+rs.getString("pincode"));
				System.out.println("BDO ID :- "+rs.getInt("bid"));
				
				
				System.out.println("------------------------------------");
				
				
			}
			bdofun();
			}catch (Exception e) {	
				System.out.println(e);
			}
		
	}

	@Override
	public void createProject() throws SQLException {
		try {
			Statement statement = con.createStatement();
			sc.nextLine();

			System.out.println("Enter project name:");
			String name = sc.nextLine();
			System.out.println("Enter area:");
			String area = sc.nextLine();
			System.out.println("Enter pincode:");
			int pincode = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter total members:");
			int totalmembers = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter estimated cost:");
			int cost = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter start date in the form YYYY-MM-DD :");
			String startdate = sc.nextLine();
            
			System.out.println("Enter end date in the form YYYY-MM-DD :");
			String enddate = sc.nextLine();
			statement.executeUpdate("insert into Project(projectName,area,pincode,totalEmployee,estimatedCost,startDate,endDate)" +
					"values('" + name + "','" + area + "','" + pincode + "','" + totalmembers + "','" + cost + "','" + startdate + "','" + enddate + "')");

			System.out.println("Done");
			statement.close();

		} catch (SQLException e) {
			System.out.println("Error is:" + e.getMessage());
		} finally {
			bdofun();
		}
		
	}

	@Override
	public void showAllProject() throws SQLException {
		try {
			
			Statement statement =con.createStatement();
			
			ResultSet rs= statement.executeQuery("select * from project");
			
			
			
			while ( rs.next()) {
				System.out.println("-----------------------------------");
				System.out.println("Project id :- "+rs.getInt("pid"));
				System.out.println("Project name :- "+rs.getString("projectName"));
				System.out.println("Area :- "+rs.getString("area"));
				System.out.println("PinCode :- "+rs.getString("pincode"));
				System.out.println("Total member :- "+rs.getInt("totalEmployee"));
				System.out.println("Estimated cost :- "+rs.getInt("estimatedCost"));
				System.out.println("Project Start date :- "+rs.getString("startDate"));
				System.out.println("Project End_date :- "+rs.getString("endDate"));
				
				
				System.out.println("------------------------------------");
				
			}
			
			bdofun();
			
			}catch (Exception e) {	
				System.out.println(e);
			}
		
	}

}




