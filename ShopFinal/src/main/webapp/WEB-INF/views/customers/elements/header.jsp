<%-- 
    Document   : header
    Created on : Sep 15, 2019, 5:13:26 PM
    Author     : KimAnh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="header-section">
    <div class="header-top">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 text-center text-lg-left">
                    <!-- logo -->
                    <a href="/ShopFinal" class="site-logo">
                        <div><h3>FASHION STORE</h3></div>
                    </a>
                </div>
                <div class="col-xl-6 col-lg-5">
                    <form class="header-search-form">
                        <input type="text" placeholder="Nhập từ khóa tìm kiếm ...">
                        <button><i class="flaticon-search"></i></button>
                    </form>
                </div>
                <div class="col-xl-4 col-lg-4">
                    <div class="user-panel">
                        <c:if test="${sessionScope.fullname==null}">                           
                            <div class="up-item">
                                <i class="fa fa-user"></i>
                                <a href="/ShopFinal/login">Tài khoản</a>
                            </div>
                        </c:if>  
                        <c:if test="${sessionScope.fullname!=null}">
                            <div class="up-item">
                                <ul class="main-menu">
                                    <li><i class="fa fa-user"></i>
                                        <a href="#">${sessionScope.fullname}</a>
                                        <ul class="sub-menu">
                                            <li><a href="/ShopFinal/myprofile">Thông tin cá nhân</a></li>
                                            <li>
                                                <form action="<c:url value="/j_spring_security_logout" />" method="post" name="logout">
                                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                    <a href="javascript: submitform();">Đăng xuất</a>
                                                </form>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </c:if> 
                        <div class="up-item">
                            <div class="shopping-card">
                                <i class="fa fa-shopping-cart"></i>
                                <span>0</span>
                            </div>
                            <a href="#">Giỏ hàng</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        function submitform() {
            document.forms["logout"].submit();
        }
    </script> 


</header>