<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <script src="/static/js/jquery.js"></script>
    <script src="/static/js/bootstrap.js"></script>
</head>
<body>
<nav class="navbar bg-dark navbar-expand-md navbar-dark">
    <a class="navbar-brand" href="/admin">在线课程学习平台管理后台</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/admin">用户管理</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    账户
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">${admin.username}</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/admin/signOut">退出登录</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<div class="container" id="app">
    <div class="row" style="margin-top: 15px">
        <h2 class="col-md-8 col-lg-9 col-xl-10 col-sm-6">用户列表</h2>
    </div>
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
    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>用户名</th>
                <th>是否会员</th>
                <th>会员到期时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <td>${user_index+1}</td>
                    <td>${user.username!}</td>
                    <#if user.vip>
                        <td>会员用户</td>
                    <#else>
                        <td>非会员用户</td>
                    </#if>
                    <td>${user.vipExpireTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                    <td>
                        <a href="/admin/do_buy?user_id=${user.userId!}&t=1" class="btn btn-primary btn-sm">会员充值一个月</a>
                        <a href="/admin/do_buy?user_id=${user.userId!}&t=3" class="btn btn-success btn-sm">会员充值三个月</a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>