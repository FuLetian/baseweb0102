<!DOCTYPE html> 
<html> 
<head> 
　<title>Page Title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.1/jquery.mobile-1.4.1.min.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.1/jquery.mobile-1.4.1.min.js"></script>
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
		<h1>HOME PAGE</h1>
	</div><!-- /header -->
	
	<div data-role="content"> 
		<p><a href="#channelListPage">channels</a></p> 
	</div><!-- /content -->
	
	<div data-role="footer">
		<div data-role="navbar">
		    <ul>
		        <li><a href="#">主页</a></li>
		        <li><a href="#" data-bind="click:navToMenus">menus</a></li>
		        <li><a href="#">Three</a></li>
		    </ul>
		</div><!-- /navbar -->
	</div><!-- /footer -->
	
</div><!-- /homepage -->

<!-- channels -->
<div id="channelListPage" data-role="page">

	<div data-role="header">
		<h1>menus</h1>
	</div><!-- /header -->
	
	<div data-role="content"> 
		
		<ul data-role="listview" data-inset="true" data-shadow="false" data-bind="foreach:menus">

			<li><a href="#" data-bind="text:$root"></a></li>

		</ul>

	</div><!-- /content -->
	
	<div data-role="footer">
		<div data-role="navbar">
		    <ul>
		        <li><a href="#homepage">主页</a></li>
		        <li><a href="#" class="ui-btn-active">menus</a></li>
		        <li><a href="#">Three</a></li>
		    </ul>
		</div><!-- /navbar -->
	</div><!-- /footer -->
	
</div><!-- /channel -->

</body>
</html>