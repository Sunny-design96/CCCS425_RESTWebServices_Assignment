package com.mcgill.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet{
	private Student student;
	
	@Override
	public void init() {
		student = new Student();
	}
	
	private void sendResponse(HttpServletResponse response, String payload) {
		try {
			   OutputStream out = response.getOutputStream();
	            out.write(payload.getBytes());
	            out.flush();
	        } catch (Exception e) {
	        	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            return;
	        }
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		if(id == null || name == null || email == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		int studentId = Integer.parseInt(id);
		Student student = new Student(studentId, name, email);
		String msg = "Student " + student.toString() + " created.";
		sendResponse(response, msg);
		
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
	}
	

}
