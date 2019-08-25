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
                    var stu = JSON.parse(data.myAddressInfo);
                    $(document).ready(function () {
                        var s = "";
                        for (var i = 0; i < stu.length; i++) {
                            s = "\n" +
                                "                        <tr>\n" +
                                "                            <td>" + stu[i].userAddressName + "</td>\n" +
                                "                            <td>" + stu[i].userAddressPhone + "</td>\n" +
                                "                            <td>" + stu[i].userAddressAddress + "</td>\n" +
                                "                            <td><button class=\"btn bg-success\"><a href=/Apache/user/editMyAddress?myAddressId=" + stu[i].userAddressId + "&userId=" + stu[i].userAddressUserId + ">编辑</a></button>" +
                                " &nbsp;<button class=\"btn bg-success\"><a onclick=delete1('myAddressId=" + stu[i].userAddressId + "&userId=" + stu[i].userAddressUserId + "')>删除</a></button>" +
                                " &nbsp;<button class=\"btn bg-success\"><a onclick=default1('myAddressId=" + stu[i].userAddressId + "&userId=" + stu[i].userAddressUserId + "')>设为默认地址</a></button></td></tr>";
                            $(".address").append(s);
                        }
                    });
                } else {
                    alert(data.myAddressInfo);
                }
            }
        });
    });

});

$(function () {
    var currentUrl = window.location.href.toString();
    var reg = RegExp(/editMyAddress/);
    if (!reg.test(currentUrl)) {
        return;
    }
    $('#userAddressName').attr("value", userAddressJson.userAddressName);
    $('#userAddressPhone').attr("value", userAddressJson.userAddressPhone);
    $('#userAddressAddress').attr("value", userAddressJson.userAddressAddress);
});

$(function () {
    $('#edit').click(function () {
        var currentUrl = document.location.toString();
        var Url = currentUrl.split("?");

        var para = Url[1];
        var editUrl = '/Apache/user/editAddress?' + para;
        var userAddress = {};
        userAddress.userAddressName = $('#userAddressName').val();
        userAddress.userAddressPhone = $('#userAddressPhone').val();
        userAddress.userAddressAddress = $('#userAddressAddress').val();
        if(userAddress.userAddressName==""){
            alert("收件人姓名不能为空！");
            return;
        }
        if(userAddress.userAddressPhone==""){
            alert("收件人电话不能为空！");
            return;
        }
        if(userAddress.userAddressAddress==""){
            alert("收件人地址不能为空！");
            return;
        }
        userAddress.userUUID = $.cookie('userUUID');
        var formData = new FormData();
        formData.append('userAddress', JSON.stringify(userAddress));
        $.ajax({
            url: editUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    alert(data.editInfo);
                    window.location.href = '/Apache/user';
                } else {
                    alert(data.editInfo);
                }
            }
        });
    });
});

$(function () {
    $('#add').click(function () {
        var addUrl = '/Apache/user/addMyAddress';
        var userAddress = {};
        userAddress.userAddressName = $('#userAddressName').val();
        userAddress.userAddressPhone = $('#userAddressPhone').val();
        userAddress.userAddressAddress = $('#userAddressAddress').val();
        if(userAddress.userAddressName==""){
            alert("收件人姓名不能为空！");
            return;
        }
        if(userAddress.userAddressPhone==""){
            alert("收件人电话不能为空！");
            return;
        }
        if(userAddress.userAddressAddress==""){
            alert("收件人地址不能为空！");
            return;
        }
        userAddress.userUUID = $.cookie('userUUID');
        var formData = new FormData();
        formData.append('userAddress', JSON.stringify(userAddress));
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
                    window.history.go(-1);
                } else {
                    alert(data.addInfo);
                }
            }
        });
    });
});


function delete1(para) {
    if (!confirm("你确定提交吗？")) {
        return;
    }
    var applyUrl = '/Apache/user/deleteMyAddress?' + para;
    $.ajax({
        url: applyUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                alert(data.deleteInfo);
                window.location.href = '/Apache/user';
            } else {
                alert(data.deleteInfo);
            }
        }
    });
};

function default1(para) {
    if (!confirm("你确定提交吗？")) {
        return;
    }
    var applyUrl = '/Apache/user/defaultMyAddress?' + para;
    $.ajax({
        url: applyUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                alert(data.defaultInfo);
                window.location.href = '/Apache/user';
            } else {
                alert(data.defaultInfo);
            }
        }
    });
};