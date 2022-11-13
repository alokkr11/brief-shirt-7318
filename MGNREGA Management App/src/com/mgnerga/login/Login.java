package com.mgnerga.login;

import java.sql.SQLException;
import java.util.Scanner;

import com.mgnerga.dao.BDODao;
import com.mgnerga.dao.BDODaoImpl;
import com.mgnerga.dao.GPMDao;
import com.mgnerga.dao.GPMDaoImpl;

public class Login {
	
	Scanner sc=new Scanner(System.in);
	
	GPMDao gpm=new GPMDaoImpl();
	BDODao bdo=new BDODaoImpl();
	
	public void login_choice() throws SQLException{
		
		System.out.println("Welcome to MGNREGA Management App... \n"
				+ "1. BDO Login \n"
				+ "2. GPM Login \n"
				+ "3. Exit");
		System.out.println("Choose the appropriate option");
		
		int x=sc.nextInt();
		
		
		switch (x) {
		case 1: {
			
			bdo.BDOLogin();
			break;
		}
		case 2:{
			gpm.GPMLogin();
			break;
		}
		
		default:
			System.out.println("Wrong option..Try again \n");
			login_choice();
			break;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
	Login login =new Login();

	
	try {
		login.login_choice();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
}
