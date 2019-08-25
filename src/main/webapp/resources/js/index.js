$(function () {
    var productUrl = "/Apache/user/getIndexProduct";
    var carouselProductUrl = "/Apache/user/getIndexCarouselProduct";
    $.ajax({
        url: productUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                var stu = JSON.parse(data.productIndexInfo);
                $(document).ready(function () {
                    var s = "";
                    for (var i = 0; i < stu.length; i++) {
                        s = "<a href='/Apache/product?productId="+stu[i].productId+"'><div class=\"col-lg-3 col-md-3 col-xs-6\">\n" +
                            "                    <div class=\"flash-deal-good\">\n" +
                            "                        <img src=" + stu[i].productImage + " width=\"110px\" alt=\"\">\n" +
                            "                        <p>" + stu[i].productName + "</p>\n" +
                            "                        <div class=\"flash-deal-price row\">\n" +
                            "                            <span class=\"col-md-6 col-lg-6 col-xs-6\">" + stu[i].productNowprice + "</span>\n" +
                            "                            <span class=\"col-md-6 col-lg-6 col-xs-6\">" +
                            " <a href='#' class='redStrikeHover'>\n" +
                            "  <span style='color:black;\n" +
                            "            background: none;'>" + stu[i].productOldprice + "</span>\n" +
                            " </a></span>\n" +
                            "                        </div>\n" +
                            "\n" +
                            "                    </div>\n" +
                            "                </div></a>";
                        $('#ms').append(s);
                    }
                });
            } else {
                alert(data.productIndexInfo);
            }
        }
    });
    $.ajax({
        url: carouselProductUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                var stu = JSON.parse(data.carouselProductInfo);
                $(document).ready(function () {
                    var t = "\n" +
                        "            <div id=\"mycan\" class=\"banner carousel slide\" data-ride=\"carousel\">\n" +
                        "                <ol class=\"carousel-indicators\">\n";
                    var s = "";
                    for (var i = 0; i < stu.length; i++) {
                        if (i == 0) {
                            s = "\n" +
                                "                    <div class=\"item active\">\n" +
                                "                        <img style='width:720px;height:388px;' src=\"" + stu[i].productImage + "\" alt=\"...\">\n" +
                                "                        <div class=\"carousel-caption\">\n" +
                                "                            <h1>" + stu[i].productName + "</h1>\n" +
                                "                            <p>" + stu[i].productDesc + "</p>\n" +
                                "                            <a href=\"/Apache/product?productId=" + stu[i].productId + "\" class=\"btn btn-warning\">查看详情</a>\n" +
                                "                        </div>\n" +
                                "                    </div>";
                            t += "                    <li data-target=\"#mycan\" data-slide-to=\"0\" class=\"active\"></li>\n";
                        } else {
                            s += "\n" +
                                "                    <div class=\"item\">\n" +
                                "                        <img style='width:720px;height:388px;' src=\"" + stu[i].productImage + "\" alt=\"...\">\n" +
                                "                        <div class=\"carousel-caption\">\n" +
                                "                            <h1>" + stu[i].productName + "</h1>\n" +
                                "                            <p>" + stu[i].productDesc + "</p>\n" +
                                "                            <a href=\"/Apache/product?productId=" + stu[i].productId + "\" class=\"btn btn-warning\">查看详情</a>\n" +
                                "                        </div>\n" +
                                "                    </div>";
                            t += "                    <li data-target=\"#mycan\" data-slide-to=\"" + i + "\" class=\"\"></li>\n";
                        }
                    }
                    s += "\n" +
                        "                </div>\n" +
                        "\n" +
                        "\n" +
                        "            </div>";
                    t += "                </ol>\n" +
                        "\n" +
                        "                <!--  修改这里轮播图-->\n" +
                        "                <div class=\"carousel-inner\" role=\"listbox\" id=\"carousel\">";
                    t+=s;
                    $('#carousel').append(t);
                    $("#mycan").carousel({
                        interval: 2000
                    })
                    $(".carousel").carousel({
                        interval: 2000
                    })
                });
            } else {
                alert(data.carouselProductInfo);
            }
        }
    });
});

$(function () {
    var productBigCategoryUrl = "/Apache/user/getBigCategory";
    var productCategoryUrl = "/Apache/user/getProductCategory";
    var productCategoryJson;
    $.ajax({
        url: productCategoryUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                productCategoryJson = JSON.parse(data.productCategoryInfo);
                $.ajax({
                    url: productBigCategoryUrl,
                    type: 'POST',
                    contentType: false,
                    processData: false,
                    cache: false,
                    success: function (data) {
                        if (data.success) {
                            var stu = JSON.parse(data.bigCategoryInfo);
                            var bigCategory = $('.bigCategory');
                            $(document).ready(function () {
                                var s = "";
                                for (var i = 0; i < stu.length; i++) {
                                    $(bigCategory[i]).text(stu[i].productBigCategoryName);
                                    $(bigCategory[i]).attr("value", stu[i].productBigCategoryId);
                                    for (var j = 0; j < productCategoryJson.length; j++) {
                                        if ($(bigCategory[i]).val() == productCategoryJson[j].productBigCategoryId) {
                                            var s = "<li class=\"list-group-item col-md-4 col-lg-3 col-xs-3 \"><a onclick=getProductListByCategory(" + productCategoryJson[j].productCategoryId + ") href=productList?productCategoryId=" + productCategoryJson[j].productCategoryId + ">" + productCategoryJson[j].productCategoryName + "</a></li>";
                                            $(bigCategory[i]).after(s);
                                        }
                                    }
                                }
                            });
                        } else {
                            alert(data.productIndexInfo);
                        }
                    }
                });
            } else {
                alert(data.productCategoryInfo);
            }
        }
    });
});

$(function () {
    $('#search').click(function () {
        var searchContent = $('#searchContent').val();
        window.location = "/Apache/search?searchContent=" + searchContent;
    });
});

$(function () {
    $('#form').keyup(function () {

        if (event.keyCode == 13) {
            var searchContent = $('#searchContent').val();
            window.location = "/Apache/search?searchContent=" + searchContent;
        }
    });
});