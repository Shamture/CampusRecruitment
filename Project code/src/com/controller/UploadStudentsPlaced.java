package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.model.conn;

/**
 * Servlet implementation class UploadStudentsPlaced
 */
public class UploadStudentsPlaced extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadStudentsPlaced() {
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
		String sname=request.getParameter("stuname");
		String batch=request.getParameter("batch");
		String rollno=request.getParameter("rollno");
		String branch=request.getParameter("branch");
		String image=request.getParameter("image");
		String com_name=request.getParameter("company");
		
		con=conn.getMyconnection();
			
		try {
			st=con.createStatement();
			String q="insert into stud_placed values('"+rollno+"','"+image+"','"+branch+"','"+batch+"','"+com_name+"','"+sname+"')";
			System.out.println("q is"+q);
			
			//System.out.println("url is"+fileurl);
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
