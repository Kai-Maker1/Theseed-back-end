<html>
<#include "../common/header.ftl"/>

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
                    <table class="table table-striped"><#--"table table-bordered table-condensed "-->
                        <thead>
                        <tr>
                            <th class="align-content-lg-center">教师编号</th>
                            <th>教师名字</th>
                            <th>openid</th>
                            <th>微信昵称</th>
                            <th>性别</th>
                            <#--<th>头像</th>-->
                            <th>状态</th>
                            <th>学院编号</th>
                            <#--<th>创建时间</th>
                            <th>修改时间</th>-->
                            <th>操作</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list teachers as teacher>
                            <tr>
                                <td>${teacher.teacherId}</td>
                                <td>${teacher.teacherName}</td>
                                <td>${teacher.openId}</td>
                                <td>${teacher.nickname}</td>
                                <td>${teacher.gender?string('男','女')}</td>
                                <#--<td>${teacher.header}</td>-->
                                <td>${teacher.status?string('审核通过','审核未通过')}</td>
                                <td>${teacher.collegeId}</td>
                                <#--<td>${teacher.createTime?string('dd.MM.yyyy HH:mm:ss')}</td>
                                <td>${teacher.updateTime?string('dd.MM.yyyy HH:mm:ss')}</td>-->
                                <td><a href="/seed/teacher/index?teacherId=${teacher.teacherId}">修改</a></td>
                                <td><a href="/seed/teacher/delete?teacherId=${teacher.teacherId}">删除</a></td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>