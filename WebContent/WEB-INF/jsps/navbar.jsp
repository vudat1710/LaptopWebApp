<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

    <div class="container">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="navbar-brand" href="${pageContext.request.contextPath}/">
            <i class="fa fa-laptop fa-2x"></i>
          </a>
        </li>
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
        <sec:authorize access="isAuthenticated()">
        	<li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath }/viewProfile"><i class="fa fa-user fa-2x" style="color: white"></i></a>
        </li>
        <li class="nav-item">
          <a href="${pageContext.request.contextPath }/logout" class="nav-link">
            <i class="fas fa-sign-out-alt"></i>
          </a>
        </li>
        </sec:authorize>
        
        <sec:authorize access="!isAuthenticated()">
        	<li class="nav-item">
          <a href="${pageContext.request.contextPath }/loginForm" class="nav-link">
            <i class="fas fa-sign-in-alt fa-2x text-white"></i>
          </a>
        </li>
        </sec:authorize>
        
      </ul>

    </div>
  </nav>