<%-- 
    Document   : revenue
    Created on : Sep 13, 2019, 10:03:50 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br/><br/>
<section class="forms">
    <div class="container-fluid">
        <div class="row">
            <form action="/ShopFinal/sanPhamChiTiet/{productModelId}" enctype="multipart/form-data">
                <c:forEach var="listProductShow" items="${listProductShow}">
                    <div class="col-lg-6">
                        <div class="product-pic-zoom">
                            <img style="width: 700px; height: 540px;" src="${pageContext.request.contextPath}/upload/
                                 <c:choose>
                                     <c:when test="${listProductShow.imgMain != null && !listProductShow.imgMain.equals('')}">${listProductShow.imgMain}</c:when>
                                     <c:otherwise>
                                         imageProduct1.png
                                     </c:otherwise>
                                 </c:choose>" class="product-big-img" />
                        </div> 

                        <div class="product-thumbs" tabindex="1" style="overflow: hidden; outline: none;">
                            <div class="product-thumbs-track">
                                <div class="pt active" data-imgbigurl="${pageContext.request.contextPath}/upload/${listProductShow.img1}">
                                    <img style="width: 240px; height: 115px;" src="${pageContext.request.contextPath}/upload/
                                         <c:choose>
                                             <c:when test="${listProductShow.img1 != null && !listProductShow.img1.equals('')}">${listProductShow.img1}</c:when>
                                             <c:otherwise>
                                                 imageProduct1.png
                                             </c:otherwise>
                                         </c:choose>" class="product-big-img" />
                                </div>
                                <div class="pt" data-imgbigurl="${pageContext.request.contextPath}/upload/${listProductShow.img2}">
                                    <img style="width: 240px; height: 115px;" src="${pageContext.request.contextPath}/upload/
                                         <c:choose>
                                             <c:when test="${listProductShow.img1 != null && !listProductShow.img1.equals('')}">${listProductShow.img2}</c:when>
                                             <c:otherwise>
                                                 imageProduct1.png
                                             </c:otherwise>
                                         </c:choose>" class="product-big-img" />
                                </div>
                                <div class="pt" data-imgbigurl="${pageContext.request.contextPath}/upload/${listProductShow.img3}">
                                    <img style="width: 240px; height: 115px;" src="${pageContext.request.contextPath}/upload/
                                         <c:choose>
                                             <c:when test="${listProductShow.img1 != null && !listProductShow.img1.equals('')}">${listProductShow.img3}</c:when>
                                             <c:otherwise>
                                                 imageProduct1.png
                                             </c:otherwise>
                                         </c:choose>" class="product-big-img" />
                                </div>
                                <div class="pt" data-imgbigurl="${pageContext.request.contextPath}/upload/${listProductShow.img4}">
                                    <img style="width: 240px; height: 115px;" src="${pageContext.request.contextPath}/upload/
                                         <c:choose>
                                             <c:when test="${listProductShow.img1 != null && !listProductShow.img1.equals('')}">${listProductShow.img4}</c:when>
                                             <c:otherwise>
                                                 imageProduct1.png
                                             </c:otherwise>
                                         </c:choose>" class="product-big-img" />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 product-details">
                        <h2 class="p-title">Tên sp: ${listProductShow.name}</h2>
                        <h2 class="p-title">Mã code: ${listProductShow.productCode}</h2>
                        <h3 class="p-price">Giá:    <fmt:formatNumber maxIntegerDigits="9"  value="${listProductShow.price}"/> VNĐ</h3>
                        <div class="fw-size-choose">
                            <p>Kích cỡ </p>
                            <input hidden="true" id="sizeid" value="${listProductShow.sizeId}" />
                            <c:forEach items="${listSize}" var="size">
                                <div class="sc-item">
                                    <input  type="radio" name="sc" value="${size.sizeId}" id="${size.sizeId}">
                                    <label for="${size.sizeId}" >${size.sizeName}</label>
                                </div>
                            </c:forEach>
                        </div>

                        <div class="quantity">
                            <p>Số lượng </p>
                            <div class="pro-qty"><input type="text" value="1"></div>
                        </div>
                        <a href="${pageContext.request.contextPath}/addCart/${listProductShow.productModelId}" class="site-btn">Thêm vào giỏ</a>
                        <div id="accordion" class="accordion-area">
                            <div class="panel">
                                <div class="panel-header" id="headingOne">
                                    <button class="panel-link active" data-toggle="collapse" data-target="#collapse1" aria-expanded="true" aria-controls="collapse1">Thông tin chi tiết</button>
                                </div>
                                <div id="collapse1" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                                    <div class="panel-body">
                                        <p>${listProductShow.description}</p>
                                    </div>
                                </div>
                            </div>                                        
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-12">
                <fieldset>
                    <legend>Bình luận</legend>
                    abcasdas
                </fieldset>
            </div>
        </c:forEach>
        </form>
    </div>
</div>
<script>
    $(document).ready(function () {
        var side = $("#sizeid").val();
        $("input:radio[name=sc][value=" + side + "]").attr('checked', true);
        console.log('sc', side);
    });
</script>
</section>
