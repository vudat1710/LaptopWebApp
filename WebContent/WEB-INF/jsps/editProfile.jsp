<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <jsp:include page="navbar.jsp"></jsp:include>

    <!-- Body -->
    <div class="container">
        <!-- Profile -->
        <h3 style="text-align: center; padding-top: 80px;padding-bottom: 50px" class="text-dark font-weight-bold">Your
              Profile</h3>
        <div class="row">              
            <div class="col-3">
                <ul class="list-group" style=" text-align: center">
                    <a href="viewProfile" class="list-group-item list-group-item-action">Your Profile</a>
                    <a href="#" class="list-group-item list-group-item-action">Change Password</a>
                    <a href="viewOrderUser" class="list-group-item list-group-item-action">Your Orders</a>
                    <a href="${pageContext.request.contextPath }/logout" class="list-group-item list-group-item-action">Log Out</a>
                </ul>
            </div>
            <div class="col-9">
                <form id="demo-form2" action="${pageContext.request.contextPath}/updateUser" method = "get" data-parsley-validate class="form-horizontal form-label-left"></form>
                    <table class="table table-hover">
                        <tbody>
                            <tr>
                                <th class="table-dark" style="width: 20%">Full Name</th>
                                <td style="padding-left: 20px"><input type="text" class="form-control" name="name" value="${user.name}"></td>
                            </tr>
                            <tr>
                                <th class="table-dark" style="width: 20%">Email</th>
                                <td style="padding-left: 20px"><input type="text" class="form-control" name="email" value="${user.email}"></td>
                            </tr>
                            <tr>
                                <th class="table-dark" style="width: 20%">D.O.B</th>
                                <td style="padding-left: 20px"><input id="datepicker" width="50%" name="birthDate" value="${user.birthDate}" />
                                    <script>$('#datepicker').datepicker({
                                        uiLibrary: 'bootstrap4'
                                        });
                                    </script>
                                </td>
                            </tr>
                            <tr>
                                <th class="table-dark" style="width: 20%">Gender</th>
                                <td style="padding-left: 20px">
                                    <div class="form-check-inline">
                                        <label class="form-check-label">
                                            <input type="radio" class="form-check-input" name="gender" value="MALE" checked>Male
                                        </label>
                                    </div>
                                    <div class="form-check-inline">
                                        <label class="form-check-label">
                                            <input type="radio" class="form-check-input" name="gender" value="FEMALE">Female
                                        </label>
                                    </div>
                                    <div class="form-check-inline disabled">
                                        <label class="form-check-label">
                                            <input type="radio" class="form-check-input" name="gender" value="OTHER">Other
                                        </label>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th class="table-dark" style="width: 20%">Address</th>
                                <td style="padding-left: 20px"><input class="form-control" rows="2" name="address" value="${user.address}"></input></td>
                            </tr>
                            <tr>
                                <th class="table-dark" style="width: 20%">Phone</th>
                                <td style="padding-left: 20px"><input class="form-control" rows="2" name="phone" value="${user.phone}"></input></td>
                            </tr>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td><button type="submit" class="btn btn-dark pull-right" style="padding: 5px 30px; margin-top: 10px; margin-right: 30px">Save</button>
                                    <button type="submit" class="btn btn-danger pull-right" style="padding: 5px 30px; margin-top: 10px; margin-right: 10px">Cancel</button>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </form>
            </div>

        <!-- End body -->

        <jsp:include page="footer.jsp"></jsp:include>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/javascript/script.js"></script>
</body>

</html>