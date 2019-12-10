<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br/><br/>
<section class="forms"> 
    <div class="container-fluid">
        <div class="row">
            <div class="container col-lg-8" style="margin-left: 30px;" >
                <div style=""> 
                    <h4>Giới thiệu</h4>
                    <img src="<c:url value="/customer/img/introduce.jpg"/>" >
                    <hr/>
                </div>
                <div>
                    <H5>Về chúng tôi</H5>

                    <p>FashionShop là một nền tảng thương mại điện tử thời trang nhanh B2C quốc tế.
                        Công ty chủ yếu tập trung vào trang phục của phụ nữ,
                        nhưng cũng cung cấp quần áo nam, quần áo trẻ em, phụ kiện,
                        giày dép, túi xách và các mặt hàng thời trang khác.                       
                        Thương hiệu được thành lập vào tháng 9 năm 2019, duy trì quan điểm "mọi người đều có thể tận hưởng vẻ đẹp của thời trang".
                    </p>
                    <hr/>
                    <h5>Sứ mệnh của chúng tôi</h5>
                    <p>
                        FashionSop tự hào cung cấp các phong cách theo xu hướng phục vụ cho cả nữ trẻ và thanh thiếu niên.
                        FashionSop tuân thủ quan điểm "mọi người đều có thể tận hưởng vẻ đẹp của thời trang".
                        FashionSop có thể đứng đầu trong các xu hướng thời trang mới nhất từ khắp nơi trên
                        thế giới đồng thời nhanh chóng đưa các kiểu dáng này ra thị trường.
                        Vì vậy, cho dù bạn đang tìm kiếm những chiếc đầm boho và áo thun họa tiết
                        hay áo sơ mi sang trọng và đồ bơi, FashionSop là cửa hàng lý tưởng cho các tín đồ thời trang hiện đại
                        nhưng tiết kiệm. Nhằm mục đích cung cấp các sản phẩm chất lượng cao
                        và thời trang với giá hấp dẫn cho mọi người dùng trên thế giới.
                    </p>
                    <br/>
                </div>
            </div>
            <div class="col-lg-2">
                <div id="accordion">
                    <div class="card">
                        <div class="card-header" id="headingOne">
                            <h5 class="mb-0">
                                <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    <span class="glyphicon glyphicon-th-list"></span>  Danh mục sản phẩm
                                </button>
                            </h5>
                        </div>

                        <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                            <div class="card-body" >
                                <div class="card" style="width: 18rem;">
                                    <ul class="list-group list-group-flush">
                                        <a href="DanhSachAo" class="list-group-item">Áo Sơ mi</a>
                                        <a href="DanhSachAo" class="list-group-item">Áo Khoác</a>
                                        <a href="DanhSachAo" class="list-group-item">Áo Thun</a>
                                        <a href="DanhSachQuan" class="list-group-item">Quần Jean</a>
                                        <a href="DanhSachQuan" class="list-group-item">Quần Kaki</a>
                                        <a href="DanhSachGiay" class="list-group-item">Giày - Dép</a>
                                        <a href="DanhSachNonMu" class="list-group-item">Nón</a>
                                        <a href="DanhSachTuiXach" class="list-group-item">Túi xách</a>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div
    </div>
</section>