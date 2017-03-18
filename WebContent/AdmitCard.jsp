<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.model.conn"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table>
<%! public int i=0; %>
<%
HttpSession ses=request.getSession(false);
String uname=(String)ses.getAttribute("uname");
Connection con=null;
Statement st=null;
ResultSet rs=null;
con=conn.getMyconnection();
try{
	

st=con.createStatement();
String query="select s.fname,s.lname,s.rollnumber,ug.col_name,ug.branch,s.email_id,s.mobile from student_det s,graduation ug where s.ug_id=ug.ug_id and username='"+uname+"'";
System.out.print("query is"+query);
rs=st.executeQuery(query);
if(rs.next())
	
{
	i++;
%>

	<tr>
	<td><b>FirstName:</b></td><td><%=rs.getString(1) %></td>
	</tr>
	<tr>
	<td><b>LastName:</b></td><td><%=rs.getString(2) %></td>
	</tr>
	<td><b>Hall ticket:</b></td><td><%=rs.getString(3) %></td>
    </tr>
    <tr>
    <td><b>UserId:</b></td><td> <%=i%></td>
   </tr>
<tr>
	<td><b>College Name:</b></td><td><%=rs.getString(4) %></td>
	</tr>
	<tr>
	<td><b>Branch:</b></td><td><%=rs.getString(5) %></td>
	</tr>
	<tr>
	<td><b>EmailId:</b></td><td><%=rs.getString(6) %></td>
	</tr>
	<tr>
	<td><b>Mobile:</b></td><td><%=rs.getString(7) %></td>
	</tr>
	
	<%} 
}
catch(Exception e)
{
	e.printStackTrace();
}
	%>
	
	</table>

<input type="button" value="PRINT ADMIT CARD" onclick="window.print()"></input>

	</center>
</body>
</html>