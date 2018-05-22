<%@include file="/WEB-INF/view/Header.jsp"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!--  <table align="center" class="table">
	<tr class="danger">
		<td colspan="3">Your Cart</td>
	</tr>
	<tr>
	<td><b>Product ID</b></td>
	<td><b>Quantity</b></td>
	<td><b>SubTotal</b></td>
	<td><b>Operation</b></td>
	</tr>

<c:forEach items="${cartList}" var="cartItem">
	<form action="<c:url value="updateCartItem${cartItem.cartItemId}"/>" method="get">
	<tr class="info">
		<td>${cartItem.productId}</td>
		
		<td><input type="text" name="quantity" value="${cartItem.quantity}"/></td>
		<td>${cartItem.subtotal}</td>
		<td>
			<input type="submit" value="Update" class="btn-success"/>
			<a href="<c:url value="/deleteCartItem${cartItem.cartItemId}"/>">Delete</a>
		</td>
	</tr>
	</form>
</c:forEach>
	<tr>
	
		<td colspan="2">Grand Total</td>
		<td colspan="2">Rs.${grandTotal}/-</td>
	</tr>


	<tr>
		<td colspan="2"><a href="<c:url value="/UserHome"/>" class="btn-btn-info">Continue Shopping</a></td>
		<td colspan="2"><a href="<c:url value="/ConfirmOrder"/>" class=btn-btn-success>Check Out</a></td>
	</tr>
</table>
-->

<div class="container">
  <div class="jumbotron">
  <span class="text-primary"><h1><center>--CART--</center></h1></span>
   <table align="center" class="table">
	<tr class="danger">
		<td colspan="4" align="center"><span class="text-info">Your Cart</span></td>
	</tr>
	<tr class="table-success">
	<td><b>Product ID</b></td>
	<td><b>Quantity</b></td>
	<td><b>SubTotal</b></td>
	<td><b>Operation</b></td>
	</tr>

<c:forEach items="${cartList}" var="cartItem">
	<form action="<c:url value="updateCartItem${cartItem.cartItemId}"/>" method="get">
	<tr class="info">
		<td>${cartItem.productId}</td>
		
		<td><input type="text" name="quantity" value="${cartItem.quantity}"/></td>
		<td>${cartItem.subtotal}</td>
		<td>
			<!--  <input type="submit" value="Update" class="btn-success"/>
			<button type="submit" class="btn btn-primary">Update</button> -->
			
		<!--  	<a href="<c:url value="/deleteCartItem${cartItem.cartItemId}"/>">Delete</a>-->
		<a href="<c:url value="/deleteCartItem${cartItem.cartItemId}"/>" class="btn btn-danger" role="button">Delete</a>
		</td>
	</tr>
	</form>
</c:forEach>
	<tr>
	
		<td colspan="2" align="right"><span class="text-success">Grand Total</span></td>
		<td colspan="2">Rs.${grandTotal}/-</td>
	</tr>
	<tr>
		<td colspan="2" align="right"><a href="<c:url value="/UserHome"/>" class="btn btn-success" role="button">Continue Shopping</a></td>
		<td colspan="2"><a href="<c:url value="/ConfirmOrder"/>" class="btn btn-success" role="button">Check Out</a></td>
	</tr>
</table>
  </div>     
</div>

<%@include file="/WEB-INF/view/Footer.jsp"  %>