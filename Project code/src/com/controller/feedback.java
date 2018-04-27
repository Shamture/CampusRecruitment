package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.conn;

/**
 * Servlet implementation class feedback
 */
public class feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public feedback() {
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
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String fid=null;
		String desc=request.getParameter("desc");
		String rating=request.getParameter("Rating");
		con=conn.getMyconnection();
		try {
			st=con.createStatement();
			String q1="select count(*)+1 from feedback ";
			rs=st.executeQuery(q1);
			if(rs.next())
			{
				fid=rs.getString(1);
			}
			String query="insert into feedback values('"+fid+"','"+desc+"',Sysdate,'"+rating+"','"+uname+"')";
			rs=st.executeQuery(query);
			System.out.println("q is:::"+query);
			
			
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
