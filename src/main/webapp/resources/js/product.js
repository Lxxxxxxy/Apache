$(function () {
    var currentUrl = window.location.href.toString();
    var reg = RegExp(/product\?productId/);
    var paraUrl = document.location.toString();
    var Url = paraUrl.split("?");

    var para = Url[1];
    var getUrl = '/Apache/user/productInfo?' + para;
    if (reg.test(currentUrl)) {
        $.ajax({
            url: getUrl,
            type: 'POST',
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    var stu = JSON.parse(data.productInfo);
                    var shopName = JSON.parse(data.shopName);
                    $(document).ready(function () {
                        $('#productNowprice').text(stu.productNowprice);
                        $('#productOldprice').text(stu.productOldprice);
                        $('#productRemaining').html(stu.productRemaining);
                        $('#productImage').attr("src", stu.productImage);
                        $('#productBigImage').attr("src", stu.productImage);
                        $('#productName').text("商品名称：" + stu.productName);
                        $('#shopName').text(shopName.shopName);
                        document.title = "商品详情-" + stu.productName;
                    });
                } else {
                    alert(data.productInfo);
                }
            }
        });
    }
});

$(function () {
    var currentUrl = document.location.toString();
    var Url = currentUrl.split("?");

    var para = Url[1];
    var url = '/Apache/user/getProductListByCategory?' + para;

    var reg = RegExp(/productList/);
    if (reg.test(currentUrl)) {
        $.ajax({
            url: url,
            type: 'POST',
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    var stu = JSON.parse(data.productListInfo);
                    $(document).ready(function () {
                        var s = "";
                        for (var i = 0; i < stu.length; i++) {
                            var s = "\n" +
                                "                <a href='/Apache/product?productId=" + stu[i].productId + "'><div class=\"col-lg-3 col-md-4 col-xs-12\">\n" +
                                "                    <div class=\"product-item\">\n" +
                                "                        <div class=\"product-item-face\">\n" +
                                "                            <img src=" + stu[i].productImage + "></div>\n" +
                                "                        <h2 class=\"product-title\">" + stu[i].productName + "</h2>\n" +
                                "                        <div class=\"product-info\"><p>" + stu[i].productDesc + "</p></div>\n" +
                                "                        <div class=\"product-price\">￥<span>" + stu[i].productNowprice + "</span></div>\n" +
                                "                    </div>\n" +
                                "                </div></a>";
                            $('#prodictList').append(s);
                        }
                    });
                } else {
                    alert(data.productListInfo);
                }
            }
        });
    }
});

$(function () {
    var getUserInfoUrl = '/Apache/user/getUserInfo';
    $('#buy').click(function () {
        var userUUID = {};
        userUUID.userUUID = $.cookie('userUUID');
        if (userUUID.userUUID == null) {
            alert("登录失败，请重新登录！");
            window.location = "/Apache/login";
        }
        var userInfo = {};
        userInfo.userUUID = $.cookie('userUUID');
        var formData = new FormData();
        formData.append('userUUID', JSON.stringify(userInfo));
        var user = null;
        $.ajax({
            url: getUserInfoUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    user = JSON.parse(data.userInfo);
                    var currentUrl = document.location.toString();
                    var Url = currentUrl.split("?");
                    var para = Url[1];
                    var buyCount = $('#buyCount').val();
                    var buyUrl = '/Apache/buy?' + para + "&userDefaultAddress=" + user.userDefaultAddress + "&buyCount=" + buyCount + "&userUUID=" + $.cookie('userUUID');
                    ;
                    window.location = buyUrl;
                } else {
                    alert(data.userInfo);
                }
            }
        });
    });
});

$(function () {
    var currentUrl = document.location.toString();
    var Url = currentUrl.split("?");

    var para = Url[1];
    var getCommentUrl = '/Apache/user/getComment?'+para;
    var currentUrl = window.location.href.toString();
    var reg = RegExp(/productList/);
    if (reg.test(currentUrl)) {
        return;
    }
    $.ajax({
        url: getCommentUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                var stu = JSON.parse(data.commentInfo);
                $(document).ready(function () {
                    var s = "";
                    for (var i = 0; i < stu.length; i++) {
                        s="\n" +
                            "            <li class=\"list-group-item\">\n" +
                            "                <div class=\"row\">\n" +
                            "                    <div class=\"col-xs-2 col-md-1 col-lg-1\">\n" +
                            "                        <img src=\""+stu[i].userHeadImage+"\" class=\"img-circle\" height=\"50px\" alt=\"\">\n" +
                            "                    </div>\n" +
                            "                    <div class=\"col-xs-10 col-md-11 col-lg-11 comment-detail\">\n" +
                            "                        <span class=\"pull-right grade\"></span>\n" +
                            "                        <p>"+stu[i].userName+"</p>\n" +
                            "                        <p>\n" +
                            "                            "+stu[i].commentDetail+"\n" +
                            "                        </p>\n" +
                            "                    </div>\n" +
                            "                </div>\n" +
                            "            </li>";
                        $('#comment').append(s);
                    }
                });
            } else {
                alert(data.commentInfo);
            }
        }
    });
});