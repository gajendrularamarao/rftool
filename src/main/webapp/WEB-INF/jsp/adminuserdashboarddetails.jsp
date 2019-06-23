
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
	
<style>
#tabledis{
 font-size:12px;
 color:#053E75;	
 text-decoration:none;
}
#wrap {
    overflow: auto;
    height: 400px;
}
</style>	
	
<script type="text/javascript">
	$(document).ready(function() {
    $('#example').DataTable();
} );

document.getElementById("wrap").addEventListener("scroll",function(){
		   var translate = "translate(0,"+this.scrollTop+"px)";
		   this.querySelector("thead").style.transform = translate;
		});
</script>	
	
	
</head>
<body>
  <table align="center" border="0" width="100%" >
   <tr id="header" ><td id="logo"><jsp:include page="header.jsp"></jsp:include> </td></tr>
  <tr id="menuheader">
   <td>
   <table border="0" width="100%" align="center">
    <tr><td width="50%" align="right" ><div class="topnav"><a href="${contextPath}/">Home</a>
          </div></td>
         <td width="20%" align="left">Welcome.. <font size="3" color=red> ${user.username} </font> </td>      
         <td width="20%" align="left">Designation <font size="3" color=red> ${user.userroll} </font> </td>                  
         <td width="10%" align="right"><a href="${contextPath}/logout" id="log">Logout</a></td> </tr>
      </table>
    </td>
   </tr> 
    <tr bgcolor="#E3F1EC">
     <td>
      <table width="100%"  border="2" align="center" height="500">
      <tr valign="top" height="100" >
      <td width="10%" align="left"> 
      
        <jsp:include page="adminmenu.jsp"></jsp:include>
        
   
       </td>
      <td width="90%" align="center">   <font size="4" color="red" face="verdana" > User wise Dash Board Details  </font>
         <div id="wrap">   
<table  id="tabledis" border="1" style="width:60%" cellpadding="0">
<tr ><th>UserMail ID</th><th>Responsible</th><th>Project Scope</th><th>status</th>
<th>Count</th>
</tr>  	

   <c:forEach var="esc" items="${dashboard}"> 
   <tr>  
   <td>${esc.mailid}</td> 
   <td>${esc.responsible}</td>  
   <td>${esc.project_scope}</td> 
   <td>${esc.status}</td>  
   <td>${esc.statuscount}</td> 
   
   
   </tr>  
   </c:forEach> 
   
   
   </table>  
   </div>
       
      
      
      
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