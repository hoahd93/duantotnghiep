<%-- 
    Document   : myprofile
    Created on : Oct 11, 2019, 4:33:41 PM
    Author     : admin
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<section class="checkout-section spad">
    <h2 class="text-center">THÔNG TIN CÁ NHÂN</h2>   
    <div class="container" style="background-color: #FFCCE6;border-radius: 10px; ">
        <div class="row" style="padding: 20px;">         
            <form:form id="form" cssStyle="border: red,soid,2px" action="/ShopFinal/myprofile/save?${_csrf.parameterName}=${_csrf.token}" modelAttribute="customer">
                <form:input type="hidden" path="userId" class="form-control" placeholder="Nhập họ và tên"/> 
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label>Tên: </label> 
                        <form:input class="form-control" path="fullName" id="fullName" placeholder="Nhập họ tên" cssStyle="margin-bottom: 5px;"/>
                        <font id="fullNameError" style="color: red;"></font>
                    </div>
                    <div class="form-group col-sm-6">
                        <label>Ngày tạo: </label> 
                        <form:input type="date" path="createDate" class="form-control" readonly="true"/>  
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
                        <form:input type="date" class="form-control" id="birthDay" path="birthDay" cssStyle="margin-bottom: 5px;"/>
                        <font id="birthDayError" style="color: red;"></font>                                 
                    </div>

                    <div class="form-group col-sm-6">
                        <label>Email: </label> 
                        <form:input type="email" path="email" class="form-control" placeholder="Nhập mật khẩu" name="email" readonly="true"/>                       
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label>Địa chỉ: </label> 
                        <form:input class="form-control" path="address" id="address" placeholder="Nhập địa chỉ" cssStyle="margin-bottom: 5px;"/>
                        <font id="addressError" style="color: red;"></font>                               
                    </div>
                    <div class="form-group col-sm-6">
                        <label>Số điện thoại: </label> 
                        <form:input class="form-control" path="phoneNumber" id="phoneNumber" placeholder="Nhập số điện thoại" cssStyle="margin-bottom: 5px;" />
                        <font id="phoneNumberError" style="color: red;"></font>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="form-group col-sm-6" style="text-align: right">                        
                        <button type="submit" class="btn btn-success" onclick="return validateFormEdit()">CẬP NHẬT</button>                                                         
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
            function validateFormEdit() {
                var f = document.getElementById("form");
                var hasFullNameError = validateFullname(f);
                var hasBirthday = validateBirthday(f);
                var hasAddressError = validateAddress(f);
                var hasPhoneError = validatePhone(f);
                if (!hasFullNameError || !hasBirthday || !hasAddressError || !hasPhoneError)
                    return false;
                else
                    return true;
            }
            function validateFullname(form) {
                var fullname = form["fullName"].value;
                return check(fullname, "fullNameError", "Họ và tên ");
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

            //Hàm Check
            function check(value, feild, name) {
                var error = document.getElementById(feild);
                error.innerHTML = "";
                if (value === null || value === "") {
                    error.innerHTML = name + "không được để trống";
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
    </div>
</section>
