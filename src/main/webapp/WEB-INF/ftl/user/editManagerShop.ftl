<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改店铺</title>
    <link rel="shortcut icon " type="images/x-icon" href="/Apache/resources/images/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/Apache/resources/css/bootstrap/bootstrap.min.css">
    <script src="/Apache/resources/js/bootstrap/jquery-3.3.1.min.js"></script>
    <script src="/Apache/resources/js/bootstrap/bootstrap.js"></script>
    <link rel="stylesheet" href="/Apache/resources/css/product.css">
</head>
<body>

<script src="/Apache/resources/header/header.js" url="/Apache/resources/header/" id="header"></script>
<div class="container">

    <form>
        <div class="form-group">
            <label>店铺名</label>
            <input type="text" class="form-control" id="shopName" name="shopName">
        </div>
        <div class="form-group">
            <label>店铺分类</label>
            <input type="text" class="form-control" id="shopCategory" name="shopCategory">
        </div>
        <div class="form-group">
            <label>店铺地址</label>
            <input type="text" class="form-control" id="shopAddress" name="shopAddress">
        </div>
        <div class="form-group">
            <label>联系方式</label>
            <input type="text" oninput="value=value.replace(/[^\d]/g,'')" class="form-control" id="shopPhone" name="shopPhone">
        </div>
        <div class="form-group">
            <label>店铺图片</label>
            <input type="file" id="shopImage" name="shopImage">
        </div>
        <div class="form-group">
            <label>店铺简介</label>
            <textarea name="describe" style="width: 100%" rows="10" id="shopDesc" name="shopDesc"></textarea>
        </div>

        <div class="form-group text-center">
            <button type="reset" class="btn btn-default btn-danger">重置</button>
            <button class="btn btn-default btn-primary" id="edit">修改</button>
        </div>
    </form>


</div>
<script src="/Apache/resources/footer/footer.js" id="footer" url="/Apache/resources/footer/"></script>

<script src="/Apache/resources/js/common/jquery-1.11.2.min.js"></script>
<script src="/Apache/resources/js/common/jquery.cookie.js"></script>
<script src="/Apache/resources/js/user/shop.js"></script>
<script>
    var shopInfo = JSON.parse('${shopInfo}');
</script>
</body>
</html>