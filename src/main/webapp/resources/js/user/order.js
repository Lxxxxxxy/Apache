$(function () {
    var getUrl = '/Apache/user/managerOrders?userId=' + $.cookie('userUUID');
    ;
    var userUUID = {};
    userUUID.userUUID = $.cookie('userUUID');
    if (userUUID.userUUID == null) {
        alert("登录失败，请重新登录！");
        window.location = "../login";
    }
    $.ajax({
        url: getUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                stu = JSON.parse(data.orderInfo);
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
                        s = "\n" +
                            "            <tr>\n" +
                            "                <td>" + stu[i].orderId + "</td>\n" +
                            "                <td>" + stu[i].productName + "</td>\n" +
                            "                <td>" + stu[i].orderUserAddress + "</td>\n" +
                            "                <td>" + stu[i].orderPaymentAmount + "</td>\n" +
                            "                <td id='" + stu[i].orderId + "'>" + stu[i].orderLogistics + "</td>\n" +
                            "                <td>" + stu[i].orderStatus + "</td>\n" +
                            "                <td>";

                        if(stu[i].orderStatus!="已收货"){
                            s += "<button class=\"btn  btn-default \" onclick='input(\"" + stu[i].orderId + "\")'>设置物流</button>";
                        }else{
                            s += "<button class=\"btn  btn-default \">无操作</button>";

                        }
                        s += "</td>\n" +
                            "            </tr>";
                        $("#orders").append(s);
                    }
                });
            } else {
                alert(data.orderInfo);
            }
        }
    });
});

function input(orderId) {
    var a = $('#' + orderId);
    var s = "<div class=\"input-group\">\n" +
        "\t\t\t\t\t<input type=\"text\" class=\"form-control\" id='logistics'>\n" +
        "\t\t\t\t\t<span class=\"input-group-btn\">\n" +
        "\t\t\t\t\t\t<button class=\"btn btn-default\" type=\"button\" onclick='addLogistics(\"" + orderId + "\")'>\n" +
        "\t\t\t\t\t\t\t提交物流\n" +
        "\t\t\t\t\t\t</button>\n" +
        "\t\t\t\t\t</span>\n" +
        "\t\t\t\t</div>";
    a.html("");
    a.append(s);
}

function addLogistics(orderId) {
    var addUrl = "/Apache/user/addLogistics?orderId=" + orderId + "&orderLogistics=" + $('#logistics').val();
    $.ajax({
        url: addUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                alert(data.addInfo);
                window.location = "/Apache/user/myOrdersByShop";
            } else {
                alert(data.addInfo);
            }
        }
    });
}