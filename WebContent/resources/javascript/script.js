(function() {
  // validate register Form
  $("#register-form").submit(validateRegisterForm);

  $("body").on("click", ".add-cart-button", addCartButtonClick);

  $("body").on("click", ".remove-cart-item-button", removeCartItemButtonClick);

  $("#search-user-form").submit(searchUsersFormSubmit);
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
      success: function(data) {
        if (data === false) {
          registerForm
            .find("#username-feedback")
            .text("This username is existed.");
        } else {
          alert("Register Successfully!");
          window.location.replace(contextPath + "/");
        }
      },
      error: function(error) {
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
    success: function(data) {
      if (data === false) {
        alert("Cannot add this item!");
      }
    },
    error: function(error) {
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
    success: function(data) {
      if (data !== false) {
        trParent.remove();
        console.log(data);
        $("#total-price").text(`Total ${data.totalPrice}`);
      } else {
        alert("Something wrong happened!");
      }
    },
    error: function(error) {
      console.log(error);
    }
  });
}

// user management

function searchUsersFormSubmit(event) {
  event.preventDefault();
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
    success: function(data) {
      tableBody.empty();
      for (var i = 0; i < data.length; i++) {
        $("<tr>")
          .addClass(i % 2 == 0 ? "even pointer" : "odd pointer")
          .append($("<td>").text(data[i].userId))
          .append($("<td>").text(data[i].username))
          .append($("<td>").text(data[i].name))
          .append($("<td>").text(data[i].email))
          .append($("<td>").text(dateFormat(data[i].birthDate)))
          .append($("<td>").text(data[i].gender))
          .append($("<td>").text(data[i].address))
          .append($("<td>").text(data[i].phone))
          .append($("<td>").text(data[i].authority))
          .append($("<td>"))
          .appendTo(tableBody);
      }
    }
  });
}

// utils

function dateFormat(milliseconds) {
  var date = new Date(milliseconds);
  return (
    date.getFullYear() +
    "-" +
    (date.getMonth() + 1 < 10
      ? "0" + (date.getMonth() + 1)
      : date.getMonth() + 1) +
    "-" +
    (date.getDate() < 10 ? "0" + date.getDate() : date.getDate())
  );
}
