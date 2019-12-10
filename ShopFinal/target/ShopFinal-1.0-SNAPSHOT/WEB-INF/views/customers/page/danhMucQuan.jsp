<%-- 
    Document   : revenue
    Created on : Sep 13, 2019, 10:03:50 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<section class="forms"> 
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-10" style="margin: 50px; left: 10px;">
                <form method="post" action="${pageContext.request.contextPath}/DanhSachQuan"  enctype="multipart/form-data">
                    <fieldset>
                        <legend>Quần</legend>
                        <c:forEach var="ProQuan" items="${listProShow}">
                            <div class="col-lg-3 col-sm-6" >                                
                                <div class="product-item" >                                    
                                    <div class="pi-pic">
                                        <a href="/ShopFinal/sanPhamChiTiet/${ProQuan.getValue().get(0).productModelId}" title="Xem chi tiết" >
                                            <img style="width: 240px; height: 280px;" src="${pageContext.request.contextPath}/upload/${ProQuan.getValue().get(0).imgMain}" />
                                        </a>
                                        <div class="pi-links">
                                            <a href="#" class="add-card"><i class="flaticon-bag">                                                
                                                </i><span>ADD TO CART</span>
                                            </a>                                 
                                        </div>
                                    </div>
                                    <div class="pi-text">
                                        <a href="sanPhamChiTiet" title="Xem chi tiết">
                                            <h6> 
                                                <fmt:formatNumber maxIntegerDigits="9"  value="${ProQuan.getValue().get(0).price}"/>
                                                <span class="fa">VNĐ</span>
                                            </h6>  
                                        </a>
                                        <a href="/ShopFinal/sanPhamChiTiet/${ProQuan.getValue().get(0).productModelId}" title="Xem chi tiết" >
                                            <p>${ProQuan.getValue().get(0).name}</p></a>
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
