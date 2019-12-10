
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<section class="forms">
    <div class="container-fluid">
        <div class="row">
            <div class="container">
                <div class="card">
                    <div class="card-header d-flex align-items-center">
                        <br/>
                        <div class="col-sm-12">
                            <h3>DANH SÁCH HÓA ĐƠN</h3>
                        </div>

                    </div>
                    <div class="card-body">
                        <table class=" table table-bordered table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Mã đơn hàng</th>
                                    <th>Tổng tiền</th>
                                    <th>Trạng thái đơn hàng</th>
                                    <th>Người đặt hàng</th>
                                    <th>Địa chỉ gửi hàng</th>
                                    <th>Ngày đặt hàng</th>
                                    <th colspan="2">Hành động</th>
                                </tr>
                            </thead>
                            <c:forEach var="order" items="${ListOrders}" varStatus="status">
                                <tbody id="my_table" class="pageStype">
                                    <tr>
                                        <td align="center">${status.count}</td>
                                        <td class="order_code" data-id="${order.orderCode}"
                                            style="text-align: center">${order.orderCode}</td>
                                        <td class="order_totalPrice"
                                            data-totalPrice="${order.totalPrice}">${order.totalPrice}</td>
                                        <td class="order_status" data-status="${order.status}">${order.status}</td>
                                        <td class="order_fullName" data-fullName="${order.fullName}">${order.fullName}</td>
                                        <td class="order_address" data-address="${order.address}">${order.address}</td>
                                        <td class="order_createdate"
                                            data-createdate="${order.createdAt}"><fmt:formatDate
                                                value="${order.createdAt}" pattern="dd-MM-yyyy" /></td>
                                        <td>

                                            <button type="button"
                                                    class="btn btn-success btn_edit btn_reset btnUpdate" data-toggle="modal" data-target="#modalOrderDetail"
                                                    id="btnUpdate" title="Chi tiết">
                                                <span class="fa fa-edit"></span>
                                            </button>
                                        </td>
                                        <td>
                                            <button type="button" class="btn btn-warning btn_remove"
                                                    title="Hủy">
                                                <span class="fa fa-trash"></span>
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


    <!-------MODAL CHI TIẾT HÓA ĐƠN------->


    <!-- The Modal -->
    <div class="modal fade" id="modalOrderDetail">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">CHI TIẾT HÓA ĐƠN</h4>

                </div>
                <div class="modal-body">
                    <form:form method="post"
                               action="/ShopFinal/order/customer/{orderCode}${_csrf.parameterName}=${_csrf.token}"
                               modelAttribute="OrderMap" enctype="multipart/form-data"
                               id="formUpdate">
                        <div class="card-body">
                            <table class=" table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>STT</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Giá tiền</th>
                                        <th>Số lượng đặt mua</th>
                                        <th>Khuyến mãi</th>
                                        <th>Tổng tiền</th>
                                    </tr>
                                </thead>
                                <c:forEach var="OrderDetail" items="${detail}"
                                           varStatus="status">
                                    <tbody id="my_table" class="pageStype">
                                        <tr>
                                            <td align="center">${status.count}</td>
                                            <td hidden="" class="OrderDetail_productName"
                                                data-id="${OrderDetail.productName}"
                                                style="text-align: center">${OrderDetail.productName}</td>
                                            <td class="OrderDetailr_price"
                                                data-price="${OrderDetail.price}">${OrderDetail.price}</td>
                                            <td class="OrderDetail_quantity"
                                                data-quantity="${OrderDetail.quantity}">${OrderDetail.quantity}</td>
                                            <td class="OrderDetail_discountRate"
                                                data-discountRate="${OrderDetail.discountRate}">${OrderDetail.discountRate}</td>
                                            <td class="OrderDetail_totalPrice"
                                                data-totalPrice="(${OrderDetail.quantity}*${OrderDetail.price} - ${OrderDetail.quantity}*${OrderDetail.price}*${OrderDetail.discountRate} )">${OrderDetail.quantity}*${OrderDetail.price}
                                                -
                                                ${OrderDetail.quantity}*${OrderDetail.price}*${OrderDetail.discountRate}</td>
                                            <td>
                                                <button type="button" class="btn btn-warning btn_cancel"
                                                        title="Thoát">
                                                    <span class="fa-trash"></span>
                                                </button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </c:forEach>
                            </table>
                            <ul id="pagination"></ul>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</section>

