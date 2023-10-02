package com.example.code06magallanes.controller;

import com.example.code06magallanes.model.StudentBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;

/**
 * Servlet implementation class ComputeGradeServlet
 */
//@WebServlet("/update.action")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config = null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String studentID = request.getParameter("studentID");
		double midterm = Double.parseDouble(request.getParameter("midtermGrade"));
		double prefinal = Double.parseDouble(request.getParameter("prefinal"));

		ResultSet rs = new StudentBean(getServletConfig()).getRecords(Integer.parseInt(request.getParameter("recordId")));
request.setAttribute("records", rs);
		RequestDispatcher dispatch = request.getRequestDispatcher("update.jsp");
			dispatch.forward(request, response);
	}

}
