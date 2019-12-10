
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
                            <h1>DANH SÁCH DANH MỤC</h1>
                        </div>
                        <div class="form-group col-sm-3">
                            <form method="post" action="${pageContext.request.contextPath}/manager/staff/searchCate?${_csrf.parameterName}=${_csrf.token}" id="CateSearch">
                                <div class="row">
                                    <div>
                                        <input class="form-control" name="search_cate" placeholder="nhập tên cần tìm" />
                                    </div>
                                    <div style="text-align: right">
                                        <button type="submit" class="btn btn-success"> <span class="fa fa-search"></span></button>
                                    </div> 
                                </div>           
                            </form>
                        </div>
                        <div class="col-sm-3" style="text-align: right">
                            <button type="button" class="btn btn-success btn_reset" data-toggle="modal" data-target="#modalInsert">
                                THÊM DANH MỤC
                            </button>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered table-hover table-striped" >  
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Hình ảnh</th>
                                    <th>Tên danh mục</th>
                                    <th>danh mục cha</th>                                    
                                    <th>Ngày tạo</th>
                                    <th>Ngày cập nhật</th>
                                    <th colspan="2">Hành động</th>                    
                                </tr>
                            </thead>
                            <c:forEach var="category" items="${listCategory}" varStatus="status">   
                                <tbody class="pageStype" id="my_table">
                                    <tr> 
                                        <td align="center">${status.count}</td>
                                        <td hidden="" class="category_id" data-id="${category.categoryId}">${category.categoryId}</td> 
                                        <td class="category_image" data-src="${pageContext.request.contextPath}/upload/${category.image}">
                                            <img style="width: 70px;" src="${pageContext.request.contextPath}/upload/
                                                 <c:choose>
                                                     <c:when test="${category.image != null && !category.image.equals('')}">${category.image}</c:when>
                                                     <c:otherwise>
                                                         imageProduct1.png
                                                     </c:otherwise>
                                                 </c:choose>" />
                                        </td>
                                        <td class="category_name" data-name="${category.nameCategory}">${category.nameCategory}</td> 
                                        <td class="category_parent" data-parent="${category.parentId}">
                                            <c:forEach items="${listCategory}" var="list">
                                                <c:if test="${category.parentId==list.categoryId}">
                                                    ${list.nameCategory}
                                                </c:if>                                            
                                            </c:forEach>
                                        </td>
                                        <td><fmt:formatDate value="${category.createDate}" pattern="dd-MM-yyyy"/></td> 
                                        <td><fmt:formatDate value="${category.updateDate}" pattern="dd-MM-yyyy"/></td>
                                        <td>
                                            <button type="button" class="btn btn-success btn_editshow btn_resert" title="Sửa" data-target="#modalEdit">
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
    <!--THÊM DANH MỤC-->

    <!-- The Modal -->
    <div class="modal fade" id="modalInsert" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">THÊM DANH MỤC</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form:form method="post" action="${pageContext.request.contextPath}/manager/staff/category?${_csrf.parameterName}=${_csrf.token}" modelAttribute="category" enctype="multipart/form-data">    
                        <div class="form-group">
                            <label>Tên danh mục: </label> 
                            <input type="text" class="form-control" placeholder="Nhập tên danh mục" name="nameCategory" />                                 
                        </div>
                        <div class="form-group">
                            <label>Danh mục cha: </label> 
                            <form:select path="parentId" class="form-control"> 
                                <option value="0" label="-----">
                                    <form:options items="${listCategory}" itemValue="categoryId" itemLabel="nameCategory"/> 
                                </form:select>
                        </div>
                        <div class="form-group col-sm-6">
                            <label for="email">Hình ảnh: </label>
                            <input type="file" name="imagea" >
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

    <!--MODAL CẬP NHẬT DANH MỤC-->
    <!-- The Modal -->
    <div class="modal fade" id="modalEdit" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">CẬP NHẬT DANH MỤC</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form:form method="post" action="${pageContext.request.contextPath}/manager/staff/editcategory?${_csrf.parameterName}=${_csrf.token}" modelAttribute="category" enctype="multipart/form-data" id="formUpdate">    
                        <input type="hidden" name="category_id"/>
                        <div class="form-group">
                            <label>Tên danh mục: </label> 
                            <input type="text" class="form-control" placeholder="Nhập tên danh mục" name="category_name" required/>                                 
                        </div>
                        <div class="form-group">
                            <label>Danh mục cha: </label> 

                            <select name="parent_id" class="form-control">
                                <option value="0" label="---">
                                    <c:forEach var="category" items="${listCategory}">
                                    <option class="form-control" value="${category.categoryId}" label="${category.nameCategory}">
                                    </c:forEach>                   
                            </select>
                        </div>
                        <div class="form-group col-sm-6">
                            <label for="email">Hình ảnh: </label><br />
                            <input type="file" name="pro_image" />
                            <div style="height: 100px;width: 100px">
                                <img width="100px" height="100px" name="img" src=""/>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="submit" class="btn btn-success btn_edit">SỬA</button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">HỦY</button>
                            </div>
                        </div>
                    </form:form>  
                </div>
            </div>
        </div>
    </div>
</section>

<script>
    $(function () {
        console.log("ready");
        $("body").on("click", ".btn_editshow", function () {
            console.log($(this).closest("tr").find("td.category_image").data("src"));
            $("#modalEdit input[name=category_id]").val($(this).closest("tr").find("td.category_id").data("id"));
            $("#modalEdit input[name=category_name]").val($(this).closest("tr").find("td.category_name").data("name"));
            $("#modalEdit select[name=parent_id]").val($(this).closest("tr").find("td.category_parent").data("parent"));
            $("#modalEdit img[name=img]").attr('src', $(this).closest("tr").find("td.category_image").data("src"));
            $("#modalEdit").modal("show");
        });

        ////xóa 
        $("body").on("click", ".btn_remove", function () {
            //alert("vao day");
            console.log($(this).closest("tr").find("td.category_id").data("id"));
            var id = $(this).closest("tr").find("td.category_id").data("id");
            var row = $(this).closest("tr");
            $.ajax({
                url: "deletecategory",
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

        //validate Insert
//        $("#formInsert").validate({
//            rules: {
//                nameCategory: "required"
//            },
//            messages: {
//                nameCategory: "Không được bỏ trống tên danh mục"
//            }
//        });
//        $("#formUpdate").validate({
//            rules: {
//                category_name: "required"
//            },
//            messages: {
//                category_name: "Không được bỏ trống tên danh mục"
//            }
//        });
//        $("#CateSearch").validate({
//            rules: {
//
//                search_cate: {
//                    required: true
//                }
//            },
//            messages: {
//                search_cate: {
//                    required: "Vui lòng nhập tên"
//                }
//            }
//        });
        //clear các ô nhập khi thêm mới
        $("body").on("click", ".btn_reset", function () {
            $("#modalInsert input[name=nameCategory]").val('');
            $("label.error").text('');
        });
        //clear câu thông báo lỗi
        $("body").on("click", ".btn_resert", function () {
            $("label.error").text('');
        });
    });

</script>
