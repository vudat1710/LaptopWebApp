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
                    
                    <div class="row " >
                        <form class="form-inline" id="search-order-form" context-path="${pageContext.request.contextPath}">
                        	<div class="col-md-3 col-sm-3 col-xs-12">
                                <div class="form-group">
                                    <label for="orderID">Mã Đơn hàng</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" id="orderID" placeholder="Nhập Mã đơn hàng">
                                        <!--  <span class="input-group-btn"><button type="button" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button></span>-->
                                    </div>
                                </div>
                        	</div>
                        	<div class="col-md-3 col-sm-3 col-xs-12">
                                <div class="form-group">
                                    <label for="userID">Mã User</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" id="userID" placeholder="Nhập Mã người dùng">
                                        <!--  <span class="input-group-btn"><button type="button" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button></span>-->
                                    </div>
                                </div>
               		 		</div>
                        	<div class="col-md-3 col-sm-3 col-xs-12">
                                <div class="form-group">
                                    <label for="orderDate">Order Date</label>
                                    <div class="input-group">
                                        <input type="date" class="form-control" id="orderDate" >
                                        <!-- <span class="input-group-btn"><button type="button" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button></span> -->
                                    </div>
                                </div>
                          
                        	</div>
                        	<div class="col-md-3 col-sm-3 col-xs-12">
                                <div class="form-group">
                                    <label for="shipDate">Ship Date</label>
                                    <div class="input-group">
                                        <input type="date" class="form-control" id="shipDate" >
                                        <button type="submit" class="btn btn-success" id="search-user-button">Tìm</button>
                                    </div>
                                </div>
                           
                        	</div>
                       	</form>
                    </div>
                    
                    <br>

                    <div class="row">
                        <div class="table-responsive">
                            <table class="table table-striped jambo_table bulk_action">
                                <thead>
                                    <tr class="headings">
                                        
                                        <th class="column-title">Mã đơn hàng </th>
                                        <th class="column-title">Mã user </th>
                                        <th class="column-title">Địa chỉ giao hàng </th>
                                        <th class="column-title">Tổng hóa đơn </th>
                                        <th class="column-title">Ngày đặt hàng hàng </th>
                                        <th class="column-title">Ngày giao hàng </th>
                                        <th class="column-title">Trạng thái </th>
                                        <th class="column-title no-link last"><span class="nobr">Action</span>
                                        </th>
                                        <th class="bulk-actions" colspan="7">
                                            <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                        </th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="order" items="${orders }">
                                    	<tr class="even pointer">
                                            
                                            <td class=" ">${order.orderId } </td>
                                            <td class=" ">${order.userId }</td>
                                            <td class=" ">${order.shipAddress }</td>
                                            <td class=" ">${order.totalPrice }</td>
                                            <td class=" "><fmt:formatDate value="${order.orderDate }" pattern="yyyy-MM-dd"/></td>
                                            <td class=" "><fmt:formatDate value="${order.shipDate }" pattern="yyyy-MM-dd"/></td>
               
                                            <td class=" ">${order.status }</td>
                                            <td class=" last"><a href="update_order.html">Update</a> | <a href="order_detail.html">Detail</a></td>
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