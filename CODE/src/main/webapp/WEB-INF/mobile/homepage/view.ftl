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
	$.mobile.defaultPageTransition="flip";
</script>
<script src="${basePath}h/javascript/jquery.lazyload.js"></script>
<!--jquery.form-->
<script src="${basePath}h/javascript/jquery.form.js"></script>
<script src="${basePath}h/javascript/jquery.cookie.js"></script>
<script src="${basePath}h/javascript/mobile.js"></script>
</head> 
<body>

<!-- homepage -->
<div id="homepage" data-role="page">
<script type="text/javascript">
$(function(){
	$("img.lazy").lazyload();
});

function toMyOrderView(userId){
	var cId=getLoginConsumerId();
	if(cId==0){
		changePage(basePath+"mobile-consumer/login-page?userId="+userId+"&targetUrl=${basePath}mobile-order/view?userId="+userId);
	}else{
		changePage(basePath+"mobile-order/view?userId="+userId);
	}
	
}
</script>

	<div>
		<div  style="background-image:url('${basePath}h/images/blue-bg-2.jpg');width:100%;height:70px;line-height:70px;text-align:center;font-size:24px;color:#FFFFFF;">聚美优品</div>
	</div><!-- /header -->
	
	<div> 
	<ul data-role="listview" data-inset="false">
    <li><a href="${basePath}mobile-user/view?userId=${userId}">
        <img src="${basePath}h/images/icon1.png">
        <h2>关于我们</h2>
        <p>Broken Bells</p></a>
    </li>
    <li><a href="${basePath}mobile-homepage/list-view?userId=${userId}&type=0">
        <img src="${basePath}h/images/icon1.png">
        <h2>人气商品</h2>
        <p>Hot Chip</p></a>
    </li>
    <li><a href="${basePath}mobile-homepage/list-view?userId=${userId}&type=1">
        <img src="${basePath}h/images/icon1.png">
        <h2>最新上架</h2>
        <p>Phoenix</p></a>
    </li>
    <li onclick="toMyOrderView(${userId});"><a href="#">
        <img src="${basePath}h/images/icon1.png">
        <h2>我的订单</h2>
        <p>Phoenix</p></a>
    </li>
</ul>
</div>
	
	
	<#include "/mobile/common/footer.ftl"/>	
</div><!-- /homepage -->
</body>
</html>