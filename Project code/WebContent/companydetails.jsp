<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.model.conn"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function check(id)
{
	alert(id);
	var xmlhttp;
	xmlhttp = new XMLHttpRequest();
	xmlhttp
			.open(
					"GET",
					"http://localhost:9090/CampusRecruitment/checkEligibility?action="+id+"",
					true);
	xmlhttp.send();
	xmlhttp.onreadystatechange = function() {
		// alert(xmlhttp.readyState);
		// alert("**************"+xmlhttp.status);
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var xmlresp = xmlhttp.responseText;
			alert(xmlresp);
			var n=xmlresp.localeCompare("ureligible");
			alert(n);
			
			if(n==0)
			{
				alert("in if");
			window.open("AdmitCard.jsp");
			
			}
		
			
		//window.location.href='AdmitCard.jsp';

		}
	}
}
</script>
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>Company</th>
<th>Description</th>
<th>Eligibility Criteria</th>
<th>Company URL</th>
<th>Baclogs Allowed</th>
<th>Drive date</th></tr>
<tr>
<%

Connection con=null;
Statement st=null;
ResultSet rs=null;
con=conn.getMyconnection();
st=con.createStatement();
String query="select * from company_details";
rs=st.executeQuery(query);
while(rs.next())
{
	%>
<td><%=rs.getString(2) %></td>	
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><a href="<%=rs.getString(5) %>">company info</a></td>
<td><%=rs.getString(6) %></td>
<td><%=rs.getString(7) %></td>
<td><input type="button" value="PrintAdmitCard" id="<%=rs.getString(1)%>" onclick="check(this.id)"></input></td>
</tr>
<% }%>



</table>
</body>
</html>