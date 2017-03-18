<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
    <%@page import="com.model.conn" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="javascript/ddowns.js"></script>
<script type="text/javascript" src="javascript/sec.js"></script>
<title>Insert title here</title>
</head>
<div class="login"> <strong>Profile</strong></div><br></br>
<body onload="setdisable()">
<form action="./Update" method="get">
<%String ssid="";
String iid="";
String ugid="";
String pgid="";
String ctid="";
String sqid=""; 
String secans="";
String back="";%>
<%
HttpSession ses=request.getSession(true);
Connection con =null;
java.sql.Statement st=null;
ResultSet rs=null;
con=conn.getMyconnection();
st=con.createStatement();
String uname=String.valueOf(ses.getAttribute("uname"));
try {
	st=con.createStatement();
	String query="select * from student_det where username='"+uname+"'";
	System.out.println(query);
	rs=st.executeQuery(query);
	if(rs.next())
	{
	ssid=rs.getString(12);
	iid=rs.getString(13);
	ugid=rs.getString(15);
	
	pgid=rs.getString(14);
	
	ctid=rs.getString(10);
	sqid=rs.getString(11);
	ses.setAttribute("pgid",pgid);
	ses.setAttribute("ugid",ugid);
	ses.setAttribute("iid",iid);
	ses.setAttribute("ssid",ssid);
	
	
	secans=rs.getString(9);
	back=rs.getString(18);
	System.out.print("dob is"+rs.getString(8));
	
	}
	%>
	<table>
	<tr>
	<td>FirstName</td><td><input type="text" name="fname" id="fn"
	value=<%=rs.getString(1) %>></input></td>
	</tr>
	<tr>
	<td>LastName</td><td><input type="text" name="lname" id="ln"
	value=<%=rs.getString(2) %>></input></td>
	</tr>
	<tr>
		<td>Gender</td>
				<%
			String gender = rs.getString(16);
					if (gender.equalsIgnoreCase("female")) {
		%><td><input type="radio" name="gender" value="female" checked id="fm"></td><td>Female</td>
		<td><input type="radio" name="gender" value="male" id="m"></td>
		<td>Male</td>
		<%
			} else {
		%>
		<td><input type="radio" name="gender" value="female" id="fm"></td>
		<td>Female</td>
		<td><input type="radio" name="gender" value="male" checked id="m"></td>
		<td>Male</td>
		<%
			}
		%>
	</tr>
	<tr>
	<td>User Name</td><td><input type="text" name="username"  id="uname" value=<%=rs.getString(3)%>></input></td>
	</tr>
	<tr>
	<td>Roll number</td><td><input type="text" name="roll"  id="roll" value=<%=rs.getString(17) %>></input></td>
	</tr>
	<tr>
	<td>Password</td><td><input type="password" name="pwd" id="pwd" value=<%=rs.getString(4) %>></input></td>
	</tr>
	<tr>
	<td>Date Of Birth</td><td><input type="date" name="dob" id="dob" value=<%=rs.getString(8) %>></input></td>
	</tr>
	<tr>
	<td>Email Id</td><td><input type="text" name="email" id="email" value=<%=rs.getString(5) %>></input></td>
	</tr>
	<tr>
	<td>Mobile Number</td><td><input type="text" name="mobile" id="mobile" value=<%=rs.getString(6) %>></input></td>
	</tr>
	<tr>
	<td>Address</td><td><input type="text" name="address" id="address" value=<%=rs.getString(7) %>></input></td>
	</tr>
	
	<%
			String s = "select c.COUNTRY_ID,c.COUNTRY_NAME,s.STATE_ID,s.STATE_NAME,ci.CITY_ID,ci.CITY_NAME,sq.SQ_ID,sq.question from country c,state s,city ci,security_ques sq where ci.city_id='"
					+ rs.getString(10)
					+ "' and ci.state_id=s.state_id and c.country_id=s.state_id and sq.sq_id="
					+ rs.getString(11);
			
System.out.print("s  is"+s);
			rs = st.executeQuery(s);
			if (rs.next()) {
				System.out
						.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::"
								+ rs.getString(2));
	%><td>Country</td>
	<td><select name="country" id="cid" onchange="statenames()">
		<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
	</select></td>
	</tr>
	<td>State</td>
		<td><select name="state" id="sid" onchange="citynames()">
		<option value="<%=rs.getString(3)%>"><%=rs.getString(4)%></option>
	</select></td>
	</tr>
	<td>City</td>
		<td><select name="city" id="ctid">
		<option value="<%=rs.getString(5)%>"><%=rs.getString(6)%></option>
	</select></td>
	</tr>
	<tr>
		<td>SecurityQuestion</td>
		<td><select id="ques" width="30" 
			name="que_id">
			<option value="<%=rs.getString(7)%>"><%=rs.getString(8)%></option>
		</select></td>
		</tr>
		<tr><td>Security Answer</td><td><input type="text" name="sec_ans" id="ans" value=<%=secans %>></input></td></tr>

	<td>Number of active backlogs</td><td><input type="text" name="back" id="back" value=<%=back %>></input></td>
</tr>
	
	<tr>
	<tr>
	<td><label><strong>PostGraduation</strong></label></td>
	</tr>
	<tr>
	<%
	String q1="select * from pg where pg_id='"+pgid+"'";
	System.out.print("pg is"+q1);
	rs=st.executeQuery(q1);
	if(rs.next())
	{
	%>
	<td>Course</td><td><input type="text" name="pg_cou" id="pcourse" value=<%=rs.getString(2)%>></input></td></tr>
	<tr>
	<tr>
	<td>CollegeName</td><td><input type="text" name="pg_col" id="pcol" value=<%=rs.getString(3) %>></input></td></tr>
	<tr>
	<td>University</td><td><input type="text" name="pg_univ" id="pun" value=<%=rs.getString(4) %>></input></td></tr>
	<tr>
	<td>Branch</td><td><input type="text" name="pg_branch" id="pbranch" value=<%=rs.getString(6) %>></input></td>
	</tr>
	<tr>
	<td>Aggregate</td><td><input type="text" name="pg_per" id="pagg" value=<%=rs.getString(5) %>></input></td></tr>
	<%} %>

	<tr>
	</tr>
	<tr>
	<td><label><strong>Graduation</strong></label></td></tr>
	<%
	String q2="select * from graduation where ug_id='"+ugid+"'";
	System.out.print("ug is"+q2);
	rs=st.executeQuery(q2);
	if(rs.next())
	{
	
	%>
	<tr>
	<td>Course</td><td><input type="text" name="ug_cou" id="ug_cou"value=<%=rs.getString(2) %>></input></td></tr>
	<tr>
	<tr>
	<td>CollegeName</td><td><input type="text" name="ug_col" id="ug_col" value=<%=rs.getString(3) %>></input></td></tr>
	<tr>
	<td>University</td><td><input type="text" name="ug_univ" id="ug_univ" value=<%=rs.getString(4) %>></input></td></tr>
	<tr>
	<td>Branch</td><td><input type="text" name="ug_branch" id="ug_branch" value=<%=rs.getString(6) %>></input></td>
	</tr>
	<tr>
	<td>Aggregate</td><td><input type="text" name="ug_per" id="ug_per" value=<%=rs.getString(5) %>></input></td></tr>
<%} %>
	<tr>
	<td><label><strong>Intermediate</strong></label></td></tr>
	<tr>
	<%
	String q3="select * from intermediate where col_id='"+iid+"'";
	System.out.print("int  is"+q3);
	rs=st.executeQuery(q3);
	if(rs.next())
	{
	
	%>
	<td>CollegeName</td><td><input type="text" name="inter_col" id="inter_col" value=<%=rs.getString(2) %>></input></td>
	</tr>
	<tr>
	<td>Board</td><td><input type="text" name="inter_board" id="inter_board" value=<%=rs.getString(3) %>></input></td></tr>
	<tr>
	<td>Stream</td><td><input type="text" name="stream" id="stream" value=<%=rs.getString(4) %>></input></td>
	</tr>
	<tr>
	<td>Aggregate</td><td><input type="text" name="inter_per" id="inter_per" value=<%=rs.getString(5) %>></input></td></tr>
	<%} %>
	<tr>
	<td><label><strong>SSC</strong></label> </td></tr>
	<tr>
	<%
	String q4="select * from ssc where schl_id='"+ssid+"'";
	System.out.print("ssc is"+q4);
	rs=st.executeQuery(q4);
	if(rs.next())
	{
	%>
	<td>SchoolName</td><td><input type="text" name="schl_name" id="schl_name" value=<%=rs.getString(2) %>></input></td>
	</tr>
	<tr>
	<td>Board</td><td><input type="text" name="tenth_board" id="tenth_board" value=<%=rs.getString(3) %>></input></td></tr>
	<tr>
	<td>Percentage</td><td><input type="text" name="tenth_per" id="tenth_per" value=<%=rs.getString(4) %>></input></td></tr>
	<td><input type="button" value="edit" onclick="setenable()"></input></td>
	<td></td>

	<%} %>
 <%
			}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}%></table>
<input type="submit" value="update" ></input>
 
</body>
</html>