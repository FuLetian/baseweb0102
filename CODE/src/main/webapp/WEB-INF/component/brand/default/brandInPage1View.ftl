<div class="panel panel-default">
	<div class="panel-heading">品牌展</div>
	<div class="panel-body">
		<#list brands as item>
			<div class="col-xs-4 margin-top-line"><img src="${item.thumbnail}" alt="${item.name}" class="image-equal-width" /></div>
		</#list>
	</div>
</div>