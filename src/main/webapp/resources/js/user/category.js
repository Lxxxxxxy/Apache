$(function () {
    var applyUrl = '/Apache/user/getBigCategory';
    var userUUID = {};
    userUUID.userUUID = $.cookie('userUUID');
    if (userUUID.userUUID == null) {
        alert("登录失败，请重新登录！");
        window.location = "/Apache/login";
    }
    $.ajax({
        url: applyUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                stu = JSON.parse(data.bigCategoryInfo);
                $(document).ready(function () {
                    var s = "";
                    for (var i = 0; i < stu.length; i++) {
                        s = $('<option value=' + stu[i].productBigCategoryId + '>' + stu[i].productBigCategoryName + '</option>');
                        $("#productBigCategoryId").append(s);
                    }
                });
            } else {
                alert(data.bigCategoryInfo);
            }
        }
    });
});

$(function () {
    var addUrl = '/Apache/user/addCategory';
    var userUUID = {};
    userUUID.userUUID = $.cookie('userUUID');
    if (userUUID.userUUID == null) {
        alert("登录失败，请重新登录！");
        window.location = "/Apache/login";
    }
    $('#form').keyup(function () {

            if (event.keyCode == 13) {
                var category = {};
                category.productCategoryName = $('#productCategoryName').val();
                category.productBigCategoryId = $('#productBigCategoryId').val();
                if(category.productCategoryName==""){
                    alert("商品分类名不能为空！");
                    return;
                }
                if(category.productBigCategoryId==""){
                    alert("商品上级分类名不能为空！");
                    return;
                }
                var formData = new FormData();
                formData.append('category', JSON.stringify(category));
                $.ajax({
                    url: addUrl,
                    type: 'POST',
                    data: formData,
                    contentType: false,
                    processData: false,
                    cache: false,
                    success: function (data) {
                        if (data.success) {
                            alert(data.addInfo);
                            window.location.href = '/Apache/user/addProductCategory';
                        } else {
                            alert(data.addInfo);
                        }
                    }
                });
            }
        }
    );
});