<!-- location -->
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="location color-greys">商品图片:</div>
		</div>
	</div>
	
</div>
<!-- //location -->
<div class="container">
	<div class="row">
		<#list imgs as item>
		<div class="col-xs-6"><img alt="" src="${item.path}" class="image-equal-width"/></div>
		</#list>
	</div>
</div>