<!DOCTYPE html>
<html>
<head>
    <title>登陆页面</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6" style="padding-top: 15px">
            <#if info?exists>
                <#if info.type="success">
                    <div class="alert alert-success alert-dismissable">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>提示!</strong> ${info.message}
                    </div>
                <#elseif info.type="error">
                    <div class="alert alert-danger alert-dismissable">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>错误!</strong> ${info.message}
                    </div>
                </#if>
            </#if>
            <h2 style="margin-top: 35px;margin-bottom: 20px">管理员登陆</h2>
            <form action="/admin/sign_in" method="post">
                <div class="form-group">
                    <label for="email">用户名:</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" required>
                </div>
                <div class="form-group">
                    <label for="password">密码:</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"
                           required>
                </div>
                <button type="submit" class="btn btn-lg btn-primary">登录</button>
            </form>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</body>
<script src="/static/js/jquery.js"></script>
<script src="/static/js/bootstrap.js"></script>
</html>