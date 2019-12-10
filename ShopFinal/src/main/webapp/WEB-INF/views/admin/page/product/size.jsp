<%-- 
    Document   : size
    Created on : Sep 13, 2019, 9:59:01 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section class="forms"> 
    <div class="container-fluid">
        <div class="row">
            <div class="container">
                <div class="card">
                    <div class="card-header d-flex align-items-centert">
                        <div class="col-sm-6">
                            <h1>DANH SÁCH KÍCH THƯỚC</h1>
                        </div>
                        <div class="form-group col-sm-3">
                            <form method="post" action="/ShopFinal/manager/staff/searchSize?${_csrf.parameterName}=${_csrf.token}" id="sizeSearch">
                                <div class="row">
                                    <div>
                                        <input class="form-control" name="search_size" placeholder="nhập tên cần tìm" />

                                    </div>
                                    <div style="text-align: right">
                                        <button type="submit" class="btn btn-success"> <span class="fa fa-search"></span></button>
                                    </div> 
                                </div>           
                            </form>
                        </div>
                        <div class="col-sm-3" style="text-align: right">
                            <button type="button" class="btn btn-success btn_reset" data-toggle="modal" data-target="#modalInsert">
                                THÊM MỚI
                            </button>
                        </div>
                    </div>
                    <div class="card-body">

                        <table id="mytb" class="table table-bordered table-hover table-striped">
                            <thead style="text-align: center">
                                <tr>
                                    <th>STT</th>  
                                    <th>Tên kích thước</th>
                                    <th>Ngày tạo</th>
                                    <th>Ngày cập nhật</th>
                                    <th colspan="2">hành động</th>
                                </tr>
                            </thead>
                            <tbody id="my_table">
                                <c:forEach var="size" items="${listSize}" varStatus="status">

                                    <tr  class="pageStype">
                                        <td class="size_count" align="center">${status.count}</td>
                                        <td hidden="" class="size_id" data-id="${size.sizeId}" style="text-align: center" >${size.sizeId}</td>
                                        <td class="size_name" data-name="${size.sizeName}">${size.sizeName}</td>
                                        <td class="size_createdate" data-createdate="${size.createDate}">
                                            <fmt:formatDate value="${size.createDate}" pattern="dd-MM-yyyy"/>
                                        </td>
                                        <td class="size_updatedate" data-updatedate="${size.updateDate}">
                                            <fmt:formatDate value="${size.updateDate}" pattern="dd-MM-yyyy"/>
                                        </td>
                                        <td style="text-align: center">
                                            <button type="button" class="btn btn-success btn_editshow btn_resert" title="Sửa">
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
    <!------------THÊM KÍCH THƯỚC-------------->

    <!-- The Modal -->
    <div class="modal fade" id="modalInsert">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">THÊM KÍCH THƯỚC</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form method="post" id="formInsert">    
                        <div class="form-group">
                            <div class="form-group col-sm-12">
                                <label for="email">Nhập tên: </label><br />
                                <input type="text" class="form-control" name="sizeName" placeholder="nhập tên kích thước" required="" id="sizeName"/>
                                <span id="name_error" style="color: red;"></span>
                                <span id="messagesizeName"></span>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <div style="text-align: right">                                
                                <button type="button" class="btn btn-success btn-inserts btn_add">THÊM</button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <button type="button" class="btn btn-danger" data-dismiss="modal">HỦY</button>
                            </div>
                        </div>                           
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-------MODAL CẬP NHẬT KÍCH THƯỚC-------> 


    <!-- The Modal -->
    <div class="modal fade" id="modalEdit" >
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">SỬA KÍCH THƯỚC</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form method="post" id="formUpdate">    
                        <div class="form-group">
                            <input type="hidden" name="size_id"/> 
                            <label>Tên kích thước: </label> 
                            <input type="text"  class="form-control" placeholder="Nhập tên kích thước" name="size_name" id="size_name" required/>                                 
                            <span id="error_name" style="color: red;"></span>
                            <span id="messeges_updateName"></span>
                        </div>
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="button" class="btn btn-success btn-updateName btn_edit">SỬA</button>
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
    var rowEditObject;
    var total_row = ${count};

    function loadPage(pageIndex) {
        var url = "get_size?${_csrf.parameterName}=${_csrf.token}";
        $.ajax({
            url: url,
            data: {page: pageIndex},
            success: function (result) {
                var html = "";
                $.each(result, function (index, data) {
                    html += '<tr class="pageStype">';
                    html += '   <td align="center">' + (index + 1) + '</td>';
                    html += '	<td hidden="" class="size_id" data-id="' + data.sizeId + '" style="text-align: center">1</td>  ';
                    html += '	<td class="size_name" data-name="' + data.sizeName + '">' + data.sizeName + '</td>  ';
                    html += '	<td>' + data.createDate + '</td>';
                    html += '	<td class="size_updatedate" data-updatedate="'+ data.updateDate + '">' + data.updateDate + '</td>';
                    html += '	<td style="text-align: center">';
                    html += '		<button type="submit" class="btn btn-success btn_editshow btn_resert" title="Sửa" data-target="#modalEdit">';
                    html += '			<span class="fa-edit"></span>';
                    html += '		</button>';
                    html += '	</td>   ';
                    html += '	<td>';
                    html += '		<button type="button" class="btn btn-warning btn_remove" title="Xóa">';
                    html += '			<span class="fa-trash"></span>';
                    html += '		</button>';
                    html += '	</td> ';
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
                loadPage($(this).text());
            }
        });
        console.log("ready");
        //lấy dữ liệu
        $("body").on("click", ".btn_editshow", function () {
            console.log($(this).closest("tr").find("td.size_id").data("id"));
            $("#modalEdit input[name=size_id]").val($(this).closest("tr").find("td.size_id").data("id"));
            $("#modalEdit input[name=size_name]").val($(this).closest("tr").find("td.size_name").data("name"));
            $("#modalEdit").modal("show");
        });
        //thêm
        $("body").on("click", ".btn_add", function () {
            var nameSize = $("#modalInsert input[name=sizeName]").val();
            console.log(nameSize);
//            var count = $("input [name=count]").val();
            var url = "addsize?${_csrf.parameterName}=${_csrf.token}";
            if (nameSize === '') {
                $("#name_error").text("Không được bỏ trống tên kích thước");
            } else {
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {nameSize: nameSize},
                    success: function (data) {
                        $('#modalInsert').modal('hide');
                        total_row++;
                        loadPage($("#pagination li.active a").text());
                    }
                });
                $("#name_error").text('');
            }
        });
        //Sửa
        $("body").on("click", ".btn_edit", function () {
            var name = $("#modalEdit input[name=size_name]").val();
            var id = $("#modalEdit input[name=size_id]").val();
            var url = "editsize?${_csrf.parameterName}=${_csrf.token}";
            if (name === '') {
                $("#error_name").text("bạn không được bỏ trống tên kích thước");
            } else {
//                alert("update");
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {size_id: id, Sizename: name},
                    success: function (data) {
//                        var formattedDate = new Date(data.updateDate);
//                        var d = formattedDate.getDate();
//                        var dd ="";
//                        if(d< 10){
//                            dd = "0" + d.toString();
//                        } else {
//                            dd = d.toString();
//                        }
//                        var m = formattedDate.getMonth();
//                        m += 1;
//                        var y = formattedDate.getFullYear();
//                        $(rowEditObject).closest("tr").find("tr.size_name").text(data.sizeName);
//                        $(rowEditObject).closest("tr").find("td.size_updatedate").text(y + "-" + m + "-" + dd);
//                        $(rowEditObject).closest("tr").find("td.size_name").data("name", data.sizeName);
                        $('#modalEdit').modal('hide');
                        total_row--;
                        loadPage($("#pagination li.active a").text());
                    }
                });
                $("#error_name").text('');
            }
        });
        ////xóa 
        $("body").on("click", ".btn_remove", function () {
            //alert("vao day");
            console.log($(this).closest("tr").find("td.user_id").data("id"));
            var id = $(this).closest("tr").find("td.size_id").data("id");
            var url = "deletesize?${_csrf.parameterName}=${_csrf.token}";
            $.ajax({
                url: url,
                type: "GET",
                data: {idSize: id},
                success: function (data) {
                    if (data) {
                        total_row--;
                        loadPage($("#pagination li.active a").text());
                    } else {
                        alert("Lỗi hệ thống. Xin vui lòng liên hệ quản trị viên");
                    }
                }
            });
        });
        $("body").on("click", "#modalInsert", function () {
            $("#modalInsert input[name=sizeName]").val('');
        });
        $("body").on("click", ".btn_reset", function () {
            $("#modalInsert input[name=size_name]").val('');
            $("#name_error").text('');
        });
        $("body").on("click", ".btn_resert", function () {
            //  $("#modalEdit input[name=size_name]").val('');
            $("#error_name").text('');
        });
        //check lỗi để trống ô tìm kiếm
        $("#sizeSearch").validate({
            rules: {

                search_size: {
                    required: true
                }
            },
            messages: {
                search_size: {
                    required: "Vui lòng nhập tên"
                }
            }
        });
        //check trung ten kich thuoc khi them moi
        $("body").on("change", "#sizeName", function () {
            $(".btn-inserts").attr("disabled", false);
            var sizeName = $('#sizeName').val();
            $.ajax({
                url: "checknameSize_Insert",
                type: 'GET',
                data: {sizeName: sizeName},
                success: function (result) {
                    var messagesizeName = $("#messagesizeName");
                    if (result) {
                        messagesizeName.css("color", "red");
                        messagesizeName.html("tên kích thước đã tồn tại");
                        $(".btn-inserts").attr("disabled", true);
                    } else {
                        $(".btn-inserts").attr("disabled", false);
                    }
                }
            });
        });
        //xóa thông báo
        $("body").on("click", "#modalInsert", function () {
            $(".btn-inserts").attr("disabled", false);
            var messagesizeName = $("#messagesizeName");
            messagesizeName.html("");
        });
        //check trùng tên khi cập nhật
        $("body").on("change", "#size_name", function () {
            $(".btn-updateName").attr("disabled", false);
            var size_name = $('#size_name').val();

            $.ajax({
                url: "checknameSize_Update",
                type: "GET",
                data: {size_name: size_name},
                success: function (result) {
                    var messeges_updateName = $("#messeges_updateName");
                    if (result) {
                        messeges_updateName.css("color", "red");
                        messeges_updateName.html("Tên kích thước này đã tồn tại");
                        $(".btn-updateName").attr("disabled", true);
                    } else {
                        $(".btn-updateName").attr("disabled", false);
                    }
                }
            });
        });
        //xóa thông báo
        $("body").on("click", "#modalEdit", function () {
            $(".btn-updateName").attr("disabled", false);
            var messeges_updateName = $("#messeges_updateName");
            messeges_updateName.html("");
        });
    });
</script>
