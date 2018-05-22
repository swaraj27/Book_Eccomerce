<%@include file="/WEB-INF/view/Header.jsp"  %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
	<div class="jumbotron">
<h3 align="center">Add Products</h3>
<div class="table-responsive-sm">
<form:form method="post" action="InsertProduct" modelAttribute="product" enctype="multipart/form-data" >
<table class="table table-hover" align="center">
	<tr align="center" class="table-success">
		<td colspan="2">Product Details</td>
	</tr>
	
	<tr align="center">
		<td>Product Name</td>
		<td><form:input path="productName"/></td>
	</tr>
	
	<tr align="center">
		<td>Category</td>
		<td>
		<form:select path="categoryId">
		<form:option value="0" label="----select----"/>
		<form:options items="${catlist}"/>
		</form:select>
		</td>
	</tr>
	
	<tr align="center">
		<td>Supplier ID</td>
		<td>
		<form:select path="supplierId">
		<form:option value="0" label="----select-----"/>
		<form:options items="${suplist}"/>
		</form:select>
		</td>
	</tr>
	
	
	<tr align="center">
		<td>Price</td>
		<td><form:input path="price"/></td>
	</tr>
	
	<tr align="center">
		<td>Stock</td>
		<td><form:input path="stock"/></td>
	</tr>
	
	<tr align="center" >
		<td>Product Desc</td>
		<td><form:input path="prodDesc"/></td>
	</tr>

	<tr align="center">
		<td>Product Image</td>
		<td><form:input type="file" path="pimage" class="btn btn-primary" />&nbsp;<button type="submit" class="btn btn-primary" >SUBMIT</button></td>
	</tr>
	
</table>
</form:form>
</div>
</div>
</div>

<%@include file="/WEB-INF/view/Footer.jsp"  %>