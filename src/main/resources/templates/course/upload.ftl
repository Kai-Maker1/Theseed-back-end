<html>
<head>
    <meta charset="utf-8">
    <title>welcome</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="/ckeditor/ckeditor.js"></script>

    <script type="text/javascript">
        window.onload = function()
        {
            CKEDITOR.replace( 'description');
        };
    </script>
</head>
<body>

<form method="post" action="">

    <label>编辑通知，图片上传，视频上传 </label>
    <br>
    <br>
    <textarea name="description" id="description"/></textarea>
    <input type="submit" class="btn btn-default"/>
</form>

</body>
</html>