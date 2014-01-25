<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page3</title>

<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="../css/common.css">

<script src="../javascript/common.js"></script>

<!--knockout-->
<script src="${basePath}javascript/knockout-3.0.0.js"></script>

<!--jquery.form-->
<script src="${basePath}javascript/jquery.form.js"></script>

<script src="${basePath}javascript/jquery.cookie.js"></script>

<script src="${basePath}javascript/model.js"></script>

</head>
<body>
	<#include MenuView/>
	<#include ArticleDetailInPage4View />
	<#include ArticlePropertiesInPage4View/>
	<#include ArticleImgListInPage4View/>
	<#include ArticleCommentListInPage4View/>
	<#include FooterView/>
</body>
</html>