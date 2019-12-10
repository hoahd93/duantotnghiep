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
                            <h1>THỐNG KÊ DOANH THU THEO THÁNG</h1>
                        </div>
                        <div class="col-sm-6">
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Năm
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-month/1">Năm 2019</a>
<!--                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-month/2">Nam 2</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-month/3">Nam 3</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-month/4">Nam 4</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-month/5">Nam 5</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-month/6">Nam 6</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-month/7">Nam 7</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-month/8">Nam 8</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-month/9">Nam 9</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-month/10">Nam 10</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-month/11">Nam 11</a>
                                    <a class="dropdown-item" href="/ShopFinal/manager/admin/invoice-month/12">Nam 12</a>-->
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered table-hover table-striped" >  
                            <thead>
                                <tr>
                                    <th>Tháng</th>
                                    <th>Số lượng sp bán được</th>
                                    <th>Tổng tiền</th>
                                    <th>Chi tiết</th>                                    
                                </tr>
                            </thead>

                            <c:forEach var="Invoice" items="${listInvoiceByMonths}">   
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
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
