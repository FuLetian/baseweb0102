<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${workspaceView_parentMenu.title}</h3>
  </div>
  <div class="panel-body">
  	<div>
		<ol class="breadcrumb">
		<#list workspaceView_parentMenu.list as item>
		  <li><a href="#">${item.title}</a></li>
		</#list>
		</ol>
  	</div>
  </div>
</div>