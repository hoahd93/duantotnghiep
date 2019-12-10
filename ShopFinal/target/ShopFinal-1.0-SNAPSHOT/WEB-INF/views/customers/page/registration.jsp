<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-sm-6" style="border-left:  #0066cc solid 2px">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h1 class="card-title text-center" style="font-size: 30px">ĐĂNG KÝ</h1>
                        <p class="text-center" style="color: green;margin-top: 5px">${susscess}</p>

                        <form:form class="form-signin" method="post" action="/ShopFinal/add-customer" modelAttribute="customer">
                            <div class="form-group">
                                <label for="inputName">Họ và tên</label>                       
                                <form:input class="form-control" path="fullName" placeholder="Nhập họ tên" value="${sessionScope.keepName}"/>

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
                                <form:input type="date" class="form-control" path="birthDay"/>
                            </div>
                            <div class="form-group">
                                <label for="email">Email: </label><br />
                                <form:input class="form-control" path="email" placeholder="Nhập địa chỉ email"/>
                                <form:errors path="email"/>
                            </div>
                            <div class="form-group">
                                <label for="email">Số điện thoại: </label>
                                <form:input class="form-control" path="phoneNumber" placeholder="Nhập số điện thoại" />
                            </div>
                            <div class="form-group">
                                <label for="form:inputAddress">Địa chỉ</label>
                                <form:input class="form-control" path="address" placeholder="Nhập địa chỉ"/>

                            </div>
                            <div class="form-group">
                                <label for="form:inputPass">Mật khẩu</label>
                                <input type="passWord" class="form-control" name="pass" placeholder="Nhập mật khẩu"/>
                            </div>
                            <br class="my-4">
                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">ĐĂNG KÝ</button>
                        </form:form>                 
                    </div>
                </div>
            </div>