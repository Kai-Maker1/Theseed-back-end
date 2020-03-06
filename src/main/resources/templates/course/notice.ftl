<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="/layui/layui.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
       <script type="text/javascript">
        window.onload = function()
        {
            CKEDITOR.replace( 'description');
        };
    </script>
</head>
<body>
<#--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>动画过程演示</legend>
</fieldset>-->
<div>
<ul class="site-doc-icon site-doc-anim">
   <#-- <li>
        <div class="layui-anim" data-anim="layui-anim-scaleSpring">发布学校通知</div>
        &lt;#&ndash;<div class="code">layui-anim-scaleSpring</div>&ndash;&gt;
    </li >
    <li>
        <div class="layui-anim" data-anim="layui-anim-scaleSpring">发布课程通知</div>
        &lt;#&ndash;<div class="code">layui-anim-scaleSpring</div>&ndash;&gt;
    </li>
    <li>
        <div class="layui-anim" data-anim="layui-anim-scaleSpring">发布教学考评通知</div>
        &lt;#&ndash;<div class="code">layui-anim-scaleSpring</div>&ndash;&gt;
    </li>-->
    <li>
        <div class="layui-anim" data-anim="layui-anim-scaleSpring">发布考试通知</div>
       <#-- <div class="code">layui-anim-scaleSpring</div>-->
    </li>
</ul>
</div>
<script src="/ckeditor/ckeditor.js"></script>
<script></script>
<form method="post" action="">

    <label>编辑通知，图片上传，视频上传 </label>
    <br>
    <br>
    <textarea name="description" id="description"/></textarea>
    <input type="submit" class="btn btn-default"/>
</form>

</body>
</html>