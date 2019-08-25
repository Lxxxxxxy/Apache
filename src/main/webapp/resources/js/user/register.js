$(function () {
    var registerUrl = '/Apache/user/register';
    $('#submit').click(function () {
        var userInfo = {};
        var userCheck = {};
        userInfo.userName = $('#userInfoName').val().trim();
        userInfo.username = $('#username').val().trim();
        userInfo.password = $('#password').val();
        userInfo.userEmail = $('#userEmail').val();
        userInfo.userPhone = $('#userPhone').val();
        userCheck.userUsername = $('#username').val();
        userCheck.userPassword = $('#password').val();
        if (userInfo.userName == "") {
            alert("昵称不能为空！");
            return;
        }
        if (userInfo.username == "") {
            alert("用户名不能为空！");
            return;
        }
        if (userInfo.password == "") {
            alert("密码不能为空！");
            return;
        }
        if (userInfo.password.length<6) {
            alert("密码长度大于6位！");
            return;
        }
        if (userInfo.userEmail == "") {
            alert("邮箱不能为空！");
            return;
        }
        if (userInfo.userPhone == "") {
            alert("联系电话不能为空！");
            return;
        }
        if (userInfo.userUsername == "") {
            alert("用户名不能为空！");
            return;
        }
        if (userInfo.userPassword == "") {
            alert("密码不能为空！");
            return;
        }
        if (/^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/.test($("#userEmail").val().trim()) == false) {
            alert("请检查邮箱");
            return;
        }
        var formData = new FormData();
        formData.append('userInfo', JSON.stringify(userInfo));
        formData.append('userCheck', JSON.stringify(userCheck));
        var thumbnail = $('#headImg')[0].files[0];
        if (thumbnail==null) {
            alert("头像不能为空！");
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
                    alert(data.info);
                    window.location.href = '/Apache/login';
                } else {
                    alert(data.info);
                }
            }
        });
    });
});
$(function () {
    var loginUrl = '/Apache/user/login';
    $('#login').click(function () {
        var userCheck = {};
        userCheck.userUsername = $('#username').val();
        userCheck.userPassword = $('#password').val();
        var formData = new FormData();
        formData.append('userCheck', JSON.stringify(userCheck));
        $.ajax({
            url: loginUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    window.location.href = '/Apache/';
                } else {
                    alert(data.loginInfo);
                    window.location.href = '/Apache/login';
                }
            }
        });
    });
});


$(function () {
    var registerUrl = '/Apache/user/login';
    $('#form').keyup(function () {

        if (event.keyCode == 13) {
            var userCheck = {};
            userCheck.userUsername = $('#username').val();
            userCheck.userPassword = $('#password').val();
            var formData = new FormData();
            formData.append('userCheck', JSON.stringify(userCheck));
            $.ajax({
                url: registerUrl,
                type: 'POST',
                data: formData,
                contentType: false,
                processData: false,
                cache: false,
                success: function (data) {
                    if (data.success) {
                        window.location.href = '/Apache/';
                    } else {
                        alert(data.loginInfo);
                    }
                }
            });
        }
        ;
    });
});


$(function () {
    var userUUID = {};
    userUUID.userUUID = $.cookie('userUUID');
    if (userUUID.userUUID != null) {
        window.location = "/Apache/user";
    }
});