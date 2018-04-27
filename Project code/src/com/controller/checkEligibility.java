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
import javax.servlet.http.HttpSession;

import com.model.conn;

/**
 * Servlet implementation class checkEligibility
 */
public class checkEligibility extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkEligibility() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses=request.getSession(false);
		String uname=(String)ses.getAttribute("uname");
		String id=request.getParameter("action");
		System.out.println("id is"+id);
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		PrintWriter pw=response.getWriter();
		String per=null;
		String per1=null;
		String per2=null;
		String per3=null;
		String per4=null;
		String back=null;
		String cback=null;
		int p=0;
		int p1=0;
		int p2=0;
		int p3=0;
		int p4=0;
		int b1=0;
		int cb=0;
		
		con=conn.getMyconnection();
		
		try {
			st=con.createStatement();
			String query="select eligibility_criteria,back from company_details where com_id='"+id+"'";
			System.out.println("q1 is"+query);
			rs=st.executeQuery(query);
			while(rs.next())
			{
				per=rs.getString(1);
				cback=rs.getString(2);
				
			}
			p=Integer.parseInt(per);
			cb=Integer.parseInt(cback);
			String q1="select s.marks,st.username from ssc s,student_det st where s.schl_id=st.schl_id and st.username='"+uname+"'";
			System.out.println("q2 is"+q1);
			rs=st.executeQuery(q1);
		while(rs.next())
		{
			per1=rs.getString(1);
			

		}
		p1=Integer.parseInt(per1);
			String q2="select i.aggregate,st.username from intermediate i,student_det st where i.col_id=st.col_id and st.username='"+uname+"' " ;
			System.out.println("q3 is"+q2);
			rs=st.executeQuery(q2);
			while(rs.next())
			{
				per2=rs.getString(1);
				
		     
			}
			 p2=Integer.parseInt(per2);
			String q3="select ug.aggregate,st.username from graduation ug,student_det st where ug.ug_id=st.ug_id and st.username='"+uname+"' ";
			System.out.println("q4 is"+q3);
			rs=st.executeQuery(q3);
			while(rs.next())
			{
				per3=rs.getString(1);
				
				
			}
			p3=Integer.parseInt(per3);
			String q4="select p.aggregate,st.username from pg p,student_det st where p.pg_id=st.pg_id and st.username='"+uname+"' ";
			System.out.println("q5 is"+q4);
			rs=st.executeQuery(q4);
			while(rs.next())
			{
				per4=rs.getString(1);
				System.out.println("per4 is"+per4);
						
			}
			String q5="select backlogs from student_det where username='"+uname+"'";
			System.out.println("q6 is"+q5);
			rs=st.executeQuery(q5);
			while(rs.next())
			{
				back=rs.getString(1);
				System.out.println("back is"+per4);
						
			}
			b1=Integer.parseInt(back);
			if(per4.equals("null"))
			{
				System.out.println("nopg");
				System.out.println("p is"+p);
				System.out.println("p1 is"+p1);
				System.out.println("p2 is"+p2);
				System.out.println("p3 is"+p3);

				if((p<=p1)&&(p<=p2)&&(p<=p3)&&(b1<=cb))
				{
					System.out.println("ureligible");
					pw.print("ureligible");

				}
				else
				{
					System.out.println("u r not eligible");
					System.out.println("in else");
					pw.print("u r not eligible");

				}
				
			}
				else
				{
					p4=Integer.parseInt(per4);
					System.out.println("p is"+p);
					System.out.println("p1 is"+p1);
					System.out.println("p2 is"+p2);
					System.out.println("p3 is"+p3);
					System.out.println("p4 is"+p4);
					
					if((p<=p1)&&(p<=p2)&&(p<=p3)&&(p<=p4)&&(b1<=cb))
					{
						System.out.println("in if");
						pw.print("u r eligible");
					}
					else
					{
						System.out.println("u r not eligible");
						System.out.println("in else");
						pw.print("u r not eligible");
					}
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
