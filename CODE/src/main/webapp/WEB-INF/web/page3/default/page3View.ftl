<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page3</title>

<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${basePath}javascript/bootstrap/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${basePath}javascript/bootstrap/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${basePath}javascript/jquery-1.9.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${basePath}javascript/bootstrap/bootstrap.min.js"></script>

<link rel="stylesheet" href="../css/common.css">

<script src="../javascript/common.js"></script>

<!--knockout-->
<script src="${basePath}javascript/knockout-3.0.0.js"></script>

<!--jquery.form-->
<script src="${basePath}javascript/jquery.form.js"></script>

<script src="${basePath}javascript/jquery.cookie.js"></script>

<script>
var global_server_domain="${global_server_domain}";
</script>

<script src="${basePath}javascript/model.js"></script>

</head>
<body>
<#include MenuView/>
<div class="container">
	<div class="row">
		<div class="col-xs-12"><#include LocationView/></div>
	</div>
	<div class="row">
		<div class="col-xs-2">
			<#include LeftNavigationView/>
		</div>
		<div class="col-xs-10"><#include MainPassageView/></div>
	</div>
</div>

<#include FooterView/>
</body>
</html>