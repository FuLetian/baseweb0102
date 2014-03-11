<html>
	<head>
		<title>title</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
		<!-- jquery mobile style -->
		<script src="${basePath}h/javascript/jquery.form.js"></script>
		<script src="${basePath}h/javascript/jquery.cookie.js"></script>
		<style type="text/css">
			body{
				background-color:#FFFDFE;
			}
			#title{font-size:24px;font-weight:bold;}
			#tree{position:fixed; bottom:70px;width:100%;left:0;border-top:1px solid #F3F1F2;}
			#gg{position:fixed; bottom:0;left:0; width:100%;height:70px;border-top:1px solid #F3F1F2;}
			
			.a{
				float:left;margin-left:5%;width:40%;height:50px;margin-top:10px;background-color:#B0DA3A;
			}
			.b{
				float:right;margin-right:5%;;;width:40%;height:50px;margin-top:10px;background-color:#EEEEEE;
			}
			.shadow{
				filter:progid:DXImageTransform.Microsoft.Shadow(color=#909090,direction=120,strength=4);
   				-moz-box-shadow: 2px 2px 10px #909090;
   				-webkit-box-shadow: 2px 2px 10px #909090;
   				box-shadow:2px 2px 10px #909090;
			}
		</style>
	</head>
	<body>
		<div id="title">${user.siteName}</div>
		<div id="tree" align="right">
			<img style="float:right;" src="${basePath}h/images/tree.png" />
		</div>
		<div id="gg">
			<div class="a shadow" onclick="toPage('${basePath}mobile-homepage/view?userId=${user.id}');";>
				<div style="font-size:20px;color:#FFFFFF;font-weight:bold;margin:5px 0px 0px 10px;">进入应用</div>
				<div style="font-size:12px;color:#FFFFFF;margin:0px 0px 0px 10px;">以游客身份进入</div>
			</div>
			<div class="b shadow" onclick="toPage('${basePath}mobile-consumer/login-homepage?userId=${user.id}');">
				<div style="font-size:20px;color:#555555;font-weight:bold;margin:5px 0px 0px 10px;">登录/注册</div>
				<div style="font-size:12px;color:#AAAAAA;margin:0px 0px 0px 10px;">享受更多优惠</div>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
var toPage=function(link){
	location.href=link;
}
	var cId=$.cookie('key_session_consumer_id');
	if(cId){
		toPage=function(){}
		window.setTimeout(function(){
			location.href="${basePath}mobile-homepage/view?userId=${user.id}";
		}, 3000);
	}
</script>