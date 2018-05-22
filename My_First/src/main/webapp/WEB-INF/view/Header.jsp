<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html lang="en">
<head>
<title>Books Online</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <style>
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: white;
   color: white;
   text-align: center;
}
body{
background-color: white;
}    

</style>
 </head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background: #FFFAF0; height: 120px">
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
<span class="navbar-toggler-icon"></span>
</button>

<!-- Brand -->
<a class="navbar-brand"  href="Home"><img src="<c:url value="/resources/logo1.jpg/"></c:url>" height=100 width=200 /></a> 


  
<c:if test="${!sessionScope.loggedIn}">
<div class="collapse navbar-collapse" id="collapsibleNavbar">
<ul class="navbar-nav mr-auto">
<li class="nav-item">
<a class="nav-link" href="Home"><font color="black">Home</font></a>
</li>
<li class="nav-item">
<a class="nav-link" href="AboutUs"><font color="black">About Us</font></a>
</li>
<li class="nav-item">
<a class="nav-link" href="ContactUs"><font color="black">Contact Us</font></a>
</li>
</ul>
<ul class="nav navbar-nav navbar-right">
<li class="nav-item">
<a class="nav-link" href="Register"><font color="black">Register</font></a>
</li>
<li class="nav-item">
<a class="nav-link" href="Login"><font color="black">Login</font></a>
</li>
</ul>
</div>
</c:if>


<c:if test="${sessionScope.loggedIn}">

	<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
<ul class="navbar-nav mr-auto">
<li class="nav-item">
<a class="nav-link" href="Home">Home</a>
</li>

<li class="nav-item">
<a class="nav-link" href="Category">Category</a>
</li>
<li class="nav-item">
<a class="nav-link" href="Product">Product</a>
</li>
<li class="nav-item">
<a class="nav-link" href="ProductPage">ProductPage</a>
</li>
<li class="nav-item">
<a class="nav-link" href="Supplier">Supplier</a>
</li>
</ul>
<ul class="nav navbar-nav navbar-right">
<li class="nav-item">
<a class="nav-link" href="Logout">Logout</a></li>
</ul>
<span class="text-success"><c:out value="${username}"></c:out></span>
</div>
</c:if>


<c:if test="${sessionScope.role=='ROLE_USER'}">
<div class="collapse navbar-collapse" id="collapsibleNavbar">
<ul class="navbar-nav mr-auto">
<li class="nav-item">
<a class="nav-link" href="Home">Home</a>
</li>
<li class="nav-item">
<a class="nav-link" href="ProductPage">ProductPage</a>
</li>
</ul>

<ul class="nav navbar-nav navbar-right">
<li class="nav=item">
<a class="nav-link" href="Cart">Cart</a>
</li>
<li class="nav=item">
<a class="nav-link" href="Logout">Logout</a>
</li>
</ul>
<span class="text-success"><c:out value="${username}"></c:out></span>
</div>
</c:if>

</c:if>

</nav>
