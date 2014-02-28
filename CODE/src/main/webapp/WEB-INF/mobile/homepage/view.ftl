<!DOCTYPE html> 
<html> 
<head> 
　<title>Page Title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<!-- consumer style -->
<link rel="stylesheet" href="${basePath}h/css/mobile.css" />
<!-- jquery mobile style -->
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<script type="text/javascript">
	var basePath="${basePath}";
</script>
<!--jquery.form-->
<script src="${basePath}h/javascript/jquery.form.js"></script>
<script src="${basePath}h/javascript/jquery.cookie.js"></script>
<script src="${basePath}h/javascript/mobile.js"></script>

</head> 
<body>

<!-- homepage -->
<div id="homepage" data-role="page">

	<div data-role="header" data-theme="b">
		<h1>HOME PAGE</h1>
	</div><!-- /header -->
	
	<div data-role="content"> 
		<p><a href="#channelListPage">channels</a></p> 
	</div><!-- /content -->
	
	<#include "/mobile/common/footer.ftl"/>	
</div><!-- /homepage -->
</body>
</html>