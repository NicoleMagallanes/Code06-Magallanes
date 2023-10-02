package com.example.code06magallanes.controller;

import java.sql.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.code06magallanes.model.StudentBean;

/**
 * Servlet implementation class DisplayRecords
 */
//@WebServlet("/displayrecords.action")
public class DisplayRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResultSet rs = new StudentBean(getServletConfig()).getAllRecords();
		
		System.out.println((rs!=null)?"valid records":"records null");
		
		request.setAttribute("records", rs); // data binding and aliasing
		request.getRequestDispatcher("listrecords.jsp").forward(request, response);
		
	}

}
