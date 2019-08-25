window.onload = $(function () {
    var currentUrl = window.location.href.toString();
    var reg = RegExp(/managerShopByAdmin/);
    var userUUID = {};
    userUUID.userUUID = $.cookie('userUUID');
    if (userUUID.userUUID == null) {
        alert("登录失败，请重新登录！");
        window.location = "/Apache/login";
    }
    if (reg.test(currentUrl)) {
        var registerUrl = '/Apache/user/getAllShop';
        $.ajax({
            url: registerUrl,
            type: 'POST',
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    var stu = JSON.parse(data.info);
                    $(document).ready(function () {
                        var s = "";
                        for (var i = 0; i < stu.length; i++) {
                            s = "<tr><td>" + stu[i].shopName + "</td><td>" + stu[i].shopCategory + "</td><td>" +
                                stu[i].shopAddress + "</td><td>" +
                                stu[i].shopPhone + "</td><td><img class='image' src='" +
                                stu[i].shopImage + "'</img></td><td>" +
                                stu[i].shopStatus + "</td><td>" +
                                stu[i].shopPriority + "</td><td>" +
                                stu[i].shopLevel + "</td><td><a onclick=deleteShop(" + stu[i].shopId + ",'" + stu[i].shopUserId + "') href=\"#\">删除</a></td></tr>";
                            $("#tab").append(s);
                        }
                    });
                } else {
                    alert(data.info);
                }
            }
        });
    }
});

$(function () {
    var registerUrl = '/Apache/user/editShop';
    $('#edit').click(function () {
        var shopInfo = {};
        shopInfo.shopName = $('#shopName').val();
        shopInfo.shopCategory = $('#shopCategory').val();
        shopInfo.shopDesc = $('#shopDesc').val();
        shopInfo.shopAddress = $('#shopAddress').val();
        shopInfo.shopPhone = $('#shopPhone').val();
        if (shop.shopName == "") {
            alert("店铺名不能为空！");
            return;
        }
        if (shop.shopCategory == "") {
            alert("店铺分类不能为空！");
            return;
        }
        if (shop.shopDesc == "") {
            alert("店铺简介不能为空！");
            return;
        }
        if (shop.shopAddress == "") {
            alert("店铺地址不能为空！");
            return;
        }
        if (shop.shopPhone == "") {
            alert("店铺联系方式不能为空！");
            return;
        }
        var formData = new FormData();
        formData.append('shopInfo', JSON.stringify(shopInfo));
        var thumbnail = $('#shopImage')[0].files[0];
        if(thumbnail==null){
            alert("店铺图片不能为空！");
            return;
        }
        formData.append('thumbnail', thumbnail);
        $.ajax({
            url: registerUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    alert(data.editInfo);
                    window.location.href = '/Apache/user/managerShop';
                } else {
                    alert(data.editInfo);
                }
            }
        });
    });
});



$(function () {
    var currentUrl = window.location.href.toString();
    var reg = RegExp(/productCategory/);
    if (reg.test(currentUrl)) {
        var url = '/Apache/user/getProductCategory';
        $.ajax({
            url: url,
            type: 'POST',
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    if (data.productCategoryInfo == '[]') {
                        alert("暂无商品分类，请添加！");
                        window.location = "/Apache/user/addProductCategory";
                    } else {
                        var stu = JSON.parse(data.productCategoryInfo);
                        $(document).ready(function () {
                            var s = "";
                            for (var i = 0; i < stu.length; i++) {
                                if(stu[i].productBigCategory==null){
                                    stu[i].productBigCategory="无";
                                }
                                s = "<tr><td>" + stu[i].productCategoryId + "</td><td>" + stu[i].productBigCategory + "</td><td>" + stu[i].productCategoryName +
                                    "</td><td><a onclick=editCategory(" + stu[i].productCategoryId + ") href='#'>编辑</a> &nbsp;" +
                                    "<a onclick=deleteCategory(" + stu[i].productCategoryId + ") href='#'>删除</a></td></tr>";
                                $("#tab").append(s);
                            }
                        });
                    }
                } else {
                    alert(data.productCategoryInfo);
                }
            }
        });
    }
});


function deleteShop(shopId, userId) {
    if (!confirm("你确定提交吗？")) {
        return;
    }
    var applyUrl = '/Apache/user/deleteShop?shopId=' + shopId + "&userId=" + userId;
    $.ajax({
        url: applyUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                alert(data.deleteInfo);
                window.location.href = '/Apache/user/managerShopByAdmin';
            } else {
                alert(data.deleteInfo);
            }
        }
    });
};

function deleteCategory(categoryId) {
    if (!confirm("你确定提交吗？")) {
        return;
    }
    var applyUrl = '/Apache/user/deleteCategory?categoryId=' + categoryId;
    $.ajax({
        url: applyUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                alert(data.deleteInfo);
                window.location.href = '/Apache/user/productCategory';
            } else {
                alert(data.deleteInfo);
            }
        }
    });
};

$(function () {
    var currentUrl = window.location.href.toString();
    var reg = RegExp(/editManagerShop/);
    if (reg.test(currentUrl)) {
        $('#shopName').attr("value", shopInfo.shopName);
        $('#shopImg').attr("src", shopInfo.shopImage);
        $('#shopCategory').attr("value", shopInfo.shopCategory);
        $('#shopDesc').attr("value", shopInfo.shopDesc);
        $('#shopAddress').attr("value", shopInfo.shopAddress);
        $('#shopPhone').attr("value", shopInfo.shopPhone);
        return;
    }
});