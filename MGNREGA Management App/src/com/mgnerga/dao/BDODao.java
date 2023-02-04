package com.mgnerga.dao;

import java.sql.SQLException;

public interface BDODao {

	public void BDOLogin() throws SQLException;

	public void createGMP() throws SQLException;

	public void showGMP() throws SQLException;

	public void createProject() throws SQLException;

	public void showAllProject() throws SQLException;

}
