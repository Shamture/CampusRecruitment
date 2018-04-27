package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.conn;

/**
 * Servlet implementation class AdminValidation
 */
public class AdminValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con =null;
		java.sql.Statement st=null;
		ResultSet rs=null;
		String s1=null;
		String s2=null;
		con=conn.getMyconnection();
		String login=request.getParameter("log");
		String pwd=request.getParameter("pwd");
		try {
			st=con.createStatement();
			ResourceBundle rb=ResourceBundle.getBundle("com.model.Admin");
			s1=rb.getString("username");
			s2=rb.getString("password");
			System.out.println(s1);
			System.out.println(s2);
			if((login.equals(s1))&&(pwd.equals(s2)))
			{
				RequestDispatcher rd=request.getRequestDispatcher("CompanyProfile.html");
				rd.forward(request,response);
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
