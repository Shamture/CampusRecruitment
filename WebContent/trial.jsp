<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.model.conn"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="result.jsp">
<table>
<%
HttpSession ses=request.getSession(true);

String tid=request.getParameter("test");
ses.setAttribute("tid",tid);
Connection con=null;
Statement st=null;
ResultSet rs=null;
con=conn.getMyconnection();
st=con.createStatement();
String query="select q.ques_id,q.ques_name,o.optionA,o.optionB,o.optionC,o.optionD from test t,question q,options o where t.test_id='"+tid+"'and q.test_id='"+tid+"' and q.ques_id=o.ques_id ";
System.out.println("query");
rs=st.executeQuery(query);
int i=0;
while(rs.next())
{
	i++;
	
	%>

	<tr><td><label name="ques<%=i%>"> <%=rs.getString(2) %></label></td></tr>
	<tr>
	<td><input type="radio" name="radio<%=i%>" value=<%=rs.getString(3)%>><%=rs.getString(3)%></td>
	<td><input type="radio" name="radio<%=i%>" value=<%=rs.getString(4)%>><%=rs.getString(4)%></td>
	<td><input type="radio" name="radio<%=i%>" value=<%=rs.getString(5)%>><%=rs.getString(5)%></td>
	<td><input type="radio" name="radio<%=i%>" value=<%=rs.getString(6)%>><%=rs.getString(6)%></td>
	</tr>
	
<% 
}

%>

</table>
<input type="submit" value="submit"></input>"
</body>
</html>