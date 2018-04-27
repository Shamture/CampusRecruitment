<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function ajaxobject() {
    if (typeof XMLHttpRequest != "undefined") {
        xmlHttp = new XMLHttpRequest();
    }
       
    else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (xmlHttp == null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    
    return xmlHttp;
}

	function getnext(valu){
		alert(valu);
		var xmlHttp=ajaxobject();

		xmlHttp.onreadystatechange = function() {
	        if (xmlHttp.readyState == 4 || xmlHttp.readyState == 200) {
	            document.getElementById("Qustion1").innerHTML = xmlHttp.responseText;
	        }
	    };
	   // var url1=url+"http://localhost:8085/SampleESS/GetValues?action=state&id="+value;

	    xmlHttp.open("GET","http://localhost:9090/CampusRecruitment/nextQuestion?id="+valu, true);
	    xmlHttp.send(null);
	}



</script>
</head>
<body>
<div id="nextt">
<%
	ArrayList al=(ArrayList)session.getAttribute("al");
System.out.println(al.size());
	int count=al.size();
	int i=0;
	String index=request.getParameter("id");
	if(index!=null){
		System.out.print("index is"+index);
		
		i=Integer.parseInt(index);
		i++;
		System.out.print("i is"+i);
		}
	if(i<count){
	HashMap hm=(HashMap)al.get(i);
%>
<p><%=hm.get("qname") %></p>
<p><input type="radio"  name="a1" required /><%=hm.get("oA") %><br>
<input type="radio" required name="a1" required /><%=hm.get("oB") %><br>
<input type="radio" required name="a1" required /><%=hm.get("oC") %><br>
<input type="radio" required name="a1" required /><%=hm.get("oD") %><br>
<%if(i==5){ %> <input type="submit" value="Submit"  /><%}else{ %>
</p>
</div>

<br>
<br>
<input type="button" value="next"  onclick="getnext(<%=i%>)" />
<%}} %>
</body>
</html>