<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

<#include "/common/resources.ftl"/>

</head>
<script>
var global_server_domain="${global_server_domain}";
</script>

<script src="${basePath}javascript/model.js"></script>

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