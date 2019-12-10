<%-- 
    Document   : quanlysanpham
    Created on : Sep 13, 2019, 9:48:10 AM
    Author     : admin
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<section class="forms"> 
    <div class="container-fluid">
        <div class="row">
            <!--LIST-->
            <div class="container">
                <div class="card">
                    <div class="card-header d-flex align-items-center">
                        <div class="col-sm-6">
                            <h1>DANH SÁCH SẢN PHẨM</h1>
                        </div>
                        <div class="form-group col-sm-3">
                            <form method="post" action="${pageContext.request.contextPath}/manager/staff/search?${_csrf.parameterName}=${_csrf.token}" id="searchProduct">
                                <div class="row">
                                    <div>
                                        <input class="form-control" name="search_product" placeholder="nhập tên cần tìm" required/>

                                    </div>
                                    <div style="text-align: right">
                                        <button type="submit" class="btn btn-success"><span class="fa fa-search"></span></button>
                                    </div> 
                                </div>           
                            </form>
                        </div>
                        <div class="col-sm-3" style="text-align: right">
                            <button type="button" id="modalInsert11" class="btn btn-success btn_reset" data-toggle="modal" data-target="#modalInsert">
                                THÊM SẢN PHẨM
                            </button>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered table-hover table-striped" >
                            <thead style="text-align: center">
                                <tr>
                                    <th>STT</th>
                                    <th>Tên sp</th>
                                    <th>Mã Code</th>
                                    <th>Giảm giá(%)</th>
                                    <th>Hình ảnh</th>                
                                    <th>Tên nhãn hiệu</th>
                                    <th>Ngày tạo</th>
                                    <th>Ngày cập nhật</th>
                                    <th colspan="2">Thao tác</th>
                                </tr> 
                            </thead>

                            <tbody id="my_table">
                                <c:forEach var="product" items="${listProduct}" varStatus="status"> 
                                    <tr> 
                                        <td align="center">${status.count}</td>
                                        <td class="pro_model_id" data-promodelid="${product.productModelId}" style="display: none">${product.productModelId}</td>
                                        <td hidden="" class="pro_id" data-id="${product.productId}">${product.productId}</td>
                                        <td class="pro_name" data-name="${product.name}">${product.name}</td> 

                                        <td class="pro_color" data-color="${product.colorId}" style="display: none">${product.colorId}</td>
                                        <td class="pro_size" data-size="${product.sizeId}" style="display: none">${product.sizeId}</td>
                                        <td class="pro_stock" data-stock="${product.stock}" style="display: none">${product.stock}</td>
                                        <td class="pro_price" data-price="${product.price}" style="display: none">${product.price}</td>

                                        <td  class="pro_code" data-code="${product.productCode}">${product.productCode}</td> 
                                        <td class="pro_rate" data-rate="${product.discountRate}">${product.discountRate}</td>
                                        <td hidden="" class="pro_short" data-short="${product.descriptionShort}">${product.descriptionShort}</td>
    <!--                                    <td class="pro_des" data-des="${product.description}">${product.description}</td>-->
                                        <td class="pro_cate" data-cate="${product.categoryId}" style="display: none">
                                            <c:forEach var="cate" items="${cate}">
                                                <c:if test="${product.categoryId==cate.categoryId}">
                                                    ${cate.nameCategory}
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td class="pro_image" data-src="${pageContext.request.contextPath}/upload/${product.imgMain}">
                                        </td>
                                        <td class="img1" hidden="" data-src="${pageContext.request.contextPath}/upload/${product.img1}"> 
                                        </td>
                                        <td class="img2" hidden="" data-src="${pageContext.request.contextPath}/upload/${product.img2}">
                                        </td>
                                        <td class="img3" hidden="" data-src="${pageContext.request.contextPath}/upload/${product.img3}">
                                        </td>
                                        <td class="img4" hidden="" data-src="${pageContext.request.contextPath}/upload/${product.img4}">
                                        </td>
                                        <td   class="pro_trade" data-trade="${trademark.trademarkName}">
                                            <c:forEach var="trademark" items="${trade}">
                                                <c:if test="${product.trademarkId==trademark.trademarkId}">
                                                    ${trademark.trademarkName}
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td><fmt:formatDate value="${product.createdAt}" pattern="dd-MM-yyyy" /></td>
                                        <td><fmt:formatDate value="${product.updateDate}" pattern="dd-MM-yyyy" /></td>
                                        <td >
                                            <button type="button" class="btn btn-success btn_edit btn_resert" title="Sửa">
                                                <span class="fa-edit"></span>
                                            </button> 
                                        </td>
                                        <td>
                                            <button type="button" class="btn btn-warning btn_remove" title="Xóa">
                                                <span class="fa-trash"></span>
                                            </button>
                                        </td>  
                                    </tr>
                                </c:forEach> 
                            </tbody>

                        </table>
                        <ul id="pagination" style="list-style: none"></ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!------------THÊM SẢN PHẨM-------------->

    <!-- The Modal -->
    <div class="modal fade" id="modalInsert">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">THÊM SẢN PHẨM</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form method="post" action="${pageContext.request.contextPath}/manager/staff/product?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" id="formInsertProduct">    
                        <div class="form-group">
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label for="email">Nhập tên sản phẩm: </label><br />
                                    <input class="form-control" name="productName" placeholder="Nhập tên sản phẩm" id="productName"/>
                                    <span id="message" style="color: red"></span>
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="email">Nhập mã code: </label><br />
                                    <input class="form-control" name="productCode" placeholder="Nhập mã code" id="productCode" onkeyup="ClearMessage()"/>
                                    <span id="messageCode" style="color: red"></span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label for="email">Phần trăm giảm giá: </label><br />
                                    <input class="form-control" name="discoutRate" placeholder="Nhập phần trăm giảm giá" value="0" id="discoutRate"/>
                                    <span id="messageRate" style="color: red"></span>
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="email">Mô tả ngắn: </label><br />
                                    <input class="form-control" name="descriptionShort" placeholder="Mô tả ngắn"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label for="email">Mô tả chi tiết: </label><br />
                                    <input class="form-control" name="description" placeholder="Mô tả chi tiết" />
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="email">Tên danh mục: </label><br />
                                    <select name="categoryId" class="form-control"> 
                                        <%--<form:options items="${listCategory}" itemValue="categoryId" itemLabel="nameCategory"/>--%> 
                                        <c:forEach var="category" items="${cate}">
                                            <option class="form-control" value="${category.categoryId}" label="${category.nameCategory}"/>
                                        </c:forEach>
                                    </select>

                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label>Màu sắc: </label>        
                                    <select name="color_Id" class="form-control">
                                        <c:forEach var="color" items="${listColor}">
                                            <option class="form-control" value="${color.colorId}" label="${color.nameColor}"/>
                                        </c:forEach>                   
                                    </select>
                                </div>
                                <div class="form-group col-sm-6">
                                    <label>Kích cở: </label>        
                                    <select name="size_Id" class="form-control">                          
                                        <c:forEach var="size" items="${listSize}">
                                            <option class="form-control" value="${size.sizeId}" label="${size.sizeName}"/>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label>Số lượng: </label> 
                                    <input type="text" class="form-control" name="productmodel_stork" placeholder="Nhập số lượng" id="productmodel_stork"/>                                 
                                    <span id="messageStock" style="color: red"></span>
                                </div>
                                <div class="form-group col-sm-6">
                                    <label>Giá: </label> 
                                    <input type="text" class="form-control" name="productmodel_price" placeholder="Nhập giá" id="productmodel_price"/>                                 
                                    <span id="messagePrice" style="color: red"></span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label for="email">Ảnh chính: </label><br />
                                    <input  name="imageMain" type="file" id="imageMain"/>
                                    <span id="messageImg" style="color: red"></span>
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="email">Ảnh 1: </label><br />
                                    <input name="image1" type="file" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label for="email">Ảnh 2: </label><br />
                                    <input  name="image2" type="file" />
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="email">Ảnh 3: </label><br />
                                    <input  name="image3" type="file" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label for="email">Ảnh 4: </label><br />
                                    <input  name="image4" type="file" />
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="email">ID nhãn hiệu: </label><br />
                                    <select name="trademarkId" class="form-control"> 
                                        <%--<form:options items="${listTrademark}" itemValue="trademarkId" itemLabel="trademarkName"/>--%> 
                                        <c:forEach var="trademark" items="${trade}">
                                            <option class="form-control" value="${trademark.trademarkId}" label="${trademark.trademarkName}"/>
                                        </c:forEach>
                                    </select> 
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="submit" class="btn btn-success btn-insertProduct">THÊM</button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">HỦY</button>
                            </div>
                        </div>                           
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-------MODAL CẬP NHẬT SẢN PHẨM-------> 


    <!-- The Modal -->
    <div class="modal fade" id="modalEdit" >
        <div class="modal-dialog modal-xl">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">CẬP NHẬT SẢN PHẨM</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form method="post" action="${pageContext.request.contextPath}/manager/staff/editproduct123?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" id="formUpdate">  
                        <input type="hidden" name="pro_id">
                        <input type="hidden" name="pro_modelId">
                        <div class="form-group">
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label for="email">Nhập tên sản phẩm: </label><br />
                                    <input class="form-control" name="pro_name" placeholder="nhập tên sản phẩm" >
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="email">Nhập mã code: </label><br />
                                    <input class="form-control" name="pro_code" placeholder="nhập mã code" >

                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label for="email">Phần trăm giảm giá: </label><br />
                                    <input class="form-control" name="pro_rate" placeholder="nhập Phần trăm giảm giá" >
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="email">Mô tả ngắn: </label><br />
                                    <input class="form-control" name="pro_short" placeholder="Mô tả ngắn" >
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label for="email">Mô tả chi tiết: </label><br />
                                    <input class="form-control" name="pro_des" placeholder="Mô tả chi tiết" >
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="email">Tên danh mục: </label><br />
                                    <select name="pro_cate" class="form-control">
                                        <c:forEach var="cate" items="${cate}">
                                            <option class="form-control" value="${cate.categoryId}" label="${cate.nameCategory}">
                                            </c:forEach>                   
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label>Màu sắc: </label>        
                                    <select name="pro_color" class="form-control">
                                        <c:forEach var="color" items="${listColor}">
                                            <option class="form-control" value="${color.colorId}" label="${color.nameColor}">
                                            </c:forEach>                   
                                    </select>
                                </div>
                                <div class="form-group col-sm-6">
                                    <label>Kích cở: </label>        
                                    <select name="pro_size" class="form-control">                          
                                        <c:forEach var="size" items="${listSize}">
                                            <option class="form-control" value="${size.sizeId}" label="${size.sizeName}">
                                            </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label>Số lượng: </label> 
                                    <input type="text" class="form-control" name="pro_stork" placeholder="Nhập số lượng" required>                                 
                                </div>
                                <div class="form-group col-sm-6">
                                    <label>Giá: </label> 
                                    <input type="text" class="form-control" name="pro_price" placeholder="Nhập giá" required>                                 
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label for="email">Ảnh chính: </label><br />
                                    <input  name="pro_image" type="file" >
                                    <div style="height: 100px;width: 100px">
                                        <img width="100" height="100" name="imgMain" src=""/>
                                    </div>
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="email">Ảnh 1: </label><br />
                                    <input name="image1" type="file" >
                                    <div style="height: 100px;width: 100px">
                                        <img width="100" height="100" name="img1" src=""/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label for="email">Ảnh 2: </label><br >
                                    <input  name="image2" type="file"/>
                                    <div style="height: 100px;width: 100px">
                                        <img width="100" height="100" name="img3" src=""/>
                                    </div>
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="email">Ảnh 3: </label><br />
                                    <input  name="image3" type="file" >
                                    <div style="height: 100px;width: 100px">
                                        <img width="100" height="100" name="img3" src=""/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm-6">
                                    <label for="email">Ảnh 4: </label><br />
                                    <input  name="image4" type="file">
                                    <div style="height: 100px;width: 100px">
                                        <img width="100" height="100" name="img4"  src=""/>
                                    </div>

                                </div>

                                <div class="form-group col-sm-6">
                                    <label for="email">ID nhãn hiệu: </label><br />
                                    <select name="pro_trade" class="form-control">
                                        <c:forEach var="trade" items="${trade}">
                                            <option class="form-control" value="${trade.trademarkId}" label="${trade.trademarkName}">
                                            </c:forEach>                   
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="submit" class="btn btn-success">SỬA</button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">HỦY</button>
                            </div>
                        </div>                            
                    </form>  
                </div>
            </div>
        </div>
    </div>
</section>

<script>
    var total_row = ${count};
    var rowEditObject;
    function loadPageProduct(pageIndex) {
        var url = "get_product?${_csrf.parameterName}=${_csrf.token}";
        $.ajax({
            url: url,
            data: {page: pageIndex},
            success: function (result) {
                var html = "";
                $.each(result, function (index, data) {
                    html += '<tr class="pageStype"> ';
                    html += '<td align="center">' + (index + 1) + '</td>';
                    html += '<td class="pro_model_id" data-promodelid="' + data.productModelId + '" style="display: none">' + data.productModelId + '</td>';
                    html += '<td hidden="" class="pro_id" data-id="' + data.productId + '">' + data.productId + '</td>';
                    html += '<td class="pro_name" data-name="' + data.name + '">' + data.name + '</td>';
                    html += '<td class="pro_color" data-color="' + data.colorId + '" style="display: none">' + data.colorId + '</td>';
                    html += '<td class="pro_size" data-size="' + data.sizeId + '" style="display: none">' + data.sizeId + '</td>';
                    html += '<td class="pro_stock" data-stock="' + data.stock + '" style="display: none">' + data.stock + '</td>';
                    html += '<td class="pro_price" data-price="' + data.price + '" style="display: none">' + data.price + '</td>';
                    html += '<td  class="pro_code" data-code="' + data.productCode + '">' + data.productCode + '</td>';
                    html += '<td class="pro_rate" data-rate="' + data.discountRate + '">' + data.discountRate + '</td>';
                    html += '<td hidden="" class="pro_short" data-short="' + data.descriptionShort + '">' + data.descriptionShort + '</td>';
                    html += '<td class="pro_cate" data-cate="' + data.categoryId + '" style="display: none">';
                    html += '<c:forEach var="cate" items="${cate}">';
                    html += '<c:if test="${data.categoryId==cate.categoryId}">';
                    html += '${cate.nameCategory}';
                    html += '</c:if>';
                    html += '</c:forEach>';
                    html += '</td>';
                    html += '<td class="pro_image" data-src="ShopFinal/src/main/webapp/WEB-INF/resources/upload/' + data.imgMain + '">';
                    html += '<td   class="pro_trade" data-trade="' + data.trademarkName + '">';
                    html += '<c:forEach var="trademark" items="${trade}">';
                    html += '<c:if test="${data.trademarkId==trademark.trademarkId}">';
                    html += '${trademark.trademarkName}';
                    html += '</c:if>';
                    html += '</c:forEach>';
                    html += '<a href="../../../../java / shop / model / CategoryModel.java"></a>';
                    html += '</td>';
                    html += '	<td>' + data.createdAt + '</td>';
                    html += '	<td>' + data.updateDate + '</td>';
                    html += '<td>';
                    html += '<button type="button" class="btn btn-success btn_edit btn_resert" title="Sửa">';
                    html += '<span class="fa-edit"></span>';
                    html += '</button> ';
                    html += '</td>';
                    html += '<td>';
                    html += '<button type="button" class="btn btn-warning btn_remove" title="Xóa">';
                    html += '<span class="fa-trash"></span>';
                    html += '</button>';
                    html += '</td>';
                    html += '</tr>';
                });
                $("#my_table").html(html);
                $("#pagination").html(pagination(pageIndex, total_row));
            }
        });
    }
    ;
    $(function () {
        $("#pagination").html(pagination(1, total_row));
        $("body").on("click", ".page-link", function () {
            if ($(this).closest("li").hasClass("active")) {
                return false;
            } else {
                loadPageProduct($(this).text());
            }
        });
        console.log("ready");
        $("body").on("click", ".btn_edit", function () {
            console.log($(this).closest("tr").find("td.pro_image").data("src"));
            $("#modalEdit input[name=pro_modelId]").val($(this).closest("tr").find("td.pro_model_id").data("promodelid"));
            $("#modalEdit input[name=pro_id]").val($(this).closest("tr").find("td.pro_id").data("id"));
            $("#modalEdit input[name=pro_name]").val($(this).closest("tr").find("td.pro_name").data("name"));
            $("#modalEdit input[name=pro_code]").val($(this).closest("tr").find("td.pro_code").data("code"));
            $("#modalEdit input[name=pro_rate]").val($(this).closest("tr").find("td.pro_rate").data("rate"));
            $("#modalEdit input[name=pro_short]").val($(this).closest("tr").find("td.pro_short").data("short"));
            $("#modalEdit input[name=pro_des]").val($(this).closest("tr").find("td.pro_des").data("des"));
            $("#modalEdit select[name=pro_cate]").val($(this).closest("tr").find("td.pro_cate").data("cate"));
            $("#modalEdit img[name=imgMain]").attr('src', $(this).closest("tr").find("td.pro_image").data("src"));
            $("#modalEdit img[name=img1]").attr('src', $(this).closest("tr").find("td.img1").data("src"));
            $("#modalEdit img[name=img2]").attr('src', $(this).closest("tr").find("td.img2").data("src"));
            $("#modalEdit img[name=img3]").attr('src', $(this).closest("tr").find("td.img3").data("src"));
            $("#modalEdit img[name=img4]").attr('src', $(this).closest("tr").find("td.img4").data("src"));
            $("#modalEdit select[name=pro_color]").val($(this).closest("tr").find("td.pro_color").data("color"));
            $("#modalEdit select[name=pro_size]").val($(this).closest("tr").find("td.pro_size").data("size"));
//            $("#modalEdit select[name=pro_trade]").val($(this).closest("tr").find("td.pro_color").data("color"));
            $("#modalEdit input[name=pro_stork]").val($(this).closest("tr").find("td.pro_stock").data("stock"));
            $("#modalEdit input[name=pro_price]").val($(this).closest("tr").find("td.pro_price").data("price"));
            $("#modalEdit").modal("show");
        });
        $("body").on("click", ".btn_remove", function () {
            console.log($(this).closest("tr").find("td.pro_id").data("id"));
            var idProduct = $(this).closest("tr").find("td.pro_id").data("id");
            var idProductModel = $(this).closest("tr").find("td.pro_model_id").data("promodelid");
            var row = $(this).closest("tr");
            $.ajax({
                url: "deleteproduct",
                type: "GET",
                data: {idProduct: idProduct,
                    idProductModel: idProductModel},
                success: function (result) {
                    if (result) {
                        total_row--;
                        loadPageProduct($("#pagination li.active a").text());
                    } else {
                        alert("Lỗi roi");
                    }
                },
                error: function (result) {
                    alert("Lỗi");
                }
            });
        });
        //check lỗi cập nhật
        $("#formUpdate").validate({
            rules: {
                pro_name: "required",
                pro_code: "required",
                imageMain: "required"
//                image1: "required",
//                image2: "required",
//                image3: "required",
//                image4: "required",
            },
            messages: {
                pro_name: "Vui lòng nhập tên sản phẩm",
                pro_code: "Vui lòng nhập mã sản phẩm",
                imageMain: "Vui lòng thêm hình sản phẩm"
//                image1: "Vui lòng thêm hình sản phẩm",
//                image2: "Vui lòng thêm hình sản phẩm",
//                image3: "Vui lòng thêm hình sản phẩm",
//                image4: "Vui lòng thêm hình sản phẩm",
            }
        });
        // thêm mới
        $("body").on("click", ".btn-insertProduct", function (e) {
            alert("vao day");
            var productName = $("#modalInsert input[name=productName]").val();
            var productCode = $("#modalInsert input[name=productCode]").val();
            var discoutRate = $("#modalInsert input[name=discoutRate]").val();
            var descriptionShort = $("#modalInsert input[name=descriptionShort]").val();
            var description = $("#modalInsert input[name=description]").val();
            var categoryId = $("#modalInsert select[name=categoryId]").val();
            var color_Id = $("#modalInsert select[name=color_Id]").val();
            var size_Id = $("#modalInsert select[name=size_Id]").val();
            var productmodel_stork = $("#modalInsert input[name=productmodel_stork]").val();
            var productmodel_price = $("#modalInsert input[name=productmodel_price]").val();
            var trademarkId = $("#modalInsert select[name=trademarkId]").val();


            // Thêm đoạn check lỗi ở đây
            console.log("bat dau ne");
            var testInt = /^\d*$/;
            var messageName = $("#message");
            var messageCode = $("#messageCode");
            var messageRate = $("#messageRate");
            var messageStock = $("#messageStock");
            var messagePrice = $("#messagePrice");
//            var messageImg = $("#messageImg");


            var productName = $("#productName").val();
            var productCode = $("#productCode").val();
            var discoutRate = $("#discoutRate").val();
            var productmodel_stork = $("#productmodel_stork").val();
            var productmodel_price = $("#productmodel_price").val();
//            var imageMain = $("#imageMain").val();
//            var imageMain = $.trim($("#messageImg").val());
            alert(productmodel_stork);
            alert(parseInt(discoutRate));
            // RỖNG & ĐỊNH DẠNG
            if (productName === "") {
                messageName.html("Không được để trống tên sản phẩm");
                e.preventDefault();
            }
            if (productCode === "") {
                messageCode.html("Không được để trống mã sản phẩm");
                e.preventDefault();
            }
            if (discoutRate === "") {
                messageRate.html("Không được để trống phần trăm giảm giá");
                e.preventDefault();
            } else if (testInt.test(discoutRate) === false || parseInt(discoutRate) > 100) {
                messageRate.html("Phải là số nguyên, lớn hơn hoặc bằng 0 và bé hơn hoặc bằng 100");
                e.preventDefault();
            }
            if (productmodel_stork === "") {
                messageStock.html("Không được để trống số lượng sản phẩm");
                e.preventDefault();
            } else if (testInt.test(productmodel_stork) === false) {
                messageStock.html("Phải là số nguyên và lớn hơn  0");
                e.preventDefault();
            }
            if (productmodel_price === "") {
                messagePrice.html("Không được để trống giá sản phẩm");
                e.preventDefault();
            } else if (testInt.test(productmodel_price) === false) {
                messagePrice.html("Phải là số nguyên và lớn hơn  0");
                e.preventDefault();
            }

            var formData = new FormData();
            var url = "addproduct?${_csrf.parameterName}=${_csrf.token}";



            formData.append('productName', productName);
            formData.append('productCode', productCode);
            formData.append('discoutRate', discoutRate);
            formData.append('descriptionShort', descriptionShort);
            formData.append('description', description);
            formData.append('categoryId', categoryId);
            formData.append('color_Id', color_Id);
            formData.append('size_Id', size_Id);
            formData.append('productmodel_stork', productmodel_stork);
            formData.append('productmodel_price', productmodel_price);
            formData.append('trademarkId', trademarkId);
            formData.append('imageMain', $("#modalInsert input[name=imageMain]")[0].files[0]);
            formData.append('image1', $("#modalInsert input[name=image1]")[0].files[0]);
            formData.append('image2', $("#modalInsert input[name=image2]")[0].files[0]);
            formData.append('image3', $("#modalInsert input[name=image3]")[0].files[0]);
            formData.append('image4', $("#modalInsert input[name=image4]")[0].files[0]);

            $.ajax({
                url: url,
//                cache: false,
                contentType: false,
                processData: false,
//                data: formData.serialize(),
                type: 'POST',
                data: formData,
                success: function (data) {
                    $("#modalInsert").modal("hide");
                    total_row++;
                    loadPageProduct($("#pagination li.active a").text());

                },
                error: function (error) {
                    console.log(error);

                }
            });

        });
        // CLEAR MESSAGE
        $("body").on("click", "#modalInsert11", function () {
            $(".btn-insertProduct").attr("disabled", false);
            var messageName = $("#message");
            var messageCode = $("#messageCode");
            var messageRate = $("#messageRate");
            var messageStock = $("#messageStock");
            var messagePrice = $("#messagePrice");
            var messageImg = $("#messageImg");
            messageName.html("");
            messageCode.html("");
            messageRate.html("");
            messageStock.html("");
            messagePrice.html("");
            messageImg.html("");
        });
        $("body").on("change", "#productName", function () {
            var messageName = $("#message");
            messageName.html("");
        });
        $("body").on("change", "#productCode", function () {
            var messageCode = $("#messageCode");
            messageCode.html("");
        });
        $("body").on("change", "#discoutRate", function () {
            var messageRate = $("#messageRate");
            messageRate.html("");
        });
        $("body").on("change", "#productmodel_stork", function () {
            var messageStock = $("#messageStock");
            messageStock.html("");
        });
        $("body").on("change", "#productmodel_price", function () {
            var messagePrice = $("#messagePrice");
            messagePrice.html("");
        });
        //check lỗi trùng productCode
        $("body").on("change", "#productCode", function () {
            $(".btn-insertProduct").attr("disabled", false);
            var productCode = $('#productCode').val();
            $.ajax({
                url: "checkProductCode",
                type: "GET",
                data: {productCode: productCode},
                success: function (result) {
                    var messageCode = $("#messageCode");
                    if (result) {
                        messageCode.html("Mã sản phẩm đã tồn tại");
                        $(".btn-insertProduct").attr("disabled", true);
                    } else {
                        $(".btn-insertProduct").attr("disabled", false);
                    }
                }
            });
        });
        $("#searchProduct").validate({
            rules: {

                search_product: {
                    required: true
                }
            },
            messages: {
                search_product: {
                    required: "Vui lòng nhập tên"
                }
            }
        });
        //clear các ô nhập khi thêm mới
        $("body").on("click", ".btn_reset", function () {
            $("#modalInsert input[name=productName]").val('');
            $("#modalInsert input[name=productCode]").val('');
            $("#modalInsert input[name=productmodel_stork]").val('');
            $("#modalInsert input[name=productmodel_price]").val('');
            $("#modalInsert img[name=imageMain]").attr('');
            $("label.error").text('');
        });
        //clear các ô nhập khi sửa
        $("body").on("click", ".btn_resert", function () {
            $("label.error").text('');
        });
    });
</script>
