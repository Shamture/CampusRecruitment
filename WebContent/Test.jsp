<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.model.conn"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
HttpSession ses=request.getSession(false);



ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
String tid=request.getParameter("test");
ses.setAttribute("tid",tid);
Connection con=null;
Statement st=null;
ResultSet rs=null;
con=conn.getMyconnection();
st=con.createStatement();
String query="select q.ques_id,q.ques_name,o.optionA,o.optionB,o.optionC,o.optionD from test t,question q,options o where t.test_id='"+tid+"'and q.test_id='"+tid+"' and q.ques_id=o.ques_id ";
rs=st.executeQuery(query);
while(rs.next())
{
	HashMap<String,String> record=new HashMap<String,String>();
	record.put("qid",rs.getString(1));
	record.put("qname",rs.getString(2));
	record.put("oA",rs.getString(3));
	record.put("oB",rs.getString(4));
	record.put("oC",rs.getString(5));
	record.put("oD",rs.getString(6));
	al.add(record);	
	%>

	
	
<% }
ses.setAttribute("al",al);
RequestDispatcher rd=request.getRequestDispatcher("Sample.jsp");
rd.forward(request,response);%>


</body>
</html>