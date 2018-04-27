package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class conn {
	public static Connection getMyconnection(){
		Connection con=null;
		String s1=null;
		String s2=null;
		String s3=null;
		String s4=null;
		System.out.println("before reading");
		ResourceBundle rb=ResourceBundle.getBundle("com.model.connect");
		 s1=rb.getString("classname");
		 s2=rb.getString("url");
		 System.out.println(s2);
		 s3=rb.getString("username");
		 s4=rb.getString("password");
		try {
			Class.forName(s1);
		    con=DriverManager.getConnection(s2,s3,s4);
		    System.out.println("connnnnnnnnnnn"+con);
			System.out.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return con;
		
		
	
	}
	public Connection Closecon( Connection con)
	{
		try {
			if(con!=null)
			{
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
		
	}
	public Statement CloseStatement(Statement st,Connection con)
	{
		try {
			if(st!=null)
			{
				st.close();
				Closecon(con);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return st;
		
		}
	public ResultSet CloseResultset(ResultSet rs,Statement st,Connection con)
	{
		try {
			if(rs!=null)
			{
				rs.close();
			CloseStatement( st,con);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
		
	}
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
conn.getMyconnection();
	}

}
