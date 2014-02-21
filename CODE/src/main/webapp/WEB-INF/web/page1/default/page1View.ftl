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

<!-- <script type="text/javascript" charset="UTF-8" src="http://chat.kefu360.com/code/13553"></script> -->
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
			<#include ServiceAndPromise/>
			<#include CommentInPage1View />
			<#include BrandInPage1View />
	</div>
	<!-- //right column -->
</div>
</div>

<!-- footer -->
	<#include FooterView />
<!-- //footer -->
</body></html>