<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>视频学习页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <script src="/static/js/jquery.js"></script>
    <script src="/static/js/bootstrap.js"></script>
</head>
<body>
<nav class="navbar bg-dark navbar-expand-md navbar-dark">
    <a class="navbar-brand" href="/">在线课程学习平台</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">主页</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/video">视频课程</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/coding">实战课程</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    账户
                </a>
                <div class="dropdown-menu">
                    <#if user.vip>
                        <a class="dropdown-item" href="#">${user.username} (会员用户)</a>
                        <a class="dropdown-item" href="#">会员到期时间：${user.vipExpireTime}</a>
                    <#else >
                        <a class="dropdown-item" href="#">${user.username} (非会员用户)</a>
                    </#if>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/recharge">会员充值</a>
                    <a class="dropdown-item" href="/sign_out">退出</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<nav class="breadcrumb">
    <a class="breadcrumb-item" href="/video">视频课程</a>
    <a class="breadcrumb-item" href="#">${course.courseCatalog}</a>
    <a class="breadcrumb-item active" href="#">${course.courseName}</a>
</nav>
<div class="container">
    <div class="row">
        <div class="col-12">
            <video src="${course.courseVideo}" controls autoplay></video>
        </div>
    </div>
</div>
<h1></h1>
</body>
</html>