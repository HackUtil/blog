<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/custom/css/404.css">
    <script src="/static/jquery/jquery.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/layer/layer.js"></script>
    <meta name="keywords" content="${Application.setting.keywords}"/>
    <meta name="description" content="${Application.setting.description}"/>
    <link rel="icon" href="${Application.setting.head}" />
    <title>${Application.setting.title}</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="left">
                <img src="${Application.setting.head}" class="rounded-circle"/>
                <div class="nickname">${Application.setting.nickname?html}</div>
                <hr/>
                <div class="signature">${Application.setting.signature?html}</div>
                <div class="menu">
                    <a class="item select btn" href="/">
                        首页
                    </a>
                    <a class="item btn" href="/category">
                        分类
                    </a>
                    <a class="item btn" href="http://wpa.qq.com/msgrd?v=3&uin=363408268&site=qq&menu=yes">
                        与我聊聊
                    </a>
                </div>
            </div>
        </div>
        <div class="col-md-9">
            <div class="middle">
                <div class="header">
                    500
                </div>
                <div class="body">
                    <img src="/static/custom/image/500.jpeg" class="img-fluid"/>
                </div>
            </div>
            <div class="padding">
            </div>
        </div>
    </div>
</div>
<footer>${Application.setting.copyright}</footer>
</body>
</html>