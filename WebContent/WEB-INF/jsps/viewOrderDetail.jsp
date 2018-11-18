<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Quản lý đơn hàng</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/resources/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
    <div class="container body">
        <div class="main_container">
            
            <jsp:include page="adminSidebar.jsp"></jsp:include>

            <!-- top navigation -->
            <div class="top_nav">
                <div class="nav_menu">
                    <nav>
                        <div class="nav toggle">
                            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                        </div>

                        <ul class="nav navbar-nav navbar-right">
                        </ul>
                    </nav>
                </div>
            </div>
            <!-- /top navigation -->


            <div class="">
                <div class="right_col" role="main">
                    <div class="row"><h3>Danh sách đơn hàng</h3></div>
                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-6">
                            <h4>Thông tin khách hàng</h4>
                        	<div>
                        		<p>${ordersDetailModels.user.username }</p>
                        		<p>${ordersDetailModels.user.email }</p>
                        		<p>${ordersDetailModels.user.phone }</p>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-4 col-md-offset-2 col-sm-offset-2 col-xs-offset-2">
                            <h4>Thông tin đơn hàng</h4>                           
                        	<div>
                        		<p>${ordersDetailModels.order.orderDate }</p>
                        		<p>${ordersDetailModels.order.shipDate }</p>
                        		<p>${ordersDetailModels.order.shipAddress }</p>
                            </div>
                        </div>
                    </div>
        
                    <div class="row">
                        <div class="table-responsive">
                            <table class="table table-striped jambo_table bulk_action">
                                <thead>
                                    <tr class="headings">
                                        <th class="column-title" style="width: 60%;">Sản phẩm </th>
                                        <th class="column-title" >Đơn giá </th>
                                        <th class="column-title" >Số lượng </th>
                                        <th class="column-title" >Thành tiền </th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="order_detail_item" items="${ordersDetailModels.orderDetailItems }">
                                    	<tr class="even pointer">
                                            
                                                <td class=" ">
                                                    <div class="col-md-2 col-sm-2 col-xs-2">
                                                        <img src="${pageContext.request.contextPath }/resources/images/product/${order_detail_item.product.productId}.jpg" style="width: 100%;">
                                                    </div>
                                                    <div class="col-md-10 col-sm-10 col-xs-10" >
                                                        <p>${order_detail_item.product.productName}</p>
                                                        <p>${order_detail_item.product.ram } - ${order_detail_item.product.hardDisk } - ${order_detail_item.product.cpu } - ${product.vga } </p>
                                                    </div>
                                                </td>
                                            <td class=" ">${order_detail_item.ordersDetail.pricePerUnit }</td>
                                            <td class=" ">${order_detail_item.ordersDetail.quantity }</td>
                                            <td class=" ">${order_detail_item.ordersDetail.pricePerUnit * order_detail_item.ordersDetail.quantity }</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>


            <!-- footer content -->
            <footer>
                <div class="pull-right">
                    Website bán laptop
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->
        </div>
    </div>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/vendors/jquery/dist/jquery.min.js"></script>
    <!--Bootstrap-->
    <script src="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="${pageContext.request.contextPath}/resources/build/js/custom.min.js"></script>

    <script src="${pageContext.request.contextPath }/resources/javascript/script.js"></script>
</body>

</html>