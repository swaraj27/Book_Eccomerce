
<%@include file="/WEB-INF/view/Header.jsp"  %>

<div class="row">
	<div class="col"></div>
	<div class="col-11">
		<div id="demo" class="carousel slide" data-ride="carousel">
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="<c:url value="/resources/book10.jpg/"></c:url>" alt="Science Fiction" width="100%" height="500">
      <div class="carousel-caption">
        <h3>Science Fiction</h3>
        <p>Imagination is more important then knowledge</p>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="<c:url value="/resources/book11.jpg/"></c:url>" alt="Romantic" width="100%" height="500">
      <div class="carousel-caption">
        <h3>Romantic</h3>
        <p>Love is Life..!!!</p>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="<c:url value="/resources/book15.jpg/"></c:url>" alt="History" width="100%" height="500">
      <div class="carousel-caption">
        <h3>History</h3>
        <p>Grate war is here..!!!</p>
      </div>   
    </div>
  </div>
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>
		
	</div>
	<div class="col"></div>
</div>



<%@include file="/WEB-INF/view/Footer.jsp"  %>