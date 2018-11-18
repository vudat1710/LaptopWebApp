(function () {
  // $.fn.dataTable.ext.errMode = 'none';

  // validate register Form
  $("#register-form").submit(validateRegisterForm);

  $("body").on("click", ".add-cart-button", addCartButtonClick);

  $("body").on("click", ".remove-cart-item-button", removeCartItemButtonClick);

  // user management
  // var userDataTable = $("#user-table").DataTable();

  $("#search-user-form").submit(searchUsersFormSubmit);

  $("#user-table").on("click", ".fa-edit", editRoleButtonClick);

  $("#user-table").on("click", ".fa-save", saveRoleButtonClick);

  // product management
  // var productDataTable = $("#product-table").DataTable();
  // var productDataTable = $("#product-table").DataTable();

  $("#search-product-form").submit(searchProductFormSubmit);

  $("#update-product-detail-form").submit(updateProductDetailFormSubmit);

  $("#add-new-product-form").submit(addNewProductFormSubmit);

  // supplier management
  $("#add-new-supplier-form").submit(addNewSupplierFormSubmit);


})();

// validate register form

function validateUsername(username) {
  var flag = true;
  if (!/[a-zA-z0-9_]{8,}/.test(username)) {
    $("#username-feedback").text(
      "Username only contains a-zA-Z0-9_ and at least 8 character."
    );
    flag = false;
  } else {
    $("#username-feedback").text("");
  }
  return flag;
}

function validateName(name) {
  var flag = true;
  if (name === "") {
    $("#name-feedback").text("This field cannot be blank!");
    flag = false;
  } else {
    $("#name-feedback").text("");
  }
  return flag;
}

function validatePhone(phone) {
  var flag = true;
  if (!/[0-9]{1,11}/.test(phone)) {
    $("#phone-feedback").text(
      "This field cannot be blank and contain no more than 11 digits."
    );
  } else {
    $("#phone-feedback").text("");
  }
  return flag;
}

function validateAddress(address) {
  var flag = true;
  if (address === "") {
    $("#address-feedback").text("This field cannot be blank");
    flag = false;
  } else {
    $("#address-feedback").text("");
  }
  return flag;
}

function validateEmail(email) {
  var flag = true;
  if (email === "") {
    $("#email-feedback").text("This field cannot be blank");
    flag = false;
  } else {
    $("#email-feedback").text("");
  }
  return flag;
}

function validatePassword(password) {
  var flag = true;
  if (/\S{8,}/.test(password)) {
    $("#password-feedback").text("");
  } else {
    $("#password-feedback").text(
      "This field contains at least 8 characters, doesn't contain any white-space!"
    );
    flag = false;
  }
  return flag;
}

function validateConfirmPassword(password, confirmPassword) {
  if (password !== confirmPassword) {
    $("#confirm-password-feedback").text("This field must match the password!");
    return false;
  } else {
    $("#confirm-password-feedback").text("");
    return true;
  }
}

function validateBirthDate(birthDate) {
  var flag = true;
  if (birthDate === "") {
    $("#birthdate-feedback").text("This field cannot be blank");
    flag = false;
  } else {
    $("#birthdate-feedback").text("");
  }
  return flag;
}

function validateRegisterForm(event) {
  event.preventDefault();
  var contextPath = $("#register-form").attr("context-path");
  var registerForm = $("#register-form");
  var username = registerForm.find("#username").val();
  console.log(username);
  var name = registerForm.find("#name").val();
  var phone = registerForm.find("#phone").val();
  var address = registerForm.find("#address").val();
  var email = registerForm.find("#email").val();
  var password = registerForm.find("#password").val();
  var confirmPassword = registerForm.find("#confirm-password").val();
  var birthDate = registerForm.find("#birthdate").val();
  var gender = registerForm.find("input[name='gender']:checked").val();

  if (
    validateUsername(username) &&
    validateName(name) &&
    validatePhone(phone) &&
    validateAddress(address) &&
    validateEmail(email) &&
    validatePassword(password) &&
    validateConfirmPassword(password, confirmPassword) &&
    validateBirthDate(birthDate)
  ) {
    $.ajax({
      type: "GET",
      contentType: "application/json",
      url: contextPath + "/register",
      data: {
        username: username,
        name: name,
        phone: phone,
        address: address,
        email: email,
        password: password,
        birthDate: birthDate,
        gender: gender
      },
      dataType: "json",
      timeout: 10000,
      success: function (data) {
        if (data === false) {
          registerForm
            .find("#username-feedback")
            .text("This username is existed.");
        } else {
          alert("Register Successfully!");
          window.location.replace(contextPath + "/");
        }
      },
      error: function (error) {
        console.log(error);
        registerForm.find("#register-form-feedback").text("Fail to register!");
      }
    });
  }
}

// cart

function addCartButtonClick(event) {
  var productId = $(this).attr("product-id");
  var quantity = $(this).attr("quantity");
  var contextPath = $(this).attr("context-path");
  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: contextPath + "/addCart",
    data: {
      productId: productId,
      quantity: quantity
    },
    dataType: "json",
    timeout: 10000,
    success: function (data) {
      if (data === false) {
        alert("Cannot add this item!");
      }
    },
    error: function (error) {
      console.log(error);
    }
  });
}

function removeCartItemButtonClick(event) {
  var productId = $(this).attr("product-id");
  var contextPath = $(this).attr("context-path");
  var trParent = $(this)
    .parent()
    .parent();

  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: contextPath + "/removeCartItem",
    data: {
      productId: productId
    },
    dataType: "json",
    timeout: 10000,
    success: function (data) {
      if (data !== false) {
        trParent.remove();
        console.log(data);
        $("#total-price").text(`Total ${data.totalPrice}`);
      } else {
        alert("Something wrong happened!");
      }
    },
    error: function (error) {
      console.log(error);
    }
  });
}

// user management

function searchUsersFormSubmit(event) {
  event.preventDefault();
  $("#user-table").DataTable().destroy();
  var contextPath = $(this).attr("context-path");
  var userId = $(this)
    .find("#user-id-input")
    .val();
  var username = $(this)
    .find("#username-input")
    .val();
  var name = $(this)
    .find("#name-input")
    .val();
  var tableBody = $("tbody");
  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: contextPath + "/admin/searchUser",
    data: {
      userId: userId,
      username: username,
      name: name
    },
    dataType: "json",
    timeout: 10000,
    success: function (data) {
      tableBody.empty();
      for (var i = 0; i < data.length; i++) {
        $("<tr>")
          .addClass(i % 2 == 0 ? "even pointer" : "odd pointer")
          .append(
            $("<td>")
            .attr("id", "userId")
            .text(data[i].userId)
          )
          .append($("<td>").text(data[i].username))
          .append($("<td>").text(data[i].name))
          .append($("<td>").text(data[i].email))
          .append($("<td>").text(dateFormat(data[i].birthDate)))
          .append($("<td>").text(data[i].gender))
          .append($("<td>").text(data[i].address))
          .append($("<td>").text(data[i].phone))
          .append(
            $("<td>").append(getRoleSelectTag(data[i].authority))
          )
          .append($("<td>").append($("<i>").addClass("fa fa-edit").attr("context-path", contextPath)))
          .appendTo(tableBody);
      }
      $("#user-table").DataTable();
    }
  });
}

// edit-role

function editRoleButtonClick(event) {
  var trParent = $(this)
    .parent()
    .parent();
  $(this)
    .removeClass("fa-edit")
    .addClass("fa-save");
  trParent.find("#authority").attr("disabled", false);
}

function saveRoleButtonClick(event) {
  var contextPath = $(this).attr("context-path");
  var saveButton = $(this);
  var trParent = $(this)
    .parent()
    .parent();
  var userId = trParent.find("#userId").text();
  var authority = trParent.find("#authority").val();

  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: contextPath + "/admin/updateRole",
    data: {
      userId: userId,
      authority: authority
    },
    dataType: "json",
    timeout: 10000,
    success: function (data) {
      saveButton.removeClass("fa-save").addClass("fa-edit");
      trParent.find("#authority").attr("disabled", true);
    },
    error: function (error) {
      console.log(error);
      alert("Failed to update the user role!");
    }
  });
}

// product management

function searchProductFormSubmit(event) {
  var contextPath = $(this).attr("context-path");
  event.preventDefault();
  $("#product-table").DataTable().destroy();
  var productId = $(this).find("#product-id-input").val();
  var productName = $(this).find("#product-name-input").val();
  var supplierId = $(this).find("#supplier-id-input").val();

  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: contextPath + "/admin/searchProduct",
    data: {
      productId: productId,
      productName: productName,
      supplierId: supplierId
    },
    dataType: "json",
    timeout: 10000,
    success: function (data) {
      var tableBody = $("#product-table").find("tbody");
      tableBody.empty();
      for (var i = 0; i < data.length; i++) {
        $("<tr>")
          .append($("<td>")
            .text(data[i].productId))
          .append($("<td>")
            .text(data[i].productName))
          .append($("<td>")
            .text(data[i].cpu))
          .append($("<td>")
            .text(data[i].vga))
          .append($("<td>")
            .text(data[i].ram))
          .append($("<td>")
            .text(data[i].hardDisk))
          .append($("<td>")
            .text(data[i].price))
          .append($("<td>")
            .text(data[i].productDescription))
          .append($("<td>")
            .append($("<a>")
              .attr("href", contextPath + `/admin/updateProductDetailForm?productId=${data[i].productId}`)
              .append($("<i>")
                .addClass("fa fa-edit"))))
          .appendTo(tableBody);
      }
      $("#product-table").DataTable().ajax.reload();
    },
    error: function (error) {
      console.log(error);
    }
  })

}

function updateProductDetailFormSubmit(event) {
  event.preventDefault();
  var contextPath = $(this).attr("context-path");
  var productId = $(this).find("#product-id").val();
  var productName = $(this).find("#product-name").val();
  var supplierId = $(this).find("#supplier-id").val();
  var cpu = $(this).find("#cpu").val();
  var vga = $(this).find("#vga").val();
  var ram = $(this).find("#ram").val();
  var hardDisk = $(this).find("#hard-disk").val();
  var price = $(this).find("#price").val();
  var productDescription = $(this).find("#product-description").val();

  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: contextPath + "/admin/updateProductDetail",
    data: {
      productId: productId,
      productName: productName,
      supplierId: supplierId,
      cpu: cpu,
      vga: vga,
      ram: ram,
      hardDisk: hardDisk,
      price: price,
      productDescription
    },
    dataType: "json",
    timeout: 10000,
    success: function (data) {
      if (data == false) {
        alert("Cập nhật thông tin sản phẩm thất bại! Vui lòng thử lại!");
      } else {
        alert("Cập nhật thông tin sản phẩm thành công!");
      }
    },
    error: function (error) {
      console.log(error);
    }
  });
}

function addNewProductFormSubmit(event) {
  event.preventDefault();
  var contextPath = $(this).attr("context-path");
  var productId = $(this).find("#product-id").val();
  var productName = $(this).find("#product-name").val();
  var supplierId = $(this).find("#supplier-id").val();
  var cpu = $(this).find("#cpu").val();
  var vga = $(this).find("#vga").val();
  var ram = $(this).find("#ram").val();
  var hardDisk = $(this).find("#hard-disk").val();
  var price = $(this).find("#price").val();
  var productDescription = $(this).find("#product-description").val();


  if (validateProductInfo(productId, productName, supplierId, cpu, vga, ram, hardDisk, price, productDescription)) {

    $.ajax({
      type: "GET",
      contentType: "application/json",
      url: contextPath + "/addNewProduct",
      data: {
        productId: productId,
        productName: productName,
        supplierId: supplierId,
        cpu: cpu,
        vga: vga,
        ram: ram,
        hardDisk: hardDisk,
        price: price,
        productDescription: productDescription
      },
      dataType: "json",
      timeout: 10000,
      success: function (data) {
        if (data == false) {
          $("#add-new-product-form").text("Thêm sản phẩm mới thất bại! Vui lòng thử lại!");
        } else {
          uploadImages(contextPath, productId);
          $("#add-new-product-form").text("Thêm sản phẩm thành công!");

        }
      },
      error: function (error) {
        $("#add-new-product-form").text("Thêm sản phẩm thất bại!");
        console.log(error);
      }
    });
  }

}

function uploadImages(contextPath, productId) {
  var productImage = $("#add-new-product-form").find("#product-image").prop('files')[0];
  var formData = new FormData();
  formData.append("productImage", productImage);
  formData.append("productId", productId);

  $.ajax({
    type: "POST",
    url: contextPath + "/uploadImage",
    data: formData,
    cache: false,
    enctype: "multipart/data-form",
    contentType: false,
    processData: false,
    success: function (data) {
      $("#product-image-feedback").text("Upload ảnh thành công.");
    },
    error: function (error) {
      $("#product-image-feedback").text("Upload ảnh không thành công.")
    }
  });
}

function validateProductInfo(productId, productName, supplierId, cpu, vga, ram, hardDisk, price, productDescription) {
  var flag = true;
  if (productId === "" || !productId.length > 20) {
    $("#product-id-feedback").text("Mã sản phẩm bao gồm 1-20 ký tự");
    flag = false;
  } else {
    $("#product-id-feedback").text("");
  }

  if (productName === "" || !productName > 45) {
    $("#product-name-feedback").text("Tên sản phẩm bao gồm 1-45 ký tự");
    flag = false;
  } else {
    $("#product-name-feedback").text("");
  }

  if (supplierId === "") {
    $("#supplier-id-feedback").text("Không để trống trường này");
    flag = false;
  } else {
    $("#supplier-id-feedback").text("");
  }

  if (cpu === "" || !cpu > 45) {
    $("#cpu-feedback").text("Trường này bao gồm 1-45 ký tự");
    flag = false;
  } else {
    $("#cpu-feedback").text("");
  }

  if (vga === "" || !vga > 45) {
    $("#vga-feedback").text("Trường này bao gồm 1-45 ký tự");
    flag = false;
  } else {
    $("#vga-feedback").text("");
  }

  if (ram === "" || !ram > 45) {
    $("#ram-feedback").text("Trường này bao gồm 1-45 ký tự");
    flag = false;
  } else {
    $("#ram-feedback").text("");
  }

  if (hardDisk === "" || !hardDisk > 45) {
    $("#hard-disk-feedback").text("Trường này bao gồm 1-45 ký tự");
    flag = false;
  } else {
    $("#hard-disk-feedback").text("");
  }

  if (price === "") {
    $("#price-feedback").text("Không để trống trường này.");
    flag = false;
  } else {
    $("#price-feedback").text("");
  }

  if (productDescription === "") {
    $("#product-description-feedback").text("Không để trống trường này.");
    flag = false;
  } else {
    $("#product-description-feedback").text("");
  }

  return flag;
}

// supplier management

function addNewSupplierFormSubmit(event) {
  event.preventDefault();
  var contextPath = $(this).attr("context-path");

  var supplierBrand = $(this).find("#supplier-brand").val();
  var supplierDescription = $(this).find("#supplier-description").val();

  if (validateSupplierForm(supplierBrand, supplierDescription)) {
    $.ajax({
      type: "GET",
      contextPath: "application/json",
      url: contextPath + "/addNewSupplier",
      data: {
        supplierBrand: supplierBrand,
        supplierDescription: supplierDescription
      },
      dataType: "json",
      timeout: 10000,
      success: function (data) {
        if (data === false) {
          $("#add-new-supplier-form-feedback").text("Thêm nhà sản xuất thất bại.");
        } else {
          $("#add-new-supplier-form-feedback").text("Thêm nhà sản xuất thành công.");
        }
      },
      error: function (error) {
        $("#add-new-supplier-form-feedback").text("Có lỗi xảy ra!");
        console.log(error);
      }
    });
  }

}

function validateSupplierForm(supplierBrand, supplierDescription) {
  var flag = true;
  if (supplierBrand === "" || supplierBrand.length > 20) {
    $("#supplier-brand-feedback").text("Trường này bao gồm 1-20 ký tự.");
    flag = false;
  } else {
    $("#supplier-brand-feedback").text("");
  }

  if (supplierDescription === "") {
    $("#supplier-description-feedback").text("Không để trống trường này!");
    flag = false;
  } else {
    $("#supplier-description-feedback").text("");
  }
  return flag;
}

// utils

function dateFormat(milliseconds) {
  var date = new Date(milliseconds);
  return (
    date.getFullYear() +
    "-" +
    (date.getMonth() + 1 < 10 ?
      "0" + (date.getMonth() + 1) :
      date.getMonth() + 1) +
    "-" +
    (date.getDate() < 10 ? "0" + date.getDate() : date.getDate())
  );
}

function getRoleSelectTag(authority) {
  var select = $("<select>")
    .attr("id", "authority")
    .append(
      $("<option>")
      .val("ROLE_USER")
      .text("User")
    )
    .append(
      $("<option>")
      .val("ROLE_ADMIN")
      .text("Admin")
    ).attr("disabled", true);

  select.find(`option[value='${authority}']`).attr("selected", "selected");

  return select;
}