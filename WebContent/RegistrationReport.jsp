<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.model.conn"%>
<%@page import="java.sql.SQLException"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration report</title>
<style>
.heading {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size:18px;
	color: #3366FF;
		margin-bottom:5px;
}
.feilds{
	
	font-family:Times New Roman;
	color:#fff;
	font-size:20px;
	
}
.img
{
	position:absolute;
	width:100%;
	height:300px;
	left: 0px;
}
</style>

<style>
* { font-family: Helvetica, Arial; font-size: 12px;}

dt { float: left; padding: 4px; }

.bar {
margin-bottom: 10px;
color: #fff;
padding: 4px;
text-align: center;
background: -webkit-gradient(linear, left top, left bottom, from(#ff7617), to(#ba550f));
background-color: #ff7617;
-webkit-box-reflect: below 0 -webkit-gradient(linear, left top, left bottom, from(rgba(0,0,0,0)), to(rgba(0,0,0,0.25)));
-webkit-border-radius: 2px;
-moz-border-radius: 2px;
border-radius: 2px;
-webkit-animation-name:bar;
-webkit-animation-duration:0.5s;
-webkit-animation-iteration-count:1;
-webkit-animation-timing-function:ease-out;
}

#data-one { -webkit-animation-name:bar-one; }
#data-two { -webkit-animation-name:bar-two; }
#data-three { -webkit-animation-name:bar-three; }
#data-four { -webkit-animation-name:bar-four; }

@-webkit-keyframes bar-one {
0% { width:0%; }
100% { width:60%; }
}

@-webkit-keyframes bar-two {
0% { width:0%; }
100% { width:80%; }
}

@-webkit-keyframes bar-three {
0% { width:0%; }
100% { width:64%; }
}

@-webkit-keyframes bar-four {
0% { width:0%; }
100% { width:97%; }
}
</style>
</head>
<body>
<%
Connection con=null;
Statement st=null;
ResultSet rs=null;
int total=0;
int t;
con=conn.getMyconnection();
st=con.createStatement();
System.out.println("connection established");
ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
HttpSession ses=request.getSession(true);
try{
	String qry="select extract(month from feedback_date),count(id) from feedback group by extract(month from feedback_date)";
	rs=st.executeQuery(qry);
	while(rs.next())
	{
		HashMap<String,String> record=new HashMap<String,String>();
		record.put("id",rs.getString(1));
		record.put("month",rs.getString(2));
		al.add(record);
		int at=rs.getInt(2);
		total=total+at;
	}
System.out.println(total);
%>
<center>
<h1>Report on Feedback!</h1>
</center>
<% 
for(HashMap<String,String> record:al)
{
	

String a =record.get("id");
String b = record.get("month");
int i = Integer.parseInt(a);
int c= Integer.parseInt(b);
System.out.println("the total is"+total);

int nsp = (c*100)/total;

%>

<table>
<dl ><tr><td>
<dt>In the ::::<%=a %>Month</dt></td><td  width="500px">
<dd><div id="data-two" class="bar" style="width: <%=nsp %>%"> <%=nsp %>%</div></dd></td>
</dl></tr>
<%
}}
catch (SQLException e){
e.printStackTrace();
}
finally
{
if(con!=null)
{
try{
st.close();
con.close();
}
catch (SQLException e){
e.printStackTrace();
}}}%>

</table>

</body>
</html>