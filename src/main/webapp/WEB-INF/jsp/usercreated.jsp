
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
    <tr><td width="50%" align="right" ><div class="topnav"><a href="${contextPath}/">Home</a>
         <td width="20%" align="left">Welcome.. </td>                       
        </tr>
      </table>
    </td>
   </tr> 
    <tr bgcolor="#E3F1EC">
    <td>
      <table width="100%"  border="2" align="center" height="450">
      <tr valign="middle" height="100" >
      <td width="50%" align="left"> <p  style="text-align:justify"> <font face="verdana" color=blue size=3 > OX Escalation Tool useful to track issues in all technologies,and the Usage is divided in to 3 parts.</br>
1. Escalation post useful to enter the site issues.</br>
2. Escalation Dashboard will helpful to know the summary of closed and open cases.</br>
3. Escalation search will helpful to search the issue cases in different scenarios, like</br>
	a. All raised cases can get with direct click: (Escalation Search).</br>
	b. Specific raised cases can get with given conditions.</br>
	c. User can download his/her all raised cases.</br></br>
	</br>
</br>
Submit Click to send email to respective teams with attachments will be coming soon.......  &#128522;</font></p>  </td>
      
      <td width="50%" align="center">  
     
          
          <table width="80%" border="1" align="center" height="100">
            <tr><td align="center">  <h2>You have successfully Registration completed...</h2> </td></tr>
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