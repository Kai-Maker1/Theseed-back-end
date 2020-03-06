<#--<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 引入样式文件和动态控制 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <!--主要样式控制-->
    <link href="/css/main.css" rel="stylesheet">

    <title></title>

</head>
<body>
<!--顶部导航栏部分-->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" title="logoTitle" href="../seed/welcome">Seed后台管理系统</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li role="presentation">
                    <a href="#">当前用户：<span class="badge">超级管理员</span></a>
                </li>
                <li>
                    <a href="../logout">
                        <span class="glyphicon glyphicon-lock"></span>退出登录</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- 中间主体内容部分 -->
<div class="pageContainer ">
    <!-- 左侧导航栏 -->
    <div class="pageSidebar">
        <ul class="nav nav-stacked nav-pills">

            <li role="presentation">
                <a href="../seed/welcome" target="mainFrame" >首页</a>
            </li>

            <li role="presentation">
                <a href="../seed/student/findAll" target="mainFrame">学生信息管理</a>
            </li>
            <li role="presentation">
                <a href="../seed/teacher/findAll" target="mainFrame">教师信息管理</a>
            </li>
            <li role="presentation">
                <a href="../seed/student/major" target="mainFrame">班级管理</a>
            </li>
            <li role="presentation">
                <a href="../seed/student/major" target="mainFrame" >专业管理</a>
            </li>

            <li role="presentation">
                <a href="../seed/student/major" target="mainFrame" >课程管理</a>
            </li>
            <!-- 开始 -->
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle"  href="nav4.html" target="mainFrame">
                    教学管理<span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="../seed/course/upload2" target="mainFrame">课程资源管理</a>
                    </li>
                    <li>
                        <a href="nav2.html" target="mainFrame">课表管理</a>
                    </li>
                    <li>
                        <a href="nav3.html" target="mainFrame">成绩管理</a>
                    </li>
                    <li>
                        <a href="nav3.html" target="mainFrame">考勤管理</a>
                    </li>
                    <li>
                        <a href="nav3.html" target="mainFrame">考试管理</a>
                    </li>
                    <li>
                        <a href="nav3.html" target="mainFrame">教学考评管理</a>
                    </li>
                    <li>
                        <a href="nav3.html" target="mainFrame">智能推荐课程</a>
                    </li>
                </ul>
            </li>
            <!-- 结束 -->
            <li role="presentation">
                <a href="../seed/course/" target="mainFrame" >通知管理</a>
            </li>
            <li role="presentation">
                <a href="../seed/course/" target="mainFrame" >社区讨论</a>
            </li>
            <!-- 开始 -->
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle"  href="nav4.html" target="mainFrame">
                    个人设置<span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="nav1.html" target="mainFrame">修改密码</a>
                    </li>
                    <li>
                        <a href="nav2.html" target="mainFrame">退出系统</a>
                    </li>
                    <li>
                        <a href="nav3.html" target="mainFrame">查看个人信息</a>
                    </li>
                </ul>
            </li>
            <!-- 结束 -->
            <li role="presentation">
                <a href="nav5.html" target="mainFrame">权限设置</a>
            </li>



        </ul>
    </div>

    <!-- 左侧导航和正文内容的分隔线 -->
    <div class="splitter"></div>
    <!-- 正文内容部分 -->
    <div class="pageContent">
        <iframe src="../seed/welcome" id="mainFrame" name="mainFrame"
                frameborder="0" width="100%"  height="100%" frameBorder="0">
        </iframe>
    </div>

</div>
<!-- 底部页脚部分 -->
<div class="footer">
    <p class="text-center">

    </p>
</div>

<script type="text/javascript">
    $(".nav li").click(function() {
        $(".active").removeClass('active');
        $(this).addClass("active");
    });


</script>

</body>
</html>
