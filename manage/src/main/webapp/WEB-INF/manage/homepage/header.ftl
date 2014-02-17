<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${basePath}javascript/bootstrap/dist/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${basePath}javascript/bootstrap/dist/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${basePath}javascript/jquery-1.9.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${basePath}javascript/bootstrap/dist/js/bootstrap.min.js"></script>

<!--knockout-->
<script src="${basePath}javascript/knockout-3.0.0.js"></script>

<script type="text/javascript">
	var Model=function(){
		var self=this;
		self.btn_staticweb_click=function(){
			$.getJSON("${basePath}homepage/staticweb",function(data){
				console.log(data);
			});
		};
	};
	
	$(function(){
		ko.applyBindings(new Model);
	});
	
</script>
<a href="#" data-bind="click:btn_staticweb_click">静态化网站</a>