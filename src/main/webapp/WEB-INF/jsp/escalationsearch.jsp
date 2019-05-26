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
                var sitename = document.getElementById("sitename").value;	
            	var startdate = document.getElementById("startdate").value;
            	var enddate = document.getElementById("enddate").value;
            	var status = document.getElementById("status").value;
                
                var dis = tocheck.style;
                console.log(tocheck);
                console.log(siteid);
                console.log(sitename);
                console.log(startdate);
                console.log(enddate);
                console.log(status);

                 if(siteid!=="" || sitename!=="" || startdate!=="" || enddate!=="" || status!=="" )
                     {
                	 document.getElementById("id").value=0;
                	 
                     }
                
                
                if (tocheck>0)
                {
                	document.getElementById("siteid").value="";
                	document.getElementById("sitename").value="";
                	document.getElementById("startdate").value="";
                	document.getElementById("enddate").value="";
                	document.getElementById("status").value="";
                	
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
        <form:form method="GET" modelAttribute="escalations" action="search">
        
        <table align=center border="1" style="width:50%">
	           
	           <tr>
					<td>Escalation Reference Number </td>
					
					<td><form:select path="id" id="id" onchange="myFunction()">
                         <form:option value="0" label="--- Select ---"/>
                         <c:forEach var="item" items="${listids}">
                         <form:option value="${item}">${item}</form:option>
                        </c:forEach>
                        
                        </form:select> <form:errors path="status" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors> 
					</td>
					 </tr>
				<tr>
					<td>site ID</td>
					<td> <form:input type="text" path="siteid" id="siteid" onchange="myFunction()"/> <form:errors path="siteid" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors> </td> </tr>
				<tr>	<td>site Name</td>
					<td> <form:input type="text" path="sitename" id="sitename" onchange="myFunction()" /> <form:errors path="sitename" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
				</tr>
				
				<tr>	<td>Start Date</td>
					<td> <form:input type="date" path="startdate" id="startdate" onchange="myFunction()" /> <form:errors path="startdate" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
				</tr>
				<tr>	<td>End Date</td>
					<td> <form:input type="date" path="enddate" id="enddate" onchange="myFunction()"/> <form:errors path="enddate" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
				</tr>
				<tr>	<td>Status</td>
					<td><form:select path="status" id="status" onchange="myFunction()">
                         <form:option value="" label="--- Select ---"/>
                         <c:forEach var="item" items="${statuslist}">
                         <form:option value="${item.statusname}">${item.statusname}</form:option>
                        </c:forEach>
                        
                        </form:select> <form:errors path="status" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors> 
					</td>
				</tr>
				<tr> <td> <input type="submit" value="Escalation Serach" class="btn btn-primary btn-sm"> </td> </tr>
				
			</table>	
        
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