package com.example.code06magallanes.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.code06magallanes.model.StudentBean;
/**
 * Servlet implementation class DeleteRecordServlet
 */
//@WebServlet("/deleterecord.action")
public class DeleteRecordServlet extends HttpServlet {
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
		// TODO Auto-generated method stub
		if(new StudentBean(getServletConfig()).isRecordDeleted(Integer.parseInt(request.getParameter("recordId")))) {
			response.sendRedirect( request.getContextPath() + "/displayrecords.action");
		} else {
			// TODO -> display that the record is not deleted
		}
	}

}
