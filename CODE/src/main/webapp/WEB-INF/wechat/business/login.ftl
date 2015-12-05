<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    
		<title>商户登陆</title>
		
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
		
		<!-- 可选的Bootstrap主题文件（一般不用引入） -->
		<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
		
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	</head>
	<body>
	
<div class="container">
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1">
		
			<form>
			  <div class="form-group">
			    <label for="exampleInputEmail1">电话号码</label>
			    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="电话">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">密码</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="密码">
			  </div>
			  <button type="submit" class="btn btn-default col-xs-6">登陆</button>
			  <a class="btn btn-default col-xs-offset-1" href="${basePath}wechat-business/page-regist">免费注册</a>
			</form>

		</div>
	</div>
</div>
		
	</body>
</html>
