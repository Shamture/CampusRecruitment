package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.conn;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		java.sql.Statement st=null;
		ResultSet rs=null;
		con=conn.getMyconnection();
		PrintWriter pw=response.getWriter();
		String pgid=(String)ses.getAttribute("pgid");
		String ugid=(String)ses.getAttribute("ugid");
		String iid=(String)ses.getAttribute("iid");
		String ssid=(String)ses.getAttribute("ssid");
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
		String pwd=request.getParameter("pwd");
		String dob=request.getParameter("dob");
		String dateofb=Dateparsing.gettingDate(dob);
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String sec_ques=request.getParameter("que_id");
		String sec_ans=request.getParameter("sec_ans");
		String roll=request.getParameter("roll");
		String back=request.getParameter("back");
		
		
	
		
		try {
			st=con.createStatement();
			String query="update student_det set fname='"+fname+"',lname='"+lname+"',password='"+pwd+"',email_id='"+email+"',mobile='"+mobile+"',address='"+address+"',dob='"+dateofb+"',security_answer='"+sec_ans+"',gender='"+gender+"',rollnumber='"+roll+"',city_id='"+ city+"', sq_id='"+sec_ques+"', backlogs='"+back+"' where username='"+uname+"'";
			int n=st.executeUpdate(query);
			System.out.println("query is :::"+query);
			
			String q1="update pg set col_name='"+pcol+"',university='"+puni+"',aggregate='"+pagg+"',branch='"+pbranch+"',name='"+pcou+"' where pg_id='"+pgid+"'";
			int n1=st.executeUpdate(q1);
			System.out.println("q1 is :::"+q1);
			
            String q2="update graduation set col_name='"+gcol+"',university='"+guni+"',aggregate='"+gagg+"',branch='"+gbranch+"',name='"+gcou+"' where ug_id='"+ugid+"'"; 		
			int n2=st.executeUpdate(q2);
			System.out.println("q2 is :::"+q2);
			
			String q3="update intermediate set col_name='"+iname+"',stream='"+istr+"',board='"+iboard+"',aggregate='"+iagg+"' where col_id='"+iid+"'";
			int n3=st.executeUpdate(q3);
			System.out.println("q3 is :::"+q3);
			
			String q4="update ssc set schl_name='"+sname+"',board='"+sboard+"',marks='"+sagg+"' where schl_id='"+ssid+"'";
			int n4=st.executeUpdate(q4);
			System.out.println("q4 is :::"+q4);
			
			pw.println("Profile updated successfully");
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
