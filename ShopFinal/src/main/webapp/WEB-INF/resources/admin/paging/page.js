/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    $(function () {
        var pageSize = 5; // Hiển thị 5 sản phẩm trên 1 trang
        showPage = function (page) {
            $(".pageStype").hide();
            $(".pageStype").each(function (n) {
                if (n >= pageSize * (page - 1) && n < pageSize * page)
                    $(this).show();
            });
        };
        showPage(1);
        ///** Cần truyền giá trị vào đây **///
        var row_count = $('#my_table tr').length;
        // Tổng số sản phẩm hiển thị
        var btnPage = 5; // Số nút bấm hiển thị di chuyển trang
        var iTotalPages = Math.ceil(row_count / pageSize);
        var obj = $('#pagination').twbsPagination({
            totalPages: iTotalPages,
            visiblePages: btnPage,
            onPageClick: function (event, page) {
                /* console.info(page); */
                showPage(page);
            }
        });
    });


