<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${product.productName}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns"
    crossorigin="anonymous">
</head>

<body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <!-- Body -->
    <div class="container">
        <div class="row">
            <!-- Image -->
            <div class="col-sm-4" style="padding-top: 100px">
                <img class="img img-fluid" src="${pageContext.request.contextPath }/resources/images/product/${product.productId}.jpg" />
                <h3 style="text-align:justify; padding-top: 50px">Price: ${product.price } VND</h3>
                <button product-id="${product.productId}" quantity="1" class="btn btn-warning add-cart-button" style="margin-top: 20px"
                    context-path="${pageContext.request.contextPath}">Add to Cart</button>
            </div>
            <!-- Details -->
            <div class="col-sm-5" style="padding-top: 100px">
                <table class="table">
                    <tr>
                        <td><b>Name</b></td>
                        <td>${product.productName }</td>
                    </tr>
                    <tr>
                        <td><b>Details</b></td>
                        <td>
                            <ul>
                                <li>${product.cpu }</li>
                                <li>${product.ram }</li>
                                <li>${product.vga }</li>
                                <li>${product.hardDisk }</li>
                            </ul>
                        </td>
                    </tr>
                    <tr>
                        <td><b>Description</b></td>
                        <td>${product.productDescription }</td>
                    </tr>
                </table>
            </div>
            <!-- Menu -->
            <ul class="list-group col-sm-3" style="padding-top:100px; text-align: center; padding-left: 50px">
                <li class="list-group-item ">
                    <h4>FILTER BY BRAND</h4>
                </li>
                <c:forEach var="supplier" items="${supplierList }">
                    <a href="${pageContext.request.contextPath }/viewProductBySupplier?supplierId=${supplier.supplierId}"
                        class="list-group-item list-group-item-action">${supplier.supplierBrand }</a>
                </c:forEach>
            </ul>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/javascript/script.js"></script>
</body>

</html>