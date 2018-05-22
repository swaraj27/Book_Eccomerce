<%@include file="/WEB-INF/view/Header.jsp"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container">
	<div class="jumbotron">
<h3 align="center">Supplier</h3>
<div class="table-responsive-sm">
<form  method="post" action="UpdateSupplier">
<table class="table table-hover" align="center">
  <tr class="table-light">
    <td>Supplier Id</td>
    <td><input type="text" readonly id="supplierId" name="supplierId" value="${supplierInfo.supplierId}"/></td>
  </tr>
  <tr class="table-light">
    <td>Supplier Name</td>
    <td><input type="text" id="supName" name="supName" value="${supplierInfo.supName}"/></td>
  </tr>
  <tr class="table-light">
    <td>Supplier Contact</td>
    <td><input type="text" id="supMob" name="supMob" value="${supplierInfo.supMob}"/></td>
  </tr>
  <tr>
  <td colspan="2" align="center"><button type="submit" class="btn btn-primary" >SUBMIT</button>
  <button type="reset" class="btn btn-primary"/>RESET</button>
  </td>
  </tr>
</table>
</form>
<table class="table table-hover" align="center" border="1">
	<thead>
	<tr class="table-success">
		<th>Supplier ID</th>
		<th>Supplier Name</th>
		<th>Contact</th>
		<th>Operation</th>
	</tr>
</thead>
<c:forEach items="${listSuppliers}" var="supplier">
<tr class="table-light">
			<td>${supplier.supplierId}</td>
			<td>${supplier.supName}</td>
			<td>${supplier.supMob}</td>
			<td><a
				href="<c:url value="/UpdateSupplier${supplier.supplierId}"/>">Update</a>/
				<a href="<c:url value="/DeleteSupplier${supplier.supplierId}"/>">Delete</a>
			</td>
		</tr>

</c:forEach>
</table>
</div>
</div>
</div>
<%@include file="/WEB-INF/view/Footer.jsp"  %>