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
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

/**
 * Servlet implementation class dropdown
 */
public class dropdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dropdown() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getParameter("action");
		if(action.equals("test"))
		{
			getTest(request,response);
		}
		if(action.equals("country"))
		{
			getCountry(request,response);
		}
		else if(action.equals("state"))
		{
			getState(request,response );
		}
		else if(action.equals("city"))
		{
			getCity(request,response );
		}
		else if(action.equals("secu_ques"))
		{
			getSecurity_ques(request,response );
		}
	}

		private void getTest(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Connection con =null;
		Statement st=null;
		ResultSet rs=null;
		con=conn.getMyconnection();
		try {
			PrintWriter pw=response.getWriter();
			response.setContentType("text/xml");
			st=con.createStatement();
			String query="select * from test";
			rs=st.executeQuery(query);
			pw.print("<test>");
			while(rs.next())
			{
				pw.print("<test_child>");
				pw.print("<test_id>"+rs.getString(1)+"</test_id>");
				pw.print("<test_name>"+rs.getString(2)+"</test_name>");
				pw.print("</test_child>");
				
			}
			pw.print("</test>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	private void getSecurity_ques(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Connection con =null;
		Statement st=null;
		ResultSet rs=null;
		con=conn.getMyconnection();
		try {
			PrintWriter pw=response.getWriter();
			response.setContentType("text/xml");
			st=con.createStatement();
			String query="select * from Security_ques";
			rs=st.executeQuery(query);
			pw.print("<Security_ques>");
			while(rs.next())
			{
				pw.print("<Security_ques_child>");
				pw.print("<ques_id>"+rs.getString(1)+"</ques_id>");
				pw.print("<ques_name>"+rs.getString(2)+"</ques_name>");
				pw.print("</Security_ques_child>");
				
			}
			pw.print("</Security_ques>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getCity(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String sid=request.getParameter("StateId");
		Connection con =null;
		Statement st=null;
		ResultSet rs=null;
		con=conn.getMyconnection();
		try {
			PrintWriter pw=response.getWriter();
			response.setContentType("text/xml");
			st=con.createStatement();
			String query="select * from city where state_id='"+sid+"'";
			rs=st.executeQuery(query);
			pw.print("<city>");
			while(rs.next())
			{
				pw.print("<city_child>");
				pw.print("<city_id>"+rs.getString(1)+"</city_id>");
				pw.print("<city_name>"+rs.getString(2)+"</city_name>");
				pw.print("</city_child>");
				
			}
			pw.print("</city>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void getState(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cid=request.getParameter("CountryId");
		Connection con =null;
		Statement st=null;
		ResultSet rs=null;
		con=conn.getMyconnection();
		try {
			PrintWriter pw=response.getWriter();
			response.setContentType("text/xml");
			st=con.createStatement();
			String query="select * from state where country_id='"+cid+"'";
			rs=st.executeQuery(query);
			pw.print("<state>");
			while(rs.next())
			{
				pw.print("<state_child>");
				pw.print("<state_id>"+rs.getString(1)+"</state_id>");
				pw.print("<state_name>"+rs.getString(2)+"</state_name>");
				pw.print("</state_child>");
				
			}
			pw.print("</state>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void getCountry(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Connection con =null;
		Statement st=null;
		ResultSet rs=null;
		con=conn.getMyconnection();
		try {
			PrintWriter pw=response.getWriter();
			response.setContentType("text/xml");
			st=con.createStatement();
			String query="select * from country";
			rs=st.executeQuery(query);
			pw.print("<country>");
			while(rs.next())
			{
				pw.print("<country_child>");
				pw.print("<country_id>"+rs.getString(1)+"</country_id>");
				pw.print("<country_name>"+rs.getString(2)+"</country_name>");
				pw.print("</country_child>");
				
			}
			pw.print("</country>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
