<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Quản trị</title>
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