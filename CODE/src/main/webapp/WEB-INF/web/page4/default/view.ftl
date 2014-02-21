<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page4</title>

<#include "/common/resources.ftl"/>

<script>
var global_server_domain="${global_server_domain}";
</script>

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