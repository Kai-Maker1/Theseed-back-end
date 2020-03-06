<html>
<#include "../common/header.ftl"/>

<body>
<div  style="margin-bottom: 80px" >
    <nav class="navbar  navbar-fixed-top" id="sidebar-wrapper" role="navigation" style="background-color: black;font-weight: bold;font-size: large;">
        <ul class="nav sidebar-nav">

            <li class="dropdown">
                <a  class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true" style="color: aquamarine">
                    <i class="fa fa-fw fa-plus"></i> 学生 <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li class="dropdown-header">操作</li>
                    <li><a href="/seed/student/findAll">列表</a></li>
                    <li><a href="/seed/student/index2">新增</a></li>
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
                    <form role="form" method="post" action="/seed/student/update">
                        <div class="form-group">
                            <label>学编号</label>
                            <input name="stuId" type="text" class="form-control" value="${(student.stuId)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>学生名字</label>
                            <input name="stuName" type="text" class="form-control" value="${(student.stuName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>openid</label>
                            <input name="openId" type="text" class="form-control" value="${(student.openId)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>微信昵称</label>
                            <input name="nickname" type="text" class="form-control" value="${(student.nickname)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>性别（0-女，1-男）</label>
                            <input name="gender" type="text" class="form-control" value="${(student.gender?c)!''}"/>
                        </div>
                       <#-- <div class="form-group">
                            <label>头像</label>
                            <input name="header" type="text" class="form-control" value="${(student.header)!''}"/>
                        </div>-->
                        <div class="form-group">
                            <label>身份认证状态（0-已认证，1-未认证）</label>
                            <input name="status" type="text" class="form-control" value="${(student.status?c)!''}"/>
                         </div>
                        <div class="form-group">
                            <label>专业编号</label>
                            <input name="majorId" type="text" class="form-control" value="${(student.majorId)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>年级编号</label>
                            <input name="classId" type="text" class="form-control" value="${(student.classId)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>学院编号</label>
                            <input name="collegeId" type="text" class="form-control" value="${(student.collegeId)!''}"/>
                        </div>
                        <#-- <div class="form-group">
                            <label>创建时间</label>
                            <input name="createTime" type="text" class="form-control" value="${(student.createTime?string('dd.MM.yyyy HH:mm:ss'))!''}"/>
                        </div>
                       <div class="form-group">
                            <label>修改时间</label>
                            <input name="updateTime" type="text" class="form-control" value="${(student.updateTime?string('dd.MM.yyyy HH:mm:ss'))!''}"/>
                        </div>
                        <input hidden type="text" name="stuId" value="${(student.stuId)!''}">-->
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>