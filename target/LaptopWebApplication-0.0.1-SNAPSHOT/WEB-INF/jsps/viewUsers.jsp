<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Quản lý người dùng</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/resources/build/css/custom.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
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
                <div class="right_col col" role="main">
                    <div class="row">
                        <h3>Danh sách người dùng</h3>
                    </div>
                    <div class="row ">
                        <form class="form-inline" id="search-user-form" context-path="${pageContext.request.contextPath}">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="user-id-input">ID:</label>
                                    <input type="number" class="form-control" id="user-id-input">
                                    <!-- <button type="submit" class="btn btn-success">Tìm</button> -->
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="username-input">Username:</label>
                                    <input type="text" class="form-control" id="username-input">
                                    <!-- <button type="submit" class="btn btn-success">Tìm</button> -->
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="name-input">Tên:</label>
                                    <input type="text" class="form-control" id="name-input">
                                </div>
                                <button type="submit" class="btn btn-success" id="search-user-button">Tìm</button>
                            </div>
                        </form>
                    </div>
                    <br>
                    <div class="row">
                        <div class="table-responsive">
                            <table class="table table-striped jambo_table bulk_action" id="user-table">
                                <thead>
                                    <tr class="headings">
                                        <th class="column-title">UserID </th>
                                        <th class="column-title">Username </th>
                                        <th class="column-title">Họ tên </th>
                                        <th class="column-title">Email </th>
                                        <th class="column-title">Ngày sinh </th>
                                        <th class="column-title">Giới tính </th>
                                        <th class="column-title">Địa chỉ </th>
                                        <th class="column-title">SĐT </th>
                                        <th class="column-title">Phân quyền </th>
                                        <th class="column-title no-link last"><span class="nobr">Action</span>
                                        </th>
                                        <th class="bulk-actions" colspan="7">
                                            <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span
                                                    class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                        </th>
                                    </tr>
                                </thead>

                                <tbody>
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

    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath }/resources/javascript/script.js"></script>
    <script>
        $.fn.dataTable.ext.errMode = 'none';
    </script>
</body>

</html>