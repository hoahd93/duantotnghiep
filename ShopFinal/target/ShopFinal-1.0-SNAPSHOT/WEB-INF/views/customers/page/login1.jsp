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
                        <p class="text-center" style="color: red;margin-top: 5px">${message}</p>
                        <form name="loginForm" id="loginForm" class="form-signin" action="<c:url value="/ShopFinal/j_spring_security_login" />" method="POST">   
                            <div class="form-group">
                                <label for="username">Tài khoản:</label><p class="text-center" style="color: red;">${username}</p>
                                <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Nhập email"/>                               
                            </div>

                            <div class="form-group">
                                <label for="password">Mật khẩu:</label>
                                <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Nhập mật khẩu"/>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                </div>
                                <div class="form-group col-sm-6" style="text-align: right;">
                                    <a href="/ShopFinal/checkemail">Quên mật khẩu</a>
                                </div>
                            </div>
                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">ĐĂNG NHẬP</button>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />                           
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-6" style="border-left:  #0066cc solid 2px">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h1 class="card-title text-center" style="font-size: 30px">ĐĂNG KÝ</h1>
                        <p class="text-center" style="color: green;margin-top: 5px">${susscess}</p>

                        <form:form cssClass="form-signin" method="post" action="/ShopFinal/add-customer" modelAttribute="customer">
                            <div class="form-group">
                                <label for="inputName">Họ và tên</label>                       
                                <form:input cssClass="form-control" path="fullName" placeholder="Nhập họ tên" />
                            </div>
                            <div class="form-group">    
                                <label for="email">Giới tính: </label><br />
                                <form:select path="gender" cssClass="form-control">
                                    <form:option   value="1" label="Nam" />
                                    <form:option   value="2" label="Nữ" />
                                    <form:option   value="3" label="Khác" />
                                </form:select>
                                <div class="select-dropdown"></div>                                   
                            </div>
                            <div class="form-group">
                                <label for="email">Ngày sinh: </label><br />
                                <input type="date" class="form-control" name="birthDay"/>
                            </div>
                            <div class="form-group">
                                <label for="email">Email: </label><br />
                                <form:input class="form-control" path="email" placeholder="Nhập địa chỉ email" />
                            </div>
                            <div class="form-group">
                                <label for="email">Số điện thoại: </label>
                                <form:input class="form-control" path="phoneNumber" placeholder="Nhập số điện thoại" />
                            </div>
                            <div class="form-group">
                                <label for="inputAddress">Địa chỉ</label>
                                <form:input class="form-control" path="address" placeholder="Nhập địa chỉ"/>

                            </div>
                            <div class="form-group">
                                <label for="inputPhone">Tên tài khoản:</label>
                                <form:input class="form-control" path="userName" placeholder="Nhập tên tài khoản"/>
                            </div>
                            <div class="form-group">
                                <label for="inputPass">Mật khẩu</label>
                                <input type="passWord" class="form-control" name="pass" placeholder="Nhập mật khẩu" pattern=".{6,}" title="Mật khẩu phải trên 6 kí tự"/>
                            </div>
                            <br class="my-4">
                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">ĐĂNG KÝ</button>
                        </form:form>
                            
                            <form:form cssClass="form-signin" method="post" action="/ShopFinal/add-customer" modelAttribute="customer">
                            <div class="form-group">
                                <label for="inputName">Họ và tên</label>                       
                                <form:input cssClass="form-control" path="fullName" placeholder="Nhập họ tên" />
                            </div>
                            <div class="form-group">    
                                <label for="email">Giới tính: </label><br />
                                <form:select path="gender" cssClass="form-control">
                                    <form:option   value="1" label="Nam" />
                                    <form:option   value="2" label="Nữ" />
                                    <form:option   value="3" label="Khác" />
                                </form:select>
                                <div class="select-dropdown"></div>                                   
                            </div>
                            <div class="form-group">
                                <label for="email">Ngày sinh: </label><br />
                                <input type="date" class="form-control" name="birthDay"/>
                            </div>
                            <div class="form-group">
                                <label for="email">Email: </label><br />
                                <form:input class="form-control" path="email" placeholder="Nhập địa chỉ email" />
                            </div>
                            <div class="form-group">
                                <label for="email">Số điện thoại: </label>
                                <form:input class="form-control" path="phoneNumber" placeholder="Nhập số điện thoại" />
                            </div>
                            <div class="form-group">
                                <label for="inputAddress">Địa chỉ</label>
                                <form:input class="form-control" path="address" placeholder="Nhập địa chỉ"/>

                            </div>
                            <div class="form-group">
                                <label for="inputPhone">Tên tài khoản:</label>
                                <form:input class="form-control" path="userName" placeholder="Nhập tên tài khoản"/>
                            </div>
                            <div class="form-group">
                                <label for="inputPass">Mật khẩu</label>
                                <input type="passWord" class="form-control" name="pass" placeholder="Nhập mật khẩu" pattern=".{6,}" title="Mật khẩu phải trên 6 kí tự"/>
                            </div>
                            <br class="my-4">
                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">ĐĂNG KÝ</button>
                        </form:form>
                            
                    </div>
                </div>
            </div>
        </div>
    </div>
                   
</section>