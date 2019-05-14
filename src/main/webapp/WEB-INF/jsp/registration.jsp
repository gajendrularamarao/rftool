
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
<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("txtPassword").value;
        var confirmPassword = document.getElementById("txtConfirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
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
    <tr><td width="50%" align="right" ><div class="topnav"><a href="/">Home</a>
         <td width="20%" align="left"> Welcome.. </td>  
                               
        </tr>
      </table>
    </td>
   </tr> 
    <tr bgcolor="#E3F1EC">
    <td>
      <table width="100%"  border="2" align="center" height="450">
      <tr valign="middle" height="100" >
      <td width="50%" align="left"> <p  style="text-align:justify"> <font face="verdana" color=red size=3 > Fourth generation wireless system is a packet switched wireless 
       system with wide area coverage and high throughput. It is designed to be cost effective and to provide high 
       spectral efficiency . The 4g wireless uses Orthogonal Frequency Division Multiplexing (OFDM),
       Ultra Wide Radio Band (UWB),and Millimeter wireless. 
       Data rate of 20mbps is employed. Mobile speed will be up to 200km/hr.
       The high performance is achieved by the use of long term channel prediction, 
       in both time and frequency, scheduling among users and smart antennas 
       combined with adaptive modulation and power control. Frequency band is 2-8 GHz. 
       it gives the ability for world wide roaming to access cell anywhere.</font></p>  </td>
      
      <td width="90%" align="center">  
        <div class="container">
          <form:form method="POST" modelAttribute="user" action="regsubmit">
          <table width="80%	" border="1" align="center" height="100">
            <tr > <td>  <h2>Registration</h2> <font size="2"  face="arial,helvetica" color="red"> ${UserExiting} </font> </td></tr>
            <tr><td> <label for="email">Email  :</label> <form:input path="mailid" type="text" placeholder="Enter Mail ID" name="mailid"/><form:errors path="mailid" cssStyle="color: #ff0000; font-size: 10px;" > </form:errors> </td> </tr>
            <tr><td><label for="email">User name :</label> <form:input path="username" type="text" placeholder="username"  name="mailid"/><form:errors path="username" cssStyle="color: #ff0000; font-size: 10px;" > </form:errors></td></tr>
            <tr><td><label for="Designation">Designation : </label><form:input path="userroll" type="text" placeholder="userroll"  name="userroll"/><form:errors path="userroll" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors></td></tr>
            <tr><td><label for="Designation">Password : </label> <form:input path="userpass" type="password" placeholder="Enter Password" name="userpass"/><form:errors path="userpass" cssStyle="color: #ff0000; font-size: 10px;"></form:errors></td> </tr>
            <tr><td> <label for="psw-repeat">Confirm Password : </label>
            <input type="password" placeholder="Confirm Password" name="psw-repeat"></td><tr>
            <tr><td align="center"><form:button type="submit" id="loginbutton" onclick="return Validate()">submit </form:button></td></tr>
          </table> 
         </form:form>
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