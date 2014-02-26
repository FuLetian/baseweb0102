<!DOCTYPE html> 
<html> 
<head> 
　<title>Page Title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${basePath}h/css/mobile.css" />
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<script src="${basePath}h/javascript/knockout-3.0.0.js"></script>
<script type="text/javascript">
	var basePath="${basePath}";
</script>
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