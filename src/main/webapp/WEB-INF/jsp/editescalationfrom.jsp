
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
         <td width="20%" align="left">Welcome.. <font size="2" color=red> ${user.username} </font> </td>                       
         <td width="10%" align="right"><a href="${contextPath}/logout" id="log">Logout</a></td> </tr>
      </table>
    </td>
   </tr> 
    <tr bgcolor="#E3F1EC">
     <td>
      <table width="100%"  border="2" align="center" height="450">
      <tr valign="top" height="100" >
      <td width="15%" align="left"> 
      
        <jsp:include page="escalationsidemenu.jsp"></jsp:include>
       </td>
      <td width="85%" align="center">  
       <font size="4" color="red" face="verdana" > Escalation Update Form </font>
      <form:form method="POST" modelAttribute="escalations" action="/editscalation">
	 
	  <table align=center border="1" style="width:70%">
	        
	            <tr>
	            <td><form:hidden path="id"></form:hidden> </td>
	            
	            </tr>
				<tr>
					<td>site ID</td>
					<td> <form:input type="text" path="siteid" id="siteid"/> <form:errors path="siteid" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors> </td>
					<td>site Name</td>
					<td> <form:input type="text" path="sitename" id="sitename" /> <form:errors path="sitename" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
				</tr>
				<tr>
					<td>Technology</td>
					
					<td> 
					    <form:select path="technology" id="technology">
                           <form:option value="NONE" label="--- Select ---"/>
                             <c:forEach var="item" items="${technologylist}">
                         <form:option value="${item.technologyname}">${item.technologyname}</form:option>
                        </c:forEach>
                       </form:select> <form:errors path="technology" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors> 
                  	 </td>
					<td>Site Status</td>
					<td> <form:input type="text" path="site_status" id="site_status" /> <form:errors path="site_status" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
				</tr>
				<tr>
					<td>RO Region</td>
					<td><form:input type="text" path="ro_region" id="ro_region" /> <form:errors path="ro_region" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
					<td>Project Scope</td>
					<td> 
					    <form:select path="project_scope" id="project_scope">
                           <form:option value="NONE" label="--- Select ---"/>
                             <c:forEach var="item" items="${projectscopelist}">
                         <form:option value="${item.projectscopename}">${item.projectscopename}</form:option>
                        </c:forEach>
                       </form:select> <form:errors path="project_scope" cssClass="error" > </form:errors>
                  	 </td>
				<tr>
					<td>Start Date</td>
					<td><form:input type="date" path="startdate" id="startdate"/> <form:errors path="startdate" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
					<td>End Date</td>
					<td><form:input type="date" path="enddate" id="enddate"/> <form:errors path="enddate" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
				</tr>
				<tr>
					<td>Status</td>
					<td><form:select path="status" id="status">
                         <form:option value="NONE" label="--- Select ---"/>
                         <c:forEach var="item" items="${statuslist}">
                         <form:option value="${item.statusname}">${item.statusname}</form:option>
                        </c:forEach>
                        
                        </form:select> <form:errors path="status" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors> 
					</td>
					<td>Originator Mail</td>
					<td> <form:input type="text" path="originator_mail" id="originator_mail" /> <form:errors path="originator_mail" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
				</tr>
				
					<tr>
					<td>Responsible</td>
					<td>
					<form:select path="responsible" id="responsible" >
					<form:option value="NONE" label="--- Select ---"/>
                         <c:forEach var="item" items="${responsiblelist}">
                         <form:option value="${item.responsiblename}">${item.responsiblename}</form:option>
                        </c:forEach>
                        
                        </form:select>
					
					   <form:errors path="responsible" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors> 
					</td>
					
					<td>category</td>
					<td><form:select path="category" id="category">
                         <form:option value="NONE" label="--- Select ---"/>
                         <c:forEach var="item" items="${categoryList}">
                         <form:option value="${item.categoryname}">${item.categoryname}</form:option>
                        </c:forEach>
                        
                        </form:select>
                        <form:errors path="category" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors> 
					</td>
				</tr>
				 
				 <tr>
					<td>Problem Description</td>
					<td><form:input type="text" path="problem_description" id="problem_description" /> <form:errors path="problem_description" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
					<td>Requested Action History</td>
					<td> <form:input type="text" path="requested_action_history" id="requested_action_history" /> <form:errors path="requested_action_history" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
				 </tr>
				
				 <tr>
					<td>Mail Reference</td>
					<td><form:input type="text" path="mail_reference" id="mail_reference" /> <form:errors path="mail_reference" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
					<td>Lead Time Days</td>
					<td><form:input type="text" path="lead_time_in_days" id="lead_time_in_days" /> <form:errors path="lead_time_in_days" cssStyle="color: #ff0000; font-size: 10px;"> </form:errors>  </td>
					
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