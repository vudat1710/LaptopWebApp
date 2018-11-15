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
        <!-- Cart -->
        <h3 style="text-align: center; padding-top: 80px" class="text-dark font-weight-bold">Your Cart</h3>
        <table class="table table-hover" style="margin-top: 20px; margin-bottom: 20px">
            <thead class="thead-dark">
                <tr>
                    <th style="width:50%">Product</th>
                    <th style="width:15%">Price</th>
                    <th style="width:10%">Quantity</th>
                    <th style="width:15%" class="text-center">Subtotal</th>
                    <th style="width:10%"></th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="cartItem" items="${cart.cartItemList }">
                    <tr>
                        <td data-th="Product">
                            <div class="row">
                                <div class="col-sm-3"><img class="float-right img-fluid" src="${pageContext.request.contextPath }/resources/images/product/${cartItem.product.productId}.jpg"></div>
                                <div class="col-sm-9">
                                    <h4 class="nomargin">${cartItem.product.productName }</h4>
                                    <p>
                                        ${cartItem.product.cpu } <br>
                                        ${cartItem.product.ram } <br>
                                        ${cartItem.product.vga } <br>
                                    </p>
                                </div>
                            </div>
                        </td>
                        <td data-th="Price">${cartItem.product.price}</td>
                        <td data-th="Quantity">${cartItem.quantity}</td>
                        <td data-th="Subtotal" class="text-center">${cartItem.product.price * cartItem.quantity}</td>
                        <td class="actions" data-th="" style="text-align: center">
                            <button class="btn btn-danger btn-sm remove-cart-item-button" product-id="${cartItem.product.productId}"
                                context-path="${pageContext.request.contextPath}"><i class="fa fa-trash"></i></button>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
            <tfoot>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/" class="btn btn-warning">Continue Shopping</a></td>
                    <td colspan="2" class="hidden-xs"></td>
                    <td class="hidden-xs text-center"><strong id="total-price">Total ${cart.totalPrice}</strong></td>
                    <td><a href="#" class="btn btn-success btn-block">Checkout</a></td>
                </tr>
            </tfoot>
        </table>



        <!-- Action Buttons -->


        <!--End Cart -->

        <!-- Suggests -->
        <div class="container" style="padding-bottom: 100px">
            <h3 style="padding-top: 100px; padding-bottom: 30px">More laptops</h3>
            <div class="row">
                <c:forEach var="product" items="${offerProductList }">
                    <div class="col-sm-3">
                        <div class="card" style="width:200px; margin: 20px 20px; border: none">
                            <img class="card-img-top img-fluid" src="${pageContext.request.contextPath }/resources/images/product/${product.productId }.jpg" alt="Card image">
                            <div class="card-body">
                                <h5 class="card-title">${product.productName }</h4>
                                <p class="card-text">${product.price }</p>
                                <a href="${pageContext.request.contextPath }/viewProductDetail?productId=${product.productId}"
                                    class="btn btn-primary btn-sm"><small>See More</small></a>
                                <button product-id="${product.productId}" quantity="1" class="btn btn-warning add-cart-button btn-sm"
                                    context-path="${pageContext.request.contextPath}"><small>Add to Cart</small></button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <!-- End body -->

        <jsp:include page="footer.jsp"></jsp:include>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/javascript/script.js"></script>
</body>

</html>