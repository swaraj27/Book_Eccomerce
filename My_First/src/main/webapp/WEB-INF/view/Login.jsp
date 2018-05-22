<%@include file="/WEB-INF/view/Header.jsp"  %>
<div class="container">
	<div class="jumbotron">
<h3 align="center">Login</h3>

<form action="perform_login" method="post">
<table class="table table-hover-xl" align="center">
	<tr align="center" class="table-success">
		<td colspan="2"><center>Enter Credential</center></td>
	</tr>
	<tr align="center">
		<td>User Name </td>
		<td><input type="text" name="username" class="form-control" autofocus="autofocus" placeholder="User name.." required autofocus /></td>
	</tr>
	<tr align="center">
		<td>Password</td>
		<td><input type="password" name="password" class="form-control" placeholder="Password"/></td>
	</tr>
	<tr align="center">
		<td colspan="2">
		<button type="submit" class="btn btn-success" >SUBMIT</button>&nbsp;
		<button type="reset" class="btn btn-danger" >RESET</button>
		</td>
	</tr>
</table>
</form>
</div>
</div>
<%@include file="/WEB-INF/view/Footer.jsp"  %>