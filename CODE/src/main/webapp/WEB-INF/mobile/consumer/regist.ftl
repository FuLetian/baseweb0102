<html>
	<head>
		<title>注册</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
		<script src="${basePath}h/javascript/jquery.form.js"></script>
		<script type="text/javascript">
			function regist(){
				$("#form").ajaxSubmit({
					url:'${basePath}util/upload',
					type:"post",
					dataType:"json",
					success:function(data){
						
						var value=$("#form").append("<input type='hidden' name='thumbnailPath' value='"+data.path+"'>").formSerialize();
						alert(value);
						$.getJSON('${basePath}mobile-consumer/onRegist',value,function(data){
							if(data.code==1){
								alert("用户名已存在");
							}else if(data.code==2){
								alert("邮箱已存在");
							}else{
								alert("注册成功");
								location.href="${basePath}mobile-consumer/login-homepage?userId=${userId}";
							}
						});
					}
				});
			};
		</script>
	</head>
	<body>
	
<form id="form">
<div>用户名<input type="text" name="account"></div>
<div>邮箱地址<input type="text" name="emailAddress"></div>
<div>密码<input type="text" name="pwd"></div>
<div>昵称<input type="text" name="name"></div>
<div>头像<input type="file" name="imgFile"></div>
<div>地址<input type="text" name="address"></div>
<div>电话号码<input type="text" name="phoneNum"></div>
<input type="hidden" name="userId" value="${userId}">
</form>
<a href="#" onclick="regist();">注册</a>

	</body>
</html>