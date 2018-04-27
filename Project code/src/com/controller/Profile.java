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

import com.model.conn;

/**
 * Servlet implementation class Profile
 */
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String id=null;
		String cname=request.getParameter("cname");
		String desc=request.getParameter("desc");
		String elig=request.getParameter("elig");
		String back=request.getParameter("back");
		String url=request.getParameter("url");
		String date=request.getParameter("date");
		String hdate=Dateparsing.gettingDate(date);
		con=conn.getMyconnection();
		try {
			st=con.createStatement();
			
			String query="select count(*)+1 from company_details";
			rs=st.executeQuery(query);
			if(rs.next())
			{
				id=rs.getString(1);
			}
			String qry1="insert into company_details values('"+id+"','"+cname+"','"+desc+"','"+elig+"','"+url+"','"+back+"','"+hdate+"')";
			System.out.println("q is"+qry1);
			int n=st.executeUpdate(qry1);
			if(n>0)
			{
				System.out.println("rows inserted");
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
		doGet(request, response);
	}

}
