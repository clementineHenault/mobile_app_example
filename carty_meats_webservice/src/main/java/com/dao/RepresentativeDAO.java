package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Representative;

public class RepresentativeDAO {
	public static Connection getConnection() {

	    Connection connection = null;
	    try {
	      //Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager.getConnection(
	    		  "jdbc:mysql://localhost:3306/rep_app", "root", "root");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return connection;
	}
	
	public static Representative checkLogin(String username, String password) {
		Connection connection = getConnection();
	    Representative representative = null ;

	    try {
	      PreparedStatement psmt = connection.prepareStatement("SELECT * FROM representative WHERE username = ? AND password_ = ?");
	      psmt.setString(1, username);
	      psmt.setString(2, password);
	      ResultSet rs = psmt.executeQuery();
	      if (rs.next()) {
	        representative = new Representative(rs.getString("username"), rs.getString("password_"), rs.getBoolean("isAdmin"));
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return representative;
	  }
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}