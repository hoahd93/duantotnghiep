<%-- 
    Document   : customer
    Created on : Sep 15, 2019, 6:12:19 PM
    Author     : KimAnh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<section class="hero-section">
    <div class="hero-slider owl-carousel">
        <div class="hs-item set-bg" data-setbg="<c:url value="/customer/img/m.jpg"/>">
            <div class="container">
                <div class="row">
                    <div class="col-xl-6 col-lg-7 text-white">
                        <span>New Arrivals</span>
                        <h2>tên</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum sus-pendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. </p>
                        <a href="#" class="site-btn sb-line">DISCOVER</a>
                        <a href="#" class="site-btn sb-white">ADD TO CART</a>
                    </div>
                </div>
                <div class="offer-card text-white">
                    <span>Chỉ từ</span>
                    <h2>69K</h2>
                    <p>Mua ngay</p>
                </div>
            </div>
        </div>
        <div class="hs-item set-bg" data-setbg="<c:url value="/customer/img/bg.jpg"/>">
            <div class="container">
                <div class="row">
                    <div class="col-xl-6 col-lg-7 text-white">
                        <span>New Arrivals</span>
                        <h2>denim jackets</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum sus-pendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. </p>
                        <a href="#" class="site-btn sb-line">DISCOVER</a>
                        <a href="#" class="site-btn sb-white">ADD TO CART</a>
                    </div>
                </div>
                <div class="offer-card text-white">
                    <span>Chỉ từ</span>
                    <h2>99K</h2>
                    <p>Mua ngay</p>
                </div>
            </div>
        </div>
        <div class="hs-item set-bg" data-setbg="<c:url value="/customer/img/bg-2.jpg"/>">
            <div class="container">
                <div class="row">
                    <div class="col-xl-6 col-lg-7 text-white">
                        <span>Hàng Mới về</span>
                        <h2>denim jackets</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum sus-pendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. </p>
                        <a href="#" class="site-btn sb-line">DISCOVER</a>
                        <a href="#" class="site-btn sb-white">ADD TO CART</a>
                    </div>
                </div>
                <div class="offer-card text-white">
                    <span>Chỉ từ</span>
                    <h2>110K</h2>
                    <p>Mua ngay</p>
                </div>
            </div>
        </div>
    </div>   
</section>

<!-- Sản phẩm nổi bật -->
<section class="top-letest-product-section">
    <div class="container">
        <form action="${pageContext.request.contextPath}/indexCustomer" enctype="multipart/form-data">
            <div class="section-title">
                <h2>SẢN PHẨM NỔI BẬT</h2>
            </div>
            <div class="product-slider owl-carousel">
                <c:forEach items="${listProShow}" var="showNB"> 
                    <div class="product-item">
                        <div class="pi-pic">
                            <a href="/ShopFinal/sanPhamChiTiet/${showNB.getValue().get(0).productModelId}" title="Xem chi tiết" >
                                <image style="width: 240px; height: 280px;" src="${pageContext.request.contextPath}/upload/${showNB.getValue().get(0).imgMain}" />
                            </a><br>
                            <div class="pi-links">
                                <a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>                                
                            </div>
                        </div>
                        <div class="pi-text">
                            <h6>
                                <fmt:formatNumber maxIntegerDigits="9"  value="${showNB.getValue().get(0).price}"/>
                                <span class="fa">VNĐ</span>
                            </h6>
                            <a href="/ShopFinal/sanPhamChiTiet/${showNB.getValue().get(0).productModelId}" title="Xem chi tiết" >
                                <label>${showNB.getValue().get(0).name}</label></a>
                        </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </form>
    </div>
</section>

<div class="container">
    <div class="slide-num-holder" id="snh-1">

    </div>
    <div class="col-lg-12">
        <form action="${pageContext.request.contextPath}/indexCustomer" enctype="multipart/form-data">
            <fieldset>
                <h2><legend style="text-align: center">Sản Phẩm Mua Nhiều</legend></h2>
                <c:forEach items="${listProShow}" var="listprod">
                    <div class="col-lg-3 col-sm-6">
                        <div class="product-item">                           
                            <div class="pi-pic">
                                <a href="/ShopFinal/sanPhamChiTiet/${listprod.getValue().get(0).productModelId}" title="Xem chi tiết" >
                                    <image style="width: 240px; height: 280px;" src="${pageContext.request.contextPath}/upload/${listprod.getValue().get(0).imgMain}" /></a><br>
                                <div class="pi-links">
                                    <a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>                                 
                                </div>
                                 <h6>${listprod.getValue().get(0).descriptionShort}</h6>
                            </div>                            
                            <div class="pi-text">
                                <a href="sanPhamChiTiet" title="Xem chi tiết">
                                    <h6>
                                        <fmt:formatNumber maxIntegerDigits="9"  value="${listprod.getValue().get(0).price}"/>
                                        <span class="fa">VNĐ</span>
                                    </h6>
                                </a>
                                <a href="/ShopFinal/sanPhamChiTiet/${listprod.getValue().get(0).productModelId}" title="Xem chi tiết" >
                                    <label>${listprod.getValue().get(0).name}</label></a>
                                </a>
                            </div>
                        </div>
                    </div> 
                </c:forEach>
            </fieldset>
        </form>
    </div>
</div>