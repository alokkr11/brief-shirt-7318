package com.mgnerga.dao;

import java.sql.SQLException;

public interface GPMDao {
	
	public void GPMLogin() throws SQLException;
	
	public void createEmployee() throws SQLException;
	
	public void viewEmployee() throws SQLException;
	
	public void assignProject() throws SQLException;
	
	public void wagesAndWorkdays() throws SQLException;
	
	
}
//1.Login into their Account.
//2. Create Employee.
//3. View the Details of Employee.
//4. Assign Employee to a Project.
//5. View total number of days Employee worked in a project and also their wages.
