<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <link rel="stylesheet" href="/static/custom/admin/css/management.css">
    <script src="/static/layui/layui.js"></script>
    <meta name="keywords" content="${Application.setting.keywords}"/>
    <meta name="description" content="${Application.setting.description}"/>
    <link rel="icon" href="${Application.setting.head}" />
    <title>${Application.setting.title}</title>
</head>
<body>
<div class="layui-card">
    <div class="layui-card-header">文章管理</div>
    <div class="layui-card-body">
        <table class="layui-hide" id="article-table" lay-filter="category-table-1"></table>
    </div>
</div>
<script type="text/javascript" src="/static/custom/admin/js/management.js"></script>
</body>
</html>