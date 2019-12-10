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
                    <div class="card-header d-flex align-items-center">
                        <div class="col-sm-6">
                            <h1>DANH SÁCH NHÂN VIÊN</h1>
                        </div>
                        <div class="form-group col-sm-3">
                            <form method="post" action="${pageContext.request.contextPath}/manager/admin/searchUser?${_csrf.parameterName}=${_csrf.token}" id="searchUser">
                                <div class="row">
                                    <div>
                                        <input id="searchname" class="form-control" name="search_user" placeholder="nhập tên cần tìm" />

                                    </div>
                                    <div style="text-align: right">
                                        <button type="submit" class="btn btn-success "> <span class="fa fa-search"></span></button>
                                    </div> 
                                </div>           
                            </form>
                        </div>
                        <div class="col-sm-3" style="text-align: right">
                            <button id="modalInsert11" type="button" class="btn btn-success btn_resert" data-toggle="modal" data-target="#myModal">
                                THÊM MỚI
                            </button>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class=" table table-bordered table-hover table-striped">
                            <thead >
                                <tr>
                                    <th>STT</th>
                                    <th>Image</th>
                                    <th>Họ và tên</th>
                                    <th>Giới tính</th>
                                    <th>Email</th>
                                    <th>Số ĐT</th>
                                    <th>Địa chỉ</th>
                                    <th colspan="3">Thao tác</th>
                                </tr>
                            </thead>
                            <tbody id="my_table" >
                                <c:forEach var="user" items="${listUser}" varStatus="status">                  
                                    <tr class="pageStype">
                                        <td align="center">${status.count}</td>
                                        <td hidden="" class="user_id" data-id="${user.userId}" style="text-align: center">${user.userId}</td>
                                        <td class="image" data-src="/ShopFinal/upload/${user.image}">
                                            <img style="width: 70px;" src="/ShopFinal/upload/${user.image}"/>
                                        </td>
                                        <td class="user_fullname" data-fullname="${user.fullName}">${user.fullName}</td>
                                        <td class="user_password" hidden="" data-password="${user.passWord}">${user.passWord}</td>
                                        <td class="user_birthday" hidden="" data-birthday="${user.birthDay}"><fmt:formatDate value="${user.birthDay}" pattern="dd-MM-yyyy"/></td>
                                        <td class="user_gender" data-gender="${user.gender}">
                                            <c:choose>
                                                <c:when test="${user.gender==1}">Nam</c:when> 
                                                <c:when test="${user.gender==2}">Nữ</c:when> 
                                                <c:otherwise>None</c:otherwise>    
                                            </c:choose>
                                        </td>                         
                                        <td class="user_email" data-email="${user.email}">${user.email}</td>
                                        <td class="user_token" hidden="" data-token="${user.token}">${user.token}</td>
                                        <td class="user_phone" data-phone="${user.phoneNumber}">${user.phoneNumber}</td>
                                        <td class="user_address" data-address="${user.address}">${user.address}</td>
                                        <td class="user_createdate" data-createdate="${user.createDate}" hidden="">
                                            <fmt:formatDate value="${user.createDate}" pattern="dd-MM-yyyy"/>
                                        </td>
                                        <td class="user_updateDate" data-updateDate="${user.updateDate}" hidden="">
                                            <fmt:formatDate value="${user.updateDate}" pattern="dd-MM-yyyy"/>
                                        </td>        
                                        <td >
                                            <button type="button" class="btn btn-success btn_edit btn_reset btnUpdate" id="btnUpdate" title="Sửa">
                                                <span class="fa-edit"></span>
                                            </button> 
                                        </td>
                                        <td>
                                            <button type="button" class="btn btn-warning btn_remove" title="Xóa">
                                                <span class="fa-trash"></span>
                                            </button>
                                        </td>
                                        <td >
                                            <button type="button" class="btn btn-success btn_changeshow" data-toggle="modal" data-target="#Modal_UpdatePassword"  title="Đổi mật khẩu">
                                                <span class="fa-lock"></span>
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
    <!------------THÊM MỚI NHÂN VIÊN-------------->

    <!-- The Modal -->
    <div class="modal fade " id="myModal">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">THÊM NHÂN VIÊN</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <!-- Modal body -->
                <div class="modal-body">
                    <form method="post"  enctype="multipart/form-data" >                        
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="email">Email: </label><br />
                                <input class="form-control" name="email" placeholder="nhập địa chỉ email" id="email"/>
                                <span id="emailerorr" style="color: red"></span>
                                <span id="message"></span>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="email">Mật khẩu: </label><br />
                                <input type="password" class="form-control" name="passWord" placeholder="nhập mật khẩu" id="password" />
                                <span id="passworderorr" style="color: red"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="email">Họ tên: </label><br />
                                <input class="form-control" name="fullName" placeholder="nhập họ tên" id="fullname"/>
                                <span id="fullnamerorr" style="color: red"></span> 
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="email">Ngày sinh: </label><br />
                                <input type="date" class="form-control" name="birthDay" placeholder="nhập ngày sinh" id="birthday"/>
                                <span id="birthdayerorr" style="color: red"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="email">Giới tính: </label><br />
                                <select name="gender" Class="form-control">
                                    <option value="1" label="Nam" >
                                    <option value="2" label="Nữ" >
                                    <option value="3" label="Khác" >
                                </select>                                 
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="email">Số điện thoại: </label><br />
                                <input class="form-control" name="phoneNumber" placeholder="nhập số điện thoại" id="phonenumber"/>
                                <span id="phonerorr" style="color: red"></span> 
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="email">Ảnh đại diện: </label><br />
                                <input type="file" name="image" id="image">
                                <span id="imgerorr" style="color: red"></span>
                            </div>

                            <div class="form-group col-sm-6">
                                <label for="email">Địa chỉ: </label><br />
                                <input class="form-control" name="address" placeholder="nhập địa chỉ" id="address" />
                                <span id="addresserorr" style="color: red"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <input type="hidden" class="form-control" name="createDate" />
                            </div>
                        </div>
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="button" class="btn btn-success btn-insertUserr btn_add" >THÊM</button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">HỦY</button>
                            </div>
                        </div>                       
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-------MODAL CẬP NHẬT NHÂN VIÊN-------> 


    <!-- The Modal -->
    <div class="modal fade" id="modalEdit" >
        <div class="modal-dialog modal-xl">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">SỬA NHÂN VIÊN</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form method="post" enctype="multipart/form-data" id="formUpdate" >    
                        <input type="hidden" name="user_id" value="0" />
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label>Email: </label> 
                                <input type="email"  class="form-control" placeholder="Nhập Email" name="user_email" id="user_email"/>                                 
                                <span id="message12" style="color: red"></span>
                                <span id="email_erorr" style="color: red"></span>
                            </div>
                            <div class="form-group col-sm-6">
                                <label>Ngày tạo: </label> 
                                <input  type="date"  class="form-control" name="user_createdate" readonly />                              
<!--                                <label>Mật khẩu: </label> 
                                <input type="password"  class="form-control" placeholder="Nhập Mật khẩu" name="user_password" id="pass_word"/>                                 
                                <span id="pass_erorr" style="color: red"></span>-->
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label>Họ tên: </label> 
                                <input type="text"  class="form-control" placeholder="Nhập Họ tên" name="user_fullname"  id="full_name"/>                                 
                                <span id="fullname_erorr" style="color: red"></span>
                            </div>
                            <div class="form-group col-sm-6">
                                <label>Ngày sinh: </label> 
                                <input type="date"  class="form-control" placeholder="Nhập Ngày sinh" name="user_birthday"  id="birth_day"/>                                 
                                <span id="birth_erorr" style="color: red"></span>
                            </div>
                        </div>
                        <div class="row">  
                            <div class="form-group col-sm-6">
                                <label>Giới tính: </label> <br/>
                                <select name="user_gender" class="form-control">
                                    <option value="1" label="Nam">
                                    <option value="2" label="Nữ">
                                    <option value="3" label="Khác">
                                </select> 
                            </div>
                            
                            <div class="form-group col-sm-6">
                                <label>Số điện thoại: </label> 
                                <input type="text" maxlength="10"   class="form-control" placeholder="Nhập số điện thoại" name="user_phone" id="phones"/>                                 
                                <span id="phone_erorr" style="color: red"></span>
                            </div>                            
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label>Ảnh đại diện: </label> <br/>
                                <input type="file" name="user_image" />
                                <div style="height: 100px;width: 100px">
                                    <img width="100" height="100" name="img" src="" id="imgup">
                                    <span id="img_erorr" style="color: red"></span>
                                </div>    
                            </div>
                            <div class="form-group col-sm-6">
                                <label>Địa chỉ: </label> 
                                <input type="text"  class="form-control" placeholder="Nhập địa chỉ" name="user_address" id="addres"/>                                 
                                <span id="addr_erorr" style="color: red"></span>
                            </div>
                        </div>
                        <input type="hidden"  class="form-control"  name="user_token" /> 
                        <input type="hidden" name="user_updateDate" value="0" />
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="button" class="btn btn-success btn_updatess" id="btn_up">SỬA</button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">HỦY</button>
                            </div>
                        </div>
                    </form>  
                </div>
            </div>
        </div>
    </div>
                                <!------------ĐỔI MẬT KHẨU NHÂN VIÊN-------------->

    <!-- The Modal -->
    <div class="modal fade " id="Modal_UpdatePassword">
        <div class="modal-dialog ">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">ĐỔI MẬT KHẨU NHÂN VIÊN</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <!-- Modal body -->
                <div class="modal-body">
                    <form method="post" >                        
                        <div class="row">                           
                            <div class="form-group col-sm-12">
                                <input type="hidden" name="user_id" value="0" />
                                <label for="email">Mật khẩu mới: </label><br />
                                <input type="password" class="form-control" name="pass_Word" placeholder="nhập mật khẩu" id="passwordUpdate" />
                                <span id="changepassword_erorr" style="color: red"></span>
                            </div>
                        </div>
                        
                        <div class="modal-footer">
                            <div style="text-align: right">
                                <button type="button" class="btn btn-success btn-changepass " >SỬA</button>
                                <!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
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
    function loadPageUsers(pageIndex) {
        var url = "get_users?${_csrf.parameterName}=${_csrf.token}";
        $.ajax({
            url: url,
            data: {page: pageIndex},
            success: function (result) {
                var html = "";
                $.each(result, function (index, data) {
                    html += '  <tr class="pageStype">';
                    html += '   <td align="center">' + (index + 1) + '</td>';
                    html += '   <td hidden="" class="user_id" data-id="' + data.userId + '" style="text-align: center">1</td>';
                    html += '   <td class="image" data-src="/ShopFinal/upload/ ' + data.image + '"> ';
                    html += '                       <img style="width: 70px;" src="/ShopFinal/upload/' + data.image + '"/>  ';
                    html += '   </td> ';
                    html += '   <td  class="user_fullname" data-fullname="' + data.fullName + '">' + data.fullName + '</td>';
                    html += '   <td class="user_password" hidden="" data-password="' + data.passWord + '"> ' + data.passWord + ' </td>';
                    html += '   <td class="user_birthday" hidden="" data-birthday="' + data.birthDay + '">' + data.birthDay + '</td>';
                    html += '   <td class="user_gender" data-gender="' + data.gender + '">';
                    if (data.gender === 1) {
                        html += 'Nam';
                    } else if (data.gender === 2) {
                        html += 'Nữ';
                    } else if (data.gender === 3) {
                        html += 'None';
                    }
                    html += '   </td>';
                    html += '   <td class="user_email" data-email="' + data.email + '">' + data.email + '</td>';
                    html += '   <td class="user_phone" data-phone="' + data.phoneNumber + '">' + data.phoneNumber + '</td>';
                    html += '   <td class="user_address" data-address="' + data.address + '">' + data.address + '</td>';
                    html += '   <td class="user_createdate" data-createdate="' + data.createDate + '" hidden=""> ';
                    html += '   </td> ';
                    html += '   <td class="user_updateDate" data-updateDate="' + data.updateDate + '" hidden=""> ';
                    html += '   </td>         ';
                    html += '   <td > ';
                    html += '   <button type="button" class="btn btn-success btn_edit btn_reset btnUpdate" id="btnUpdate" title="Sửa"> ';
                    html += '    <span class="fa-edit"></span> ';
                    html += '    </button>  ';
                    html += '    </td> ';
                    html += '     <td> ';
                    html += '     <button type="button" class="btn btn-warning btn_remove" title="Xóa"> ';
                    html += '       <span class="fa-trash"></span> ';
                    html += '      </button> ';
                    html += '      </td> ';
                    html += '   <td >';
                    html += '      <button type="button" class="btn btn-success btn_changeshow " data-toggle="modal" data-target="#Modal_UpdatePassword"  title="Đổi MK">';
                    html += '       <span class="fa-lock"></span>';
                    html += '       </button> ';
                    html += '   </td>';
                    html += ' </tr>';
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
                loadPageUsers($(this).text());
            }
        });

        console.log("ready");
        $("body").on("click", ".btn_edit", function () {
            console.log($(this).closest("tr").find("td.user_id").data("id"));
            $("#modalEdit input[name=user_id]").val($(this).closest("tr").find("td.user_id").data("id"));
//            $("#modalEdit input[name=user_password]").val($(this).closest("tr").find("td.user_password").data("password"));
            $("#modalEdit input[name=user_fullname]").val($(this).closest("tr").find("td.user_fullname").data("fullname"));
            $("#modalEdit input[name=user_birthday]").val($(this).closest("tr").find("td.user_birthday").data("birthday"));
            $("#modalEdit input[name=user_gender]").val($(this).closest("tr").find("td.user_gender").data("gender"));
            $("#modalEdit input[name=user_email]").val($(this).closest("tr").find("td.user_email").data("email"));
            $("#modalEdit input[name=user_phone]").val($(this).closest("tr").find("td.user_phone").data("phone"));
            $("#modalEdit input[name=user_token]").val($(this).closest("tr").find("td.user_token").data("token"));
            $("#modalEdit input[name=user_createdate]").val($(this).closest("tr").find("td.user_createdate").data("createdate"));
            $("#modalEdit img[name=img]").attr('src', $(this).closest("tr").find("td.user_image").data("src"));
            $("#modalEdit input[name=user_address]").val($(this).closest("tr").find("td.user_address").data("address"));
            $("#modalEdit").modal("show");
        });
        //INSERT BẰNG AJAX
        $("body").on("click", ".btn_add", function () {
            console.log(email);
            var email = $("#myModal input[name=email]").val();
            var passWord = $("#myModal input[name=passWord]").val();
            var fullName = $("#myModal input[name=fullName]").val();
            var birthDay = $("#myModal input[name=birthDay").val();
            var gender = $("#myModal select[name=gender]").val();
            var phoneNumber = $("#myModal input[name=phoneNumber]").val();
            var address = $("#myModal input[name=address]").val();
//            var createDate = $("#myModal input[name=createDate]").val();
//            var image = $("#myModal input[name=image]").val();


//            alert("Bắt đầu thêm");
            //code check lỗi thêm mới nè
            function valiInsert() {
                var messageEmail = $("#emailerorr");
                var messagePassword = $("#passworderorr");
                var messageFullname = $("#fullnamerorr");
                var messageBirthday = $("#birthdayerorr");
                var messagePhoneNumber = $("#phonerorr");
                var messageAddress = $("#addresserorr");
                var messageImage = $("#imgerorr");

                var email = $("#email").val();
                var passw = $("#password").val();
                var fulname = $("#fullname").val();
                var birth = $("#birthday").val();
                var phone = $("#phonenumber").val();
                var address = $("#address").val();
                var imgs = $("#image").val();
                var filteremail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; //định dạng mail
                var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g; // định dạng số điện thoại
                var patternpass = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,}/; // định dạng mật khẩu
                var current = new Date().getFullYear(); // năm hiện tại
                var birthyear = new Date(birth).getFullYear(); // lấy năm trong ngày sinh
                var status = true;
                if (birth !== '') {
                    if ((current - birthyear) < 18) {
                        messageBirthday.html("Bạn không được tuyển nhân viên dưới 18 tuổi  !!");
                        status = false;
                    } else {
                        messageBirthday.html("");
                    }
                } else {
                    messageBirthday.html("Bạn chưa điền ngày sinh");
                    status = false;
                }
//                if (passw !== '') {
//                    if (patternpass.test(passw) === false)
//                    {
//                        messagePassword.html("Mật khẩu phải có 4 ký tự trở lên, có ít nhất một chữ hoa (uppercase), và có ít nhất một chữ thường (lowercase).!");
//                        status = false;
//                    } else {
//                        messagePassword.html("");
//                    }
//                } else {
//                    messagePassword.html("Bạn chưa điền mật khẩu!");
//                    status = false;
//                }
                if(passw === ""){
                    messagePassword.html("Bạn chưa điền mật khẩu!");
                    status = false;
                }
                if (fulname === "") {
                    messageFullname.html("Bạn chưa điền họ tên");
                    status = false;
                }
                if (imgs === "") {
                    messageImage.html("Bạn chưa điền hình ảnh");
                    status = false;
                } else {
                    messageImage.html("");
                }
                if (address === "") {
                    messageAddress.html("Bạn chưa điền địa chỉ");
                    status = false;
                } else {
                    messageAddress.html("");
                }
                if (email !== '') {
                    if (filteremail.test(email) === false)
                    {
                        messageEmail.html("Hay nhap dia chi email hop le.");
                        status = false;
                    } else {
                        messageEmail.html("");
                    }
                } else {
                    messageEmail.html("Bạn chưa điền email!");
                    status = false;
                }

                if (phone !== '') {
                    if (vnf_regex.test(phone) === false)
                    {
                        messagePhoneNumber.html("Số điện thoại của bạn không đúng định dạng!");
                        status = false;
                    } else {
                        messagePhoneNumber.html("");
                    }
                } else {
                    messagePhoneNumber.html("Bạn chưa điền số điện thoại!");
                    status = false;
                }

                return status;
            }
            //hết code check lỗi thêm mới rồi nè//

            var formData = new FormData();
            formData.append('email', email);
            formData.append('passWord', passWord);
            formData.append('fullName', fullName);
            formData.append('birthDay', birthDay);
            formData.append('gender', gender);
            formData.append('phoneNumber', phoneNumber);
            formData.append('address', address);
//            formData.append('createDate', createDate);
            formData.append('image', $("#myModal input[name=image]")[0].files[0]);
            var url = "addstaff?${_csrf.parameterName}=${_csrf.token}";
            console.log(url);
            if (valiInsert() === false) {
                return false;
            } else {
                $.ajax({
                    url: url,
                    contentType: false,
                    processData: false,
                    type: 'POST',
                    data: formData,
                    success: function (data) {
                        $("#myModal").modal("hide");
                        total_row--;
                        loadPageUsers($("#pagination li.active a").text());
                    },
                    error: function (error) {
                        console.log(error);
                    }
                });
            }
            ;
        });
        //đổi mật khẩu nhân viên
        $("body").on("click", ".btn-changepass", function (){
            var user_id = $("#Modal_UpdatePassword input[name=user_id]").val();
            var changepass = $("#Modal_UpdatePassword input[name=pass_Word]").val();
            var url = "change-password?${_csrf.parameterName}=${_csrf.token}";
            if(changepass === ""){
                $("#changepassword_erorr").text("bạn không được bỏ trống mật khẩu");
            } else {
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {id: user_id, changePassword: changepass},
                    success: function (data) {
                        $("#Modal_UpdatePassword").modal("hide");
                        total_row--;
                        loadPageUsers($("#pagination li.active a").text());
                    }
                });
                $("#changepassword_erorr").text("");
            }
        });
        // update nhân viên
        $("body").on("click", ".btn_updatess", function () {
            var user_id = $("#modalEdit input[name=user_id]").val();
            var user_email = $("#modalEdit input[name=user_email]").val();
            var user_fullname = $("#modalEdit input[name=user_fullname]").val();
            var user_birthday = $("#modalEdit input[name=user_birthday").val();
            var user_gender = $("#modalEdit select[name=user_gender]").val();
            var user_phone = $("#modalEdit input[name=user_phone]").val();
            var user_address = $("#modalEdit input[name=user_address]").val();

//            //code check lỗi cập nhật nè
//            function valiUpdate() {
//                var messageEmailUpdate = $("#email_erorr");
//                var messageFullnameUpdate = $("#fullname_erorr");
//                var messageBirthdayUpdate = $("#birth_erorr");
//                var messagePhoneNumberUpdate = $("#phone_erorr");
//                var messageAddressUpdate = $("#addr_erorr");
//                var messageImageUpdate = $("#user_image");
//
//                var ful_name = $("#full_name").val();
//                var birth_day = $("#birth_day").val();
//                var phone_nb = $("#phones").val();
//                var email_ = $("#user_email").val();
//                var img_s = $("#imgup").val();
//                var add_ress = $("#addres").val();
//                var filter_email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; //định dạng mail
//                var vnfregex = /((09|03|07|08|05)+([0-9]{8})\b)/g; // định dạng số điện thoại
//                var pattern_pass = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,}/; // định dạng mật khẩu
//                var current = new Date().getFullYear(); // năm hiện tại
//                var birthyear = new Date(birth_day).getFullYear(); // lấy năm trong ngày sinh
//                var status = true;
//                if (birth_day !== '') {
//                    if ((current - birthyear) < 18) {
//                        messageBirthdayUpdate.html("Bạn không được tuyển nhân viên dưới 18 tuổi  !!");
//                        status = false;
//                    } else {
//                        messageBirthdayUpdate.html("");
//                    }
//                } else {
//                    messageBirthdayUpdate.html("Bạn chưa điền ngày sinh");
//                    status = false;
//                }
//                if (ful_name === "") {
//                    messageFullnameUpdate.html("Bạn chưa điền họ tên");
//                    status = false;
//                }
//                if (img_s === "") {
//                    messageImageUpdate.html("Bạn chưa điền hình ảnh");
//                    status = false;
//                } else {
//                    messageImageUpdate.html("");
//                }
//                if (add_ress === "") {
//                    messageAddressUpdate.html("Bạn chưa điền địa chỉ");
//                    status = false;
//                } else {
//                    messageAddressUpdate.html("");
//                }
//                if (email_ !== '') {
//                    if (filter_email.test(email_) === false)
//                    {
//                        messageEmailUpdate.html("Hay nhap dia chi email hop le.");
//                        status = false;
//                    } else {
//                        messageEmailUpdate.html("");
//                    }
//                } else {
//                    messageEmailUpdate.html("Bạn chưa điền email!");
//                    status = false;
//                }
//
//                if (phone_nb !== '') {
//                    if (vnfregex.test(phone_nb) === false)
//                    {
//                        messagePhoneNumberUpdate.html("Số điện thoại của bạn không đúng định dạng!");
//                        status = false;
//                    } else {
//                        messagePhoneNumberUpdate.html("");
//                    }
//                } else {
//                    messagePhoneNumberUpdate.html("Bạn chưa điền số điện thoại!");
//                    status = false;
//                }
//
//                return status;
//            };

            var formDataUpdate = new FormData();
            formDataUpdate.append('user_id', user_id);
            formDataUpdate.append('user_email', user_email);
            formDataUpdate.append('user_fullname', user_fullname);
            formDataUpdate.append('user_birthday', user_birthday);
            formDataUpdate.append('user_gender', user_gender);
            formDataUpdate.append('user_phone', user_phone);
            formDataUpdate.append('user_address', user_address);
            formDataUpdate.append('user_image', $("#modalEdit input[name=user_image]")[0].files[0]);
            var url = "editstaff?${_csrf.parameterName}=${_csrf.token}";
            alert(url);
            ///BỎ VALIDATE VÔ UPDATE KHÔNG ĐƯỢC NÈ///
//            if (valiUpdate() === false) {
//                return false;
//            } else {
            $.ajax({
                url: url,
                contentType: false,
                processData: false,
                type: 'POST',
                data: formDataUpdate,
                success: function (data) {
                    $("#modalEdit").modal("hide");
                    total_row--;
                    loadPageUsers($("#pagination li.active a").text());
                },
                error: function (error) {
                    console.log(error);
                }
            });
//            };           
        });
//DELETE
        $("body").on("click", ".btn_remove", function () {
            console.log($(this).closest("tr").find("td.user_id").data("id"));
            var id = $(this).closest("tr").find("td.user_id").data("id");
            var url = "deleteuser?${_csrf.parameterName}=${_csrf.token}";
            $.ajax({
                url: url,
                type: "GET",
                data: {id: id},
                success: function (result) {
                    if (result) {
                        total_row--;
                        loadPageUsers($("#pagination li.active a").text());
                    } else {
                        alert("Lỗi hệ thống. Vui lòng liên hệ quảnt trị viên");
                    }
                }
            });
        });
        $("#searchUser").validate({
            rules: {

                search_user: {
                    required: true
                }
            },
            messages: {
                search_user: {
                    required: "Vui lòng nhập tên"
                }
            }
        });
        $("body").on("click", ".btn_reset", function () {
            $("label.error").text('');
        });
//clear các ô nhập khi thêm mới
        $("body").on("click", ".btn_resert", function () {
            $("#myModal input[name=passWord]").val('');
            $("#myModal input[name=fullName]").val('');
            $("#myModal input[name=birthDay]").val('');
            $("#myModal input[name=email]").val('');
            $("#myModal input[name=phoneNumber]").val('');
            $("#myModal input[name=address]").val('');
            $("#myModal input[name=token]").val('');
            $("label.error").text('');
        });
//CHECK TRÙNG EMAIL-insert
        $("body").on("change", "#email", function () {
            $(".btn-insertUserr").attr("disabled", false);
            var email = $('#email').val();
            $.ajax({
                url: "checkEmail",
                type: "GET",
                data: {email: email},
                success: function (result) {
                    var message = $("#message");
                    if (result) {
                        message.css("color", "red");
                        message.html("địa chỉ email đã tồn tại");
                        $(".btn-insertUserr").attr("disabled", true);
                    } else {
                        $(".btn-insertUserr").attr("disabled", false);
                    }
                }
            });
        });
        $("body").on("click", "#modalInsert11", function () {
            $(".btn-insertUserr").attr("disabled", false);
            var message = $("#message");
            message.html("");
        });
        //xóa thông báo lỗi khi mới bắt đầu
        $("body").on("click", "#modalInsert11", function () {
            $(".btn-insertUserr").attr("disabled", false);
            var usname = $("#usnamerorr");
            var passw = $("#passworderorr");
            var fulname = $("#fullnamerorr");
            var birth = $("#birthdayerorr");
            var phone = $("#phonerorr");
            var email = $("#emailerorr");
            var imgs = $("#imgerorr");
            var address = $("#addresserorr");
            usname.html("");
            passw.html("");
            birth.html("");
            fulname.html("");
            phone.html("");
            email.html("");
            imgs.html("");
            address.html("");
            //xóa thông báo lỗi khi nhập đúng
            $("body").on("change", "#password", function () {
                var passw = $("#passworderorr");
                passw.html("");
            });
            $("body").on("change", "#fullname", function () {
                var fulname = $("#fullnamerorr");
                fulname.html("");
            });
            $("body").on("change", "#birthday", function () {
                var birth = $("#birthdayerorr");
                birth.html("");
            });
            $("body").on("change", "#phonenumber", function () {
                var phone = $("#phonerorr");
                phone.html("");
            });
            $("body").on("change", "#email", function () {
                var email = $("#emailerorr");
                var message = $("#message");
                message.html("");
                email.html("");
            });
            $("body").on("change", "#image", function () {
                var imgs = $("#imgerorr");
                imgs.html("");
            });
            $("body").on("change", "#address", function () {
                var address = $("#addresserorr");
                address.html("");
            });
        });

        //xóa thông báo lỗi khi mới bắt đầu---Update
        $("body").on("click", "#btnUpdate", function () {
            $("#btn_up").attr("disabled", false);
            var us_name = $("#usname_erorr");
            var ful_name = $("#fullname_erorr");
            var birth_day = $("#birth_erorr");
            var phone_nb = $("#phone_erorr");
            var email_ = $("#email_erorr");
            var img_s = $("#img_erorr");
            var add_ress = $("#addr_erorr");
            us_name.html("");
            birth_day.html("");
            ful_name.html("");
            phone_nb.html("");
            email_.html("");
            img_s.html("");
            add_ress.html("");
            //xóa thông báo lỗi khi nhập đúng---Update
            $("body").on("change", "#full_name", function () {
                var fulname = $("#fullname_erorr");
                fulname.html("");
            });
            $("body").on("change", "#birth_day", function () {
                var birth = $("#birth_erorr");
                birth.html("");
            });
            $("body").on("change", "#phones", function () {
                var phone = $("#phone_erorr");
                phone.html("");
            });
            $("body").on("change", "#user_email", function () {
                var email = $("#email_erorr");
                var message = $("#message12");
                message.html("");
                email.html("");
            });
            $("body").on("change", "#imgup", function () {
                var imgs = $("#img_erorr");
                imgs.html("");
            });
            $("body").on("change", "#addres", function () {
                var address = $("#addr_erorr");
                address.html("");
            });
            $("body").on("click", "#btnUpdate", function () {
                $("#btn_up").attr("disabled", false);
                var message12 = $("#message12");
                message12.html("");
            });
        });
        //CHECK TRÙNG EMAIL---update
        $("body").on("change", "#user_email", function () {
            $("#btn_up").attr("disabled", false);
            var user_email = $('#user_email').val();
            $.ajax({
                url: "checkEmailup",
                type: "GET",
                data: {user_email: user_email},
                success: function (result) {
                    var message12 = $("#message12");
                    if (result) {
                        message12.css("color", "red");
                        message12.html("địa chỉ email đã tồn tại");
                        $("#btn_up").attr("disabled", true);
                    } else {
                        $("#btn_up").attr("disabled", false);
                    }
                }
            });
        });
    });
</script>
