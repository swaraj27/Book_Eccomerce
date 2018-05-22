<%@include file="/WEB-INF/view/Header.jsp"  %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
	<div class="jumbotron">
<div class="table-responsive-sm">
<form:form method="post" action="InsertUser" modelAttribute="userModel"  >
<table class="table table-hover" align="center">
	<tr align="center" class="table-success">
		<td colspan="2"><h2>Registration</h2></td>
	</tr>
	<tr align="center">
		<td>Name</td>
		<td><form:input path="custname" placeholder="name should be greater than 2 letters " class="form-control" required="true" pattern=".{2,}"/></td>
	</tr>
	
	<tr align="center">
		<td>Mobile</td>
		<td><form:input path="custmob" placeholder=" mobile no.Should be 10 digits" class="form-control"  required="true" pattern=".{6,}"/></td>
	</tr>
	
	<tr align="center">
		<td>User Name</td>
		<td><form:input path="username" placeholder="It should be unique" class="form-control"  required="true" pattern=".{2,}"/></td>
	</tr>
	
	
	<tr align="center">
		<td>Password</td>
		<td><form:password path="password" placeholder="Minimum 6 characters " class="form-control"  required="true" pattern=".{6,}"/></td>
	</tr>
	
	<tr align="center">
		<td>Mail_ID</td>
		<td><form:input path="custmail" placeholder="Enter Mail_ID" class="form-control" required="true" pattern=".{6,}"/></td>
	</tr>
	
	<tr align="center">
		<td>Address</td>
		<td><form:input path="custaddress" placeholder="Enter Address" class="form-control"  required="true" pattern=".{6,}"/></td>
	</tr>
	<tr align="center" colspan="1">
	<td><button type="submit" class="btn btn-success" >SUBMIT</button></td> <td><button type="reset" class="btn btn-danger" >RESET</button></td>
	</tr>

	
</table>
</form:form>
</div>
</div>
</div>
<%@include file="/WEB-INF/view/Footer.jsp"  %>