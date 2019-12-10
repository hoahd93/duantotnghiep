<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Main Navbar-->
<header class="header">
    <nav class="navbar">
        <!-- Search Box-->
        <div class="search-box">
            <button class="dismiss"><i class="fa fa-close"></i></button>
            <form id="searchForm" action="#" role="search">
                <input type="search" placeholder="Nhập từ khóa bạn muốn tìm kiếm" class="form-control">
            </form>
        </div>
        <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
                <!-- Navbar Header-->
                <div class="navbar-header">
                    <!-- Navbar Brand --><a href="/ShopFinal" class="navbar-brand d-none d-sm-inline-block">
                        <div class="brand-text d-none d-lg-inline-block"><span>Fashion </span><strong> Store</strong></div>
                        <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>FS</strong></div></a>
                    <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
                </div>
                <!-- Navbar Menu -->
                <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                    <!-- Search-->
                    <li class="nav-item d-flex align-items-center"><a id="search" href="#" class="nav-link"><span class="d-none d-sm-inline">Tìm kiếm  </span><i class="fa fa-search"></i></a></li>                            
                    <!-- Logout    -->
                    <li class="nav-item d-flex align-items-center">
                        <form action="<c:url value="/j_spring_security_logout"/>" method="post" name="logout">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <a href="javascript: submitform();"><span class="d-none d-sm-inline">Đăng xuất </span> <i class="fa fa-sign-out"></i></a>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <script type="text/javascript">
        function submitform() {
            document.forms["logout"].submit();
        }
    </script> 
</header>