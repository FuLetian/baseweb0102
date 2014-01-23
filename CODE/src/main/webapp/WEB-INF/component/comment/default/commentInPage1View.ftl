<div class="font-bold well well-sm">
	<span class="glyphicon glyphicon-book"></span>&nbsp;服务承诺
</div>
<div class="panel-body right-content">
	<#list comments as item>
		<div class="row">
			<div class="col-xs-3"><img src="../images/icon-user.jpg" class="image-equal-width" /></div>
			<div class="col-xs-9">
				<div class="right-content-title">服了天</div>
				<div class="right-content-text">${item.content}</div>
			</div>
		</div>
	</#list>
</div>