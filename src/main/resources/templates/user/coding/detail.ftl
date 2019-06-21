<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${course.courseName}课程详情</title>
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
            <li class="nav-item">
                <a class="nav-link" href="/video">视频课程</a>
            </li>
            <li class="nav-item active">
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
<div class="container">
    <div class="row" style="margin-top: 30px">
        <div class="col-4" style="text-align: center">
            <div style="margin-top: 15px">
                <img src="${course.coursePic}" class="rounded"
                     alt="Cinque Terre" width="304" height="236">
            </div>

        </div>
        <div class="col-8">
            <div class="row">
                <div class="col-12"><h2>${course.courseName}</h2>
                    <span class="badge badge-pill badge-primary">${course.courseCatalog}</span>
                    <#if course.code == 0>
                        <span class="badge badge-pill badge-danger">收费课程</span>
                    <#elseif course.code == 1>
                        <span class="badge badge-pill badge-success">免费课程</span>
                    <#elseif course.code == 2>
                        <span class="badge badge-pill badge-info">限时免费课程</span>
                    </#if>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-12"><h5>${course.teacherName}：</h5><i>${course.teacherIntro}</i></div>
            </div>
            <br>
            <div class="row">
                <div class="col-12">课程简介：${course.courseIntro}</div>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 50px">
        <div class="col-12" style="text-align: center">
            <#if course.code = 0>
                <#if user.vip>
                    <a href="/coding/learn?courseName=${course.courseName!}&courseCatalog=${course.courseCatalog!}&courseVideo=${course.courseVideo!}&code=${course.code}" class="btn btn-success">您已是会员，现在可以开始学习实战课程</a>
                <#else >
                    <a href="/recharge" class="btn btn-danger">收费课程需要开通会员，点击前往充值页面</a>
                </#if>
            <#elseif course.code = 1>
                <a href="/coding/learn?courseName=${course.courseName!}&courseCatalog=${course.courseCatalog!}&courseVideo=${course.courseVideo!}&code=${course.code}"
                   class="btn btn-success">开始学习实战课程</a>
            <#elseif course.code=2>
                <a href="/coding/learn?courseName=${course.courseName!}&courseCatalog=${course.courseCatalog!}&courseVideo=${course.courseVideo!}&code=${course.code}" class="btn btn-success">限时免费课程，快去学习吧</a>
            </#if>
        </div>
    </div>
</div>
</body>
</html>