<html>
	<head>
		<title>注册</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
		<script src="${basePath}h/javascript/jquery.form.js"></script>
		<script type="text/javascript">
			function regist(){
				alert(1);
				var value=$("#form").ajaxSubmit({
					url:'${basePath}mobile-consumer/onRegist',
					dataType:"json",
					success:function(data){
						if(data.code==1){
							alert("用户名已存在");
						}else if(data.code==2){
							alert("邮箱已存在");
						}else{
							alert("注册成功");
							location.href="${basePath}mobile-consumer/login-homepage?userId=${userId}";
						}
					}
				});

			};
		</script>
		<style type="text/css">
			#container{
				background-color:#F0F0F0;
				border:1px solid #BBBBBB;
			}
			.table{
				width:100%;
			}
			
			tr{
				border-top:1px solid #BBBBBB;
				height:30px;
			}
			
			.table input{width:90%;margin-left:5%;}
		</style>
	</head>
	<body>
	
<form id="form" action="${basePath}mobile-consumer/onRegist">
<div id="container">
<table class="table">
	<tr>
		<td style="width:30%;">账户名:</td>
		<td><input type="text" name="account" holdPlace="账户名"></td>
	</tr>
	<tr>
		<td>邮箱:</td>
		<td><input type="text" name="emailAddress"></td>
	</tr>
	<tr>
		<td>密码:</td>
		<td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<td>确认密码:</td>
		<td><input type="password" name="pwd2"></td>
	</tr>
	<tr>
		<td>昵称:</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>地址:</td>
		<td><input type="text" name="address"></td>
	</tr>
	<tr>
		<td>电话号码:</td>
		<td><input type="text" name="phoneNum"></td>
	</tr>
	<tr>
		<td>头像:</td>
		<td><input type="file" name="imgFile"></td>
	</tr>
</table>
</div>
<input type="hidden" name="userId" value="${userId}">
</form>
<div onclick="regist()">注册</div>

	</body>
</html>