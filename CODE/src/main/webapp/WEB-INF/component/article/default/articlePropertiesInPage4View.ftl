<!-- location -->
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="location text-info">商品参数:</div>
		</div>
	</div>
	
</div>
<!-- //location -->

<!-- article parameters -->
<div class="container">
	<div class="row" align="center">
		<#list props as item>
		<div class="col-md-6">
			${item.name}:${item.value}
		</div>
		</#list>
	</div>
</div>
<!--// article parameters -->