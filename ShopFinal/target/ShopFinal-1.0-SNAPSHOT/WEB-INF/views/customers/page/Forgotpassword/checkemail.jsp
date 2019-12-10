<%-- 
    Document   : checkemail
    Created on : Oct 15, 2019, 10:32:37 AM
    Author     : admin
--%>
<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section style="margin: 20px">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">

            </div>
            <div class="panel-group col-sm-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">NHẬP ĐỊA CHỈ EMAIL</div>
                    <div class="panel-body">
                        <form action="/ShopFinal/checkemail?${_csrf.parameterName}=${_csrf.token}" method="POST" id="form">
                            <div class="form-group panel-body">
                                <div class="row">         
                                    <input type="text" placeholder="Nhập email đăng ký" name="email" id="email" style="width: 80%"/><button type="submit" onclick="return checkForm()">RESET PASSWORD</button>
                                    <p style="color: red" id="error">${fail}</p>
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
<script>
    function checkForm() {
        var email = document.getElementById("email").value;
        var filteremail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; //định dạng mail
        var status = true;
        if (email !== '') {
            if (filteremail.test(email) === false)
            {
                document.getElementById("error").innerHTML = "Email không hợp lệ! Vui lòng thử lại.";
                status = false;
            } else {
                document.getElementById("error").innerHTML = "";
            }
        } else {
            document.getElementById("error").innerHTML = "Vui lòng nhập Email!";
            status = false;
        }
        return status;
    }
    ;
</script>