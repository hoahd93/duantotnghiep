<%-- 
    Document   : revenue
    Created on : Sep 13, 2019, 10:03:50 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <h1>THỐNG KÊ DOANH THU THEO NGÀY</h1>
                        </div>
                        <div class="col-sm-6">
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Tháng
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-day/1">Thang 1</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-day/2">Thang 2</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-day/3">Thang 3</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-day/4">Thang 4</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-day/5">Thang 5</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-day/6">Thang 6</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-day/7">Thang 7</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-day/8">Thang 8</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-day/9">Thang 9</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-day/10">Thang 10</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-day/11">Thang 11</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-day/12">Thang 12</a>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered table-hover table-striped" >  
                            <thead>
                                <tr>
                                    <th>Ngày</th>
                                    <th>Số lượng sp bán được</th>
                                    <th>Tổng tiền</th>
                                    <th>Chi tiết</th>                                    
                                    <!--                                    <th colspan="2">Hành động</th>                    -->
                                </tr>

                            </thead>

                            <c:forEach var="Invoice" items="${listInvoice}">   
                                <tbody class="pageCate" id="my_table">
                                    <tr>  
                                        <td>${Invoice.dateTime}</td>
                                        <td>${Invoice.quantity}</td> 
                                        <td>${Invoice.totalPrice}</td> 
                                        <td>
                                            <button type="button" class="btn btn-success btn_editshow btn_resert" title="Chi tiết" data-target="#modalEdit">
                                                <span class="fa-edit"></span>
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
</section>
