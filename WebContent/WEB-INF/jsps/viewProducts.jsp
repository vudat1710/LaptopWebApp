<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <title>Quản lý sản phẩm</title>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <!-- Bootstrap -->
  <link href="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />

  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">
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

      <div class="">
        <div class="right_col" role="main">
          <div class="row">
            <a href="${pageContext.request.contextPath}/admin/addNewProductForm" class="btn btn-primary">Thêm sản phẩm
              mới</a>
            <a href="${pageContext.request.contextPath}/admin/addNewSupplierForm" class="btn btn-primary">Thêm nhà sản
              xuất</a>
          </div>
          <div class="row">
            <h3>Danh sách sản phẩm</h3>
          </div>
          <div class="row ">
            <h4>Tìm kiếm sản phẩm theo :</h4>
            <form class="form-inline" id="search-product-form" context-path="${pageContext.request.contextPath}">
              <div class="col-md-4">
                <div class="form-group">
                  <label for="product-id-input">ID:</label>
                  <input type="text" class="form-control" id="product-id-input" />
                </div>
              </div>
              <div class="col-md-4">
                <div class="form-group">
                  <label for="product-name-input">Product Name:</label>
                  <input type="text" class="form-control" id="product-name-input" />
                </div>
              </div>
              <div class="col-md-4">
                <div class="form-group">
                  <label for="supplier-id-input">Nhà cung cấp:</label>
                  <select class="form-control" name="supplier-id-input" id="supplier-id-input">
                    <option value="" selected></option>
                    <c:forEach var="supplier" items="${supplierList }">
                      <option value="${supplier.supplierId }">${supplier.supplierBrand }</option>
                    </c:forEach>
                  </select>
                </div>
                <button type="submit" class="btn btn-success" id="search-product-button">
                  Tìm
                </button>
              </div>
            </form>
          </div>
          <br />

          <div class="row">
            <div class="table-responsive" id="view-product-table">
              <table class="table table-striped jambo_table bulk_action" id="product-table">
                <thead>
                  <tr class="headings">
                    <th class="column-title">ID</th>
                    <th class="column-title">Tên sản phẩm</th>
                    <th class="column-title">CPU</th>
                    <th class="column-title">VGA</th>
                    <th class="column-title">RAM</th>
                    <th class="column-title">HardDisk</th>
                    <th class="column-title">Giá</th>
                    <th class="column-title">Mô tả</th>
                    <th class="column-title no-link last">
                      <span class="nobr">Action</span>
                    </th>
                  </tr>
                </thead>
                <tbody></tbody>
              </table>
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

  <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>

  <script src="${pageContext.request.contextPath }/resources/javascript/script.js"></script>
  <script>
    $.fn.dataTable.ext.errMode = 'none';
  </script>
</body>

</html>