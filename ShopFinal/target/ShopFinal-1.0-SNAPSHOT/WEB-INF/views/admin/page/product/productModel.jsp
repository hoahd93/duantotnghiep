<%-- 
    Document   : productModel
    Created on : Sep 18, 2019, 3:50:11 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<section class="forms"> 
    <div class="container-fluid">
        <div class="row">
            <div class="container">
                <div class="card">
                    <div class="card-header d-flex align-items-center">
                        <div class="col-sm-6">
                            <h1>DANH SÁCH SẢN PHẨM MẪU</h1>
                        </div>
                        <div class="form-group col-sm-3">
                            <form method="post" action="/ShopFinal/manager/staff/searchproductmodel?${_csrf.parameterName}=${_csrf.token}" id="searchProductDetail">
                                <div class="row">
                                    <div>
                                        <input class="form-control" name="search_productmodel" placeholder="nhập tên cần tìm" required/>

                                    </div>
                                    <div style="text-align: right">
                                        <button type="submit" class="btn btn-success"><span class="fa fa-search"></span></button>
                                    </div> 
                                </div>           
                            </form>
                        </div>
                        <div class="col-sm-3" style="text-align: right">
                            <button type="button"  class="btn btn-success" data-toggle="modal" data-target="#modalInsert">
                                THÊM SẢN PHẨM MẪU
                            </button>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered table-hover table-striped" >  
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Tên màu</th>
                                    <th>Kích cở</th> 
                                    <th>Số lượng</th> 
                                    <th>Giá tiền</th> 
                                    <th>Ngày tạo</th>
                                    <th>Ngày cập nhật</th>
                                    <th colspan="2">Thao tác</th>                    
                                </tr>
                            </thead>

                            <c:forEach var="productmodel" items="${listProductModel}" varStatus="status">   
                                <tbody id="my_table" class="pageStype">
                                    <tr>  
                                        <td align="center">${status.count}</td>
                                        <td hidden="" class="productmodel_id" data-id="${productmodel.productDetailId}">${productmodel.productDetailId}</td>       
                                        <td class="productmodel_idproduct" data-idproduct="${productmodel.productId}">
                                            <c:forEach var="listProduct" items="${listProduct}">
                                                <c:if test="${productmodel.productId==listProduct.productId}">
                                                    ${listProduct.name}
                                                </c:if>
                                            </c:forEach></td> 
                                        <td class="productmodel_idcolor" data-idcolor="${productmodel.colorId}"> 
                                            <c:forEach var="listColor" items="${listColor}">
                                                <c:if test="${productmodel.colorId==listColor.colorId}">
                                                    ${listColor.nameColor}
                                                </c:if>
                                            </c:forEach></td>
                                        <td class="productmodel_idsize" data-idsize="${productmodel.sizeId}"> 
                                            <c:forEach var="listSize" items="${listSize}">
                                                <c:if test="${productmodel.sizeId==listSize.sizeId}">
                                                    ${listSize.sizeName}
                                                </c:if>
                                            </c:forEach></td>
                                        <td class="productmodel_stock" data-stock="${productmodel.stock}">${productmodel.stock}</td>
                                        <td class="productmodel_price" data-price="${productmodel.price}">${productmodel.price}</td>
                                        <td><fmt:formatDate value="${productmodel.createDate}" pattern="dd-MM-yyyy" /></td>
                                        <td><fmt:formatDate value="${productmodel.updateDate}" pattern="dd-MM-yyyy" /></td>
                                        <td>
                                            <button type="button" class="btn btn-success btn_edit btn_resert" title="Sửa">
                                                <span class="fa-edit"></span>
                                            </button>
                                        </td>
                                        <td> <button type="button" class="btn btn-warning btn_remove" title="Xóa">
                                                <span class="fa-trash"></span>
                                            </button>
                                        </td>  
                                    </tr> 
                                </tbody>
                            </c:forEach>  
                        </table>
                        <ul id="pagination"></ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!------------THÊM SẢN PHẨM MODEL-------------->
    <!-- The Modal -->
    <div class="modal fade" id="modalInsert" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">THÊM SẢN PHẨM MẪU</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form:form method="post" action="/ShopFinal/manager/staff/productModel?${_csrf.parameterName}=${_csrf.token}" modelAttribute="productmodel" enctype="multipart/form-data">    
                        <div class="form-group">
                            <label>Sản phẩm: </label>                            
                            <form:select path="productId" class="form-control">                          
                                <form:options class="form-control" items="${listProduct}" itemValue="productId" itemLabel="name"/>
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label>Màu sắc: </label> 
                            <form:select path="colorId" class="form-control">                          
                                <form:options class="form-control" items="${listColor}" itemValue="colorId" itemLabel="nameColor"/>
                            </form:select>                                 
                        </div>
                        <div class="form-group">
                            <label>Kích cở: </label> 
                            <form:select path="sizeId" class="form-control">                          
                                <form:options class="form-control" items="${listSize}" itemValue="sizeId" itemLabel="sizeName"/>
                            </form:select>                                                           
                        </div>
                        <div class="form-group">
                            <label>Số lượng: </label> 
                            <form:input type="text" class="form-control" placeholder="Nhập số lượng" path="stock"/>                                 
                        </div>
                        <div class="form-group">
                            <label>Giá: </label> 
                            <form:input type="text" class="form-control" placeholder="Nhập giá" path="price"/>                                 
                        </div> 
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="submit" class="btn btn-success">THÊM</button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">HỦY</button>
                            </div>
                        </div>
                    </form:form>  
                </div>
            </div>
        </div>
    </div>


    <!-------CẬP NHẬT SẢN PHẨM MODEL------->
    <div class="modal fade" id="modalEdit" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">CẬP NHẬT SẢN PHẨM MẪU</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form method="post" action="/ShopFinal/manager/staff/editproductmodel?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" id="editProductModel">  
                        <input type="hidden" name="productModel_Id"/>
                        <div class="form-group">
                            <label>Tên sản phẩm: </label>                           
                            <input type="text" class="form-control" name="product_Id"  readonly/>                                 
                        </div>
                        <div class="form-group">
                            <label>Màu sắc: </label>        
                            <select name="color_Id" class="form-control">
                                <c:forEach var="color" items="${listColor}">
                                    <option class="form-control" value="${color.colorId}" label="${color.nameColor}"/>
                                </c:forEach>                   
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Kích cở: </label>        
                            <select name="size_Id" class="form-control">                          
                                <c:forEach var="size" items="${listSize}">
                                    <option class="form-control" value="${size.sizeId}" label="${size.sizeName}"/>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Số lượng: </label> 
                            <input type="text" class="form-control" name="productmodel_stork"/>                                 
                        </div>
                        <div class="form-group">
                            <label>Giá: </label> 
                            <input type="text" class="form-control" name="productmodel_price"/>                                 
                        </div>
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="submit" class="btn btn-success ">SỬA</button>
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
    $(function () {
        console.log("ready");
        $("body").on("click", ".btn_edit", function () {
            console.log($(this).closest("tr").find("td.productmodel_idcolor").data("idcolor"));
            console.log($(this).closest("tr").find("td.productmodel_idproduct").data("idproduct"));

            $("#modalEdit input[name=productModel_Id]").val($(this).closest("tr").find("td.productmodel_id").data("id"));
            $("#modalEdit input[name=product_Id]").val($(this).closest("tr").find("td.productmodel_idproduct").data("idproduct"));
            $("#modalEdit select[name=color_Id]").val($(this).closest("tr").find("td.productmodel_idcolor").data("idcolor"));
//            $("#modalEdit select[name=color_Id]").val($(this).closest("tr").find("td.productmodel_idcolor").data("idcolor"));
            $("#modalEdit select[name=size_Id]").val($(this).closest("tr").find("td.productmodel_idsize").data("idsize"));
            $("#modalEdit input[name=productmodel_stork]").val($(this).closest("tr").find("td.productmodel_stock").data("stock"));
            $("#modalEdit input[name=productmodel_price]").val($(this).closest("tr").find("td.productmodel_price").data("price"));
            $("#modalEdit").modal("show");
        });

        ////xóa 
        $("body").on("click", ".btn_remove", function () {
            //alert("vao day");
            console.log($(this).closest("tr").find("td.productmodel_id").data("id"));
            var id = $(this).closest("tr").find("td.productmodel_id").data("id");
            var row = $(this).closest("tr");
            $.ajax({
                url: "deleteproductdetailmodel",
                type: "GET",
                data: {id: id},
                success: function (result) {
                    row.remove();
                    console.log(result);
                    //alert("Đã xóa thành công");

                },
                error: function (result) {
                    alert("Lỗi");
                }
            });
        });
        $("#editProductModel").validate({
            rules: {

                productmodel_stork: {
                    required: true,
                    number: true,
                    digits: true
                },
                productmodel_price: {
                    required: true,
                    number: true

                }
            },
            messages: {
                productmodel_stork: {
                    required: "Vui lòng nhập số lượng",
                    number: "Sai định dạng số lượng",
                    digits: "Số lượng không được là số âm"
                },
                productmodel_price: {
                    required: "Vui lòng nhập giá tiền",
                    number: "Sai định dạng giá tiền"

                }
            }
        });
        $("body").on("click", ".btn_resert", function () {
            $("label.error").text('');
        });
        $("#searchProductDetail").validate({
            rules: {

                search_productmodel: {
                    required: true
                }
            },
            messages: {
                search_productmodel: {
                    required: "Vui lòng nhập tên"
                }
            }
        });

    });

</script>