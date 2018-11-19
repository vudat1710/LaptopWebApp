<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View Your Order</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <jsp:include page="navbar.jsp"></jsp:include>

    <!-- Body -->
    <div class="container">
        <!-- Profile -->
        <h3 style="text-align: center; padding-top: 80px;padding-bottom: 50px" class="text-dark font-weight-bold">Your Orders</h3>
        <div class="row">
            <div class="col-3">
        <ul class="list-group" style=" text-align: center">
          <a href="viewProfile" class="list-group-item list-group-item-action">Your Profile</a>
          <a href="#" class="list-group-item list-group-item-action">Change Password</a>
          <a href="viewOrderUser" class="list-group-item list-group-item-action">Your Orders</a>
          <a href="${pageContext.request.contextPath }/logout" class="list-group-item list-group-item-action">Log Out</a>  
        </ul>
            </div>
            <div class="col-9">
             <button type="button" class="btn btn-primary dropdown-toggle pull-right" data-toggle="dropdown" style="margin-bottom: 15px; margin-right: 50px">
            Sort by
          </button>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Price</a>
            <a class="dropdown-item" href="#">Order Date</a>
              <a class="dropdown-item" href="#">Recieve Date</a>
          </div>
            <table class="table table-hover" style="margin-top: 20px; margin-bottom: 20px">
            <thead class="thead-dark">
                 <tr>
                     <th style="width:5%">OrderID</th>
                     <th style="width:39%" class="text-center">Products</th>
                     <th style="width:15%" class="text-center">Price</th>
                     <th style="width:14%">Order Date</th>
                     <th style="width:17%">Ship Date</th>
                     <th style="width:6%">Status</th>
                 </tr>
            </thead>
            <tbody>
                <c:foreach var="orderModel" items="${orderModelList}">
                    <tr>
                        <td data-th="OrderID">${orderModel.order.orderId}</td>
                        <td data-th="Products">
                            <ul>
                                <c:foreach var="orderItem" items="${orderModel.orderDetailItems}">
                                    <li><a href="#">${orderItem.product.productName}</a>x ${orderItem.ordersDetail.quatity}</li>
                                </c:foreach>
                            </ul>
                        </td>
                        <td data-th="Price" class="text-center">${orderModel.order.totalPrice}</td>
                        <td data-th="Order Date">${orderModel.order.orderDate}</td>
                        <td data-th="Ship Date">${orderModel.order.shipDate}</td>
                        <td data-th="Status" >${orderModel.order.status}</td>
                    </tr>
                </c:foreach>
            </tbody>
            <tfoot>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                    <td></td>
                </tr>
            </tfoot>
            </table>
            <ul class="pagination col justify-content-end" style="padding: 0px 50px">
                        <li class="page-item"><a class="page-link" href="#">&larr;</a></li>
                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">&rarr;</a></li>
                    </ul></td>
            </div>
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