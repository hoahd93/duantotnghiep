<%-- 
    Document   : resetpass
    Created on : Oct 15, 2019, 10:34:18 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section style="margin: 20px">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">

            </div>
            <div class="panel-group col-sm-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">ĐỔI MẬT KHẨU</div>
                    <div class="panel-body">
                        <form action="/ShopFinal/reset?${_csrf.parameterName}=${_csrf.token}" method="POST">
                            <div class="form-group panel-body">
                                <div class="form-group">
                                    <input type="hidden" name="email" class="form-control" value="${sessionScope.email}"/>
                                </div> 
                                <div class="form-group">
                                    <input type="password" placeholder="Nhập mật khẩu mới" name="pass1" class="form-control"/>
                                </div> 
                                <div class="form-group">
                                    <input type="password" placeholder="Xác nhận mật khẩu" name="pass2" class="form-control"/>                            
                                </div> 
                                <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">ĐỔI MẬT KHẨU</button>    
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-3">

        </div>              
    </div>
</section>

