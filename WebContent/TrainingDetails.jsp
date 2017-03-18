<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.model.conn"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>Company name</th>
<th>Training date</th>
<th>Number of days</th>
<th>Timings</th>
<th>Venue</th>
</tr>
<tr>
<%

Connection con=null;
Statement st=null;
ResultSet rs=null;
con=conn.getMyconnection();
st=con.createStatement();
String query="select * from training";
rs=st.executeQuery(query);
while(rs.next())
{
	%>
<td><%=rs.getString(2) %></td>	
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>
</tr>
<% }%>



</table>

</body>
</html>