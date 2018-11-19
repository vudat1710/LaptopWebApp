<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dang Ky</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns"
    crossorigin="anonymous">

    <style>
        .col-center-block { 
                float: none;    
                display: block; 
                margin-left: auto;  
                margin-right: auto;
            }

            html, body, .container {    
                height: 100%;   
                width: 100%;
            }
            .container {    
                display: table; 
                vertical-align: middle;
            }
            .vertical-center-row {  
                display: table-cell;    
                vertical-align: middle;

            }
    </style>
</head>

<body>
    <%-- <jsp:include page="navbar.jsp"></jsp:include> --%>
    <div class="container">
        <h1 class="text-center"></h1>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-4 well well-sm col-md-offset-4">
                <h1> Nhập thông tin tài khoản</h1>
                <form action="${pageContext.request.contextPath}/login" method="post" class="form">
                    <div class="form-group">
                        <input class="form-control" placeholder="Username" name="username" id="username" type="text">
                    </div>
                    <div class="form-group">
                        <input class="form-control" placeholder="Password" name="password" id="password" type="password">
                    </div>
                    <br> <button class="btn btn-info" type="submit">Đăng nhập</button>
                    <br>
                    <div><small>Không có tài khoản?</small> <a href=""><small>Tạo tài khoản</small></a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%-- <jsp:include page="footer.jsp"></jsp:include> --%>


    <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/javascript/script.js"></script>
</body>

</html>