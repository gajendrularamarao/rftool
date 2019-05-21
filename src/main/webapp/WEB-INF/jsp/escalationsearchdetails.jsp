<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>OX Escalation Tool </title>
	<link href="${contextPath}/css/bootstrap.css"      rel="stylesheet">
	<link href="${contextPath}/css/custom.css"      rel="stylesheet">
	<link href="${contextPath}/css/main.css"      rel="stylesheet">
	
	
	
</head>
<body>
   

<script>
            function myFunction()
               {

                var tocheck = document.getElementById("id").value;

                var siteid = document.getElementById("siteid").value;
                
                var dis = tocheck.style;
                console.log(tocheck);
                console.log(siteid);
                 if(siteid!=="")
                     {
                	 document.getElementById("id").disabled = true;
                     }
                 else
                     {
                	 document.getElementById("id").disabled = false;
                     }
                
                if (tocheck>0)
                {
                	document.getElementById("siteid").disabled = true;
                	document.getElementById("sitename").disabled = true;
                	document.getElementById("startdate").disabled = true;
                	document.getElementById("enddate").disabled = true;
                	document.getElementById("status").disabled = true;
                }
                else
                {
                	document.getElementById("siteid").disabled = false;
                	document.getElementById("sitename").disabled = false;
                	document.getElementById("startdate").disabled = false;
                	document.getElementById("enddate").disabled = false;
                	document.getElementById("status").disabled = false;
                }
                 }

	</script>


  <table align="center" border="0" width="85%" >
   <tr id="header" ><td id="logo"><jsp:include page="header.jsp"></jsp:include> </td></tr>
  <tr id="menuheader">
   <td><table border="0" width="100%" align="center">
    <tr><td width="50%" align="right" ><div class="topnav"><a href="#home">Home</a>
          <a href="#">Escalation</a></div></td>
         <td width="20%" align="left">Welcome.. <font font="2" color=red> ${user.username} </font> </td>                       
         <td width="10%" align="right"><a href="${contextPath}/logout" id="log">Logout</a></td> </tr>
      </table>
    </td>
   </tr> 
    <tr bgcolor="#E3F1EC">
     <td>
      <table width="100%"  border="2" align="center" height="450">
      <tr valign="top" height="100" >
      <td width="10%" align="left"> 
      
      <jsp:include page="escalationsidemenu.jsp"></jsp:include>
      
       </td>
      <td width="90%" align="center">  
           <font size="4" color="red" face="verdana" > Escalation Search </font>
        <form:form  class="form-horizontal" >
<table id="t01" border="2" width="70%" cellpadding="2">
<tr><th>Site ID</th><th>Site Name</th><th>Technology Name</th>
<th>Site Status</th><th>RO Region</th>
<th>Project Scope</th><th>Start Date</th><th>End Date</th>
<th>Status </th><th>Originator Mail</th>
<th>Responsible</th><th>Category</th>
<th>Problem Description</th><th>Request Action history</th>
<th>Mail Refereance</th><th>Lead Time</th>
<th>User ID</th>
</tr>  

   <c:forEach var="esc" items="${escalations}"> 
   <tr>  
   <td>${esc.siteid}</td>  
   <td>${esc.sitename}</td> 
   <td>${esc.technology}</td>  
   <td>${esc.site_status}</td> 
   <td>${esc.ro_region}</td>  
   <td>${esc.project_scope}</td> 
   <td>${esc.startdate}</td>  
   <td>${esc.enddate}</td>  
   <td>${esc.status}</td>  
   <td>${esc.originator_mail}</td>  
   
    <td>${esc.responsible}</td>  
   <td>${esc.category}</td> 
   <td>${esc.problem_description}</td>  
   <td>${esc.requested_action_history}</td>  
   <td>${esc.mail_reference}</td>  
   <td>${esc.lead_time_in_days}</td>  
     <td>${esc.userid}</td>  
   
   <td><a href="/editstudent/${esc.userid}">Edit</a></td>  
   
   </tr>  
   </c:forEach> 
   
   
   </table>  
   <br/>
   
  
   </form:form>
        
       </td>
       
      </tr>
      
      
      </table>
    
    </td> 
    
    
    
    </tr>
   
    <tr id="footerbar">
    <td> <font size="2" color="#fff" >OX Escalation Tool @copy rights from 2019... </font>  </td>
    </tr>
   
   
   </table>
 </body>
</html>