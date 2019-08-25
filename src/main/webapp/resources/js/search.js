$(function () {
    var findUserUrl = "/Apache/user/getUserInfo";
    var userUUID = {};
    userUUID.userUUID = $.cookie('userUUID');
    var formData = new FormData();
    formData.append('userUUID', JSON.stringify(userUUID));
    $.ajax({
        url: findUserUrl,
        type: 'POST',
        data: formData,
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                $('#userName').find("a").remove();
                stu = JSON.parse(data.userInfo);
                var s = "<a href=/Apache/user>欢迎你，" + stu.userName + "</a>";
                $('#userName').append(s);
                var s = "<li><a href=\"#\" onclick='logout()'>注销</a></li>";
                $('#register').remove();
                $('#userName').after(s);
            } else {
                alert(data.userInfo);
            }
        }
    });
});

$(function () {
    var currentUrl = document.location.toString();
    var Url = currentUrl.split("?");

    var para = Url[1];
    var url = '/Apache/user/searchProduct?' + para;

    var reg = RegExp(/search\?/);
    if (reg.test(currentUrl)) {
        $.ajax({
            url: url,
            type: 'POST',
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    var stu = JSON.parse(data.searchInfo);
                    $(document).ready(function () {
                        var s = "";
                        for (var i = 0; i < stu.length; i++) {
                            var s = "\n" +
                                "                <a href='/Apache/product?productId=" + stu[i].productId + "'><div class=\"col-lg-3 col-md-4 col-xs-12\">\n" +
                                "                    <div class=\"product-item\">\n" +
                                "                        <div class=\"product-item-face\">\n" +
                                "                            <img src=" + stu[i].productImage + "></div>\n" +
                                "                        <h2 class=\"product-title\">" + stu[i].productName + "</h2>\n" +
                                "                        <div class=\"product-label\">\n" +
                                "                            <span class=\"label label-info\">" + stu[i].productName + "</span>\n" +
                                "                        </div>\n" +
                                "                        <div class=\"product-info\"><p>" + stu[i].productDesc + "</p></div>\n" +
                                "                        <div class=\"product-price\">￥<span>" + stu[i].productNowprice + "</span></div>\n" +
                                "                    </div>\n" +
                                "                </div></a>";
                            $('#prodictList').append(s);
                        }
                    });
                } else {
                    alert(data.searchInfo);
                }
            }
        });
    }
});