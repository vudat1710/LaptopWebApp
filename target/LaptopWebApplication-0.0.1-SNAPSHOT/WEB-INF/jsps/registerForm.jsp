<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dang Ky</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns"
    crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
	<%-- <jsp:include page="navbar.jsp"></jsp:include> --%>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-4 well well-sm col-md-offset-4">
                <span><a href=""><i class="glyphicon glyphicon-globe"></i></a> Đăng ký thành viên!</span>
                <form method="post" class="form" id="register-form" context-path="${pageContext.request.contextPath}">
                    <input class="form-control" id="username" placeholder="Username" type="text">
                    <small class="form-text text-muted" id="username-feedback"></small>
                    <input class="form-control" id="name" placeholder="Họ tên" type="text">
                    <small class="form-text text-muted" id="name-feedback"></small>
                    <input class="form-control" id="phone" placeholder="Số điện thoại" type="text">
                    <small class="form-text text-muted" id="phone-feedback"></small>
                    <input class="form-control" id="address" placeholder="Địa chỉ" type="text">
                    <small class="form-text text-muted" id="address-feedback"></small>
                    <input class="form-control" id="email" placeholder="Email" type="email">
                    <small class="form-text text-muted" id="email-feedback"></small>
                    <input class="form-control" id="password" placeholder="Mật khẩu" type="password">
                    <small class="form-text text-muted" id="password-feedback"></small>
                    <input class="form-control" id="confirm-password" placeholder="Nhập lại mật khẩu" type="password">
                    <small class="form-text text-muted" id="confirm-password-feedback"></small><br>
                    <label for="">Ngày Sinh : </label>
                    <input class="form-control" id="birthdate" placeholder="ngày sinh" type="date">
                    <small class="form-text text-muted" id="birthdate-feedback"></small><br>
                    <label>Giới tính </label><br>
                    <label class="radio-inline"><input name="gender" value="MALE" type="radio" checked> Nam </label>
                    <label class="radio-inline"><input name="gender" value="FEMALE" type="radio"> Nữ </label>
                    <br>
                    <br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit"> Đăng ký</button>
                    <small class="form-text text-muted" id="register-form-feedback"></small>
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