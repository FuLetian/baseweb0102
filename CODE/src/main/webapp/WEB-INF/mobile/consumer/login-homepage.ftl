<html>
	<head>
		<title>title</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
		<!-- jquery mobile style -->
		<script src="${basePath}h/javascript/jquery.form.js"></script>
		<script src="${basePath}h/javascript/jquery.cookie.js"></script>
		
		<style type="text/css">
			body{
				background-color:#0063C6;
			}
			.btn{
				color:#FFFFFF;
				font-weight:bold;
				font-size:16px;
				text-align:center;
				background-color:#2787EA;
				height:40px;
				line-height:40px;
				margin-top:10px;
				
			}
			#content{
				height:150px;
				width:80%;
				padding:10px 10px 10px 10px;
				
				position:fixed;
				top:101px;
				left:10%;
			}
			
			#signup{
				background-color:#C8781C;
				height:40px;
				line-height:40px;
				color:#FFFFFF;
				text-align:center;
				font-size:20px;
				font-weight:bold;
				float:right;
				width:100px;
				margin-right:30px;
			}
			#footer{
				position:fixed;
				bottom:20px;
				left:0%;
				width:100%;
				height:40px;
			}
			.shadow{
				filter:progid:DXImageTransform.Microsoft.Shadow(color=#909090,direction=120,strength=4);
   				-moz-box-shadow: 2px 2px 10px #909090;
   				-webkit-box-shadow: 2px 2px 10px #909090;
   				box-shadow:2px 2px 10px #909090;
			}
		</style>
		<script type="text/javascript">
			function hideFooter(){
				$("#footer").hide();
			}
			function showFooter(){
				$("#footer").show();
			};
		
			function login(){
				$("#loginForm").ajaxSubmit({
					dataType:"json",
					success:function(data){
						if(data.result){
							$.cookie('key_session_consumer_id',data.consumerId, { expires: 7, path: '/' });
							location.href="${basePath}mobile-homepage/view?userId=${userId}&cId="+data.consumerId;
						}else{
							alert("账户或密码错误");
						}
					}
				});
				
				return false;
			}
		</script>
	</head>
	<body>
		<div align="center"><img src="${basePath}h/images/cow.png" style="width:70%;" /></div>
		<div id="content">
			<form id="loginForm" action="${basePath}mobile-consumer/login">
				<div style="color:#FFFFFF;font-size:12px;font-weight:bold;">
					<label for="account">用户名/Email</label>
				</div>
				<div>
					<input type="text" name="account" onfocus="hideFooter()" onblur="showFooter();" style="width:100%;height:30px;border:1px solid #E8E8E8;border-radius:0%;">
				</div>
				
				<div style="color:#FFFFFF;font-size:12px;font-weight:bold;margin-top:10px;">
					<label>密码</label>
				</div>
				<div>
					<input type="password" id="pwd" name="pwd" onfocus="hideFooter()" onblur="showFooter();" style="width:100%;height:30px;border:1px solid #E8E8E8;border-radius:0%;">
				</div>
				
				<div class="btn" onclick="login();">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</div>
				
				<div id="footer">
					<div style="width:100px;float:left;font-size:12px;color:#FFFFFF;margin-top:20px;margin-left:10%;">没有账户吗?</div>
					<div id="signup" class="shadow" onclick="location.href='${basePath}mobile-consumer/regist-view?userId=${userId}'">注册</div>
				</div>
			</form>
		</div>
	</body>
</html>