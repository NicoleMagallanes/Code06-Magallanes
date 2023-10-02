package com.example.code06magallanes.model;

import java.sql.*;

import jakarta.servlet.ServletConfig;

import com.example.code06magallanes.helper.DBUtility;

public class StudentBean {
	String name, studentID, remarks;
	double midterm, prefinal, finalGrade;
	ServletConfig config;
	
	public StudentBean() {}
	
	public StudentBean(ServletConfig config) {
		this.config = config;
	}
	public StudentBean(String name, String studentID, double midterm, double prefinal, ServletConfig config) {
		this.name = name;
		this.studentID = studentID;
		this.midterm = midterm;
		this.prefinal = prefinal;
		this.config = config;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public double getMidterm() {
		return midterm;
	}

	public void setMidterm(double midterm) {
		this.midterm = midterm;
	}

	public double getPrefinal() {
		return prefinal;
	}

	public void setPrefinal(double prefinal) {
		this.prefinal = prefinal;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
	}
	
	public void computeFinalGrade() {
		this.finalGrade = (0.5*this.midterm)+(0.5*this.prefinal);
	}
	
	public void determineRemarks() {
		this.remarks = (this.finalGrade < 60) ? "Failed!" : "Passed!";
	}
	
	public Connection getConnection() {
		Connection connect = null;
		System.out.println(this.config.getInitParameter("jdbcDriver"));
		try {
			Class.forName(this.config.getInitParameter("jdbcDriver"));
			//Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(
					this.config.getInitParameter("jdbcURL"),
					this.config.getInitParameter("username"),
					this.config.getInitParameter("password"));
			
			//create table if not exist
		} catch(ClassNotFoundException cnfe) {
			System.out.println("Class not found");
			System.err.println(cnfe.getMessage());
		} catch(SQLException sqle) {
			System.out.println("SQLE");
			System.err.println(sqle.getMessage());
		}
		
		return connect;
	}
	
	public boolean isRecordInserted() {
		Connection connect = getConnection();
		boolean isValid = false;
		
		if(connect != null) {
			try {
				PreparedStatement pstmt = connect.prepareStatement(DBUtility.INSERT_RECORD);
				
				pstmt.setString(1, this.name);
				pstmt.setString(2, this.studentID);
				pstmt.setDouble(3, this.midterm);
				pstmt.setDouble(4, this.prefinal);
				pstmt.setDouble(5, this.finalGrade);
				pstmt.setString(6, this.remarks);
				pstmt.setInt(7, 0);
				
				pstmt.executeUpdate();
				isValid = true;
			} catch(SQLException sqle) {
				System.err.println(sqle.getMessage());
			}
		} else {
			System.out.println("Connected Object not Created.");
		}
		
		return isValid;
	}
	
	public ResultSet getAllRecords() {
		ResultSet rs = null;
		
		Connection connect = getConnection();
		
		if(connect != null) {
			// connection established
			try {
				PreparedStatement pstmt = connect.prepareStatement(DBUtility.SELECT_ALL);
				
				rs = pstmt.executeQuery();
			
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
			}
			
		} else {
			System.out.println("Connection Object NOT Created");
		}
		
		return rs;
	}
	
	public boolean isRecordDeleted(int id) {
		Connection connect = getConnection();
		boolean isValid = false;
		
		if(connect != null) {
			try {
				PreparedStatement pstmt = connect.prepareStatement(DBUtility.DELETE_RECORD);
				
				pstmt.setInt(1, id);
				
				pstmt.executeUpdate();
				isValid = true;
			} catch(SQLException sqle) {
				System.err.println(sqle.getMessage());
			}
		} else {
			System.out.println("Connected Object not Created.");
		}
		
		return isValid;
	}
}
