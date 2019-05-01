
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
          
     
       <table width="100%" border="1" align="center" height="100">
            <tr><td align="center">  <h2>You have successfully Rise Escalation and Details...</h2> </td></tr>
            <c:forEach var="User" items="${list}"> 
            <tr><td>
            <table width="90%" border="1" align="center" height="100">
            <tr><td id="regdisplay">Escalation Reference No</td> <td> ${User.id}</td> </tr>
            <tr><td id="regdisplay" > Site ID </td> <td>  ${User.siteid}</td>  </tr>
            <tr><td id="regdisplay"> Site Name </td> <td> ${User.sitename}</td>  </tr>
            <tr><td id="regdisplay">Technology  </td> <td>  ${User.technology}</td></tr>
            <tr><td id="regdisplay">Site Status  </td> <td> ${User.site_status}</td> </tr>
            
             <tr><td id="regdisplay" > RO Region </td> <td> ${User.ro_region}</td>  </tr>
            <tr><td id="regdisplay"> Project Scope </td> <td> ${User.project_scope}</td>  </tr>
            <tr><td id="regdisplay"> Start Date  </td> <td>  ${User.startdate}</td></tr>
            <tr><td id="regdisplay">Status  </td> <td> ${User.status}</td> </tr>
            
             <tr><td id="regdisplay" > Originator Mail </td> <td>  ${User.originator_mail}</td>  </tr>
            <tr><td id="regdisplay"> Responsible  </td> <td> ${User.responsible}</td>  </tr>
            <tr><td id="regdisplay">Category </td> <td> ${User.category}</td></tr>
            <tr><td id="regdisplay">Designation </td> <td> ${User.problem_description}</td> </tr>
            
            <tr><td id="regdisplay" > Requested Action History </td> <td>  ${User.requested_action_history}</td>  </tr>
            <tr><td id="regdisplay"> Mail Reference </td> <td> ${User.mail_reference}</td>  </tr>
            <tr><td id="regdisplay"> Lead Time in Days </td> <td> ${User.lead_time_in_days}</td></tr>
            
            </table> </td></tr>
            
            <tr>  <td id="reg">if you want change any data please : <a href="#">Edit</a></td> </tr>
            
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