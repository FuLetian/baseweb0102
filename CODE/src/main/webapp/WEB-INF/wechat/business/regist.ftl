<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    
		<title>商户注册</title>
		
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
		
		<!-- 可选的Bootstrap主题文件（一般不用引入） -->
		<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
		
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		
		<script src="${basePath}lib/jquery.form.js"></script>
		<script src="${basePath}lib/moxie.min.js"></script>
		<script src="${basePath}lib/plupload.dev.js"></script>
		<script src="${basePath}lib/qiniu.min.js"></script>
		<script src="${basePath}js/qiniu_load.js"></script>
		<script src="${basePath}js/regist.js"></script>
		
<script>
$(function(){
	initRegist('${qnToken}','${basePath}');
});
</script>
	</head>
	<body>
	
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12">
		
			<form id="registForm" action="${basePath}wechat-business/action-business-regist" method="POST">
			  <div class="form-group">
			    <label for="exampleInputEmail1">商品名字</label>
			    <input id="name" name="name" type="text" class="form-control"  placeholder="">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail1">电话号码</label>
			    <input id="phone" name="phone" type="text" class="form-control"  placeholder="">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">密码</label>
			    <input id="password" name="password" type="password" class="form-control"  placeholder="Password">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">再次输入密码</label>
			    <input type="password" class="form-control" id="password2" placeholder="Password">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">店家介绍</label>
			    <textarea id="info" name="info" class="form-control" rows="3"></textarea>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputFile">LOGO</label>
			    <div id="container2"><button id="bg_logo_upload_btn" class="btn btn-default">选择LOGO图片</button></div>
			    
			  </div>
			  <div class="form-group">
			    <label for="exampleInputFile">背景图</label>
			    <div id="container"><button id="bg_img_upload_btn" class="btn btn-default">选择背景图片</button></div>
			    
			  </div>
			  <input id="imgBg" name="imgBg" type="hidden">
			  <input id="imgLogo" name="imgLogo" type="hidden">
			  <button type="submit" class="btn btn-default">提交</button>
			</form>

		</div>
	</div>
</div>
		
	</body>
</html>
