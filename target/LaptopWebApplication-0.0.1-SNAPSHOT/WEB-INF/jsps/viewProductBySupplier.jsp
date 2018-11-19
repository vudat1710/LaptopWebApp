<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Kết quả tìm kiếm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns"
        crossorigin="anonymous">
</head>

<body>
    <jsp:include page="navbar.jsp"></jsp:include>

    <div class="container">
        <h3 style="text-align: center; padding-top: 80px; padding-bottom: 50px" class="text-dark font-weight-bold">Results
            for: ${supplierBrand }</h3>
        <div class="row">
            <c:forEach var="product" items="${productList }">
                <div class="col-sm-3">
                    <div class="card" style="width:200px; margin: 0px 20px; border: none">
                        <img class="card-img-top" src="${pageContext.request.contextPath }/resources/images/product/${product.productId }.jpg"
                            alt="Card image">
                        <div class="card-body">
                            <h4 class="card-title">${product.productName }</h4>
                            <p class="card-text">${product.price } VND</p>
                            <a href="${pageContext.request.contextPath }/viewProductDetail?productId=${product.productId}"
                                class="btn btn-primary btn-sm"><small>See More</small></a>
                            <button product-id="${product.productId}" quantity="1" class="btn btn-warning add-cart-button btn-sm"
                                context-path="${pageContext.request.contextPath}"><small>Add to Cart</small></button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <hr />
        <div class="row">
            <ul class="pagination col justify-content-end" style="padding: 10px 70px">
                <c:if test="${noPage > 0 }">

                </c:if>
                <c:choose>
                    <c:when test="${noPage > 0 }">
                        <c:forEach var="pageNum" begin="0" end="${noPage - 1 }" step="1">
                            <c:choose>
                                <c:when test="${page == pageNum }">
                                    <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath }/viewProductBySupplier?supplierId=${supplier.supplierId}&&page=${pageNum}">${pageNum
                                            + 1}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/viewProductBySupplier?supplierId=${supplier.supplierId}&&page=${pageNum}">${pageNum
                                            + 1}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h2 class="text-center display-2">Không tìm thấy kết quả nào.</h2>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/javascript/script.js"></script>

    <script>

    </script>

</body>

</html>