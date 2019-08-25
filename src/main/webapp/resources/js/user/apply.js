$(function () {
    var applyUrl = '/Apache/user/applyForShop';
    var userUUID = {};
    userUUID.userUUID = $.cookie('userUUID');
    if (userUUID.userUUID == null) {
        alert("登录失败，请重新登录！");
        window.location = "../login";
    }
    $('#apply').click(function () {
        var shop = {};
        shop.shopName = $('#shopName').val();
        shop.shopCategory = $('#shopCategory').val();
        shop.shopDesc = $('#shopDesc').val();
        shop.shopAddress = $('#shopAddress').val();
        shop.shopPhone = $('#shopPhone').val();
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
        shop.userUUID = $.cookie('userUUID');
        var formData = new FormData();
        formData.append('shop', JSON.stringify(shop));
        var thumbnail = $('#shopImage')[0].files[0];
        if(thumbnail==null){
            alert("店铺图片不能为空！");
            return;
        }
        formData.append('thumbnail', thumbnail);
        $.ajax({
            url: applyUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    alert(data.applyInfo);
                    window.location.href = '/Apache/user';
                } else {
                    alert(data.applyInfo);
                }
            }
        });
    });
});