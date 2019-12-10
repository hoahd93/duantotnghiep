<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section style="margin: 20px">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h1 class="card-title text-center" style="font-size: 30px">ĐĂNG NHẬP</h1>
                        <h5 style="color: red;margin-top: 5px" class="text-center">${message}</h5>
                        <form name="loginForm" id="loginForm" class="form-signin" action="<c:url value="/ShopFinal/j_spring_security_login" />" method="POST">   
                            <div class="form-group">
                                <label for="username">Tài khoản:</label>
                                <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Nhập email" style="margin-bottom: 5px;"/> 
                                <font id="inputEmailError" style="color: red"></font>
                            </div>

                            <div class="form-group">
                                <label for="password">Mật khẩu:</label>
                                <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Nhập mật khẩu" style="margin-bottom: 5px;"/>
                                <font id="inputPasswordError" style="color: red;"></font>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                </div>
                                <div class="form-group col-sm-6" style="text-align: right;">
                                    <a href="/ShopFinal/checkemail">Quên mật khẩu</a>
                                </div>
                            </div>
                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" onclick="return validateFormLogin()">ĐĂNG NHẬP</button>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />                           
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-sm-6" style="border-left:  #0066cc solid 2px">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h1 class="card-title text-center" style="font-size: 30px">ĐĂNG KÝ</h1>                       

                        <form:form cssClass="form-signin" modelAttribute="customer" id="form" method="post" action="/ShopFinal/add-customer?${_csrf.parameterName}=${_csrf.token}">
                            <div class="form-group">
                                <label for="inputName">Họ và tên: </label>                       
                                <form:input class="form-control" path="fullName" id="fullName" placeholder="Nhập họ tên" cssStyle="margin-bottom: 5px;"/>
                                <font id="fullNameError" style="color: red;"></font>
                            </div>
                            <div class="form-group">    
                                <label for="email">Giới tính: </label><br />
                                <form:select path="gender" class="form-control">
                                    <form:option   value="1" label="Nam" />
                                    <form:option   value="2" label="Nữ" />
                                    <form:option   value="3" label="Khác" />
                                </form:select>
                                <div class="select-dropdown"></div>                                   
                            </div>
                            <div class="form-group">
                                <label for="email">Ngày sinh: </label><br />
                                <form:input type="date" class="form-control" id="birthDay" path="birthDay" cssStyle="margin-bottom: 5px;"/>
                                <font id="birthDayError" style="color: red;"></font>
                            </div>
                            <div class="form-group">
                                <label for="email">Email: </label><br />
                                <input class="form-control" id="email" name="email" placeholder="Nhập địa chỉ email" style="margin-bottom: 5px;"/>
                                <font id="emailError" style="color: red;">Email đã tồn tại</font>
                            </div>
                            <div class="form-group">
                                <label for="email">Số điện thoại: </label>
                                <form:input class="form-control" path="phoneNumber" id="phoneNumber" placeholder="Nhập số điện thoại" cssStyle="margin-bottom: 5px;" />
                                <font id="phoneNumberError" style="color: red;"></font>
                            </div>
                            <div class="form-group">
                                <label for="form:inputAddress">Địa chỉ</label>
                                <form:input class="form-control" path="address" id="address" placeholder="Nhập địa chỉ" cssStyle="margin-bottom: 5px;"/>
                                <font id="addressError" style="color: red;"></font>
                            </div>
                            <div class="form-group">
                                <label for="form:inputPass">Mật khẩu</label>
                                <input type="password" class="form-control" name="pass" id="pass" placeholder="Nhập mật khẩu" style="margin-bottom: 5px;"/>
                                <font id="passError" style="color: red;"></font>
                            </div>
                            <br class="my-4">
                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" onclick="return validateFormSigUp()">ĐĂNG KÝ</button>
                        </form:form>                
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    var isExistEmail = false;
    //Form Sig Up
    function validateFormSigUp() {
        var f = document.getElementById("form");
        var hasFullNameError = validateFullname(f);
        var hasEmailError = validateEmail(f);
        if(hasEmailError && isExistEmail)
        {
            $("#emailError").html("Email đã tồn tại");
        }
        var hasBirthday = validateBirthday(f);
        var hasAddressError = validateAddress(f);
        var hasPhoneError = validatePhone(f);
        var hasPassError = validatePassword(f);
        if (!hasFullNameError || !hasEmailError || !hasBirthday || !hasAddressError || !hasPhoneError || !hasPassError)
            return false;
        else
            return true;
    }
    $("body").on("change", "#email", function validateEmailTrung() {
        var email = $("#email").val();
        var message = $("#emailError");
        $.ajax({
            url: "email",
            type: "GET",
            data: {email: email},
            success: function (result) {
                if (result) {
                    message.html("Email đã tồn tại");
                    isExistEmail = true;
                } else
                {
                    message.html("");
                    isExistEmail = false;
                }
            }
        });
        if (message.val() !== "") {
            return false;
        } else
            return true;
    });

    function validateFullname(form) {
        var fullname = form["fullName"].value;
        return check(fullname, "fullNameError", "Họ và tên ");
    }
    function validateEmail(form) {
        var email = form["email"].value;
        return check(email, "emailError", "Email ");
    }
    function validateBirthday(form) {
        var birthday = form["birthDay"].value;
        return check(birthday, "birthDayError", "Ngày sinh ");
    }
    function validateAddress(form) {
        var address = form["address"].value;
        return check(address, "addressError", "Địa chỉ ");
    }
    function validatePhone(form) {
        var phone = form["phoneNumber"].value;
        return check(phone, "phoneNumberError", "Số điện thoại ");
    }

    function validatePassword(form) {
        var pass = form["pass"].value;
        return check(pass, "passError", "Mật khẩu ");
    }

    //Form Login
    function validateFormLogin() {
        var fLogin = document.getElementById("loginForm");
        var hasEmailError = validateEmailLogin(fLogin);
        var hasPassError = validatePassLogin(fLogin);
        if (!hasEmailError || !hasPassError)
            return false;
        else
            return true;
    }
    function validateEmailLogin(fLogin) {
        var email = fLogin["inputEmail"].value;
        return check(email, "inputEmailError", "Email ");
    }
    function validatePassLogin(fLogin) {
        var pass = fLogin["inputPassword"].value;
        return check(pass, "inputPasswordError", "Mật khẩu ");
    }
    //Hàm Check
    function check(value, feild, name) {
        var error = document.getElementById(feild);
        error.innerHTML = "";
        if (value === null || value === "") {
            error.innerHTML = name + "không được để trống";
        }
        //Check Password
        else if (feild === "passError") {
            if (value.length < 6) {
                error.innerHTML = name + "phải trên 5 ký tự";
            }
        }
        //Check Email
        else if (feild === "emailError" || feild === "inputEmailError") {
            var regx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            if (!value.match(regx)) {
                error.innerHTML = name + "sai định dạng!";
            }
        }
        //Check Số điện thoại
        else if (feild === "phoneNumberError") {
            if (isNaN(value)) {
                error.innerHTML = name + "sai định dạng!";
            }
        }
        //Check Địa Chỉ
        else if (feild === "addressError") {
            if (!isNaN(value)) {
                error.innerHTML = name + "sai định dạng!";
            }
        }

        if (error.innerHTML.length > 0)
            return false;
        else
            return true;
    }


</script> 
<script>
//    $(function () {
//        $("body").on("change", "#email", function () {
//            var email = $("#email").val();
//            $.ajax({
//                url: "email",
//                type: "GET",
//                data: {email: email},
//                success: function (result) {
//                    var message = $("#emailError");
//                    if (result) {
//                        message.html("Email đã tồn tại");
//                    } else
//                        message.html("");
//                }
//            });
//        });
//    });

</script>   