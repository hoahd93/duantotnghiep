<%-- 
    Document   : checktoken
    Created on : Oct 15, 2019, 10:33:23 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section style="margin: 20px">
    <div class="container">
        <div class="row">
            <div class="row">
                <div class="col-sm-3">

                </div>
                <div class="panel-group col-sm-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">NHẬP MÃ XÁC NHẬN</div>
                        <div class="panel-body">
                            <form action="/ShopFinal/checkToken?${_csrf.parameterName}=${_csrf.token}" method="POST">
                                <div class="form-group panel-body">
                                    <div class="row">
                                        <p style="color:green">${emailsuscess}</p>
                                        <p style="color:red">${codefail}</p>
                                        <input type="hidden" value="${sessionScope.token}" name="token1"/>
                                        <input type="text" placeholder="Nhập mã xác nhận" name="token2"  style="width: 80%"/><button type="submit">XÁC NHẬN</button> 
                                    </div> 
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