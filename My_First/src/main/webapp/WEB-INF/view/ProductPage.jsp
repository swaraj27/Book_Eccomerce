<%@include file="/WEB-INF/view/Header.jsp"  %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 align="center"><span class="text-primary">--PRODUCTS--</span></h1>
<div class="container">
<!--  <div class="table-responsive">
<table align="center">
	<tr class="table-success" align="center">
		<td colspan="3">Product Detail</td>	
	</tr>
	<tr>
<c:forEach items="${listProducts}" var="product">
	
		<td>
			<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="200" height="200"/>
		<br><br>
			<a href="<c:url value="/ProductDesc${product.productId}"/>">${product.productName}</a>
			<br>INR. ${product.price} /-
		</td>
	
</c:forEach>
	</tr>
</table>
</div> -->
<div class="jumbotron">
<div class="row">
	<c:forEach items="${listProducts}" var="product">
	<div class="col-sm-4">
	<div class="card" style="width: 18rem; margin-top: 10px;">
  	<img class="card-img-top" src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt="Card image cap" width="200" height="200">
  	<div class="card-body">
    <p class="card-text"><a href="<c:url value="/ProductDesc${product.productId}"/>">${product.productName}</a>
			<br><span class="bg-secondary text-white">INR. ${product.price} /-</span></p>
  </div>
  </div>
  </div>
  
  </c:forEach>
</div>
</div>
</div>


<%@include file="/WEB-INF/view/Footer.jsp"  %>