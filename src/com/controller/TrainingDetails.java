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
 * Servlet implementation class TrainingDetails
 */
public class TrainingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingDetails() {
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
		String com_name=request.getParameter("company");
		String tdat=request.getParameter("tdate");
		String tdate=Dateparsing.gettingDate(tdat);
		String days=request.getParameter("days");
		String timings=request.getParameter("timings");
		String venue=request.getParameter("venue");
		con=conn.getMyconnection();
		try {
			st=con.createStatement();
			String q1="select count(*)+1 from training";
			rs=st.executeQuery(q1);
			if(rs.next())
			{
				id=rs.getString(1);
			}
			String q="insert into training values('"+id+"','"+com_name+"','"+tdate+"','"+days+"','"+timings+"','"+venue+"')";
			System.out.println("q is"+q);
			int n=st.executeUpdate(q);
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
	}

}
