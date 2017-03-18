var testnameval = new Array();
var testidval = new Array();
function test() {

	//alert("in javascript");

	var xmlhttp;
	xmlhttp = new XMLHttpRequest();
	xmlhttp
			.open(
					"GET",
					"http://localhost:9090/CampusRecruitment/dropdown?action=test",
					true);
	xmlhttp.send();
	xmlhttp.onreadystatechange = function() {
		// alert(xmlhttp.readyState);
		// alert("**************"+xmlhttp.status);
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var xmlresp = xmlhttp.responseXML;
			var testnames = xmlresp.getElementsByTagName("test_name");
			var testids = xmlresp.getElementsByTagName("test_id");
		//	alert("after error");

			for ( var i = 0; i < testnames.length; i++) {
				testnameval[i] = testnames[i].childNodes[0].nodeValue;
				testidval[i] = testids[i].childNodes[0].nodeValue;
			//alert("in getting val..........." + countrynameval);
				
			}
			fillTest();
		}
	}
	function fillTest() {
		//alert("in fill country");
		option = new Option("select", "select");
		
		tid.options[0] = option;
		for ( var i = 0; i < testnameval.length; i++) {
			option = new Option(testnameval[i], testidval[i]);
			tid.options[i + 1] = option;
			//alert("now there");
		}
	}
}

var countrynameval = new Array();
var countryidval = new Array();
function country() {

	//alert("in javascript");

	var xmlhttp;
	xmlhttp = new XMLHttpRequest();
	xmlhttp
			.open(
					"GET",
					"http://localhost:9090/CampusRecruitment/dropdown?action=country",
					true);
	xmlhttp.send();
	xmlhttp.onreadystatechange = function() {
		// alert(xmlhttp.readyState);
		// alert("**************"+xmlhttp.status);
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var xmlresp = xmlhttp.responseXML;
			var countrynames = xmlresp.getElementsByTagName("country_name");
			var countryids = xmlresp.getElementsByTagName("country_id");
		//	alert("after error");

			for ( var i = 0; i < countrynames.length; i++) {
				countrynameval[i] = countrynames[i].childNodes[0].nodeValue;
				countryidval[i] = countryids[i].childNodes[0].nodeValue;
			//	alert("in getting val..........." + countrynameval);
				
			}
			fillCountry();
		}
	}
	function fillCountry() {
		//alert("in fill country");
		option = new Option("select", "select");
		
		cid.options[0] = option;
		for ( var i = 0; i < countrynameval.length; i++) {
			option = new Option(countrynameval[i], countryidval[i]);
			cid.options[i + 1] = option;
			//alert("now there");
		}
	}
}


var stateNamesArray=new Array();
var stateIdArray=new Array();
function statenames()
{
	
	
	
//	alert("in state js");
	var countryId=document.getElementById("cid").value;
	//alert("******ids"+countryId);
	
	var http_request=null;
	if(window.XMLHttpRequest)
	{
		http_request=new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
	{
		http_request=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	http_request.open("GET","http://localhost:9090/CampusRecruitment/dropdown?action=state&CountryId="+countryId+"");
	http_request.send();
	http_request.onreadystatechange=function()	 
	{
		 
			 if(http_request.readyState==4&&http_request.status==200)
			 {
				 
			 var b=http_request.responseXML;
			 var statenames=b.getElementsByTagName("state_name");
			 var stateIds=b.getElementsByTagName("state_id");
			 
			
			for(var i=0;i<statenames.length;i++)
			 {
				//alert("in values");
				//alert(":::::::::::::::::::::::::::length  "+statenames.length);
				
				stateNamesArray[i]=statenames[i].childNodes[0].nodeValue;
				//alert("statenames::::::"+stateNamesArray);
				stateIdArray[i]=stateIds[i].childNodes[0].nodeValue;
		//alert("stateids"+stateIdArray);	
			 }
			 fillState();
			 }
	 }

	
	
 	
}
function fillState()
{

		
option=new Option("select","select");

sid.options[0]=option;
 for(var i=0;i<stateNamesArray.length;i++)
 {
 option=new Option(stateNamesArray[i],stateIdArray[i]);
 sid.options[i+1]=option;
 }
}


var cityNamesArray=new Array();
var cityIdArray=new Array();
function citynames()
{
	//document.getElementById("hcity_id").innerHTML="";
	//alert("in city js");
	var stateId=document.getElementById("sid").value;
	//alert("******ids"+stateId);
	
	var http_request=null;
	if(window.XMLHttpRequest)
	{
		http_request=new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
	{
		http_request=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	http_request.open("GET","http://localhost:9090/CampusRecruitment/dropdown?action=city&StateId="+stateId+"");
	http_request.send();
	http_request.onreadystatechange=function()	 
	{
		 
	 if(http_request.readyState==4&&http_request.status==200)
	 {
		 
	 var b=http_request.responseXML;
	 var citynames=b.getElementsByTagName("city_name");
	 var cityIds=b.getElementsByTagName("city_id");
	 
	
	for(var i=0;i<citynames.length;i++)
	 {
		//alert("in values");
		//alert(":::::::::::::::::::::::::::length  "+citynames.length);
		cityNamesArray[i]=citynames[i].childNodes[0].nodeValue;
		//alert("citynames::::::"+cityNamesArray);
		cityIdArray[i]=cityIds[i].childNodes[0].nodeValue;
//alert("cityids"+cityIdArray);	
	 }
	 fillCity();
	 }
	 }

	
	function fillCity()
	{
	//alert("in filling");	
	option=new Option("select","select");
	
	ctid.options[0]=option;
	 for(var i=0;i<cityNamesArray.length;i++)
	 {
	 option=new Option(cityNamesArray[i],cityIdArray[i]);
	 ctid.options[i+1]=option;
	 }
	}
}
 	




var secnameval=new Array();
var secidval=new Array();
function secu_ques()
{
//alert("in javascript secu_ques");
var xmlhttp;
xmlhttp=new XMLHttpRequest();
xmlhttp.open("GET","http://localhost:9090/CampusRecruitment/dropdown?action=secu_ques",true);
xmlhttp.send();
xmlhttp.onreadystatechange=function()
{
	//alert(xmlhttp.readyState);
	//alert("**************"+xmlhttp.status);
	if(xmlhttp.readyState==4 && xmlhttp.status==200)
	{
		var xmlresp=xmlhttp.responseXML;
		 var secnames=xmlresp.getElementsByTagName("ques_name");
		 var secids=xmlresp.getElementsByTagName("ques_id");
		//alert("after error");
		
		for(var i=0;i<secnames.length;i++)
		{
			secnameval[i]=secnames[i].childNodes[0].nodeValue;
			secidval[i]=secids[i].childNodes[0].nodeValue;
			//alert("in getting val..........."+countrynameval);
			/*var option=document.createElement("option");
			option.text=xmllength[i].childNodes[0].nodeValue;
			
			combocountry.add(option);
			//alert(info);
*/			
			}
		fillSecurity();
	}
}
function fillSecurity()
{
	//alert("in fill security");
	option=new Option("select","select");
	ques.options[0]=option;
	for(var i=0;i<secnameval.length;i++)
	{
		option=new Option(secnameval[i],secidval[i]);
		ques.options[i+1]=option;
		//alert("now there");
	}
}
}

function disablePg()
{
	document.getElementById("pcourse").disabled=true;
	document.getElementById("pcol").disabled=true;
	document.getElementById("pun").disabled=true;
	document.getElementById("pbranch").disabled=true;
	document.getElementById("pagg").disabled=true;
}

function enablepg()

{

	 if(document.getElementById("pgcheck").checked)
	 {
	document.getElementById("pcourse").disabled=false;
	document.getElementById("pcol").disabled=false;
	document.getElementById("pun").disabled=false;
	document.getElementById("pbranch").disabled=false;
	document.getElementById("pagg").disabled=false;
	 }
	 else
	 {
		 document.getElementById("pcourse").disabled=true;
			document.getElementById("pcol").disabled=true;
			document.getElementById("pun").disabled=true;
			document.getElementById("pbranch").disabled=true;
			document.getElementById("pagg").disabled=true;
	 }
}



