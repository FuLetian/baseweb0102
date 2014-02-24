<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${basePath}h/javascript/bootstrap/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${basePath}h/javascript/jquery-1.9.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${basePath}h/javascript/bootstrap/js/bootstrap.min.js"></script>

<!--knockout-->
<script src="${basePath}h/javascript/knockout-3.0.0.js"></script>

<div class="list-group" data-bind="foreach:menus">
  <a data-bind="click:loadWorkspace,text:$data.name,attr:{class:style}"></a>
</div>

<script>
$(function(){
	function MenuViewModel(){
		menus=${menus};
		loadWorkspace=function(menu){
			window.parent.workspace.location.href=menu.location;
		}
		
		style=ko.computed(function(){
			return "list-group-item";
		},this);
	}
	
	ko.applyBindings(new MenuViewModel());
});
</script>