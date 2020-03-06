<html>
<#include "../common/header.ftl"/>
<#--
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 引入样式文件和动态控制 &ndash;&gt;
<link href="https://cdn.bootcss.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
-->

<body>
<div  style="margin-bottom: 80px" >
    <nav class="navbar  navbar-fixed-top" id="sidebar-wrapper" role="navigation" style="background-color: black;font-weight: bold;font-size: large;">
        <ul class="nav sidebar-nav">

            <li class="dropdown">
                <a  class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true" style="color: aquamarine">
                    <i class="fa fa-fw fa-plus"></i> 教师 <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li class="dropdown-header">操作</li>
                    <li><a href="/seed/teacher/findAll">列表</a></li>
                    <li><a href="/seed/teacher/index2">新增</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</div>

<div id="wrapper" class="toggled">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/seed/teacher/update">
                        <div class="form-group">
                            <label>教师编号</label>
                            <input name="teacherId" type="text" class="form-control" value="${(teacher.teacherId)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>教师名字</label>
                            <input name="teacherName" type="text" class="form-control" value="${(teacher.teacherName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>openid</label>
                            <input name="openId" type="text" class="form-control" value="${(teacher.openId)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>微信昵称</label>
                            <input name="nickname" type="text" class="form-control" value="${(teacher.nickname)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>性别（0-女，1-男）</label>
                            <input name="gender" type="text" class="form-control" value="${(teacher.gender?c)!''}"/>
                        </div>
                       <#-- <div class="form-group">
                            <label>头像</label>
                            <input name="header" type="text" class="form-control" value="${(teacher.header)!''}"/>
                        </div>-->
                        <div class="form-group">
                            <label>状态</label>
                            <input name="status" type="text" class="form-control" value="${(teacher.status?c)!''}"/>
                         </div>
                        <div class="form-group">
                            <label>学院编号</label>
                            <input name="collegeId" type="text" class="form-control" value="${(teacher.collegeId)!''}"/>
                        </div>
                        <#-- <div class="form-group">
                            <label>创建时间</label>
                            <input name="createTime" type="text" class="form-control" value="${(teacher.createTime?string('dd.MM.yyyy HH:mm:ss'))!''}"/>
                        </div>
                       <div class="form-group">
                            <label>修改时间</label>
                            <input name="updateTime" type="text" class="form-control" value="${(teacher.updateTime?string('dd.MM.yyyy HH:mm:ss'))!''}"/>
                        </div>
                        <input hidden type="text" name="teacherId" value="${(teacher.teacherId)!''}">-->
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>