<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

    <div class="container">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="navbar-brand" href="${pageContext.request.contextPath }/">
            <img src="${pageContext.request.contextPath }/resources/images/logo.jpg" alt="Logo" style="width: 40px;height: auto">
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link 1</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link 2</a>
        </li>
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item">
          <form class="form-inline" action="#" method="post">
            <input class="form-control" type="text" placeholder="Search" required name="search" style="width: 500px">
          </form>
        </li>
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath }/viewCart"><i class="fas fa-shopping-cart fa-2x"></i></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><i class="far fa-user fa-2x"></i></a>
        </li>
      </ul>

    </div>
  </nav> -->

  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

    <div class="container">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="navbar-brand" href="${pageContext.request.contextPath}/">
            <!-- <img src="img/logo.jpg" alt="Logo" style="width: 40px;height: auto"> -->
            <i class="fa fa-laptop fa-2x"></i>
          </a>
        </li>
        <!-- <li class="nav-item">
          <a class="nav-link" href="#">About Us</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Contact</a>
        </li> -->
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item">
          <form class="form-inline input-group" id="search-form" action="${pageContext.request.contextPath}/viewSearchResult" method="get">
            <input class="form-control form-control-borderless" type="text" placeholder="Search" id="searchValue" name="searchValue"
              style="width: 500px">
              <input type="text" hidden name="page" id="page" value="0">
              <div class="input-group-append">
                <button class="btn btn-light" type="submit">
                  <i class="fa fa-search"></i>
                </button>
              </div>
          </form>
        </li>
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath }/viewCart"><i class="fa fa-shopping-cart fa-2x" style="color: white; margin: 0px 20px"></i></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><i class="fa fa-user fa-2x" style="color: white"></i></a>
        </li>
      </ul>

    </div>
  </nav>