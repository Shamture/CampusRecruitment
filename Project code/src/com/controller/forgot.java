package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.conn;

/**
 * Servlet implementation class forgot
 */
public class forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String uname=request.getParameter("uname");
		String seid=request.getParameter("secques");
		String seans=request.getParameter("sec_ans");
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		con=conn.getMyconnection();
		try {
			st=con.createStatement();
			String query="select email_id,password where username='"+uname+"' and sq_id='"+seid+"' security_answer='"+seans+"'";
			rs=st.executeQuery(query);
			if(rs.next())
			{
				Mail.postMail(rs.getString(1), rs.getString(2));
				pw.print("password sent to mail plase check it");
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
