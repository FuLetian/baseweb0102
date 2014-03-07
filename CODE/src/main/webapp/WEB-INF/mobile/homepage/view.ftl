<!DOCTYPE html> 
<!-- <html manifest="${basePath}h/mobile/app.appcache"> -->
<html>
<head> 
　<title>思盖网络科技</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<!-- consumer style -->
<link rel="stylesheet" href="${basePath}h/css/mobile.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<!-- jquery mobile style -->
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" />
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
</head> 
<body>

<!-- homepage -->
<div id="homepage" data-role="page">

	<div>
		<div  style="background-image:url('${basePath}h/images/public-bg3.jpg');width:100%;height:150px;text-align:center;font-size:24px;color:#FFFFFF;">
			<img src="${basePath}h/images/icon-user.jpg" style="height:50%;margin-top:40px;border-radius: 50%;" />
		</div>
		<div style="color:#FFFFFF;background-color:#2D2D2D;height:40px;line-height:40px;text-align:center;font-size:18px;">您的品牌名字</div>
	</div><!-- /header -->
	
	<div> 
	<ul data-role="listview" data-inset="false" data-theme="c">
    <li><a href="${basePath}mobile-user/view?userId=${userId}">
        <img src="${basePath}h/images/i1.png">
        <h2>关于我们</h2>
        <p>Broken Bells</p></a>
    </li>
    <li><a href="${basePath}mobile-homepage/list-view?userId=${userId}&type=0">
        <img src="${basePath}h/images/i2.png">
        <h2>人气商品</h2>
        <p>Hot Chip</p></a>
    </li>
    <li><a href="${basePath}mobile-homepage/list-view?userId=${userId}&type=1">
        <img src="${basePath}h/images/i3.png">
        <h2>最新上架</h2>
        <p>Phoenix</p></a>
    </li>
    <li onclick="toMyOrderView(${userId});"><a href="#">
        <img src="${basePath}h/images/i4.png">
        <h2>我的订单</h2>
        <p>Phoenix</p></a>
    </li>
</ul>
	</div>

	<#include "/mobile/common/footer.ftl"/>	

</div><!-- /homepage -->


</body>
</html>