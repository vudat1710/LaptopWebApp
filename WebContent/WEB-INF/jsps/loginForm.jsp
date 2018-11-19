<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns"
        crossorigin="anonymous">
</head>

<body>
    <jsp:include page="navbar.jsp"></jsp:include>

    <div class="container login-container">
        <div class="row">
            <div class="col-3">
            </div>
            <div class="col-6" style="padding: 5%; box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19)">
                <h3 style="text-align: center"><i class="fa fa-lock"></i> Login</h3>
                <form action="${pageContext.request.contextPath}/login" method="post" class="form">
                    <div class="form-group" style="padding-top:10px ">
                        <input class="form-control" placeholder="Username" name="username" id="username" type="text">
                    </div>
                    <div class="form-group">
                        <input class="form-control" placeholder="Password" name="password" id="password" type="password">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-dark pull-right" style="padding: 5px 20px">Login</button>
                    </div>
                    <div class="form-group">
                        <a href="${pageContext.request.contextPath }/registerForm" style="font-weight: 600; color: black">Register</a>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/javascript/script.js"></script>
</body>

</html>