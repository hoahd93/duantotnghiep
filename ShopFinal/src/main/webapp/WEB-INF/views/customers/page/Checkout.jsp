
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
						<div class="col-sm-6">
							<h1>XÁC NHẬN THANH TOÁN</h1>
						</div>
					</div>
					<div class="card-body">
						<form method="post"
							action="${pageContext.request.contextPath}/checkout"
							enctype="multipart/form-data">
							<table class=" table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Tên sản phẩm</th>
										<th>Hình ảnh</th>
										<th>Giá tiền</th>
										<th>Số lượng đặt mua</th>
										<th>Khuyến mãi</th>
										<th>Tổng tiền</th>
									</tr>
								</thead>
								<c:forEach var="cart" items="${listCart}">
									<tbody id="my_table" class="pageStype">
										<tr>
											<td class="cart_productName" style="text-align: center">${cart.productCart.productname}</td>
											<td class="cart_imageMain"><img
												style="width: 240px; height: 280px;"
												src="${pageContext.request.contextPath}/upload/${cart.productCart.imageMain}" />
											<td />
											<td class="cart_price">${cart.productCart.price}</td>
											<td class="cart_quantity">${cart.quantity}</td>
											<td class="cart_discountRate">${cart.productCart.discountRate}</td>
											<td class="cart_totalPrice">${cart.quantity}*${cart.productCart.price}
												-
												${cart.quantity}*${cart.productCart.price}*${cart.productCart.discountRate}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
							<table class=" table table-bordered table-hover table-striped">
							
							</table>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</section>

