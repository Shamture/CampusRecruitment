<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.model.conn"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="java.io.PrintWriter"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<String> al=new ArrayList<String>();
ArrayList<String> al1=new ArrayList<String>();
ArrayList<String> al2=new ArrayList<String>();

HttpSession ses=request.getSession(false);
String tid=(String)ses.getAttribute("tid");
String uname=(String)ses.getAttribute("uname");
PrintWriter pw=response.getWriter();
Connection con=null;
Statement st=null;
ResultSet rs=null;
String gid=null;
int marks=0;
int total=0;
con=conn.getMyconnection();

st=con.createStatement();
String qry="select ques_id from question where test_id='"+tid+"'";
System.out.print("query is"+qry);
rs=st.executeQuery(qry);
while(rs.next())
{
	al.add(rs.getString(1));
	
}
total=al.size();
for(String s:al)
{
	String query="select correct_answer from options where ques_id='"+s+"'";
System.out.print("query is"+query);
	rs=st.executeQuery(query);
	while(rs.next())
	{
		al1.add(rs.getString(1));
	}
}
	String st1[]=new String[5];
	for(int i=0;i<st1.length;i++){
	int j=i+1;
	st1[i]=request.getParameter("radio"+j);
	al2.add(request.getParameter("radio"+j));
	System.out.println(st1[i]);

	}
	System.out.print(al2);
	System.out.print(al1);
	al1.retainAll(al2);
System.out.print("arraylist is"+al1);
System.out.print("Arraylength is"+al1.size());
marks=al1.size();
String q="select count(*)+1 from grades";
rs=st.executeQuery(q);
if(rs.next())
{
	gid=rs.getString(1);
	System.out.println("gid is"+gid);
}
String q1="insert into grades values('"+gid+"','"+marks+"','"+tid+"','"+uname+"',sysdate,'"+total+"')";
System.out.println("q is"+q1);
int n=st.executeUpdate(q1);
if(n>0)
{
	System.out.println("inserted");
	
	pw.println("You have successfully finished your exam.Your result for this test is "+marks+"/"+total);
}

%>
</body>
</html>