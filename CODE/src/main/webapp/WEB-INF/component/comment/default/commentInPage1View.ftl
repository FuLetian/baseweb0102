<div class="panel panel-default">
<div class="panel-heading"><span class="glyphicon glyphicon-book"></span>&nbsp;会员评价</div>
<div class="panel-body right-content">
		
		<ul class="media-list">
		<#list comments as item>
		  <li class="media">
		    <a class="pull-left" href="#" style="width:20%;">
		      <img class="media-object" src="${basePath}h/images/icon-user.jpg" style="width:100%;" />
		    </a>
		    <div class="media-body text-info">
		      <h5 class="media-heading">Media heading</h5>
		      	<div>${item.content}</div>
		    </div>
		  </li>
		</#list>
		</ul>
</div>
</div>