<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>

<!--knockout-->
<script src="${basePath}javascript/knockout-3.0.0.js"></script>

<!--jquery.form-->
<script src="${basePath}javascript/jquery.form.js"></script>

<div class="container">
<div class="row">
	
	<table class="table">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>type</td>
			<td>idx</td>
		</tr>
		<tbody data-bind="foreach:brands">
			<tr>
				<td data-bind="text:id"></td>
				<td data-bind="text:name"></td>
				<td data-bind="text:type"></td>
				<td data-bind="text:idx"></td>
			</tr>
		</tbody>
	</table>
</div>
</div>

<script>
	var BrandModel=function(){
		var self=this;
		
		self.brands=ko.observableArray(${brands});
		
		
	}
</script>