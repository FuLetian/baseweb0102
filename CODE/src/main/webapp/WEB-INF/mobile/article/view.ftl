<!DOCTYPE html> 
<html> 
<head> 
　<title>Article</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${basePath}h/javascript/jquerymobile/jquery.mobile-1.4.1.min.css" />
<script src="${basePath}h/javascript/jquery-1.9.1.min.js"></script>
<script src="${basePath}h/javascript/jquerymobile/jquery.mobile-1.4.1.min.js"></script>
<!--knockout-->
<script src="${basePath}h/javascript/knockout-3.0.0.js"></script>
<script type="text/javascript">
	var basePath="${basePath}";
</script>
<script src="${basePath}h/javascript/mobile.js"></script>
</head> 
<body>

<!-- homepage -->
<div id="homepage" data-role="page">

	<div data-role="header">
		<a data-rel="back" data-icon="back">back</a>
		<h1>商品列表</h1>
	</div><!-- /header -->
	
	<div data-role="content"> 
	<ul data-role="listview" data-inset="true">
		<#list articles as item>
            <li><a href="${basePath}mobile-article/details?userId=${userId}&articleId=${item.id}">
                <img src="${basePath}h/images/apple.png" class="ui-li-thumb">
                <h2>${item.name}</h2>
                <p>Apple released iOS 6.1</p>
                <p class="ui-li-aside">iOS</p>
            </a></li>
        </#list>
   </ul>
	</div><!-- /content -->
	
	<div data-role="footer" data-position="fixed">
		<div data-role="navbar">
		    <ul>
		        <li><a href="#" data-icon="home">home</a></li>
		        <li><a href="${basePath}mobile-menu/view?userId=${userId}" data-icon="bullets">menus</a></li>
		        <li><a href="#" data-icon="gear">settings</a></li>
		    </ul>
		</div><!-- /navbar -->
	</div><!-- /footer -->
	
</div><!-- /homepage -->
</body>
</html>