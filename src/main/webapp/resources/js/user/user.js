window.onload = $(function () {
    var getUserInfo = '/Apache/user/getUserInfo';
    var userUUID = {};
    userUUID.userUUID = $.cookie('userUUID');
    if (userUUID.userUUID == null) {
        alert("登录失败，请重新登录！");
        window.location = "/Apache/login";
    }
    var formData = new FormData();
    formData.append('userUUID', JSON.stringify(userUUID));
    $(function () {
        $.ajax({
            url: getUserInfo,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                var a = JSON.parse(data.userInfo);
                $('#username').text("用户名：" + a.userName);
                $('#userEmail').text("电子邮箱：" + a.userEmail);
                $('#userHeadImage').attr("src", a.userHeadImage);
                if (a.userApplyShop == 1) {
                    var s = " <a id=\"shopInfo\" href=\"#\" class=\"btn btn-info\">店铺信息 </a> " +
                        " <a id=\"shopProduct\" href=\"/Apache/user/managerProduct\" class=\"btn btn-success\">商品管理</a> " +
                        " <a id=\"orders\" href=\"/Apache/user/myOrdersByShop\" class=\"btn btn-success\">订单管理</a> " +
                        " <a href=\"/Apache/user/addProduct\" class=\"btn btn-success\">添加商品</a> " +
                        "";
                    $('#apply').remove();
                    $('#ManagerShop').append(s);
                    var url = '/Apache/user/editManagerShop?userId=' + $.cookie('userUUID');
                    $('#shopInfo').attr("href", url);
                }
                if (a.userType == 2) {
                    $('#shop').attr("href", "/Apache/user/managerShopByAdmin");
                    $('#apply').text("管理所有店铺");
                    var a = $('<a id="productCategory" href="/Apache/user/productCategory">商品分类管理</a><br>')
                    $('.info').append(a);
                    // <a id="productCategory" href="user/productCategory">商品分类管理</a><br>
                    $('#myOrders').remove();
                    $('#myAddress').remove();
                    $('#address').remove();
                    $('#addAddress').remove();
                    $('#orders').remove();
                    $('#addressInfo').remove();
                    $('#orderInfo').remove();
                    var categoryManager = "\n" +
                        "                <div class=\"alert alert-info\" id=\"myOrders\" href=\"./myOrders\">\n" +
                        "                    商品分类管理\n" +
                        "                </div>\n" +
                        "                <div class=\"container\" style=\"margin-bottom: 10px\">\n" +
                        "                    <a id=\"shop\" href=\"/Apache/user/productCategory\">\n" +
                        "                        <button class=\"btn btn-warning\">分类管理</button>\n" +
                        "                    </a>\n" +
                        "<a href='/Apache/user/addProductCategory'>" +
                        "<button class=\"btn btn-warning\">添加分类</button>\n" +
                        "</a>\n" +
                        "                </div>";
                    $('#ManagerShop').after(categoryManager);
                }
            }
        });
    });
});
$(function () {
    $('#exit').click(function () {
        $.removeCookie('userUUID', {path: '/'});
        window.location = "/Apache/login";
    });
});

$(function () {
    $('#userHeadImage').click(function () {
        var url = $('#userHeadImage').attr("src");
        window.open(url);
    });
});

$(function () {
    var getOrdersInfo = '/Apache/user/getOrders?userId=' + $.cookie('userUUID');
    $(function () {
        $.ajax({
            url: getOrdersInfo,
            type: 'POST',
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    var stu = JSON.parse(data.orderInfo);
                    $(document).ready(function () {
                        var s = "";
                        for (var i = 0; i < stu.length; i++) {
                            if (stu[i].orderStatus == 1) {
                                stu[i].orderStatus = "已付款";
                            }
                            if (stu[i].orderStatus == 2) {
                                stu[i].orderStatus = "已发货";
                            }
                            if (stu[i].orderStatus == 3) {
                                stu[i].orderStatus = "已收货";
                            }
                            if (stu[i].orderLogistics == "") {
                                stu[i].orderLogistics = "暂无物流信息";
                            }
                            s = "<tr>\n" +
                                "<td>" + stu[i].orderId + "</td>\n" +
                                "<td>" + stu[i].productName + "</td>\n" +
                                "<td>" + stu[i].orderPaymentAmount + "</td>\n" +
                                "<td>" + stu[i].orderLogistics + "</td>\n" +
                                "<td>" + stu[i].orderStatus + "</td>\n";
                            if (stu[i].orderStatus == "已发货") {
                                s += "<td><button class=\"btn  btn-default \" onclick=confirm1(\"" + stu[i].orderId + "\")>确认收货</button></td>\n";
                            } else if (stu[i].orderComment != 1 && stu[i].orderStatus == "已收货") {
                                s += "<td><button class=\"btn  btn-default \" onclick=ShowCreateModal(\"" + stu[i].orderId + "\")>评价</button></td>\n";
                            } else if (stu[i].orderComment == 1) {
                                s += "<td><button class=\"btn  btn-default \">已评价</button></td>\n";
                            } else {
                                s += "<td><button class=\"btn  btn-default \">无操作</button></td>\n";
                            }
                            s += "</tr>";
                            $("#orders").append(s);
                        }
                    });
                } else {
                    alert(data.orderInfo);
                }
            }
        });
    });
});

function confirm1(orderId) {
    var confirmUrl = "/Apache/user/confirmOrder?orderId=" + orderId;
    $.ajax({
        url: confirmUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                alert(data.confirmInfo);
                window.location = "/Apache/user";
            } else {
                alert(data.confirmInfo);
            }
        }
    });
}


function ShowCreateModal(orderId) {
    $('#createFileMModal').modal('show');
    $('#orderId').val(orderId);
}

$("#createFileSureBut").click(function () {
    $("#createFileMModal").modal("hide");
    var commentDetail = $("#comment").val();
    var orderId = $('#orderId').val();
    var commentUrl = "/Apache/user/commentOrder?orderId=" + orderId + "&commentDetail=" + commentDetail;
    $.ajax({
        url: commentUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                alert(data.conmmentInfo);
                window.location = "/Apache/user";
            } else {
                alert(data.conmmentInfo);
            }
        }
    });
});

function editPassword() {
    $('#password').modal('show');
}

$("#ok").click(function () {
    $("#password").modal("hide");
    var newpassword = $("#newpassword").val();
    var editUrl = "/Apache/user/editPassword?userId=" + $.cookie('userUUID') + "&newpassword=" + newpassword;
    $.ajax({
        url: editUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                alert(data.editInfo);
                $.removeCookie('userUUID', {path: '/'});
                window.location = "/Apache/login";
            } else {
                alert(data.editInfo);
            }
        }
    });
});