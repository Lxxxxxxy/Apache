$(document).ready(function(){


    var resurl=$("#header").attr("url");
    console.log(resurl);
    //var css = $("<link rel='stylesheet' href='"+resurl+"css.css"+"'>");
    var header = $("<header>");
    $("#header").after(header);
    header.hide();
    $.ajax({
        url:resurl+"index.html",
        type:"get",
        success:function (data) {

            header.append(data);
            header.ready(function () {
                header.fadeIn(1000);
            })


        }
    });



});

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
            }
        }
    });
});

function logout() {
    if (!confirm("你确定注销吗？")) {
        return;
    }
    $.removeCookie('userUUID', {path: '/'});
    window.location = "/Apache/login";
}