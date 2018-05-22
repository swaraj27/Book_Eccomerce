<%@include file="/WEB-INF/view/Header.jsp"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
  <div class="jumbotron">
<table align="center" class="table">
	<tr>
		<td colspan="4"><center> <span class="text-info">Your Order</span> </center></td>
	</tr>
	<tr class="table-success">
		<td><span class="text-success">Product ID</span></td>
		<td><span class="text-success">Quantity</span></td>
		<td><span class="text-success">SubTotal</span></td>
		<td><span class="text-success">Operation</span></td>
	</tr>

<c:forEach items="${cartList}" var="cartItem">
<form action="<c:url value="updateCartItem${cartItem.cartItemId}"/>" method="get">
	<tr>
		<td>${cartItem.productId}</td>
		
		<td><input type="text" name="quantity" value="${cartItem.quantity}"/></td>
		<td>${cartItem.subtotal}</td>
		<td>
			<!--  <input type="submit" value="Update" class="btn-success"/>-->
			<!--  <button type="submit" class="btn btn-primary">Update</button>-->
			
			<!--  <a href="<c:url value="/deleteCartItem${cartItem.cartItemId}"/>">Delete</a>-->
			<a href="<c:url value="/deleteCartItem${cartItem.cartItemId}"/>" class="btn btn-danger" role="button">Delete</a>
		</td>
	</tr>
	</form>
</c:forEach>
<tr>
	
		<td colspan="2" align="right"><span class="text-success">Grand Total</span></td>
		<td colspan="2">Rs.${grandTotal}/-</td>
	</tr>
	</table>
	<form action="<c:url value="/PaymentConfirm"/>" method="post">
	<table align="center" class="table">
		<tr class="table-success">
			<td colspan="4" align="center"><span class="text-info">Payment Option</span> </td>
		</tr>
		<tr>
			<td align="center"><span class="text-success" >PaymentMode</span></td>
			<td>
			<input type="radio" name="pmode" required value="CC"/>Credit Card
			<input type="radio" name="pmode"  required value="NB"/>Net Banking
			<input type="radio" name="pmode" required  value="CD"/>Cash On Delivery
			</td>
		</tr>	
		
		
		<tr>
		<td align="center"><span class="text-success">Shipment Address</span></td>
		</tr>
		<tr>
			<td><input type="text" name="shipAddr" class="form-control" autofocus="autofocus" placeholder="Enter Your state" required autofocus /></td>
		</tr>
		<tr>
			<td><input type="text" name="shipAddr" class="form-control" autofocus="autofocus" placeholder="Enter Your City" required autofocus /></td>
		</tr>
		<tr>
			<td><input type="text" name="shipAddr" class="form-control" autofocus="autofocus" placeholder="Building Name" required autofocus /></td>
		</tr>
		<tr>
			<td><input type="text" name="shipAddr" class="form-control" autofocus="autofocus" placeholder="Area/Locality/LandMark" required autofocus /></td>
		</tr>
		<tr>
			<td><input type="text" name="shipAddr" class="form-control" autofocus="autofocus" placeholder="Pincode" required autofocus /></td>
		</tr>
		<tr align="center">
			<td colspan="2">
			<button type="submit" class="btn btn-primary btn-block">Pay</button>
			</td>
		</tr>
	</table>
	</form>
</div>
</div>
	
<%@include file="/WEB-INF/view/Footer.jsp"  %>