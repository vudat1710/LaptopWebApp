<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

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
  </nav>