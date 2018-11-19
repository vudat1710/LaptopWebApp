<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Thêm sản phẩm mới</title>
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
                        <h3>Thêm danh mục nhà sản xuất</h3>
                    </div>
                    <div class="row">
                        <div class="x_content">
                            <br />
                            <form id="add-new-supplier-form" data-parsley-validate class="form-horizontal form-label-left" context-path="${pageContext.request.contextPath}">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="supplier-brand">
                                        Nhà sản xuất
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="supplier-brand" class="form-control col-md-7 col-xs-12">
                                        <small class="form-text text-muted" id="supplier-brand-feedback"></small>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="supplier-description">Mô
                                        tả
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <textarea type="text" id="supplier-description" cols="30" rows="5" class="form-control col-md-7 col-xs-12"></textarea>
                                        <small class="form-text text-muted" id="supplier-description-feedback"></small>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <button class="btn btn-primary" type="reset">Reset</button>
                                        <button type="submit" class="btn btn-success">Thêm</button>
                                        <small class="form-text text-muted" id="add-new-supplier-form-feedback"></small>
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