<%@include file="/WEB-INF/view/Header.jsp"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<div class="jumbotron">
<h3 align="center">Update Category</h3>

<div class="table-responsive-lg">
<form action="<c:url value="/UpdateCategory"/>" method="post">
<table class="table table-hover" align="center">

<tr>
	<td>Category ID</td>
	<td><input type="text" readonly id="catid" name="catid" value="${categoryInfo.categoryId}"/></td>
</tr>
<tr>
	<td>Category Name</td>
	<td><input type="text" id="catname" name="catname" value="${categoryInfo.categoryName}"/></td>
</tr>
<tr>
	<td>Category Desc</td>
	<td><input type="text" id="catdesc" name="catdesc" value="${categoryInfo.categoryDesc}"/></td>
</tr>
<tr>
	<td colspan="2" align="center">
	<button type="submit" class="btn btn-primary"/>UPDATE </button>
	<button type="reset" class="btn btn-danger"/>RESET</button></td>
</tr>
</table>
</form>

<table class="table table-hover" align="center" border="1">
<thead>
	<tr class="table-success">
		<th>Category ID</th>
		<th>Category Name</th>
		<th>Category Desc</th>
		<th>Operation</th>
	</tr>
</thead>
	<c:forEach items="${listCategories}" var="category">
	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
		<a href="<c:url value="/updateCategory${category.categoryId}"/>" class="btn btn-success" role="button">Update</a>
			<a href="<c:url value="deleteCategory${category.categoryId}"/>" class="btn btn-danger" role="button">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>
</div>
</div>
</div>
<%@include file="/WEB-INF/view/Footer.jsp"  %>