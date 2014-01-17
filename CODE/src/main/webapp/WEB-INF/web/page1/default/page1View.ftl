<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

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

</head>
<body>
<#include MenuView />
<#include ChannelView />
<div class="container">
<div class="row">
	<!-- article column -->
		<#include ArticleInPage1View />
	<!-- //article column -->
	
	<!-- right column -->
	<div class="col-xs-4">
		<div class="subject-text2"></div>
		<div class="panel">
			<#include ServiceAndPromise/>
			<#include CommentInPage1View />
			<#include BrandInPage1View />
		</div>
	</div>
	<!-- //right column -->
</div>
</div>

<!-- footer -->
	<#include FooterView />
<!-- //footer -->
</body></html>