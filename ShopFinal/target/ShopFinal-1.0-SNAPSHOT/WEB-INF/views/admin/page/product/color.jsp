<%-- 
    Document   : color
    Created on : Sep 13, 2019, 9:59:12 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section class="forms"> 
    <div class="container-fluid">
        <div class="row">
            <!--LIST-->
            <div class="container">
                <div class="card">
                    <div class="card-header d-flex align-items-center">
                        <div class="col-sm-6">
                            <h1>DANH SÁCH MÀU SẮC</h1>
                        </div>
                        <div class="form-group col-sm-3">
                            <form method="post" action="/ShopFinal/admin/searchColor?${_csrf.parameterName}=${_csrf.token}" id="colorSearch">
                                <div class="row">
                                    <div>
                                        <input class="form-control" name="search_color" placeholder="nhập tên cần tìm" />

                                    </div>
                                    <div style="text-align: right">
                                        <button type="submit" class="btn btn-success"> <span class="fa fa-search"></span></button>
                                    </div> 
                                </div>           
                            </form>
                        </div>
                        <div class="col-sm-3" style="text-align: right">
                            <button type="button" class="btn btn-success btn_reset" data-toggle="modal" data-target="#modalInsert">
                                THÊM MÀU SẮC
                            </button>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered table-hover table-striped" >
                            <thead style="text-align: center">
                                <tr>
                                    <th>STT</th>
                                    <th>Tên màu sắc</th>
                                    <th>Ngày tạo</th>
                                    <th>Ngày cập nhật</th>
                                    <th colspan="2">Hành động</th>
                                </tr>  
                            </thead>
                            <tbody id="my_table">
                                <c:forEach var="color" items="${list}" varStatus="status">   
                                    <tr>
                                        <td class="color_count" align="center">${status.count}</td>
                                        <td hidden="" class="color_id" data-id="${color.colorId}"  style="text-align: center">${color.colorId}</td>  
                                        <td class="color_name" data-name="${color.nameColor}">${color.nameColor}</td>  
                                        <td><fmt:formatDate value="${color.createDate}" pattern="yyyy-MM-dd"/></td>
                                        <td class="color_updatedate" data-updatedate="${color.updateDate}">
                                            <fmt:formatDate value="${color.updateDate}" pattern="yyyy-MM-dd"/></td>                          
                                        <td style="text-align: center">
                                            <button type="submit" class="btn btn-success btn_editshow btn_resert" title="Sửa" data-target="#modalEdit">
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

    <!------------THÊM MÀU SẮC-------------->

    <!-- The Modal -->
    <div class="modal fade" id="modalInsert" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">THÊM MÀU SẮC</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form method="post">    
                        <div class="form-group">
                            <label>Tên màu sắc: </label> 
                            <input type="text" class="form-control" placeholder="Nhập tên màu sắc" name="color_name" required/>                                 
                            <span id="name_error" style="color: red;"></span>
                        </div>
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="button" class="btn btn-success btn_add">THÊM</button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">HỦY</button>
                            </div>
                        </div>
                    </form>  
                </div>
            </div>
        </div>
    </div>

    <!-------MODAL CẬP NHẬT MÀU SẮC-------> 


    <!-- The Modal -->
    <div class="modal fade" id="modalEdit" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">SỬA MÀU SẮC</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form method="post">    
                        <div class="form-group">
                            <input type="hidden" name="color_id"/> 
                            <label>Tên màu sắc: </label> 
                            <input type="text"  class="form-control" placeholder="Nhập tên màu sắc" name="color_name" required/>                                 
                            <span id="error_name" style="color: red;"></span>
                        </div>
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="button" class="btn btn-success btn_edit">SỬA</button>
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
    
    function loadPage(pageIndex){
        var url = "get_color?${_csrf.parameterName}=${_csrf.token}";
        $.ajax({
            url: url,
            data: {page: pageIndex},
            success: function (result) {
                var html =  "";
                $.each(result, function(index,data){
                  
                    html += '<tr class="pageStype">';
                    html += '   <td align="center">'+(index+1)+'</td>';
                    html += '	<td hidden="" class="color_id" data-id="'+data.colorId+'" style="text-align: center">1</td>  ';
                    html += '	<td class="color_name" data-name="' + data.nameColor + '">' + data.nameColor + '</td>  ';
                    html += '	<td>' + data.createDate + '</td>';
                    html += '	<td class="color_updatedate" data-updatedate="">'+ data.updateDate +'</td>';
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
                $("#pagination").html(pagination(pageIndex,total_row));
            }
        })
    };
    
    
    $(function () {
        $("#pagination").html(pagination(1,total_row));
        
        $("body").on("click",".page-link",function(){
            if($(this).closest("li").hasClass("active")){
                return false;
            }else{
                loadPage($(this).text());
            }
        });
        
        console.log("ready");

        //Lấy giá trị
        $("body").on("click", ".btn_editshow", function () {
            rowEditObject = this;
            console.log($(this).closest("tr").find("td.color_id").data("id"));
            $("#modalEdit input[name=color_id]").val($(this).closest("tr").find("td.color_id").data("id"));
            $("#modalEdit input[name=color_id]").val($(this).closest("tr").find("td.color_id").attr("data-id"));
            $("#modalEdit input[name=color_name]").val($(this).closest("tr").find("td.color_name").data("name"));
            $("#modalEdit").modal("show");
        });
        //Sửa
        $("body").on("click", ".btn_edit", function () {
            var name = $("#modalEdit input[name=color_name]").val();
           
            var datee = $("#modalEdit input[name=color_updatedate]").val();
            var id = $("#modalEdit input[name=color_id]").val();
            var url = "editcolor?${_csrf.parameterName}=${_csrf.token}";
            if (name === '') {
                $("#error_name").text("Không được bỏ trống tên màu sắc");
            } else {
                $.ajax({
                    url: url,
                    data: {idColor: id, nameColor: name},
                    success: function (data) {
                        var formattedDate = new Date(data.updateDate);
                        var d = formattedDate.getDate();
                        var dd = "";
                        if (d < 10) {
                            dd = "0" + d.toString();

                        } else
                            dd = d.toString();
                        var m = formattedDate.getMonth();
                        m += 1; // JavaScript months are 0-11
                        var y = formattedDate.getFullYear();
                        $(rowEditObject).closest("tr").find("td.color_name").text(data.nameColor);
                        $(rowEditObject).closest("tr").find("td.color_updatedate").text(y + "-" + m + "-" + dd);
                        $(rowEditObject).closest("tr").find("td.color_name").data("name", data.nameColor);
                        $('#modalEdit').modal('hide');
                    }
                });
                $("#error_name").text('');
            }
        });
        //Xóa
        $("body").on("click", ".btn_remove", function () {
            var id = $(this).closest("tr").find("td.color_id").data("id");
            var count = $("tr.color_count");
            $.each(count, function (index, value) {
                console.log(index + ':' + value);
            });
            var row = $(this).closest("tr");
            var url = "deletecolor?${_csrf.parameterName}=${_csrf.token}";
            $.ajax({
                url: url,
                data: {colorId: id},
                success: function (data) {
                    if(data){
                        total_row--;
                       loadPage($("#pagination li.active a").text());
                   }else{
                       alert("Lỗi hệ thống. Xin hay liên hệ quản trị viên");
                   }
                }
            });
        });
//        Thêm
        $("body").on("click", ".btn_add", function () {
            var name = $("#modalInsert input[name=color_name]").val();
            var url = "addcolor?${_csrf.parameterName}=${_csrf.token}";
            if (name === '') {
                $("#name_error").text("Không được bỏ trống tên màu sắc");
            } else {
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {name: name},
                    success: function (data) {
                        $('#modalInsert').modal('hide');
                        total_row++;
                       loadPage($("#pagination li.active a").text());
                    }
                });
                $("#name_error").text('');
            }
        });
        $("body").on("click", "#modalInsert", function () {
            $("#modalInsert input[name=color_name]").val('');
        });
        $("body").on("click", ".btn_reset", function () {
            $("#modalInsert input[name=color_name]").val('');
            $("#name_error").text('');
        });
        $("body").on("click", ".btn_resert", function () {
            $("#error_name").text('');
        });
        //check lỗi để trống ô tìm kiếm
        $("#colorSearch").validate({
            rules: {

                search_color: {
                    required: true
                }
            },
            messages: {
                search_color: {
                    required: "Vui lòng nhập tên"
                }
            }
        });
    }
    );
</script>