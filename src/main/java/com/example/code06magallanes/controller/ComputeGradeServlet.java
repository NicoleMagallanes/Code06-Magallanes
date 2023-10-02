package com.example.code06magallanes.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.code06magallanes.model.StudentBean;
/**
 * Servlet implementation class ComputeGradeServlet
 */
//@WebServlet("/computegrade.action")
public class ComputeGradeServlet extends HttpServlet {
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
		
		StudentBean student = new StudentBean(name,studentID,midterm,prefinal,config);
		
		student.computeFinalGrade();
		student.determineRemarks();
		
		if(student.isRecordInserted()) {
			request.setAttribute("estudyante", student);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("result.jsp");
			dispatch.forward(request, response);
		} else {
			//TODO
		}
	}

}
