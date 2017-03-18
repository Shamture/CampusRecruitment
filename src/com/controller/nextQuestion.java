package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import com.model.conn;

/**
 * Servlet implementation class nextQuesstion
 */
public class nextQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	static int marks=0;
	
	
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
    public nextQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		/*HttpSession session=request.getSession();
		ArrayList al=(ArrayList)session.getAttribute("Questions");
		HashMap hm=(HashMap)al.get(index);
		PrintWriter pw=response.getWriter();
		 pw.println(hm.get("Q1")+"<br>");
		 pw.println("<input type='radio' name='a1'>"+hm.get("o1")+"<br>");
		 pw.println("<input type='radio' name='a1'>"+hm.get("o2")+"<br>");
		 pw.println("<input type='radio' name='a1'>"+hm.get("o3")+"<br>");
		 pw.println("<input type='radio' name='a1'>"+hm.get("o4")+"<br>");
		 pw.println("<br><br><input type='button' value='Prevoius'><br><br><input type='button' value='next' ondbclick='getnext(<%=i%>)' /> ");
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses=request.getSession(false);
		String tid=(String) ses.getAttribute("tid");
		String uname=(String) ses.getAttribute("uname");
		con=conn.getMyconnection();
	
		String i=request.getParameter("id");
		System.out.println("id in next...."+i);
		String q=request.getParameter("qname");
		System.out.println("question in next...."+q);
		String a=request.getParameter("a1");
		System.out.println("answer in next...."+a);
		String t=request.getParameter("test");
		System.out.println("testname in next...."+t);
		String grade=null;
		
			
		
		
		try {
			
			st=con.createStatement();
			String qry="select CORRECT_ANSWER from options where QUES_ID='"+i+"'";
			System.out.println(qry);
			rs=st.executeQuery(qry);
			if(rs.next())
			{
				String correctans=rs.getString(1);
				System.out.println(correctans);
				if(a.equalsIgnoreCase(correctans))
				{
					marks++;
				}
				else
				{
					System.out.println("wrong answer");
				}
				System.out.println("total"+marks);
				
			}
			st=con.createStatement();
			String q1="select count(*)+1 from grades";
			rs=st.executeQuery(q1);
			String gid=null;
			if(rs.next())
			{
				gid=rs.getString(1);
				
			}
			String qry1="insert into grades values ('"+gid+"','"+marks+"','"+tid+"','"+uname+"')";
			System.out.println(qry1);
			int u=st.executeUpdate(qry1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("Sample.jsp?id="+i);
	}

}
