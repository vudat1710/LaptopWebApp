<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
    <c:forEach var="product" items="${productList }">
        <div class="col-md-4 col-sm-6 px-2">
            <div class="card">
                <img class="card-img-top img img-fluid" src="${pageContext.request.contextPath }/resources/images/product/${product.productId }.jpg"
                    alt="Card image">
                <div class="card-body">
                    <h4 class="card-title">${product.productName }</h4>
                    <p class="card-text">${product.price } VND</p>
                    <a href="${pageContext.request.contextPath }/viewProductDetail?productId=${product.productId}"
                        class="btn btn-primary">See More</a>
                    <button product-id="${product.productId}" quantity="1" class="btn btn-warning add-cart-button "
                        context-path="${pageContext.request.contextPath}">Add to Cart</button>
                </div>
            </div>
        </div>
    </c:forEach>
</div>