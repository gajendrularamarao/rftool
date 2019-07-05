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
	<link href="${contextPath}/css/datatable.css"      rel="stylesheet">
	<link href="${contextPath}/css/main.css"      rel="stylesheet">
	<script type="text/javascript" src="${contextPath}/js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="${contextPath}/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="${contextPath}/js/jquery.dataTables.min.js"></script>
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
         <td width="20%" align="left">Welcome.. <font font="2" color=yellow> ${user.username} </font> </td> 
         <td width="20%" align="left">Designation <font size="3" color=yellow> ${user.userroll} </font> </td>                       
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
           
       
   
         <table width="80%" border="1" align="center" height="100">
            <tr><td align="center">  <h2>Your Password successfully Changed ...</h2> </td></tr>
           
            <c:forEach var="User" items="${list}"> 
            <tr><td id="regdisplay" >Your Registration Number :  ${User.userid}</td>  </tr>
            <tr><td id="regdisplay">your Login ID : ${User.mailid}</td>  </tr>
            <tr><td id="regdisplay">Name :  ${User.username}</td></tr>
            <tr><td id="regdisplay">Designation :${User.userroll}</td> </tr>
            <tr><td id="reg"><a href="${contextPath}/">Please Login</a></td> </tr>
            
            </c:forEach>
           
            </table>      
   
   
   
   
   
   
   
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