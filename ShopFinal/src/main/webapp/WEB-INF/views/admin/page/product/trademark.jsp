<%-- 
    Document   : thuonghieu
    Created on : Sep 13, 2019, 9:58:42 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section class="forms"> 
    <div class="container-fluid">
        <div class="row">
            <!--LIST-->
            <div class="container">
                <div class="card">
                    <div class="card-header d-flex align-items-center">
                        <div class="col-sm-6">
                            <h1>DANH SÁCH NHÃN HIỆU</h1>
                        </div>
                        <div class="form-group col-sm-3">
                            <form method="post" action="/ShopFinal/manager/staff/searchTrade?${_csrf.parameterName}=${_csrf.token}" id="tradeSearch">
                                <div class="row">
                                    <div>
                                        <input class="form-control" name="search_trade" placeholder="nhập tên cần tìm" />

                                    </div>
                                    <div style="text-align: right">
                                        <button type="submit" class="btn btn-success"> <span class="fa fa-search"></span></button>
                                    </div> 
                                </div>           
                            </form>
                        </div>
                        <div class="col-sm-3" style="text-align: right">
                            <button type="button" class="btn btn-success btn_reset" data-toggle="modal" data-target="#modalInsert">
                                THÊM NHÃN HIỆU
                            </button>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered table-hover table-striped" >
                            <thead style="text-align: center">
                                <tr>
                                    <th>STT</th>
                                    <th>Tên nhãn hiệu</th>
                                    <th>Ngày tạo</th>
                                    <th>Ngày cập nhật</th>
                                    <th colspan="2">Hành động</th>
                                </tr>  
                            </thead>
                            <tbody id="my_table">
                                <c:forEach var="tr" items="${list}" varStatus="status"> 
                                    <tr class="pageStype">  
                                        <td class="trademark_count" align="center">${status.count}</td>
                                        <td hidden="" class="trademark_id" data-id="${tr.trademarkId}" style="text-align: center">${tr.trademarkId}</td>
                                        <td class="trademark_name" data-name="${tr.trademarkName}">${tr.trademarkName}</td>  
                                        <td><fmt:formatDate value="${tr.createDate}" pattern="dd-MM-yyyy"/></td>
                                        <td class="trademark_updatedate" data-updatedate="${tr.updateDate}">
                                            <fmt:formatDate value="${tr.updateDate}" pattern="dd-MM-yyyy"/></td>
                                        <td>
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
    <!------------THÊM NHÃN HIỆU-------------->

    <!-- The Modal -->
    <div class="modal fade" id="modalInsert" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">THÊM NHÃN HIỆU</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form method="post">    
                        <div class="form-group">
                            <label>Tên nhãn hiệu: </label> 
                            <input type="text" class="form-control" placeholder="Nhập tên nhãn hiệu" name="trademark_name" required/>                                 
                            <span id="name_error" style="color: red;"></span>
                        </div>
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="button" class="btn btn-success btn-add">THÊM</button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">HỦY</button>
                            </div>
                        </div>
                    </form>  
                </div>
            </div>
        </div>
    </div>

    <!-------MODAL CẬP NHẬT NHÃN HIỆU-------> 


    <!-- The Modal -->
    <div class="modal fade" id="modalEdit" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">SỬA NHÃN HIỆU</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form>  
                        <div class="form-group">                            
                            <input type="hidden" class="form-control" disabled name="trademark_id"/>                                                            
                        </div>         
                        <div class="form-group">
                            <label>Tên nhãn hiệu: </label> 
                            <input type="text"  class="form-control" placeholder="Nhập tên nhãn hiệu" name="trademark_name" required/>                                 
                            <span id="error_name" style="color: red;"></span>
                        </div>
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="button" class="btn btn-success btn-edit">SỬA</button>
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
        var url = "get_trademark?${_csrf.parameterName}=${_csrf.token}";
        $.ajax({
            url: url,
            data: {page: pageIndex},
            success: function (result) {
                var html = "";
                $.each(result, function (index, data) {

                    html += '<tr class="pageStype">';
                    html += '   <td align="center">' + (index + 1) + '</td>';
                    html += '	<td hidden="" class="trademark_id" data-id="' + data.trademarkId + '" style="text-align: center">1</td>  ';
                    html += '	<td class="trademark_name" data-name="' + data.trademarkName + '">' + data.trademarkName + '</td>  ';
                    html += '	<td>' + data.createDate + '</td>';
                    html += '	<td class="trademark_updatedate" data-updatedate="">' + data.updateDate + '</td>';
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
        //Lấy dữ liệu
        $("body").on("click", ".btn_editshow", function () {
            console.log($(this).closest("tr").find("td.trademark_id").data("id"));
            $("#modalEdit input[name=trademark_id]").val($(this).closest("tr").find("td.trademark_id").data("id"));
            $("#modalEdit input[name=trademark_name]").val($(this).closest("tr").find("td.trademark_name").data("name"));
            $("#modalEdit").modal("show");
        });
        //Thêm
        $("body").on("click", ".btn-add", function () {
            alert("Vào đây");
            var nameTrademark = $("#modalInsert input[name=trademark_name").val();
            console.log(nameTrademark);
            var url = "addtrademark?${_csrf.parameterName}=${_csrf.token}";
            alert(url);
            if (nameTrademark === '') {
                $("#name_error").text("Không được bỏ trống tên nhãn hiệu");
            } else {
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {nameTrademark: nameTrademark},
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
        $("body").on("click", ".btn-edit", function () {
            var name = $("#modalEdit input[name=trademark_name]").val();
            var id = $("#modalEdit input[name=trademark_id]").val();
            var url = "edittrademark?${_csrf.parameterName}=${_csrf.token}";
            if (name === '') {
                $("#error_name").text("Không được bỏ trống tên nhãn hiệu");
            } else {
                alert("Vào update");
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {idTrademark: id, trademarkName: name},
                    success: function (data) {
                        $('#modalEdit').modal('hide');
                        total_row--;
                        loadPage($("#pagination li.active a").text());
                    }
                });
                $("#error_name").text('');
            }
        });

        //Xóa
        $("body").on("click", ".btn_remove", function () {
            console.log($(this).closest("tr").find("td.trademark_id").data("id"));
            var id = $(this).closest("tr").find("td.trademark_id").data("id");
            var url = "deletetrade?${_csrf.parameterName}=${_csrf.token}";
            $.ajax({
                url: url,
                type: "GET",
                data: {idTrandemark: id},
                success: function (data) {
                    if (data) {
                        total_row--;
                        loadPage($("#pagination li.active a").text());
                    } else {
                        alert("Lỗi hệ thống. Xin hay liên hệ quản trị viên");
                    }
                }
            });
        });
        //
        $("body").on("click", "#modalInsert", function () {
            $("#modalInsert input[name=trademark_name]").val('');
        });
        $("body").on("click", ".btn_reset", function () {
            $("#modalInsert input[name=trademark_name]").val('');
            $("#name_error").text('');
        });
        $("body").on("click", ".btn_resert", function () {
            $("#error_name").text('');
        });

        //check lỗi để trống ô tìm kiếm
        $("#tradeSearch").validate({
            rules: {

                search_trade: {
                    required: true
                }
            },
            messages: {
                search_trade: {
                    required: "Vui lòng nhập tên"
                }
            }
        });
    });
</script>
