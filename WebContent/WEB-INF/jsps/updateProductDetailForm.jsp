<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Cập nhật sản phẩm</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/resources/build/css/custom.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
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

                        <ul class="nav navbar-nav navbar-right"></ul>
                    </nav>
                </div>
            </div>
            <!-- /top navigation -->

            <div>
                <div class="right_col" role="main">
                    <div class="row">
                        <h3>Cập nhật chi tiết sản phẩm</h3>
                    </div>
                    <div class="row">
                        <div class="x_content">
                            <br />
                            <form data-parsley-validate class="form-horizontal form-label-left" id="update-product-detail-form"
                                context-path="${pageContext.request.contextPath}">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-id">Mã sản
                                        phẩm
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="product-id" required="required" class="form-control col-md-7 col-xs-12"
                                            value="${product.productId }" disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-name">Tên sản
                                        phẩm
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="product-name" required="required" class="form-control col-md-7 col-xs-12"
                                            value="${product.productName }">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="supplier-id">Nhà sản
                                        xuất
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select class="form-control" name="supplier-id" id="supplier-id">
                                            <c:forEach var="supplier" items="${supplierList }">
                                                <c:choose>
                                                    <c:when test="${product.supplierId == supplier.supplierId }">
                                                        <option value="${supplier.supplierId }" selected>${supplier.supplierBrand
                                                            }</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${supplier.supplierId }">${supplier.supplierBrand
                                                            }</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="cpu" class="control-label col-md-3 col-sm-3 col-xs-12">CPU</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="cpu" class="form-control col-md-7 col-xs-12" type="text" name="cpu"
                                            value="${product.cpu }">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="vga" class="control-label col-md-3 col-sm-3 col-xs-12">VGA</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="vga" class="form-control col-md-7 col-xs-12" type="text" name="vga"
                                            value="${product.vga }">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="ram" class="control-label col-md-3 col-sm-3 col-xs-12">RAM</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="ram" class="form-control col-md-7 col-xs-12" type="text" name="ram"
                                            value="${product.ram }">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="hard-disk" class="control-label col-md-3 col-sm-3 col-xs-12">HarDisk</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="hard-disk" class="form-control col-md-7 col-xs-12" type="text" name="hard-disk"
                                            value="${product.hardDisk }">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="price" class="control-label col-md-3 col-sm-3 col-xs-12">Giá</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="price" class="form-control col-md-7 col-xs-12" type="text" name="price"
                                            value="${product.price }">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-description">Mô
                                        tả sản phẩm
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <textarea name="product-description" id="product-description" cols="30" rows="6"
                                            class="form-control col-md-7 col-xs-12">${product.productDescription}</textarea>
                                    </div>
                                </div>
                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <button class="btn btn-primary" type="reset">Reset</button>
                                        <button type="submit" class="btn btn-success">Cập nhật</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>

            <!-- footer content -->
            <footer>
                <div class="pull-right">Website bán laptop</div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->
        </div>
    </div>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="${pageContext.request.contextPath}/resources/build/js/custom.min.js"></script>

    <script src="${pageContext.request.contextPath }/resources/javascript/script.js"></script>
</body>

</html>