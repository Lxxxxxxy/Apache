$(function () {
    var currentUrl = document.location.toString();
    var Url = currentUrl.split("?");

    var para = Url[1];
    var activeUrl = '/Apache/user/activation?'+para;
    $.ajax({
        url: activeUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                alert(data.activeInfo);
                window.location.href = '/Apache/login';
            } else {
                alert(data.activeInfo);
            }
        }
    });
});