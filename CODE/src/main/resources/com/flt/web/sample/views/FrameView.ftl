<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>

<style type="text/css">
.main_container{
	width:100%;
}
.div_borderd{
	border:1px red solid;
}

.margin_top{
	margin-top:10px;
}

.width_70{
	width:70%;
}

.width_100{
	width:100%;
}

.width_90{
	width:90%;
}

.height_50{
	height:50px;
}
body{
	background-image:url(images/sidebar_bg.png)
}
</style>
</head>
<body>
<div class="main_container container" >

<div class="row">
	<div class="col-md-12">
		<#include frameView.topView.template/>
	</div>
</div>
<div class="row">
	<div class="col-md-3 div_border">
		<#include frameView.menuView.template/>
	</div>
	<div class="col-md-9 div_border" id="workspace">
	
		<div class="panel panel-default">
		  <div class="panel-heading">
		    <h3 class="panel-title">飛</h3>
		  </div>
		  <div class="panel-body">
		  	<div>
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li><a href="#">Library</a></li>
				  <li class="active">Data</li>
				</ol>
		  	</div>
		  	<div>
		  		<ul class="nav nav-tabs nav-justified">
				  <li><a href="#searchTab"><span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;<span>查找</span></a></li>
				  <li><a href="#addTab"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;<span>添加</span></a></li>
				  <li><a href="#refreshTab"><span class="glyphicon glyphicon-refresh"></span>&nbsp;&nbsp;刷新</a></li>
				</ul>
				<div class="tab-content">
					<div id="searchTab" class="tab-panel fade in active">
						<div class="panel">
							<table class="width_70 margin_top">
								<tr>
									<td align="right"><span class="label label-primary">dd</span></td>
									<td><input class="width_90"></td>
									<td align="right"><span class="label label-primary">dd</span></td>
									<td><input class="width_90"></td>
								</tr>
								<tr class="height_50">
									<td colspan=4 align="right"><button class="btn btn-primary">submit</button></td>
								</tr>
							</table>
						</div>
					</div>
					<div id="addTab" class="tab-panel">add</div>
					<div id="refreshTab" class="tab-panel">refresh</div>
				</div>
		  	</div>
			<div class="margin_top">
				<table class="table table-bordered table-hover">
				  <tr>
				  	<th>title</th>
				  	<th>title</th>
				  	<th>title</th>
				  	<th>title</th>
				  	<th>title</th>
				  	<th>title</th>
				  </tr>
				  <tr>
				  	<td>dd</td>
				  	<td>dd</td>
				  	<td>dd</td>
				  	<td>dd</td>
				  	<td>dd</td>
				  	<td align="right">
				  	
				  		<div class="btn-group" data-toggle="buttons">
						  <label class="btn btn-primary btn-xs">
						    <input type="radio" name="options" id="option1"> Option 1
						  </label>
						  <label class="btn btn-primary btn-xs btn-success">
						    <input type="radio" name="options" id="option2"> Option 2
						  </label>
						  <label class="btn btn-primary btn-xs btn-danger">
						    <input type="radio" name="options" id="option3"> Option 3
						  </label>
						</div>
				  	</td>
				  </tr>
				</table>
			</div>
			<div align="right">
				<ul class="pagination pagination-sm">
				  <li><a href="#">&laquo;</a></li>
				  <li><a href="#">1</a></li>
				  <li><a href="#">2</a></li>
				  <li><a href="#">3</a></li>
				  <li><a href="#">4</a></li>
				  <li><a href="#">5</a></li>
				  <li><a href="#">&raquo;</a></li>
				</ul>
			</div>
		  </div>
		</div>
	
	</div>
</div>
</div>
<#include frameView.footerView.template/>
</body>
</html>