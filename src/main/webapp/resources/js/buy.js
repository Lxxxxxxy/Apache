$(function () {
    var currentUrl = document.location.toString();
    var Url = currentUrl.split("?");
    var para = Url[1];
    var editUrl = '/Apache/user/buyProduct?' + para;
    $.ajax({
        url: editUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                // alert(data.productInfo);
                // alert(data.userAddressInfo);
                // alert(data.buyCount);
                // alert(data.shopInfo);
                var product = JSON.parse(data.productInfo);
                var bigCategory = $('.bigCategory');
                $(document).ready(function () {
                    $('#productImage').attr("src", product.productImage);
                    $('#productName').text(product.productName);
                    $('#productDesc').text(product.productDesc);
                    $('#productNowprice').text(product.productNowprice);
                    $('#productRemaining').text(product.productRemaining);
                    $('#countPrice').text(product.productNowprice * data.buyCount);
                });
            } else {
                alert(data.buyInfo);
            }
        }
    });
});

$(function () {
    var url = document.location.toString();
    var splitUrl = url.split("=");
    var productId = splitUrl[1].substring(0, splitUrl[1].match("^[1-9]\\d*"));
    var buyCount = splitUrl[3].substring(0, splitUrl[3].match("^[1-9]\\d*"));
    var addOrderUrl = '/Apache/user/addOrder?productId='+productId+"&buyCount="+buyCount;
    $('#addOrder').click(function () {
        var order = {};
        order.productId = productId;
        var a=$('#address')[$('#address')[0].selectedIndex].textContent;
        order.orderUserAddress = a;
        var count={};
        count.buyCount = buyCount;
        order.userUUID = $.cookie('userUUID');
        var formData = new FormData();
        formData.append('order', JSON.stringify(order));
        formData.append('count', JSON.stringify(count));
        $.ajax({
            url:addOrderUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    alert(data.orderInfo);
                    window.location="/Apache/user";
                } else {
                    alert(data.orderInfo);
                }
            }
        });
    });
});

$(function () {
    var getMyAddressUrl = '/Apache/user/getMyAddress';
    var userUUID = {};
    userUUID.userUUID = $.cookie('userUUID');
    var formData = new FormData();
    formData.append('userUUID', JSON.stringify(userUUID));
    $(function () {
        $.ajax({
            url: getMyAddressUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    if(data.myAddressInfo=="[]"){
                        alert("收货地址为空，请添加！");
                        window.location="/Apache/user/addAddress";
                    }else{
                        stu = JSON.parse(data.myAddressInfo);
                        $(document).ready(function () {
                            var s = "";
                            for (var i = 0; i < stu.length; i++) {
                                s = $('<option value=' + stu[i].userAddressId + '>姓名：' + stu[i].userAddressName+"    电话："+stu[i].userAddressPhone +"    地址："+stu[i].userAddressAddress+ '</option>');
                                $("#address").append(s);
                            }
                        });
                    }
                } else {
                    alert(data.myAddressInfo);
                }
            }
        });
    });

});