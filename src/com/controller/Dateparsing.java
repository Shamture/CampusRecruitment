package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class Dateparsing {
	public static String  gettingDate(String date)
	{
		 String somedate=null;
		 Date d=null;
		 Date d1=null;
		 try {
		        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");      
		        SimpleDateFormat sdf1=new SimpleDateFormat("dd-MMM-yyyy");      
			       
		        d=sdf.parse(date);
		        sdf.applyPattern("dd-M" +
		        		"" +
		        		"MM-yyyy");
		         somedate=sdf.format(d);
		     System.out.println(somedate);
		     
		         d1=sdf1.parse(somedate);
		        System.out.println("parse date");
		        
		       // System.out.println(d);		               
		 } catch (java.text.ParseException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		 }
		return somedate ;	
	
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("parse date:::::::"+Dateparsing.gettingDate("2013-11-13"));
	}

}
