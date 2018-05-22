<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/WEB-INF/view/Header.jsp"  %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
</head>
<body>

<div id="googleMap" style="width:100%;height:400px;"></div>

<script>
function myMap() {
var mapProp= {
    center:new google.maps.LatLng(19.121480,72.850246),
    zoom:5,
};
var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBTDhHJCz2ij_BwxOfIGBhADP8s_wh9gAU&callback=myMap"></script>

<div class="row">

<div class="col"></div>

	<div class="col-lg-6">
	<h3>Get In Touch With Us</h3>
	<form>
  <div class="form-group">
    <label for="formGroupExampleInput">Name</label>
    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Enter Your Name">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Email</label>
    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Enter your Email">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Subject</label>
    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Enter Subject">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Message</label>
    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Enter Message">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
	</div>

<div class="col"></div>
</div>
</body>
<%@include file="/WEB-INF/view/Footer.jsp"  %>