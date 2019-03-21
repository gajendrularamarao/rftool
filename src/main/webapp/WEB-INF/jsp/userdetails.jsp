<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="/css/bootstrap.css"      rel="stylesheet">
	<link href="/css/custom.css"      rel="stylesheet">
	<link href="/css/main.css"      rel="stylesheet">
</head>
<body>
<h1 align="center">User List</h1>
<table id="t02"  cellpadding="2">
<tr>
<th>
<a  href="/enroll"><h2>Home Page:Enroll New Student</h2></a>

</th>

<th>

<a  align ="right" href="/delete"><h2>Delete All Students</h2></a>
</th>
</tr>
</table>

   
<form:form  class="form-horizontal" >
<table id="t01" border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>User Name</th>
<th>Roll</th>
<th>Email</th>
<th>Password</th>
<th>Edit</th><th>Delete</th></tr>  

   <c:forEach var="User" items="${list}"> 
   <tr>  
   <td>${User.userid}</td>  
   <td>${User.username}</td>   
   <td>${User.userroll}</td> 
   <td>${User.mailid}</td>  
   <td>${User.userpass}</td> 
  
   <td><a href="/editstudent/${student.id}">Edit</a></td>  
   <td><a href="/deletestudent/${student.id}">Delete</a></td>  
   </tr>  
   </c:forEach> 
   
   
   </table>  
   <br/>
   
  
   </form:form>
</body>
</html>