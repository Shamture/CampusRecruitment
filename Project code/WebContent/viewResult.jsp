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
<table>
<tr>
<%
Connection con=null;
Statement st=null;
ResultSet rs=null;
int i=1;
con=conn.getMyconnection();
st=con.createStatement();
HttpSession ses=request.getSession(false);
String uname=(String)ses.getAttribute("uname");
String q="select g.name,g.gdate,t.name,g.total from grades g,test t where t.test_id=g.test_id and g.username='"+uname+"'";
rs=st.executeQuery(q);
System.out.println("q is"+q);
while(rs.next())
{
	%>
<tr><td><u><b>Test<%=i %></b></u></td></tr>
<tr><td>Test name:</td><td><%=rs.getString(3) %></td></tr>
<tr><td>Marks:</td><td><%=rs.getString(1) %></td></tr>
<tr><td>Total marks:</td><td><%=rs.getString(4) %></td></tr>
<tr><td>Date of test:</td><td><%=rs.getString(2) %></td></tr>
<%
i++;
}

%>
</tr>
</table>
</body>
</html>