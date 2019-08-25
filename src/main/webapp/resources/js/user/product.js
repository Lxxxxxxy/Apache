$(function () {
    var registerUrl = '/Apache/user/putProduct';
    $('#add').click(function () {
        var product = {};
        product.productName = $('#productName').val();
        product.productOldprice = $('#productOldprice').val();
        product.productNowprice = $('#productNowprice').val();
        product.productRemaining = $('#productRemaining').val();
        product.productCategory = $('#productCategory').val();
        product.productDesc = $('#productDesc').val();
        if(product.productName==""){
            alert("商品名不能为空！");
            return;
        }
        if(product.productOldprice==""){
            alert("商品原价不能为空！");
            return;
        }
        if(product.productNowprice==""){
            alert("商品现价不能为空！");
            return;
        }
        if(product.productRemaining==""){
            alert("商品库存不能为空！");
            return;
        }
        if(product.productCategory==""){
            alert("商品分类不能为空！");
            return;
        }
        if(product.productDesc==""){
            alert("商品简介不能为空！");
            return;
        }
        product.userUUID = $.cookie('userUUID');
        var formData = new FormData();
        formData.append('product', JSON.stringify(product));
        var thumbnail = $('#productImage')[0].files[0];
        if(thumbnail==null){
                alert("商品图片不能为空！");
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
                    alert(data.putProductInfo);
                    window.location = "/Apache/user/managerProduct";
                } else {
                    alert(data.putProductInfo);
                }
            }
        });
    });
});

$(function () {
    var userUUID = {};
    userUUID.userUUID = $.cookie('userUUID');
    if (userUUID.userUUID == null) {
        alert("登录失败，请重新登录！");
        window.location = "/Apache/login";
    }
    var formData = new FormData();
    formData.append('userUUID', JSON.stringify(userUUID));
    var currentUrl = window.location.href.toString();
    var reg = RegExp(/managerProduct/);
    if (!reg.test(currentUrl)) {
        return;
    }
    var url = "/Apache/user/managerProductList";
    $.ajax({
        url: url,
        type: 'POST',
        data: formData,
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                if (data.productInfo == "[]") {
                    alert("商品为空，请添加！");
                    window.location = "/Apache/user/addProduct";
                }
                var stu = JSON.parse(data.productInfo);
                $(document).ready(function () {
                    var s = "";
                    for (var i = 0; i < stu.length; i++) {
                        s = "<tr><td>" + stu[i].productName + "</td><td class='category'>" + stu[i].productCategory.toString().trim() + "</td><td>" +
                            stu[i].productOldprice + "</td><td>" +
                            stu[i].productNowprice + "</td><td><img class='image' src='" +
                            stu[i].productImage + "'</img></td><td>" +
                            stu[i].productRemaining + "</td><td>" +
                            stu[i].productDesc + "</td><td><a onclick=deleteProductCategory(" + stu[i].productId + ",'" + stu[i].productUserId + "') href=\"#\">删除</a></td></tr>";
                        $("#tab").append(s);
                    }
                    var cate;
                    var url = '/Apache/user/getProductCategory';
                    $.ajax({
                        url: url,
                        type: 'POST',
                        contentType: false,
                        processData: false,
                        cache: false,
                        success: function (data) {
                            if (data.success) {
                                cate = JSON.parse(data.productCategoryInfo);
                                $(document).ready(function () {
                                    var s = "";
                                    var category = $('.category');
                                    for (var i = 0; i < cate.length; i++) {
                                        for (var j = 0; j < category.length; j++) {
                                            if (cate[i].productCategoryId == category[j].innerHTML) {
                                                category[j].innerHTML = cate[i].productCategoryName;
                                            }
                                        }
                                    }
                                });
                            } else {
                                alert(data.productCategoryInfo);
                            }
                        }
                    });
                });
            } else {
                alert(data.info);
            }
        }
    });
});

function deleteProductCategory(productId, productUserId) {
    if (!confirm("你确定提交吗？")) {
        return;
    }
    var registerUrl = '/Apache/user/deleteProduct';
    var formData = new FormData();
    formData.append('productId', JSON.stringify(productId));
    formData.append('productUserId', JSON.stringify(productUserId));
    $.ajax({
        url: registerUrl,
        type: 'POST',
        data: formData,
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                alert(data.deleteInfo);
                window.location = "/Apache/user/managerProduct";
            } else {
                alert(data.deleteInfo);
            }
        }
    });
};

$(function () {
    var currentUrl = window.location.href.toString();
    var reg = RegExp(/addProduct/);
    if (!reg.test(currentUrl)) {
        return;
    }
    var stu;
    var url = '/Apache/user/getProductCategory';
    $.ajax({
        url: url,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                stu = JSON.parse(data.productCategoryInfo);
                $(document).ready(function () {
                    var s = "";
                    var category = $('.category');
                    for (var i = 0; i < stu.length; i++) {
                        s = $('<option value=' + stu[i].productCategoryId + '>' + stu[i].productCategoryName + '</option>');
                        $("#productCategory").append(s);
                        for (var j = 0; j < category.length; j++) {
                            if (stu[i].productCategoryId == category[i].innerHTML) {
                                category[i].innerHTML = stu[i].productCategoryName;
                            }
                        }
                    }
                });
            } else {
                alert(data.productCategoryInfo);
            }
        }
    });
});