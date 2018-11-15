<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns"
    crossorigin="anonymous">
</head>

<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="banner.jsp"></jsp:include>
	<div class="container">
		<div class="row ">
			<ul class="list-group col-sm-3" style="padding-top:100px; text-align: center">
				<li class="list-group-item ">
					<h4>FILTER BY BRAND</h4>
				</li>
				<c:forEach var="supplier" items="${supplierList }">
                	<a href="${pageContext.request.contextPath }/viewProductBySupplier?supplierId=${supplier.supplierId}" class="list-group-item list-group-item-action">${supplier.supplierBrand }</a>
                </c:forEach>

			</ul>
			<!-- Product-->
			<div class="col-sm-9">
				<!-- Product bar-->
				<!-- <div class="row">
					<div class="dropdown col-5" style=" margin: 20px 20px">
						<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
							Sort by
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Price</a>
							<a class="dropdown-item" href="#">Name</a>
							<a class="dropdown-item" href="#">Date</a>
						</div>
					</div>
				</div> -->
				<!-- Product view -->
				<jsp:include page="productView.jsp"></jsp:include>
				<!-- End preview -->
			</div>
		</div>

		<!-- Page -->
		<ul class="pagination col justify-content-end" style="padding: 20px 20px">
			<li class="page-item"><a class="page-link" href="#">Previous</a></li>
			<li class="page-item active"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/javascript/script.js"></script>
</body>

</html>