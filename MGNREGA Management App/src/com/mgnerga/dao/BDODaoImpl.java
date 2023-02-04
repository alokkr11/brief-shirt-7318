package com.mgnerga.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mgnerga.login.Login;
import com.mgnrega.util.DBUtil;

public class BDODaoImpl implements BDODao {

	DBUtil db = new DBUtil();
	Connection con = DBUtil.provideConnection();

	Scanner sc = new Scanner(System.in);

	@Override
	public void BDOLogin() throws SQLException {

		try {

			Statement statement = con.createStatement();

			System.out.println("Enter Email id : ");
			String email = sc.next();

			System.out.println("Enter password : ");
			String password = sc.next();

			ResultSet rs = statement
					.executeQuery("select * from BDO where email='" + email + "' AND password ='" + password + "' ");
			if (rs.next()) {
				System.out.println("welcome.....");
				System.out.println("Block Development Officer");

				bdofun();

			} else {
				System.out.println("Email/Password is incorrect");
				Login l = new Login();
				l.login_choice();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void createGMP() throws SQLException {

		try {

			Statement statement = con.createStatement();
			sc.nextLine();

			System.out.println("Enter name:");
			String gname = sc.nextLine();
			System.out.println("Enter email id:");
			String email = sc.nextLine();
			System.out.println("Enter Password:");
			String password = sc.nextLine();
			System.out.println("Enter Area:");
			String area = sc.nextLine();
			System.out.println("Enter PinCode:");
			int pincode = sc.nextInt();
			System.out.println("Enter BDO id:");
			int bid = sc.nextInt();

			statement.execute("insert into gpm (gname, email, password, area, pincode, bId) " + "values('" + gname
					+ "','" + email + "','" + password + "','" + area + "','" + pincode + "','" + bid + "')");

			System.out.println("GPM added successfully.....");
			System.out.println("GPM Email: " + email + "\n" + "password" + password);
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bdofun();
		}
	}

	public void bdofun() {

		System.out.print("1.Create Gpm \n" + "2.Create Project \n" + "3.View all Projects \n" + "4.View all the GPM.\n"
				+ "5. Exit");
		System.out.println();
		System.out.println("Choose an appropriate option");
		int x = sc.nextInt();

		switch (x) {
		case 1: {

			try {
				createGMP();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;
		}
		case 2: {
			try {
				createProject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		case 3: {
			try {
				showAllProject();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 4: {
			try {
				showGMP();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		case 5: {
			System.out.println("Thank You");
			Login l = new Login();
			try {
				l.login_choice();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + x);
		}

	}

	@Override
	public void showGMP() throws SQLException {

		try {

			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("select * from gpm");

			while (rs.next()) {
				System.out.println("-----------------------------------");
				System.out.println("GPM name :- " + rs.getString("gname"));
				System.out.println("GPM Emaail id :- " + rs.getString("email"));
				System.out.println("GPM Password :- " + rs.getString("password"));
				System.out.println("Area :- " + rs.getString("area"));
				System.out.println("Pincode :- " + rs.getString("pincode"));
				System.out.println("BDO ID :- " + rs.getInt("bid"));

				System.out.println("------------------------------------");

			}
			bdofun();
		} catch (Exception e) {
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
			statement.executeUpdate(
					"insert into Project(projectName,area,pincode,totalEmployee,estimatedCost,startDate,endDate)"
							+ "values('" + name + "','" + area + "','" + pincode + "','" + totalmembers + "','" + cost
							+ "','" + startdate + "','" + enddate + "')");

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

			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("select * from project");

			while (rs.next()) {
				System.out.println("-----------------------------------");
				System.out.println("Project id :- " + rs.getInt("pid"));
				System.out.println("Project name :- " + rs.getString("projectName"));
				System.out.println("Area :- " + rs.getString("area"));
				System.out.println("PinCode :- " + rs.getString("pincode"));
				System.out.println("Total member :- " + rs.getInt("totalEmployee"));
				System.out.println("Estimated cost :- " + rs.getInt("estimatedCost"));
				System.out.println("Project Start date :- " + rs.getString("startDate"));
				System.out.println("Project End_date :- " + rs.getString("endDate"));

				System.out.println("------------------------------------");

			}

			bdofun();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
