<div class="panel panel-default">
<div class="panel-heading"><span class="glyphicon glyphicon-book"></span>&nbsp;会员评价</div>
<div class="panel-body right-content">
<!-- 		<div class="row"> -->
<!-- 			<div class="col-xs-3"><img src="${basePath}images/icon-user.jpg" class="image-equal-width" /></div> -->
<!-- 			<div class="col-xs-9"> -->
<!-- 				<div class="right-content-title">服了天</div> -->
<!-- 				<div class="right-content-text">${item.content}</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
		<ul class="media-list">
		<#list comments as item>
		  <li class="media">
		    <a class="pull-left" href="#" style="width:20%;">
		      <img class="media-object" src="${basePath}images/icon-user.jpg" style="width:100%;" />
		    </a>
		    <div class="media-body" style="color:#666666;">
		      <h5 class="media-heading">Media heading</h5>
		      	<div>${item.content}</div>
		    </div>
		  </li>
		</#list>
		</ul>
</div>
</div>