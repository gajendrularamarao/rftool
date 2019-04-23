
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
      
      <table> 
      <tr><td id="reg"><a href="#">Escalation DashBoard</a></td></tr>
      <tr><td id="reg"><a href="#">Escalation POST     </a></div></td></tr>
      <tr><td id="reg"><a href="#">get EscalationList </a></div> </td></tr>
      </table>
       </td>
      <td width="90%" align="center">  
       <font size="4" color="red" face="verdana" > Escalation Form </font>
      <form:form method="POST" modelAttribute="escalations" action="save">
	 
	  <table align=center border="1" style="width:70%">
	            <tr> <c:out value="${error.siteid}"></c:out>  </tr>
				<tr>
					<td>site ID</td>
					<td> <form:input type="text" path="siteid" id="siteid" /> <form:errors path="siteid" cssClass="error" > </form:errors> </td>
					<td>site Name</td>
					<td> <form:input type="text" path="sitename" id="sitename" />  </td>
				</tr>
				<tr>
					<td>Technology</td>
					<td><form:input type="text" path="technology" id="technology" /></td>
					<td>Site Status</td>
					<td> <form:input type="text" path="site_status" id="site_status" />  </td>
				</tr>
				<tr>
					<td>RO Region</td>
					<td><form:input type="text" path="ro_region" id="ro_region" /></td>
					<td>Project Scope</td>
					<td> 
					    <form:select path="project_scope" id="project_scope">
                           <form:option value="NONE" label="--- Select ---"/>
                             <c:forEach var="item" items="${projectscopelist}">
                         <form:option value="${item.projectscopeid}">${item.projectscopename}</form:option>
                        </c:forEach>
                       </form:select> <form:errors path="project_scope" cssClass="error" > </form:errors>
                  	 </td>
				<tr>
					<td>Start Date</td>
					<td><form:input type="text" path="startdate" id="startdate"/></td>
					<td>End Date</td>
					<td><form:input type="text" path="enddate" id="enddate"/> </td>
				</tr>
				<tr>
					<td>Status</td>
					<td><form:select path="status" id="status">
                         <form:option value="NONE" label="--- Select ---"/>
                         <c:forEach var="item" items="${statuslist}">
                         <form:option value="${item.statusid}">${item.statusname}</form:option>
                        </c:forEach>
                        
                        </form:select>
					</td>
					<td>Originator Mail</td>
					<td> <form:input type="text" path="originator_mail" id="originator_mail" />  </td>
				</tr>
				
					<tr>
					<td>Responsible</td>
					<td>
					<form:select path="responsible" id="responsible" >
					<form:option value="NONE" label="--- Select ---"/>
                         <c:forEach var="item" items="${responsiblelist}">
                         <form:option value="${item.responsibleid}">${item.responsiblename}</form:option>
                        </c:forEach>
                        
                        </form:select>
					
					
					</td>
					
					<td>category</td>
					<td><form:select path="category" id="category">
                         <form:option value="NONE" label="--- Select ---"/>
                         <c:forEach var="item" items="${categoryList}">
                         <form:option value="${item.categoryid}">${item.categoryname}</form:option>
                        </c:forEach>
                        
                        </form:select>
					</td>
				</tr>
				 
				 <tr>
					<td>Problem Description</td>
					<td><form:input type="text" path="problem_description" id="problem_description" /></td>
					<td>Requested Action History</td>
					<td> <form:input type="text" path="requested_action_history" id="requested_action_history" />  </td>
				 </tr>
				
				 <tr>
					<td>Mail Reference</td>
					<td><form:input type="text" path="mail_reference" id="mail_reference" /></td>
					<td>Lead Time Days</td>
					<td><form:input type="text" path="lead_time_in_days" id="lead_time_in_days" /></td>
					
				 </tr>
				 <tr>
				 <td>
				 <div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="submit" class="btn btn-primary btn-sm">
			</div>
		</div></td></tr>
				 
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