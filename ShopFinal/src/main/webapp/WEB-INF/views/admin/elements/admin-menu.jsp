<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="side-navbar">
    <!-- Sidebar Header-->
    <div class="sidebar-header d-flex align-items-center" enctype="multipart/form-data">
        <div class="avatar"><img src="${pageContext.request.contextPath}/upload/${sessionScope.image}" alt="" class="img-fluid rounded-circle"></div>
        <div class="title">
            <h1 class="h4">${sessionScope.fullname}</h1>
             <c:if test="${sessionScope.role=='1'}">              
            <p>QUẢN LÝ</p>
             </c:if>
            <c:if test="${sessionScope.role=='2'}">              
            <p>NHÂN VIÊN</p>
             </c:if>
        </div>
    </div>
    <!-- Sidebar Navidation Menus-->
    <ul class="list-unstyled">
        <li class="li"><a href="<c:url value="/manager/staff" />"> <i class="fa fa-home"></i>TRANG CHỦ </a></li>
        <li class="li"><a href="<c:url value="/manager/staff/mypro/{email}" />"> <i class="fa fa-address-card"></i>HỒ SƠ CÁ NHÂN </a></li>
        <li class="li"><a href="<c:url value="/manager/admin/staff" />"> <i class="fa fa-user"></i>QUẢN LÝ NHÂN VIÊN </a></li>
        <li class="lis"><a href="#Product" aria-expanded="false" data-toggle="collapse"> <i class="fa fa-list"></i>QUẢN LÝ SẢN PHẨM </a>
            <ul id="Product" class="collapse list-unstyled ">
                <li class="sub"><a href="<c:url value="/manager/staff/product"/>">DANH SÁCH SẢN PHẨM</a></li>
                <li class="sub"><a href="<c:url value="/manager/staff/productModel"/>">DANH SÁCH SẢN PHẨM-MODEL</a></li>
                <li class="sub"><a href="<c:url value="/manager/staff/category"/>">DANH MỤC SẢN PHẨM</a></li>
                <li class="sub"><a href="<c:url value="/manager/staff/size"/>">KÍCH THƯỚC</a></li>
                <li class="sub"><a href="<c:url value="/manager/staff/trademark"/>">NHÃN HIỆU</a></li>
                <li class="sub"><a href="<c:url value="/manager/staff/color"/>">MÀU SẮC</a></li>
            </ul>
        </li>
        <li class="li"><a href="<c:url value="/manager/staff/order" />"> <i class="fa fa-address-card"></i>QUẢN LÝ HÓA ĐƠN </a>
        </li>
        <li class="li"><a href="<c:url value="/manager/staff/feedback"/>"> <i class="fa fa-comment"></i>PHẢN HỒI KHÁCH HÀNG </a></li>
        <li class="lis"><a href="#Revenue" aria-expanded="false" data-toggle="collapse"> <i class="fa fa-bar-chart"></i>THỐNG KÊ DOANH THU </a>
            <ul id="Revenue" class="collapse list-unstyled ">
                <li class="sub"><a href="<c:url value="/manager/admin/invoice-day" />">THỐNG KÊ THEO NGÀY</a></li>
                <li class="sub"><a href="<c:url value="/manager/admin/invoice-month" />">THỐNG KÊ THEO THÁNG</a></li>
            </ul>
        </li>
    </ul>

</nav>

<script type="text/javascript">
    $(function () {
        $('.li a').filter(function () {
            return this.href === location.href
        }).parent().addClass('active').siblings().removeClass('active');
        $('.li a').click(function () {

            $(this).parent().addClass('active').siblings().removeClass('active');
        });
    });
    $(function () {
        $('.sub a').filter(function () {
            return this.href === location.href
        }).parent().addClass('active').siblings().removeClass('active');
        $('.sub a').click(function () {
            $(this).parent().addClass('active').siblings().removeClass('active');
            $('.sub a').filter(function () {
                return this.href === location.href
            }).parent().addClass('active').siblings().removeClass('active');
        });
    });
</script>