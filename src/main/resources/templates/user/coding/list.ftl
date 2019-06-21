<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>实战课程</title>
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
<div class="container" id="app">
    <div class="row" style="margin-top: 15px">
        <h2 class="col-md-8 col-lg-9 col-xl-10 col-sm-6">实战课程列表</h2>
    </div>
    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>课程名</th>
                <th>课程类别</th>
                <th>老师</th>
                <th>课程类型</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list courses as course>
                <tr>
                    <td>${course_index+1}</td>
                    <td>${course.courseName!}</td>
                    <td>${course.courseCatalog!}</td>
                    <td>${course.teacher.teacherName!}</td>
                    <#if course.courseKind.free>
                        <td>免费</td>
                        <td>
                            <a href="/coding/detail?courseName=${course.courseName!}&courseIntro=${course.courseIntro!}&courseCatalog=${course.courseCatalog!}&coursePic=${course.coursePic!}&courseVideo=${course.courseVideo!}&teacherName=${course.teacher.teacherName!}&teacherIntro=${course.teacher.teacherIntro!}&code=1">查看</a>
                        </td>

                    <#else>
                        <td>收费</td>
                        <td>
                            <a href="/coding/detail?courseName=${course.courseName!}&courseIntro=${course.courseIntro!}&courseCatalog=${course.courseCatalog!}&coursePic=${course.coursePic!}&courseVideo=${course.courseVideo!}&teacherName=${course.teacher.teacherName!}&teacherIntro=${course.teacher.teacherIntro!}&code=0">查看</a>
                        </td>
                    </#if>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>