<%-- 
    Document   : profile
    Created on : Sep 15, 2019, 4:27:12 PM
    Author     : KimAnh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<section class="checkout-section spad">
    <div class="container">       
        <form:form cssStyle="border: red,soid,2px" action="/ShopFinal/manager/staff/mypro/save?${_csrf.parameterName}=${_csrf.token}" modelAttribute="staff" method="POST" id="formprofile">
            <form:input type="hidden" path="userId" class="form-control" placeholder="Nhập họ và tên"/> 
            <div class="row">
                <div class="form-group col-sm-6">
                    <label>Tên: </label> 
                    <form:input type="text" path="fullName" class="form-control" placeholder="Nhập họ và tên" name="fullname" id="fullname" /> 
                   <span id="fullnameerorr" style="color: red"></span>
                </div>
                <div class="form-group col-sm-6">
                    <label>Ngày tạo: </label> 
                    <form:input type="date" path="createDate" class="form-control"  readonly="true"/>  
                </div>
            </div>
            <br>
            <div class="row">
                <div class="form-group col-sm-2">
                    <label>Giới tính: </label> 
                    <form:select path="gender" class ="form-control">
                        <form:option   value="1" label="Nam" />
                        <form:option   value="2" label="Nữ" />
                        <form:option   value="3" label="Khác" />
                    </form:select>                                 
                </div>
                <div class="form-group col-sm-4">
                    <label>Ngày sinh: </label> 
                    <form:input type="date" path="birthDay" class="form-control" placeholder="Nhập mật khẩu" name="birthday" id="birthday"/>
                    <span id="birthdayerorr" style="color: red"></span>
                </div>

                <div class="form-group col-sm-6">
                    <label>Email: </label> 
                    <form:input type="email" path="email" class="form-control" placeholder="Nhập mật khẩu" name="email" id="email"/>
                    <span id="message"></span>
                    <span id="emailerorr" style="color: red"></span>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label>Địa chỉ: </label> 
                    <form:input type="text" path="address" class="form-control" placeholder="Nhập địa chỉ" name="address" id="address"/>
                    <span id="addresserorr" style="color: red"></span>
                </div>
                <div class="form-group col-sm-6">
                    <label>Số điện thoại: </label> 
                    <form:input type="text" path="phoneNumber" class="form-control" placeholder="Nhập số điện thoại" name="phone" id="phone"/> 
                    <span id="phoneerorr" style="color: red"></span>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="form-group col-sm-6" style="text-align: right">                        
                    <button type="submit" class="btn btn-success btnupdate" onclick="return validateprofile();">CẬP NHẬT</button>                                                         
                </div>
                <div class="form-group col-sm-6">
                    <button type="button" class="btn btn-success" onclick="back()">QUAY LẠI</button>                                
                </div>
            </div>
        </form:form>
    </div>
    <script>
        function back() {
            history.back();
        }
    </script>
</section>
<script>
    function validateprofile(){
        var name = document.getElementById("fullname").value;
        var birthday = document.getElementById("birthday").value;
        var email = document.getElementById("email").value;
        var filteremail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; //định dạng mail
        var address = document.getElementById("address").value;
        var phone = document.getElementById("phone").value;
        var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g; // định dạng số điện thoại
        var status = true;
        if(name === ""){
            document.getElementById("fullnameerorr").innerHTML = "Không được bỏ trống họ tên";
            status = false;
        } else {
            document.getElementById("fullnameerorr").innerHTML = "";
        }
        if(birthday === ""){
            document.getElementById("birthdayerorr").innerHTML = "Không được bỏ trống ngày sinh";
            status = false;
        } else {
            document.getElementById("birthdayerorr").innerHTML = "";
        }
        if (email !== '') {
            if (filteremail.test(email) === false)
            {
                document.getElementById("emailerorr").innerHTML = "Hay nhap dia chi email hop le.";
                status = false;
            } else {
                document.getElementById("emailerorr").innerHTML = "";
            }
        } else {
            document.getElementById("emailerorr").innerHTML = "Bạn không được bỏ trống email!";
            status = false;
        }
        if(address === ""){
            document.getElementById("addresserorr").innerHTML = "Không được bỏ trống địa chỉ";
            status = false;
        } else {
            document.getElementById("addresserorr").innerHTML = "";
        }
        if (phone !== '') {
            if (vnf_regex.test(phone) === false)
            {
                document.getElementById("phoneerorr").innerHTML = "Số điện thoại của bạn không đúng định dạng!";
                status = false;
            } else {
                document.getElementById("phoneerorr").innerHTML = "";
            }
        } else {
            document.getElementById("phoneerorr").innerHTML = "Bạn chưa điền số điện thoại!";
            status = false;
        }
        
        return status;
    }   
        $("body").on("change", "#fullname", function () {
            var fulname = $("#fullnameerorr");
            fulname.html("");
        });
        $("body").on("change", "#birthday", function () {
            var birth = $("#birthdayerorr");
            birth.html("");
        });
        $("body").on("change", "#phonenumber", function () {
            var phone = $("#phonerorr");
            phone.html("");
        });
        $("body").on("change", "#email", function () {
            var email = $("#emailerorr");
            var message = $("#message");
            message.html("");
            email.html("");
        });
        $("body").on("change", "#address", function () {
            var address = $("#addresserorr");
            address.html("");
        });
        
</script>
<script>
    $(function () {
        //CHECK TRÙNG EMAIL
        $("body").on("change", "#email", function () {
            $(".btnupdate").attr("disabled", false);
            var email = $('#email').val();
            $.ajax({
                url: "checkEmail",
                type: "GET",
                data: {email: email},
                success: function (result) {
                    var message = $("#message");
                    if (result) {
                        message.css("color", "red");
                        message.html("địa chỉ email đã tồn tại");
                        $(".btnupdate").attr("disabled", true);
                    } else {
                        $(".btnupdate").attr("disabled", false);
                    }
                }
            });
        });
//        $("body").on("click", "#formprofile", function () {
//            $(".btnupdate").attr("disabled", false);
//            var message = $("#message");
//            message.html("");
//
//        });
         });
</script>
