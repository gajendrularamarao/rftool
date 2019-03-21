<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Escalation Form...</title>
	<link href="css/bootstrap.css"      rel="stylesheet">
	<link href="css/custom.css"      rel="stylesheet">
	<link href="css/main.css"      rel="stylesheet">
</head>

<body >
 	
 	
 	<h1>SSA Escalation</h1>
 	
	<form:form method="POST" modelAttribute="escalations" action="save">
	 
	  <table align=center border="1" style="width:70%">
				<tr>
					<td>site ID</td>
					<td> <form:input type="text" path="siteid" id="siteid" />  </td>
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
					<td> <form:input type="text" path="project_scope" id="project_scope" />  </td>

				<tr>
					<td>Start Date</td>
					<td><form:input type="text" path="startdate" id="startdate"/></td>
					<td>End Date</td>
					<td><form:input type="text" path="enddate" id="enddate"/> </td>
				</tr>
				<tr>
					<td>Status</td>
					<td><form:input type="text"  path="status" id="status" /></td>
					<td>Originator Mail</td>
					<td> <form:input type="text" path="originator_mail" id="originator_mail" />  </td>
				</tr>
				
					<tr>
					<td>Responsible</td>
					<td><form:input type="text" path="responsible" id="responsible" /></td>
					<td>category</td>
					<td> <form:input type="text" path="category" id="category" />  </td>
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
	
</body>
</html>