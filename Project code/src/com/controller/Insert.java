package com.controller;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.conn;

/**
 * Servlet implementation class Insert
 */
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pgrid=null;
		String ugrid=null;
		String sscid=null;
		String iid=null;
		String pgcheck=request.getParameter("pgcheck");
		Connection con =null;
		java.sql.Statement st=null;
		ResultSet rs=null;
		con=conn.getMyconnection();
		String pcol=request.getParameter("pg_col");
		String puni=request.getParameter("pg_univ");
		String pagg=request.getParameter("pg_per");
		String pbranch=request.getParameter("pg_branch");
		String pcou=request.getParameter("pg_cou");
		
		String gcol=request.getParameter("ug_col");
		String guni=request.getParameter("ug_univ");
		String gagg=request.getParameter("ug_per");
		String gbranch=request.getParameter("ug_branch");
		String gcou=request.getParameter("ug_cou");
		
		String iname=request.getParameter("inter_col");
		String istr=request.getParameter("stream");
		String iboard=request.getParameter("inter_board");
		String iagg=request.getParameter("inter_per");
		
		String sname=request.getParameter("schl_name");
		String sboard=request.getParameter("tenth_board");
		String sagg=request.getParameter("tenth_per");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String gender=request.getParameter("gender");
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		String dob=request.getParameter("dob");
		String dateofb=Dateparsing.gettingDate(dob);
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String sec_ques=request.getParameter("sec_ques");
		String sec_ans=request.getParameter("sec_ans");
		String roll=request.getParameter("roll");
		String back=request.getParameter("back");
		if(pgcheck=="")
		{
			System.out.println("pg not selected");
		}
		else
		{
		try {
			st=con.createStatement();
			String pgid="select count(*)+1 from pg";
			System.out.println(pgid);
			rs=st.executeQuery(pgid);
			if(rs.next())
			{
				pgrid=rs.getString(1);
				System.out.println("in for loop");
			}
			st=con.createStatement();
			String query="insert into pg values('"+pgrid+"','"+pcou+"','"+pcol+"','"+puni+"','"+pagg+"','"+pbranch+"')";
			System.out.println("Q1:::::::::::::"+query);
			int n=st.executeUpdate(query);
			if(n>0)
			{
				System.out.println("rows inserted");
				
			}
			
			
		}
		
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		try
		{
			st=con.createStatement();
			String ugid="select count(*)+1 from graduation";
			rs=st.executeQuery(ugid);
			if(rs.next())
			{
				ugrid=rs.getString(1);
			}
		String query1="insert into graduation values('"+ugrid+"','"+gcou+"','"+gcol+"','"+guni+"','"+gagg+"','"+gbranch+"')";
		System.out.println("Q2:::::::::::::"+query1);
		int n=st.executeUpdate(query1);
		if(n>0)
		{
			System.out.println("rows inserted");
		}
		
		
	}
	
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		try
		{
			st=con.createStatement();
			String inid="select count(*)+1 from intermediate";
			rs=st.executeQuery(inid);
			if(rs.next())
			{
				iid=rs.getString(1);
			}
		String query2="insert into intermediate values('"+iid+"','"+iname+"','"+iboard+"','"+istr+"','"+iagg+"')";
		System.out.println("Q3:::::::::::::"+query2);
		int n=st.executeUpdate(query2);
		if(n>0)
		{
			System.out.println("rows inserted");
		}
		
		
	}
	
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		try{
			st=con.createStatement();
			String sid="select count(*)+1 from ssc";
			rs=st.executeQuery(sid);
			if(rs.next())
			{
				sscid=rs.getString(1);
			}
			String query3="insert into SSC values('"+sscid+"','"+sname+"','"+sboard+"','"+sagg+"')";
			System.out.println("Q4:::::::::::::"+query3);
			int n=st.executeUpdate(query3);
			if(n>0)
			{
				System.out.println("rows inserted");
			}
			
			
		}
		
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try
			{
				st=con.createStatement();
				String query4="insert into student_det values('"+fname+"','"+lname+"','"+username+"','"+pwd+"','"+email+"','"+mobile+"','"+address+"','"+dateofb+"','"+sec_ans+"','"+city+"','"+sec_ques+"','"+sscid+"','"+iid+"','"+pgrid+"','"+ugrid+"','"+gender+"','"+roll+"','"+back+"')";
				System.out.println("Q5:::::::::::::"+query4);
				int n=st.executeUpdate(query4);
				if(n>0)
				{
					System.out.println("rows inserted");
					RequestDispatcher rd=request.getRequestDispatcher("Login.html");
					rd.forward(request, response);
				}
			
				
				
			}
			
				catch (SQLException e) {
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
