package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.conn;

/**
 * Servlet implementation class Admitcard
 */
public class Admitcard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admitcard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses=request.getSession(false);
		String uname=(String) ses.getAttribute("uname");

		Connection con =null;
		java.sql.Statement st=null;
		ResultSet rs=null;
		con=conn.getMyconnection();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String ht=request.getParameter("ht");
		String colname=request.getParameter("colname");
		String branch=request.getParameter("branch");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		try {
			st=con.createStatement();
			
			String query="select s.fname,s.lname,s.roll,ug.col_name,ug.branch,s.email_id,s.mobile from student_det s,graduation ug where s.ug_id=ug.ug_id and username='"+uname+"'";
			rs=st.executeQuery(query);
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
