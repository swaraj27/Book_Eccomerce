<%@include file="/WEB-INF/view/Header.jsp"  %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container">
<div class="jumbotron">
<h3 align="center">Product Description</h3>

<div class="table-responsive" align="center">
<table>
	<tr class="table-light">
		<td rowspan="6">
		<img src="<c:url value="/resources/images/${ProductInfo.productId}.jpg"/>" width="200" height="200"/>
		</td>
		<td>Product ID</td>
		<td>${ProductInfo.productId}</td>
	</tr>
	<tr class="table-light">
		<td>Price</td>
		<td>${ProductInfo.price}</td>
	</tr>
	<tr class="table-light">
		<td>Product Name</td>
		<td>${ProductInfo.productName}</td>
	</tr>
	<tr class="table-light">
		<td>Category ID</td>
		<td>${categoryName}</td>
	</tr>
	<tr class="table-light">
		<td>Supplier ID</td>
		<td>${ProductInfo.supplierId}</td>
	</tr>
	<tr class="table-light">
		<td>Product Description</td>
		<td>${ProductInfo.prodDesc}</td>
	</tr>
	
	<c:if test="${sessionScope.loggedIn}">
		<c:if test="${sessionScope.role=='ROLE_USER'}">
	<tr>
	<td colspan="2">
	<form action="<c:url value="/addToCart${ProductInfo.productId}"/>" method="get">
	<table>
	<tr>
		<td ><span class="text-primary">Quantity</span></td>
		<td>
		<input type ="number"  name="quantity" min="1" max="${ProductInfo.stock}" />
		</td>
		<td>
		<button type="submit" class="btn btn-success" >AddToCart</button>
		</td>
	</tr>
	
	</table>
	</form>
	</td>
	</tr>
	</c:if>
	<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
	<tr>
	<td><a href="<c:url value="/UpdateProduct${ProductInfo.productId}"/>" class="btn btn-success" role="button">Update</a></td>
	
	
	<td><a href="<c:url value="/DeleteProduct${ProductInfo.productId}"/>" class="btn btn-danger" role="button">Delete</a></td>
	</tr>
	</c:if>
	</c:if>
</table>
</div>
</div>
</div>
<%@include file="/WEB-INF/view/Footer.jsp"  %>