

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


function setdisable()
{
	//alert("in disable");
	document.getElementById("back").disabled=true;
	document.getElementById("fn").disabled=true;
	document.getElementById("ln").disabled=true;
	document.getElementById("fm").disabled=true;
	document.getElementById("m").disabled=true;
	document.getElementById("uname").disabled=true;
	document.getElementById("roll").disabled=true;
	document.getElementById("pwd").disabled=true;
	document.getElementById("dob").disabled=true;
	document.getElementById("email").disabled=true;
	document.getElementById("mobile").disabled=true;
	document.getElementById("address").disabled=true;
	document.getElementById("cid").disabled=true;
	document.getElementById("sid").disabled=true;
	document.getElementById("ctid").disabled=true;
	document.getElementById("ques").disabled=true;
	document.getElementById("ans").disabled=true;
	document.getElementById("pcourse").disabled=true;
	document.getElementById("pcol").disabled=true;
	document.getElementById("pun").disabled=true;
	document.getElementById("pbranch").disabled=true;
	document.getElementById("pagg").disabled=true;
	document.getElementById("ug_cou").disabled=true;
	document.getElementById("ug_col").disabled=true;
	document.getElementById("ug_univ").disabled=true;
	document.getElementById("ug_branch").disabled=true;
	document.getElementById("ug_per").disabled=true;
	document.getElementById("inter_col").disabled=true;
	document.getElementById("inter_board").disabled=true;
	document.getElementById("stream").disabled=true;
	document.getElementById("inter_per").disabled=true;
	document.getElementById("schl_name").disabled=true;
	document.getElementById("tenth_board").disabled=true;
	document.getElementById("tenth_per").disabled=true;
	
	
}
function setenable()
{
	//alert("in enable");
	country();
	secu_ques();
	document.getElementById("fn").disabled=false;
	document.getElementById("ln").disabled=false;
	document.getElementById("fm").disabled=false;
	document.getElementById("m").disabled=false;
	document.getElementById("uname").disabled=true;
	document.getElementById("roll").disabled=false;
	document.getElementById("pwd").disabled=false;
	document.getElementById("dob").disabled=false;
	document.getElementById("email").disabled=false;
	document.getElementById("mobile").disabled=false;
	document.getElementById("address").disabled=false;
	document.getElementById("cid").disabled=false;
	document.getElementById("sid").disabled=false;
	document.getElementById("ctid").disabled=false;
	document.getElementById("ques").disabled=false;
	document.getElementById("ans").disabled=false;
	document.getElementById("back").disabled=false;
	document.getElementById("pcourse").disabled=false;
	document.getElementById("pcol").disabled=false;
	document.getElementById("pun").disabled=false;
	document.getElementById("pbranch").disabled=false;
	document.getElementById("pagg").disabled=false;
	document.getElementById("ug_cou").disabled=false;
	document.getElementById("ug_col").disabled=false;
	document.getElementById("ug_univ").disabled=false;
	document.getElementById("ug_branch").disabled=false;
	document.getElementById("ug_per").disabled=false;
	document.getElementById("inter_col").disabled=false;
	document.getElementById("inter_board").disabled=false;
	document.getElementById("stream").disabled=false;
	document.getElementById("inter_per").disabled=false;
	document.getElementById("schl_name").disabled=false;
	document.getElementById("tenth_board").disabled=false;
	document.getElementById("tenth_per").disabled=false;
}