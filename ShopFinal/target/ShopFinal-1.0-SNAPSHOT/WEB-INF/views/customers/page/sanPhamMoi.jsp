<%-- 
    Document   : revenue
    Created on : Sep 13, 2019, 10:03:50 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<br/>
<section class="forms"> 
    <div class="container-fluid">
        <div class="row">

            <div class="col-lg-2">
                <div class="accordion" id="accordionExample">
                    <div class="card">
                        <div class="card-header" id="headingOne">
                            <h2 class="mb-0">
                                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    <span class="fa fa-list"></span>
                                    Danh mục sản phẩm
                                </button>
                            </h2>
                        </div>

                        <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                            <div class="card-body">
                                <a href="DanhSachAo" class="list-group-item">Áo Sơ mi</a>
                                <a href="DanhSachAo" class="list-group-item">Áo Khoác</a>
                                <a href="DanhSachAo" class="list-group-item">Áo Thun</a>
                                <a href="DanhSachQuan" class="list-group-item">Quần Jean</a>
                                <a href="DanhSachQuan" class="list-group-item">Quần Kaki</a>
                                <a href="DanhSachGiay" class="list-group-item">Giày - Dép</a>
                                <a href="DanhSachNonMu" class="list-group-item">Nón</a>
                                <a href="DanhSachTuiXach" class="list-group-item">Túi xách</a>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header" id="headingTwo">
                            <h2 class="mb-0">
                                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                    <span class="fa fa-tint"></span>   Màu sắc
                                </button>
                            </h2>
                        </div>
                        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                            <div class="card-body">
                                <a href="DanhSachAo" class="list-group-item">Màu Đen</a>
                                <a href="DanhSachAo" class="list-group-item">Màu Trắng</a>
                                <a href="DanhSachAo" class="list-group-item">Màu Xám</a>
                                <a href="DanhSachAo" class="list-group-item">Màu Hồng</a>
                            </div>
                        </div><br/><br/>
                    </div>
                </div>
            </div>
            <div class="col-lg-10">
                <form action="/ShopFinal/SanphamMoi" enctype="multipart/form-data">
                    <fieldset>
                        <legend>Sản Phẩm</legend>
                        <c:forEach items="${listProShow}" var="listprod">
                            <div class="col-lg-3 col-sm-6">
                                <div class="product-item">
                                    <div class="pi-pic">
                                        <a href="/ShopFinal/sanPhamChiTiet/${listprod.getValue().get(0).productModelId}" title="Xem chi tiết" >
                                            <image style="width: 240px; height: 260px;" src="${pageContext.request.contextPath}/upload/
                                                   <c:choose>
                                               <c:when test="${listprod.getValue().get(0).imgMain != null && !listprod.getValue().get(0).imgMain.equals('')}">${listprod.getValue().get(0).imgMain}</c:when>
                                             <c:otherwise>
                                                 imageProduct1.png
                                             </c:otherwise>
                                         </c:choose>" />
                                        </a><br>
                                        <div class="pi-links">
                                            <a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>                                 
                                        </div>
                                    </div>
                                    <div class="pi-text">                                        
                                        <h6>
                                            <fmt:formatNumber maxIntegerDigits="9"  value="${listprod.getValue().get(0).price}"/>
                                            <span class="fa">VNĐ</span>
                                        </h6>
                                        <a href="/ShopFinal/sanPhamChiTiet/${listprod.getValue().get(0).productModelId}" title="Xem chi tiết" >
                                            <label>${listprod.getValue().get(0).name}</label></a>
                                    </div>
                                </div>
                            </div> 
                        </c:forEach>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</section>
